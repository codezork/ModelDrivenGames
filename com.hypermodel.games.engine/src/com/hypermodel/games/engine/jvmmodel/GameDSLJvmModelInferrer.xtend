package com.hypermodel.games.engine.jvmmodel

import android.os.Bundle
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.gwt.GwtApplication
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration
import com.badlogic.gdx.backends.iosrobovm.IOSApplication
import com.google.gwt.event.logical.shared.ResizeEvent
import com.google.gwt.event.logical.shared.ResizeHandler
import com.hypermodel.games.engine.gameDSL.GamePackage
import com.hypermodel.games.engine.gameDSL.GameRoot
import com.hypermodel.games.engine.gameDSL.GameScreen
import com.hypermodel.games.engine.generator.GameProperties
import com.hypermodel.games.engine.generator.GameProperties.ProjectType
import java.util.regex.Pattern
import javax.inject.Inject
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.moe.natj.general.Pointer
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameDSLJvmModelInferrer extends AbstractModelInferrer {
	@Inject extension JvmTypesBuilder
	@Inject extension IQualifiedNameProvider

   	def dispatch void infer(GamePackage gamePkg, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		for (game : gamePkg.games) {
			// core module
			var rootClassName = game.name.toFirstUpper
			val rootClass = gamePkg.toClass(rootClassName);
			rootClass.superTypes.add(_typeReferenceBuilder.typeRef(Game))
			val pkgName = gamePkg.fullyQualifiedName.toString
			acceptor.accept(
				rootClass,
				[
					it.toFields(game)
					it.toOperations(gamePkg, game)
					packageName = pkgName
					documentation = "generated by hypermodels.com"
				]
			)
			// launchers
			for(pType:ProjectType.values) {
				if(pType != ProjectType.core) {
					acceptor.createLauncher(gamePkg, game, pkgName, pType)
				}
			}
			// screens
			for(screen : game.screens) {
				acceptor.createScreen(gamePkg, rootClass, screen)
			}
		}
   	}
	
	protected def void createLauncher(IJvmDeclaredTypeAcceptor acceptor, GamePackage gamePkg, GameRoot game, String pkgName, ProjectType pType) {
		val doc = "generated by hypermodels.com"
		switch(pType) {
			case ProjectType.android: {
				val launcherClass = gamePkg.toClass('''�pType.name.toFirstUpper�Launcher''');
				launcherClass.superTypes.add(_typeReferenceBuilder.typeRef(AndroidApplication))
				acceptor.accept(
					launcherClass,
					[
						var method = game.toMethod("onCreate", _typeReferenceBuilder.typeRef(Void::TYPE), [
							parameters += game.toParameter("savedInstanceState", _typeReferenceBuilder.typeRef(Bundle))
							annotations += _annotationTypesBuilder.annotationRef(Override)
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
						packageName = pkgName
						documentation = doc
					]
				)
			}
			case ProjectType.desktop: {
				val launcherClass = gamePkg.toClass('''�pType.name.toFirstUpper�Launcher''');
				acceptor.accept(
					launcherClass,
					[
						var method = game.toMethod("main", _typeReferenceBuilder.typeRef(Void::TYPE), [
							parameters += game.toParameter("arg", _typeReferenceBuilder.typeRef(typeof(String[])))
							body = [
								append(
								'''
								LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
								new LwjglApplication(new �pkgName�.�game.name.toFirstUpper�(), config);''')
							]
						])
						method.static = true
						it.members += method
						packageName = '''�pkgName�.�pType.name�'''
						documentation = doc
					]
				)
			}
			case ProjectType.html: {
				val launcherClass = gamePkg.toClass('''�pType.name.toFirstUpper�Launcher''');
				launcherClass.superTypes.add(_typeReferenceBuilder.typeRef(GwtApplication))
				acceptor.accept(
					launcherClass,
					[
						packageName = '''�pkgName�.client'''
						documentation = doc
						var field = game.toField("PADDING", _typeReferenceBuilder.typeRef(int), [initializer = [append('''0''')]])
						it.members += field
						field = game.toField("cfg", _typeReferenceBuilder.typeRef(GwtApplicationConfiguration))
						it.members += field
						var method = game.toMethod("getConfig", _typeReferenceBuilder.typeRef(GwtApplicationConfiguration), [
							annotations += _annotationTypesBuilder.annotationRef(Override)
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
						method = game.toMethod("createApplicationListener", _typeReferenceBuilder.typeRef(ApplicationListener), [
							annotations += _annotationTypesBuilder.annotationRef(Override)
							body = [
								append(
								'''
				                return new �pkgName�.�game.name.toFirstUpper�();''')
							]
						])
						it.members += method
						val resizeClass = gamePkg.toClass("ResizeListener");
						resizeClass.superTypes.add(_typeReferenceBuilder.typeRef(ResizeHandler))
						var innermethod = game.toMethod("onResize", _typeReferenceBuilder.typeRef(Void::TYPE), [
							parameters += game.toParameter("event", _typeReferenceBuilder.typeRef(ResizeEvent))
							annotations += _annotationTypesBuilder.annotationRef(Override)
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
				launcherClass.superTypes.add(_typeReferenceBuilder.typeRef(IOSApplication.Delegate))
				acceptor.accept(
					launcherClass,
					[
						packageName = '''�pkgName�'''
						documentation = doc
						var method = game.toMethod("createApplication", _typeReferenceBuilder.typeRef(IOSApplication), [
							annotations += _annotationTypesBuilder.annotationRef(Override)
							body = [
								append(
								'''
								IOSApplicationConfiguration config = new IOSApplicationConfiguration();
								�IF gamePkg.config.ios.useAccelerometer�config.useAccelerometer = true;�ENDIF�
								return new IOSApplication(new �game.name.toFirstUpper�(), config);''')
							]
						])
						it.members += method
						method = game.toMethod("main", _typeReferenceBuilder.typeRef(Void::TYPE), [
							parameters += game.toParameter("arg", _typeReferenceBuilder.typeRef(typeof(String[])))
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
				launcherClass.superTypes.add(_typeReferenceBuilder.typeRef(com.badlogic.gdx.backends.iosmoe.IOSApplication.Delegate))
				acceptor.accept(
					launcherClass,
					[
						packageName = pkgName
						documentation = doc
						var constructor = game.toConstructor( [
							parameters += game.toParameter("peer", _typeReferenceBuilder.typeRef(Pointer))
							body = [
								append(
								'''
						        super(peer);''')
							]
						])
						constructor.visibility = JvmVisibility.PROTECTED
						it.members += constructor
						var method = game.toMethod("createApplication", _typeReferenceBuilder.typeRef(com.badlogic.gdx.backends.iosmoe.IOSApplication), [
							annotations += _annotationTypesBuilder.annotationRef(Override)
							body = [
								append(
								'''
								IOSApplicationConfiguration config = new IOSApplicationConfiguration();
								�IF gamePkg.config.iosmoe.useAccelerometer�config.useAccelerometer = true;�ENDIF�
								return new IOSApplication(new �game.name.toFirstUpper�(), config);''')
							]
						])
						it.members += method
						method = game.toMethod("main", _typeReferenceBuilder.typeRef(Void::TYPE), [
							parameters += game.toParameter("arg", _typeReferenceBuilder.typeRef(typeof(String[])))
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
		field = game.toField("batch", _typeReferenceBuilder.typeRef(SpriteBatch))
		type.members += field
		field = game.toField("V_WIDTH", _typeReferenceBuilder.typeRef(int)) [initializer = [append('''�game.width�''')]]
		field.static = true
		field.final = true
		type.members += field
		field = game.toField("V_HEIGHT", _typeReferenceBuilder.typeRef(int)) [initializer = [append('''�game.height�''')]]
		field.static = true
		field.final = true
		type.members += field
		field = game.toField("TITLE", _typeReferenceBuilder.typeRef(String)) [initializer = [append('''"�game.title�"''')]]
		field.static = true
		field.final = true
		type.members += field
		field = game.toField("PPM", _typeReferenceBuilder.typeRef(float)) [initializer = [append('''�game.ppm�f''')]]
		field.static = true
		field.final = true
		type.members += field
	}

	def void toOperations(JvmGenericType type, GamePackage gamePkg, GameRoot game) {
		type.members += game.toMethod("create", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			body = [
				append(
				'''
				batch = new SpriteBatch();
				�FOR screen:game.screens�
				setScreen(new �gamePkg.fullyQualifiedName.toString+".screens"�.�screen.name.toFirstUpper�(this));
				�ENDFOR�
				''')
			]
		])
		type.members += game.toMethod("render", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			body = [
				append(
				'''
				super.render();''')
			]
		])
		type.members += game.toMethod("dispose", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			body = [
				append(
				'''
				super.dispose();
				batch.dispose();''')
			]
		])
	}

	def void createScreen(IJvmDeclaredTypeAcceptor acceptor, GamePackage gamePkg, JvmGenericType gameClass, GameScreen screen) {
		var screenClassName = screen.name.toFirstUpper
		val screenClass = gamePkg.toClass(screenClassName);
		screenClass.superTypes.add(_typeReferenceBuilder.typeRef(Screen))
		val pkgName = gamePkg.fullyQualifiedName.toString+".screens"
		acceptor.accept(
			screenClass,
			[
				members += screen.toConstructor[
		   			parameters += gamePkg.toParameter("game", _typeReferenceBuilder.typeRef(gameClass))
					body = [ append(
					'''
			        this.game = game;
			        atlas = new TextureAtlas("�screen.atlasName�.pack");
					''')]
				]
				it.toFields(screen, gameClass)
				it.toOperations(screen)
				packageName = pkgName
				documentation = "generated by hypermodels.com"
			]
		)
	}
	def void toFields(JvmGenericType type, GameScreen screen, JvmGenericType gameClass) {
		var JvmField field = null
		field = screen.toField("game", _typeReferenceBuilder.typeRef(gameClass))
		type.members += field
		field = screen.toField("atlas", _typeReferenceBuilder.typeRef(TextureAtlas))
		type.members += field
		type.members += screen.toGetter("atlas", _typeReferenceBuilder.typeRef(TextureAtlas))
	}

	def void toOperations(JvmGenericType type, GameScreen screen) {
		type.members += screen.toMethod("resize", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			parameters += screen.toParameter("width", _typeReferenceBuilder.typeRef(int))
			parameters += screen.toParameter("height", _typeReferenceBuilder.typeRef(int))
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("pause", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("resume", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("dispose", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("show", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("render", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			parameters += screen.toParameter("delta", _typeReferenceBuilder.typeRef(float))
			body = [
				append(
				'''
				''')
			]
		])
		type.members += screen.toMethod("hide", _typeReferenceBuilder.typeRef(Void::TYPE), [
			annotations += _annotationTypesBuilder.annotationRef(Override)
			body = [
				append(
				'''
				''')
			]
		])
	}
}