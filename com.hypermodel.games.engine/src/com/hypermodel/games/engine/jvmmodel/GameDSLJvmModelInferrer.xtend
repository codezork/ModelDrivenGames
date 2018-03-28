package com.hypermodel.games.engine.jvmmodel

import android.os.Bundle
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.gwt.GwtApplication
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration
import com.badlogic.gdx.backends.iosrobovm.IOSApplication
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.utils.viewport.Viewport
import com.google.gwt.event.logical.shared.ResizeEvent
import com.google.gwt.event.logical.shared.ResizeHandler
import com.hypermodel.games.engine.gameDSL.GamePackage
import com.hypermodel.games.engine.gameDSL.GameRoot
import com.hypermodel.games.engine.gameDSL.GameScene
import com.hypermodel.games.engine.gameDSL.GameScreen
import com.hypermodel.games.engine.generator.GameProperties
import com.hypermodel.games.engine.generator.GameProperties.ProjectType
import javax.inject.Inject
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.moe.natj.general.Pointer
import com.hypermodel.games.engine.gameDSL.GameDisplayValueType
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector2
import com.hypermodel.games.engine.gameDSL.GameSprite
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.physics.box2d.Body
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.badlogic.gdx.physics.box2d.CircleShape
import com.badlogic.gdx.physics.box2d.EdgeShape

class GameDSLJvmModelInferrer extends AbstractModelInferrer {
	@Inject extension JvmTypesBuilder
	@Inject extension IQualifiedNameProvider
	val genInfo = "generated by hypermodels.com"

	def dispatch void infer(GamePackage gamePkg, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		gamePkg.games.forEach[game|
			// core module
			val rootClass = gamePkg.toClass(game.fullyQualifiedName) 
			acceptor.accept(
				rootClass,
				[
					superTypes += Game.typeRef
					packageName = game.fullyQualifiedName.skipLast(1).toString
					documentation = genInfo
					it.toFields(game)
					it.toOperations(gamePkg, game)
				]
			)
			// launchers
			ProjectType.values.filter[it != ProjectType.core].forEach[acceptor.createLauncher(gamePkg, game, it)]
			// scenes
			game.scenes.forEach[acceptor.createScene(gamePkg, rootClass, it)]
			// screens
			game.screens.forEach[acceptor.createScreen(gamePkg, rootClass, it)]
		]
	}

	protected def void createLauncher(IJvmDeclaredTypeAcceptor acceptor, GamePackage gamePkg, GameRoot game, ProjectType pType) {
		val doc = genInfo
		switch (pType) {
			case ProjectType.android: {
				val launcherClass = gamePkg.toClass('''�pType.name.toFirstUpper�Launcher''');
				launcherClass.superTypes.add(AndroidApplication.typeRef)
				acceptor.accept(
					launcherClass,
					[
						var method = game.toMethod("onCreate", Void.TYPE.typeRef, [
							parameters += game.toParameter("savedInstanceState", Bundle.typeRef)
							annotations += Override.annotationRef
							body = [
								append(
								'''
								super.onCreate(savedInstanceState);
								AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
								�IF gamePkg.config.android.useAccelerometer�config.useAccelerometer = true;�ENDIF�
								initialize(new �game.name.toFirstUpper�(), config);''')
							]
						])
						it.members += method
						packageName = gamePkg.fullyQualifiedName.toString
						documentation = doc
					]
				)
			}
			case ProjectType.desktop: {
				val launcherClass = gamePkg.toClass('''�pType.name.toFirstUpper�Launcher''');
				acceptor.accept(
					launcherClass,
					[
						var method = game.toMethod("main", Void.TYPE.typeRef, [
							parameters += game.toParameter("arg", typeof(String[]).typeRef)
							body = [
								append(
								'''
								LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
								new LwjglApplication(new �game.fullyQualifiedName�(), config);''')
							]
						])
						method.static = true
						it.members += method
						packageName = '''�gamePkg.fullyQualifiedName.toString�.�pType.name�'''
						documentation = doc
					]
				)
			}
			case ProjectType.html: {
				val launcherClass = gamePkg.toClass('''�pType.name.toFirstUpper�Launcher''');
				launcherClass.superTypes.add(GwtApplication.typeRef)
				acceptor.accept(
					launcherClass,
					[
						packageName = '''�gamePkg.fullyQualifiedName.toString�.client'''
						documentation = doc
						var field = game.toField("PADDING", int.typeRef, [
							initializer = [append('''0''')]
						])
						it.members += field
						field = game.toField("cfg", GwtApplicationConfiguration.typeRef)
						it.members += field
						var method = game.toMethod("getConfig", GwtApplicationConfiguration.typeRef, [
								annotations += Override.annotationRef
								body = [
									append(
								'''
									int w = Window.getClientWidth() - PADDING;
									int h = Window.getClientHeight() - PADDING;
									cfg = new GwtApplicationConfiguration(w, h);
									Window.enableScrolling(false);
									Window.setMargin("0");
									Window.addResizeHandler(new ResizeListener());
									cfg.preferFlash = false;
									return cfg;''')
								]
							])
						it.members += method
						method = game.toMethod("createApplicationListener", ApplicationListener.typeRef, [
								annotations += Override.annotationRef
								body = [
									append(
								'''
									return new �game.fullyQualifiedName�();''')
								]
							])
						it.members += method
						val resizeClass = gamePkg.toClass("ResizeListener");
						resizeClass.superTypes.add(ResizeHandler.typeRef)
						var innermethod = game.toMethod("onResize", Void.TYPE.typeRef, [
							parameters += game.toParameter("event", ResizeEvent.typeRef)
							annotations += Override.annotationRef
							body = [
								append(
								'''
								int width = event.getWidth() - PADDING;
								int height = event.getHeight() - PADDING;
								getRootPanel().setWidth("" + width + "px");
								getRootPanel().setHeight("" + height + "px");
								getApplicationListener().resize(width, height);
								Gdx.graphics.setWindowedMode(width, height);''')
							]
						])
						resizeClass.members += innermethod
						it.members += resizeClass
					]
				)
			}
			case ProjectType.ios: {
				val launcherClass = gamePkg.toClass('''�pType.name.toUpperCase�Launcher''');
				launcherClass.superTypes.add(IOSApplication.Delegate.typeRef)
				acceptor.accept(
					launcherClass,
					[
						packageName = '''�gamePkg.fullyQualifiedName.toString�'''
						documentation = doc
						var method = game.toMethod("createApplication", IOSApplication.typeRef, [
							annotations += Override.annotationRef
							body = [
								append(
								'''
								IOSApplicationConfiguration config = new IOSApplicationConfiguration();
								�IF gamePkg.config.ios.useAccelerometer�config.useAccelerometer = true;�ENDIF�
								return new IOSApplication(new �game.name.toFirstUpper�(), config);''')
							]
						])
						it.members += method
						method = game.toMethod("main", Void.TYPE.typeRef, [
							parameters += game.toParameter("arg", typeof(String[]).typeRef)
							body = [
								append(
								'''
								NSAutoreleasePool pool = new NSAutoreleasePool();
								UIApplication.main(arg, null, �pType.name.toUpperCase��GameProperties.launcherPostfix�.class);
								pool.close();''')
							]
						])
						method.static = true
						it.members += method
					]
				)
			}
			case ProjectType.iosmoe: {
				val launcherClass = gamePkg.toClass('''�pType.name.toUpperCase�Launcher''');
				launcherClass.superTypes.add(com.badlogic.gdx.backends.iosmoe.IOSApplication.Delegate.typeRef)
				acceptor.accept(
					launcherClass,
					[
						packageName = gamePkg.fullyQualifiedName.toString
						documentation = doc
						var constructor = game.toConstructor( [
							parameters += game.toParameter("peer", Pointer.typeRef)
							body = [
								append(
								'''
								super(peer);''')
							]
						])
						constructor.visibility = JvmVisibility.PROTECTED
						it.members += constructor
						var method = game.toMethod("createApplication",	com.badlogic.gdx.backends.iosmoe.IOSApplication.typeRef, [
								annotations += Override.annotationRef
								body = [
									append(
								'''
									IOSApplicationConfiguration config = new IOSApplicationConfiguration();
									�IF gamePkg.config.iosmoe.useAccelerometer�config.useAccelerometer = true;�ENDIF�
									return new IOSApplication(new �game.name.toFirstUpper�(), config);''')
								]
							])
						it.members += method
						method = game.toMethod("main", Void.TYPE.typeRef, [
							parameters += game.toParameter("arg", typeof(String[]).typeRef)
							body = [
								append(
								'''
								UIKit.UIApplicationMain(0, null, null, �pType.name.toUpperCase��GameProperties.launcherPostfix�.class.getName());''')
							]
						])
						method.static = true
						it.members += method
					]
				)
			}
			default: {
			}
		}
	}

	def void toFields(JvmGenericType type, GameRoot game) {
		var JvmField field = null
		field = game.toField("batch", SpriteBatch.typeRef)
		field.visibility = JvmVisibility.PUBLIC
		type.members += field
		field = game.toField("V_WIDTH", int.typeRef)[initializer = [append('''�game.width�''')]]
		field.static = true
		field.final = true
		field.visibility = JvmVisibility.PUBLIC
		type.members += field
		field = game.toField("V_HEIGHT", int.typeRef) [initializer = [append('''�game.height�''')]]
		field.static = true
		field.final = true
		field.visibility = JvmVisibility.PUBLIC
		type.members += field
		field = game.toField("TITLE", String.typeRef) [
			initializer = [append('''"�game.title�"''')]
		]
		field.static = true
		field.final = true
		field.visibility = JvmVisibility.PUBLIC
		type.members += field
		field = game.toField("PPM", float.typeRef)[initializer = [append('''�game.ppm�f''')]]
		field.static = true
		field.final = true
		field.visibility = JvmVisibility.PUBLIC
		type.members += field
	}

	def void toOperations(JvmGenericType type, GamePackage gamePkg, GameRoot game) {
		type.members += game.toMethod("create", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			body = [
				it.append(
				'''
				batch = new SpriteBatch();
				''')
				for (screen : game.screens) {
					it.append("setScreen(new ")
					it.append(gamePkg.toClass(screen.fullyQualifiedName))
					it.append("(this));")
				}
			]
		])

		type.members += game.toMethod("render", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			body = [
				append(
				'''
				super.render();''')
			]
		])
		type.members += game.toMethod("dispose", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			body = [
				append(
				'''
				super.dispose();
				batch.dispose();''')
			]
		])
	}

	// screens
	def void createScreen(IJvmDeclaredTypeAcceptor acceptor, GamePackage gamePkg, JvmGenericType gameClass, GameScreen screen) {
		val screenClass = gamePkg.toClass(screen.fullyQualifiedName) 
		acceptor.accept(
			screenClass,
			[
				superTypes += Screen.typeRef
				packageName = screen.fullyQualifiedName.skipLast(1).toString
				documentation = genInfo
				it.toFields(gamePkg, screen, gameClass)
				members += screen.toConstructor [
					parameters += gamePkg.toParameter("game", gameClass.typeRef)
					body = [
						append(
						'''
						this.game = game;
						atlas = new TextureAtlas("�screen.atlasName�.pack");
						gamecam = new OrthographicCamera();
						gamePort = new ''')
						append(FitViewport)
						append(
						'''
						(MarioBros.V_WIDTH / MarioBros.PPM, MarioBros.V_HEIGHT / MarioBros.PPM, gamecam);
						mapLoader = new TmxMapLoader();
						map = mapLoader.load("level1.tmx");
						renderer = new OrthogonalTiledMapRenderer(map, 1 / MarioBros.PPM);
						gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
						world = new World(new ''')
						append(Vector2)
						append(
						'''
						(0, -10), true);
						b2dr = new Box2DDebugRenderer();
						�IF screen.scene !== null��screen.scene.name.toFirstLower� = new �screen.scene.name.toFirstUpper�(game.batch);�ENDIF�
						''')
						
					]
				]
				it.toOperations(screen)
			]
		)
		// sprites
		screen.sprites.forEach[acceptor.createSprite(gamePkg, gameClass, screenClass, it)]
	}

	def void toFields(JvmGenericType type, GamePackage gamePkg, GameScreen screen, JvmGenericType gameClass) {
		var JvmField field = null
		type.members += screen.toField("game", gameClass.typeRef)
		type.members += screen.toField("atlas", TextureAtlas.typeRef)
		type.members += screen.toField("gamecam", OrthographicCamera.typeRef);
		type.members += screen.toField("gamePort", Viewport.typeRef);
		type.members += screen.toField("mapLoader", TmxMapLoader.typeRef);
		type.members += screen.toField("map", TiledMap.typeRef);
		type.members += screen.toField("renderer", OrthogonalTiledMapRenderer.typeRef);
		type.members += screen.toField("world", World.typeRef);
		type.members += screen.toField("b2dr", Box2DDebugRenderer.typeRef);
		type.members += screen.toField("music", Music.typeRef);
//		type.members += screen.toField("creator", B2WorldCreator.typeRef);
//		type.members += screen.toField("player", Mario.typeRef);
//		type.members += screen.toField("items", Array, Item.typeRef)) ;
//		type.members += screen.toField("itemsToSpawn", LinkedBlockingQueue, ItemDef.typeRef)) ;
		if(screen.scene !== null) {
			field = screen.toField(screen.scene.name.toFirstLower, gamePkg.toClass(screen.scene.fullyQualifiedName).typeRef)
			field.visibility = JvmVisibility.PUBLIC 
			type.members += field
		}
	}

	def void toOperations(JvmGenericType type, GameScreen screen) {
		type.members += screen.toGetter("atlas", TextureAtlas.typeRef)
		type.members += screen.toGetter("map", TiledMap.typeRef)
		type.members += screen.toGetter("world", World.typeRef)
		type.members += screen.toMethod("resize", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			parameters += screen.toParameter("width", int.typeRef)
			parameters += screen.toParameter("height", int.typeRef)
			body = [
				append(
				'''
				gamePort.update(width, height);''')
			]
		])
		type.members += screen.toMethod("pause", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("resume", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("dispose", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			body = [
				append(
				'''
				map.dispose();
				renderer.dispose();
				world.dispose();
				b2dr.dispose();
				�IF screen.scene !== null��screen.scene.name.toFirstLower�.dispose();�ENDIF�
				''')
			]
		])
		type.members += screen.toMethod("show", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("render", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			parameters += screen.toParameter("delta", float.typeRef)
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("hide", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			body = [
				append(
				'''
				''')
			]
		])
	}

	// scenes
	def void createScene(IJvmDeclaredTypeAcceptor acceptor, GamePackage gamePkg, JvmGenericType gameClass, GameScene scene) {
		acceptor.accept(
			gamePkg.toClass(scene.fullyQualifiedName),
			[
				superTypes += Disposable.typeRef
				packageName = scene.fullyQualifiedName.skipLast(1).toString
				documentation = genInfo
				it.toFields(scene, gameClass)
				members += scene.toConstructor [
					parameters += gamePkg.toParameter("spriteBatch", SpriteBatch.typeRef)
					body = [
						append("viewport = new ")
						append(FitViewport)
						append("(")
						append(gamePkg.toClass(gameClass.fullyQualifiedName))
						append('''.V_WIDTH, �gameClass.simpleName�.V_HEIGHT, new ''')
						append(OrthographicCamera)
						append("());\n")
						append("stage = new ")
						append(Stage)
						append("(viewport, spriteBatch);\n")
						append(Table)
						append(
						'''
						 table = new Table();
						table.top();
						table.setFillParent(true);
						stage.addActor(table);
						''')
						val current = it
						if(scene.hasScore) {
							scene.score.displays.forEach[
								current.append(
								'''
								�it.name�TitleLabel = new Label("�it.name.toUpperCase�", new Label.LabelStyle(new ''')
								current.append(BitmapFont)
								current.append("(), ")
								current.append(Color)
								current.append(".WHITE));\n")
								current.append(
								'''
								table.add(�it.name�TitleLabel).expandX().padTop(�scene.score.topPadding�);
								''')
							]
							it.append("table.row();\n")
							scene.score.displays.forEach[
								current.append(
								'''
								�it.name�ValueLabel = new Label(String.format("�it.format�", �it.name�), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
								table.add(�it.name�ValueLabel).expandX();
								''')
							]
						}
					]
				]
				it.toOperations(scene)
			]
		)
	}

	def void toFields(JvmGenericType type, GameScene scene, JvmGenericType gameClass) {
		var field = scene.toField("stage", Stage.typeRef)
		field.visibility = JvmVisibility.PUBLIC
		type.members += field
		type.members += scene.toField("viewport", Viewport.typeRef)
		if(scene.hasScore) {
			scene.score.displays.forEach[
				type.members += scene.toField('''�it.name�TimeCount''', float.typeRef) [initializer = [append("0")]]
				var displayField = scene.toField('''�it.name�''', it.type.getName.typeRef)
				val current = it			
				displayField.initializer = [append('''�IF current.hasInitial��IF current.type == GameDisplayValueType.STRING�"�current.initialStringValue�"�ELSEIF current.type == GameDisplayValueType.FLOAT��current.initialNumberValue��ELSEIF current.type == GameDisplayValueType.INT��current.initialIntValue��ENDIF��ELSE��IF current.type == GameDisplayValueType.STRING�""�ELSEIF current.type == GameDisplayValueType.FLOAT�0.0�ELSEIF current.type == GameDisplayValueType.INT�0�ENDIF��ENDIF�''')]
				if(it.hasAdder||it.hasSetter) {
					displayField.static = true
				}
				type.members += displayField
				type.members += scene.toField('''�it.name�TitleLabel''', Label.typeRef)
				type.members += scene.toField('''�it.name�ValueLabel''', Label.typeRef)
			]
		}
	}

	def void toOperations(JvmGenericType type, GameScene scene) {
		type.members += scene.toMethod("update", Void.TYPE.typeRef, [
			parameters += scene.toParameter("dt", float.typeRef)
			body = [
				val current = it
				if(scene.hasScore) {
					scene.score.displays.filter[it.hasDelta].forEach[
						current.append(
						'''
						�it.name�TimeCount += dt;
						if (�it.name�TimeCount >= �it.timePeriod�) {
							�it.name� += �it.deltaValue�;
							�it.name�ValueLabel.setText(String.format("�it.format�", �it.name�));
							�it.name�TimeCount = 0;
						}
						''')
					]
				}
			]
		])
		type.members += scene.toMethod("dispose", Void.TYPE.typeRef, [
			annotations += Override.annotationRef
			body = [
				append(
				'''
				stage.dispose();
				''')
			]
		])
		if(scene.hasScore) {
			scene.score.displays.filter[it.hasAdder].forEach[
				val current = it
				var operation = scene.toMethod('''add�it.name.toFirstUpper�''', Void.TYPE.typeRef, [
					parameters += scene.toParameter("value", current.type.getName.typeRef)
					body = [
						append(
						'''
						�current.name� += value;
						''')
					]
				])
				operation.static = true
				type.members += operation 
			]
			scene.score.displays.filter[it.hasSetter].forEach[
				val current = it
				var operation = scene.toMethod('''set�it.name.toFirstUpper�''', Void.TYPE.typeRef, [
					parameters += scene.toParameter("value", current.type.getName.typeRef)
					body = [
						append(
						'''
						�current.name� = value;
						''')
					]
				])
				operation.static = true
				type.members += operation 
			]
		}
	}

	// sprites
	def void createSprite(IJvmDeclaredTypeAcceptor acceptor, GamePackage gamePkg, JvmGenericType gameClass, JvmGenericType screenClass, GameSprite sprite) {
		acceptor.accept(
			gamePkg.toClass(sprite.fullyQualifiedName),
			[
				superTypes += Sprite.typeRef
				packageName = sprite.fullyQualifiedName.skipLast(1).toString
				documentation = genInfo
				it.toFields(sprite)
				members += sprite.toConstructor [
					parameters += gamePkg.toParameter("screen", screenClass.typeRef)
					body = [
						append(
						'''
						world = screen.getWorld();
						stateTimer = 0;
						runningRight = true;
						''')
						append(Array)
						append("<")
						append(TextureRegion)
						append("> frames = new Array<TextureRegion>();\n")
						val current = it
						sprite.animations.forEach[
							if(it.hasFrames) {
								current.append(
								'''
								for (int i = �it.offset�; i < �it.frames+it.offset�; i++) {
									frames.add(new TextureRegion(screen.getAtlas().findRegion("�it.region.name�"), i * �it.region.width�, 0, �it.region.width�, �it.region.height�));
								}
								''')
							}
							if(it.hasStands) {
								it.stands.forEach[
									current.append(
									'''
									frames.add(new TextureRegion(screen.getAtlas().findRegion("�it.region.name�"), �it.offset*it.region.width�, 0, �it.region.width�, �it.region.height�));
									''')
								]
								
							}
							current.append(
							'''
							�it.name� = new ''')
							current.append(Animation)
							current.append('''
							(�it.duration�f, frames);
							frames.clear();
							''')
						]
						sprite.stands.forEach[
							current.append(
								'''
								�it.name� = new TextureRegion(screen.getAtlas().findRegion("�it.region.name�"), �it.offset*it.region.width�, 0, �it.region.width�, �it.region.height�);
								'''
							)
						]
						append(
						'''
				        define�sprite.name.toFirstUpper�(new Vector2(�sprite.x� / �gameClass.simpleName�.PPM, �sprite.y� / �gameClass.simpleName�.PPM), null);
				        setBounds(0, 0, �sprite.start.region.width� / ''')
				        append(gameClass)
				        append('''.PPM,  �sprite.start.region.height� / �gameClass.simpleName�.PPM);
				        ''')
						append('''
						setRegion(�sprite.start.name�);
						'''
						)
					]
				]
				it.toOperations(sprite, gameClass)
			]
		)
	}

	def void toFields(JvmGenericType type, GameSprite sprite) {
		var field = sprite.toField("world", World.typeRef)
		field.visibility = JvmVisibility.PUBLIC
		type.members += field
		field = sprite.toField("b2body", Body.typeRef)
		field.visibility = JvmVisibility.PUBLIC
		type.members += field
		type.members += sprite.toField("stateTimer", float.typeRef)
		type.members += sprite.toField("runningRight", boolean.typeRef)
		
		sprite.animations.forEach[type.members += sprite.toField('''�it.name�''', Animation.typeRef)]
		sprite.stands.forEach[type.members += sprite.toField('''�it.name�''', TextureRegion.typeRef)]
	}

	def void toOperations(JvmGenericType type, GameSprite sprite, JvmGenericType gameClass) {
		type.members += sprite.toMethod("update", Void.TYPE.typeRef, [
			parameters += sprite.toParameter("dt", float.typeRef)
			body = [
				val current = it
			]
		])
		type.members += sprite.toMethod('''define�sprite.name.toFirstUpper�''', Void.TYPE.typeRef, [
			parameters += sprite.toParameter("position", Vector2.typeRef)
			parameters += sprite.toParameter("shapePosition", Vector2.typeRef)
			body = [
				append(BodyDef)
				append('''
				 bdef = new BodyDef();
				bdef.position.set(position);
				bdef.type = BodyDef.BodyType.DynamicBody;
				b2body = world.createBody(bdef);
				''')
				append(FixtureDef)
				append(''' fdef = new FixtureDef();
				''')
				append(CircleShape)
				append('''
				 shape = new CircleShape();
				shape.setRadius(�sprite.radius� / �gameClass.simpleName�.PPM);
				fdef.filter.categoryBits = �(2**sprite.id) as int�;
				''')
				var mask = 0.0
				for(s:sprite.interactionSprites) {
					mask = mask + (2**s.id)
				}
				append('''
				fdef.filter.maskBits = �mask as int�;
				fdef.shape = shape;
				b2body.createFixture(fdef).setUserData(this);
				if(shapePosition != null) {
					shape.setPosition(shapePosition);
					b2body.createFixture(fdef).setUserData(this);
				}
				''')
				if(sprite.hasSensor) {
					append(EdgeShape)
					append(
					'''
					 head = new EdgeShape();
					head.set(new Vector2(-�sprite.sensorLength� / 2 / �gameClass.simpleName�.PPM, �sprite.radius� / �gameClass.simpleName�.PPM), new Vector2(�sprite.sensorLength� / 2 / �gameClass.simpleName�.PPM, �sprite.radius� / �gameClass.simpleName�.PPM));
					fdef.filter.categoryBits = �(2**sprite.sensorID) as int�;
					fdef.shape = head;
					fdef.isSensor = true;
					b2body.createFixture(fdef).setUserData(this);
					''')
				}
			]
		])
	}
}
