package com.hypermodel.games.engine.jvmmodel;

import android.os.Bundle;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.common.base.Objects;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.hypermodel.games.engine.gameDSL.GameActor;
import com.hypermodel.games.engine.gameDSL.GameBodyProperty;
import com.hypermodel.games.engine.gameDSL.GameContactType;
import com.hypermodel.games.engine.gameDSL.GameDisplay;
import com.hypermodel.games.engine.gameDSL.GameDisplayValueType;
import com.hypermodel.games.engine.gameDSL.GameEvent;
import com.hypermodel.games.engine.gameDSL.GameInput;
import com.hypermodel.games.engine.gameDSL.GamePackage;
import com.hypermodel.games.engine.gameDSL.GameRoot;
import com.hypermodel.games.engine.gameDSL.GameScene;
import com.hypermodel.games.engine.gameDSL.GameScreen;
import com.hypermodel.games.engine.gameDSL.GameSprite;
import com.hypermodel.games.engine.gameDSL.GameSpriteAnimation;
import com.hypermodel.games.engine.gameDSL.GameSpriteStand;
import com.hypermodel.games.engine.gameDSL.GameSpriteState;
import com.hypermodel.games.engine.gameDSL.GameTile;
import com.hypermodel.games.engine.generator.GameProperties;
import java.util.Arrays;
import java.util.function.Consumer;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.moe.natj.general.Pointer;

@SuppressWarnings("all")
public class GameDSLJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private TypesFactory typesFactory;
  
  @Inject
  @Extension
  private IJvmTypeProvider.Factory typeProviderFactory;
  
  private final String genInfo = "generated by hypermodels.com";
  
  protected void _infer(final GamePackage gamePkg, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    final Consumer<GameRoot> _function = (GameRoot game) -> {
      final JvmGenericType rootClass = this._jvmTypesBuilder.toClass(gamePkg, this._iQualifiedNameProvider.getFullyQualifiedName(game));
      final Procedure1<JvmGenericType> _function_1 = (JvmGenericType it) -> {
        EList<JvmTypeReference> _superTypes = it.getSuperTypes();
        JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(Game.class);
        this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
        it.setPackageName(this._iQualifiedNameProvider.getFullyQualifiedName(game).skipLast(1).toString());
        this._jvmTypesBuilder.setDocumentation(it, this.genInfo);
        this.toFields(it, game);
        this.toOperations(it, gamePkg, game);
      };
      acceptor.<JvmGenericType>accept(rootClass, _function_1);
      final Function1<GameProperties.ProjectType, Boolean> _function_2 = (GameProperties.ProjectType it) -> {
        return Boolean.valueOf((!Objects.equal(it, GameProperties.ProjectType.core)));
      };
      final Consumer<GameProperties.ProjectType> _function_3 = (GameProperties.ProjectType it) -> {
        this.createLauncher(acceptor, gamePkg, game, it);
      };
      IterableExtensions.<GameProperties.ProjectType>filter(((Iterable<GameProperties.ProjectType>)Conversions.doWrapArray(GameProperties.ProjectType.values())), _function_2).forEach(_function_3);
      final Consumer<GameScene> _function_4 = (GameScene it) -> {
        this.createScene(acceptor, gamePkg, rootClass, it);
      };
      game.getScenes().forEach(_function_4);
      final Consumer<GameScreen> _function_5 = (GameScreen it) -> {
        this.createScreen(acceptor, gamePkg, rootClass, it, game);
      };
      game.getScreens().forEach(_function_5);
    };
    gamePkg.getGames().forEach(_function);
  }
  
  protected void createLauncher(final IJvmDeclaredTypeAcceptor acceptor, final GamePackage gamePkg, final GameRoot game, final GameProperties.ProjectType pType) {
    final String doc = this.genInfo;
    if (pType != null) {
      switch (pType) {
        case android:
          StringConcatenation _builder = new StringConcatenation();
          String _firstUpper = StringExtensions.toFirstUpper(pType.name());
          _builder.append(_firstUpper);
          _builder.append("Launcher");
          final JvmGenericType launcherClass = this._jvmTypesBuilder.toClass(gamePkg, _builder.toString());
          launcherClass.getSuperTypes().add(this._typeReferenceBuilder.typeRef(AndroidApplication.class));
          final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
            final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
              EList<JvmFormalParameter> _parameters = it_1.getParameters();
              JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "savedInstanceState", this._typeReferenceBuilder.typeRef(Bundle.class));
              this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
              JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
              this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
              final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("super.onCreate(savedInstanceState);");
                _builder_1.newLine();
                _builder_1.append("AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();");
                _builder_1.newLine();
                {
                  boolean _isUseAccelerometer = gamePkg.getConfig().getAndroid().isUseAccelerometer();
                  if (_isUseAccelerometer) {
                    _builder_1.append("config.useAccelerometer = true;");
                  }
                }
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("initialize(new ");
                String _firstUpper_1 = StringExtensions.toFirstUpper(game.getName());
                _builder_1.append(_firstUpper_1);
                _builder_1.append("(), config);");
                it_2.append(_builder_1);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_2);
            };
            JvmOperation method = this._jvmTypesBuilder.toMethod(game, "onCreate", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_1);
            EList<JvmMember> _members = it.getMembers();
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members, method);
            it.setPackageName(this._iQualifiedNameProvider.getFullyQualifiedName(gamePkg).toString());
            this._jvmTypesBuilder.setDocumentation(it, doc);
          };
          acceptor.<JvmGenericType>accept(launcherClass, _function);
          break;
        case desktop:
          StringConcatenation _builder_1 = new StringConcatenation();
          String _firstUpper_1 = StringExtensions.toFirstUpper(pType.name());
          _builder_1.append(_firstUpper_1);
          _builder_1.append("Launcher");
          final JvmGenericType launcherClass_1 = this._jvmTypesBuilder.toClass(gamePkg, _builder_1.toString());
          final Procedure1<JvmGenericType> _function_1 = (JvmGenericType it) -> {
            final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
              EList<JvmFormalParameter> _parameters = it_1.getParameters();
              JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "arg", this._typeReferenceBuilder.typeRef(String[].class));
              this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();");
                _builder_2.newLine();
                _builder_2.append("new LwjglApplication(new ");
                QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(game);
                _builder_2.append(_fullyQualifiedName);
                _builder_2.append("(), config);");
                it_2.append(_builder_2);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_3);
            };
            JvmOperation method = this._jvmTypesBuilder.toMethod(game, "main", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_2);
            method.setStatic(true);
            EList<JvmMember> _members = it.getMembers();
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members, method);
            StringConcatenation _builder_2 = new StringConcatenation();
            String _string = this._iQualifiedNameProvider.getFullyQualifiedName(gamePkg).toString();
            _builder_2.append(_string);
            _builder_2.append(".");
            String _name = pType.name();
            _builder_2.append(_name);
            it.setPackageName(_builder_2.toString());
            this._jvmTypesBuilder.setDocumentation(it, doc);
          };
          acceptor.<JvmGenericType>accept(launcherClass_1, _function_1);
          break;
        case html:
          StringConcatenation _builder_2 = new StringConcatenation();
          String _firstUpper_2 = StringExtensions.toFirstUpper(pType.name());
          _builder_2.append(_firstUpper_2);
          _builder_2.append("Launcher");
          final JvmGenericType launcherClass_2 = this._jvmTypesBuilder.toClass(gamePkg, _builder_2.toString());
          launcherClass_2.getSuperTypes().add(this._typeReferenceBuilder.typeRef(GwtApplication.class));
          final Procedure1<JvmGenericType> _function_2 = (JvmGenericType it) -> {
            StringConcatenation _builder_3 = new StringConcatenation();
            String _string = this._iQualifiedNameProvider.getFullyQualifiedName(gamePkg).toString();
            _builder_3.append(_string);
            _builder_3.append(".client");
            it.setPackageName(_builder_3.toString());
            this._jvmTypesBuilder.setDocumentation(it, doc);
            final Procedure1<JvmField> _function_3 = (JvmField it_1) -> {
              final Procedure1<ITreeAppendable> _function_4 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("0");
                it_2.append(_builder_4);
              };
              this._jvmTypesBuilder.setInitializer(it_1, _function_4);
            };
            JvmField field = this._jvmTypesBuilder.toField(game, "PADDING", this._typeReferenceBuilder.typeRef(int.class), _function_3);
            EList<JvmMember> _members = it.getMembers();
            this._jvmTypesBuilder.<JvmField>operator_add(_members, field);
            field = this._jvmTypesBuilder.toField(game, "cfg", this._typeReferenceBuilder.typeRef(GwtApplicationConfiguration.class));
            EList<JvmMember> _members_1 = it.getMembers();
            this._jvmTypesBuilder.<JvmField>operator_add(_members_1, field);
            final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
              EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
              JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
              this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
              final Procedure1<ITreeAppendable> _function_5 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("int w = Window.getClientWidth() - PADDING;");
                _builder_4.newLine();
                _builder_4.append("int h = Window.getClientHeight() - PADDING;");
                _builder_4.newLine();
                _builder_4.append("cfg = new GwtApplicationConfiguration(w, h);");
                _builder_4.newLine();
                _builder_4.append("Window.enableScrolling(false);");
                _builder_4.newLine();
                _builder_4.append("Window.setMargin(\"0\");");
                _builder_4.newLine();
                _builder_4.append("Window.addResizeHandler(new ResizeListener());");
                _builder_4.newLine();
                _builder_4.append("cfg.preferFlash = false;");
                _builder_4.newLine();
                _builder_4.append("return cfg;");
                it_2.append(_builder_4);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_5);
            };
            JvmOperation method = this._jvmTypesBuilder.toMethod(game, "getConfig", this._typeReferenceBuilder.typeRef(GwtApplicationConfiguration.class), _function_4);
            EList<JvmMember> _members_2 = it.getMembers();
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, method);
            final Procedure1<JvmOperation> _function_5 = (JvmOperation it_1) -> {
              EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
              JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
              this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
              final Procedure1<ITreeAppendable> _function_6 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("return new ");
                QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(game);
                _builder_4.append(_fullyQualifiedName);
                _builder_4.append("();");
                it_2.append(_builder_4);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_6);
            };
            method = this._jvmTypesBuilder.toMethod(game, "createApplicationListener", this._typeReferenceBuilder.typeRef(ApplicationListener.class), _function_5);
            EList<JvmMember> _members_3 = it.getMembers();
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, method);
            final JvmGenericType resizeClass = this._jvmTypesBuilder.toClass(gamePkg, "ResizeListener");
            resizeClass.getSuperTypes().add(this._typeReferenceBuilder.typeRef(ResizeHandler.class));
            final Procedure1<JvmOperation> _function_6 = (JvmOperation it_1) -> {
              EList<JvmFormalParameter> _parameters = it_1.getParameters();
              JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "event", this._typeReferenceBuilder.typeRef(ResizeEvent.class));
              this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
              JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
              this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
              final Procedure1<ITreeAppendable> _function_7 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("int width = event.getWidth() - PADDING;");
                _builder_4.newLine();
                _builder_4.append("int height = event.getHeight() - PADDING;");
                _builder_4.newLine();
                _builder_4.append("getRootPanel().setWidth(\"\" + width + \"px\");");
                _builder_4.newLine();
                _builder_4.append("getRootPanel().setHeight(\"\" + height + \"px\");");
                _builder_4.newLine();
                _builder_4.append("getApplicationListener().resize(width, height);");
                _builder_4.newLine();
                _builder_4.append("Gdx.graphics.setWindowedMode(width, height);");
                it_2.append(_builder_4);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_7);
            };
            JvmOperation innermethod = this._jvmTypesBuilder.toMethod(game, "onResize", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_6);
            EList<JvmMember> _members_4 = resizeClass.getMembers();
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_4, innermethod);
            EList<JvmMember> _members_5 = it.getMembers();
            this._jvmTypesBuilder.<JvmGenericType>operator_add(_members_5, resizeClass);
          };
          acceptor.<JvmGenericType>accept(launcherClass_2, _function_2);
          break;
        case ios:
          StringConcatenation _builder_3 = new StringConcatenation();
          String _upperCase = pType.name().toUpperCase();
          _builder_3.append(_upperCase);
          _builder_3.append("Launcher");
          final JvmGenericType launcherClass_3 = this._jvmTypesBuilder.toClass(gamePkg, _builder_3.toString());
          launcherClass_3.getSuperTypes().add(this._typeReferenceBuilder.typeRef(IOSApplication.Delegate.class));
          final Procedure1<JvmGenericType> _function_3 = (JvmGenericType it) -> {
            StringConcatenation _builder_4 = new StringConcatenation();
            String _string = this._iQualifiedNameProvider.getFullyQualifiedName(gamePkg).toString();
            _builder_4.append(_string);
            it.setPackageName(_builder_4.toString());
            this._jvmTypesBuilder.setDocumentation(it, doc);
            final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
              EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
              JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
              this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
              final Procedure1<ITreeAppendable> _function_5 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("IOSApplicationConfiguration config = new IOSApplicationConfiguration();");
                _builder_5.newLine();
                {
                  boolean _isUseAccelerometer = gamePkg.getConfig().getIos().isUseAccelerometer();
                  if (_isUseAccelerometer) {
                    _builder_5.append("config.useAccelerometer = true;");
                  }
                }
                _builder_5.newLineIfNotEmpty();
                _builder_5.append("return new IOSApplication(new ");
                String _firstUpper_3 = StringExtensions.toFirstUpper(game.getName());
                _builder_5.append(_firstUpper_3);
                _builder_5.append("(), config);");
                it_2.append(_builder_5);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_5);
            };
            JvmOperation method = this._jvmTypesBuilder.toMethod(game, "createApplication", this._typeReferenceBuilder.typeRef(IOSApplication.class), _function_4);
            EList<JvmMember> _members = it.getMembers();
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members, method);
            final Procedure1<JvmOperation> _function_5 = (JvmOperation it_1) -> {
              EList<JvmFormalParameter> _parameters = it_1.getParameters();
              JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "arg", this._typeReferenceBuilder.typeRef(String[].class));
              this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              final Procedure1<ITreeAppendable> _function_6 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("NSAutoreleasePool pool = new NSAutoreleasePool();");
                _builder_5.newLine();
                _builder_5.append("UIApplication.main(arg, null, ");
                String _upperCase_1 = pType.name().toUpperCase();
                _builder_5.append(_upperCase_1);
                _builder_5.append(GameProperties.launcherPostfix);
                _builder_5.append(".class);");
                _builder_5.newLineIfNotEmpty();
                _builder_5.append("pool.close();");
                it_2.append(_builder_5);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_6);
            };
            method = this._jvmTypesBuilder.toMethod(game, "main", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_5);
            method.setStatic(true);
            EList<JvmMember> _members_1 = it.getMembers();
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, method);
          };
          acceptor.<JvmGenericType>accept(launcherClass_3, _function_3);
          break;
        case iosmoe:
          StringConcatenation _builder_4 = new StringConcatenation();
          String _upperCase_1 = pType.name().toUpperCase();
          _builder_4.append(_upperCase_1);
          _builder_4.append("Launcher");
          final JvmGenericType launcherClass_4 = this._jvmTypesBuilder.toClass(gamePkg, _builder_4.toString());
          launcherClass_4.getSuperTypes().add(this._typeReferenceBuilder.typeRef(com.badlogic.gdx.backends.iosmoe.IOSApplication.Delegate.class));
          final Procedure1<JvmGenericType> _function_4 = (JvmGenericType it) -> {
            it.setPackageName(this._iQualifiedNameProvider.getFullyQualifiedName(gamePkg).toString());
            this._jvmTypesBuilder.setDocumentation(it, doc);
            final Procedure1<JvmConstructor> _function_5 = (JvmConstructor it_1) -> {
              EList<JvmFormalParameter> _parameters = it_1.getParameters();
              JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "peer", this._typeReferenceBuilder.typeRef(Pointer.class));
              this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              final Procedure1<ITreeAppendable> _function_6 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("super(peer);");
                it_2.append(_builder_5);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_6);
            };
            JvmConstructor constructor = this._jvmTypesBuilder.toConstructor(game, _function_5);
            constructor.setVisibility(JvmVisibility.PROTECTED);
            EList<JvmMember> _members = it.getMembers();
            this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, constructor);
            final Procedure1<JvmOperation> _function_6 = (JvmOperation it_1) -> {
              EList<JvmAnnotationReference> _annotations = it_1.getAnnotations();
              JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
              this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
              final Procedure1<ITreeAppendable> _function_7 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("IOSApplicationConfiguration config = new IOSApplicationConfiguration();");
                _builder_5.newLine();
                {
                  boolean _isUseAccelerometer = gamePkg.getConfig().getIosmoe().isUseAccelerometer();
                  if (_isUseAccelerometer) {
                    _builder_5.append("config.useAccelerometer = true;");
                  }
                }
                _builder_5.newLineIfNotEmpty();
                _builder_5.append("return new IOSApplication(new ");
                String _firstUpper_3 = StringExtensions.toFirstUpper(game.getName());
                _builder_5.append(_firstUpper_3);
                _builder_5.append("(), config);");
                it_2.append(_builder_5);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_7);
            };
            JvmOperation method = this._jvmTypesBuilder.toMethod(game, "createApplication", this._typeReferenceBuilder.typeRef(com.badlogic.gdx.backends.iosmoe.IOSApplication.class), _function_6);
            EList<JvmMember> _members_1 = it.getMembers();
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, method);
            final Procedure1<JvmOperation> _function_7 = (JvmOperation it_1) -> {
              EList<JvmFormalParameter> _parameters = it_1.getParameters();
              JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "arg", this._typeReferenceBuilder.typeRef(String[].class));
              this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              final Procedure1<ITreeAppendable> _function_8 = (ITreeAppendable it_2) -> {
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append("UIKit.UIApplicationMain(0, null, null, ");
                String _upperCase_2 = pType.name().toUpperCase();
                _builder_5.append(_upperCase_2);
                _builder_5.append(GameProperties.launcherPostfix);
                _builder_5.append(".class.getName());");
                it_2.append(_builder_5);
              };
              this._jvmTypesBuilder.setBody(it_1, _function_8);
            };
            method = this._jvmTypesBuilder.toMethod(game, "main", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_7);
            method.setStatic(true);
            EList<JvmMember> _members_2 = it.getMembers();
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, method);
          };
          acceptor.<JvmGenericType>accept(launcherClass_4, _function_4);
          break;
        default:
          break;
      }
    } else {
    }
  }
  
  public void toFields(final JvmGenericType type, final GameRoot game) {
    JvmField field = null;
    field = this._jvmTypesBuilder.toField(game, "batch", this._typeReferenceBuilder.typeRef(SpriteBatch.class));
    field.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmMember> _members = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members, field);
    final Procedure1<JvmField> _function = (JvmField it) -> {
      final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        int _width = game.getWidth();
        _builder.append(_width);
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setInitializer(it, _function_1);
    };
    field = this._jvmTypesBuilder.toField(game, "V_WIDTH", this._typeReferenceBuilder.typeRef(int.class), _function);
    field.setStatic(true);
    field.setFinal(true);
    field.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmMember> _members_1 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_1, field);
    final Procedure1<JvmField> _function_1 = (JvmField it) -> {
      final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        int _height = game.getHeight();
        _builder.append(_height);
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setInitializer(it, _function_2);
    };
    field = this._jvmTypesBuilder.toField(game, "V_HEIGHT", this._typeReferenceBuilder.typeRef(int.class), _function_1);
    field.setStatic(true);
    field.setFinal(true);
    field.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmMember> _members_2 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_2, field);
    final Procedure1<JvmField> _function_2 = (JvmField it) -> {
      final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        String _title = game.getTitle();
        _builder.append(_title);
        _builder.append("\"");
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setInitializer(it, _function_3);
    };
    field = this._jvmTypesBuilder.toField(game, "TITLE", this._typeReferenceBuilder.typeRef(String.class), _function_2);
    field.setStatic(true);
    field.setFinal(true);
    field.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmMember> _members_3 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_3, field);
    final Procedure1<JvmField> _function_3 = (JvmField it) -> {
      final Procedure1<ITreeAppendable> _function_4 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        int _ppm = game.getPpm();
        _builder.append(_ppm);
        _builder.append("f");
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setInitializer(it, _function_4);
    };
    field = this._jvmTypesBuilder.toField(game, "PPM", this._typeReferenceBuilder.typeRef(float.class), _function_3);
    field.setStatic(true);
    field.setFinal(true);
    field.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmMember> _members_4 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_4, field);
  }
  
  public void toOperations(final JvmGenericType type, final GamePackage gamePkg, final GameRoot game) {
    EList<JvmMember> _members = type.getMembers();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("batch = new SpriteBatch();");
        _builder.newLine();
        it_1.append(_builder);
        EList<GameScreen> _screens = game.getScreens();
        for (final GameScreen screen : _screens) {
          {
            it_1.append("setScreen(new ");
            it_1.append(this._jvmTypesBuilder.toClass(gamePkg, this._iQualifiedNameProvider.getFullyQualifiedName(screen)));
            it_1.append("(this));");
          }
        }
      };
      this._jvmTypesBuilder.setBody(it, _function_1);
    };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(game, "create", this._typeReferenceBuilder.typeRef(Void.TYPE), _function);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    EList<JvmMember> _members_1 = type.getMembers();
    final Procedure1<JvmOperation> _function_1 = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("super.render();");
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_2);
    };
    JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(game, "render", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_1);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
    EList<JvmMember> _members_2 = type.getMembers();
    final Procedure1<JvmOperation> _function_2 = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("super.dispose();");
        _builder.newLine();
        _builder.append("batch.dispose();");
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_3);
    };
    JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(game, "dispose", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_2);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method_2);
  }
  
  public void createScreen(final IJvmDeclaredTypeAcceptor acceptor, final GamePackage gamePkg, final JvmGenericType gameClass, final GameScreen screen, final GameRoot root) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(gamePkg);
    String _plus = (_fullyQualifiedName + ".WorldContact");
    final JvmGenericType contactClass = this._jvmTypesBuilder.toClass(gamePkg, _plus);
    this.createContactListener(acceptor, gamePkg, contactClass, root);
    final JvmGenericType screenClass = this._jvmTypesBuilder.toClass(gamePkg, this._iQualifiedNameProvider.getFullyQualifiedName(screen));
    QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(gamePkg);
    String _plus_1 = (_fullyQualifiedName_1 + ".WorldCreator");
    final JvmGenericType creatorClass = this._jvmTypesBuilder.toClass(gamePkg, _plus_1);
    this.createCreator(acceptor, gamePkg, creatorClass, gameClass, screenClass, screen, root);
    final Function1<GameSprite, Boolean> _function = (GameSprite it) -> {
      return Boolean.valueOf(it.isHasStartPosition());
    };
    final GameSprite playerSprite = IterableExtensions.<GameSprite>findFirst(screen.getSprites(), _function);
    JvmGenericType pClass = null;
    if ((playerSprite != null)) {
      pClass = this._jvmTypesBuilder.toClass(gamePkg, this._iQualifiedNameProvider.getFullyQualifiedName(playerSprite));
    }
    final JvmGenericType playerClass = pClass;
    final Procedure1<JvmGenericType> _function_1 = (JvmGenericType it) -> {
      EList<JvmTypeReference> _superTypes = it.getSuperTypes();
      JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(Screen.class);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
      it.setPackageName(this._iQualifiedNameProvider.getFullyQualifiedName(screen).skipLast(1).toString());
      this._jvmTypesBuilder.setDocumentation(it, this.genInfo);
      this.toFields(it, gamePkg, root, screen, gameClass, creatorClass, contactClass, playerClass);
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmConstructor> _function_2 = (JvmConstructor it_1) -> {
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(gamePkg, "game", this._typeReferenceBuilder.typeRef(gameClass));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_2) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("this.game = game;");
          _builder.newLine();
          _builder.append("atlas = new TextureAtlas(\"");
          String _atlasName = screen.getAtlasName();
          _builder.append(_atlasName);
          _builder.append(".pack\");");
          _builder.newLineIfNotEmpty();
          _builder.append("gamecam = new OrthographicCamera();");
          _builder.newLine();
          _builder.append("gamePort = new ");
          it_2.append(_builder);
          it_2.append(FitViewport.class);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("(");
          String _simpleName = gameClass.getSimpleName();
          _builder_1.append(_simpleName);
          _builder_1.append(".V_WIDTH / ");
          String _simpleName_1 = gameClass.getSimpleName();
          _builder_1.append(_simpleName_1);
          _builder_1.append(".PPM, ");
          String _simpleName_2 = gameClass.getSimpleName();
          _builder_1.append(_simpleName_2);
          _builder_1.append(".V_HEIGHT / ");
          String _simpleName_3 = gameClass.getSimpleName();
          _builder_1.append(_simpleName_3);
          _builder_1.append(".PPM, gamecam);");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("mapLoader = new TmxMapLoader();");
          _builder_1.newLine();
          _builder_1.append("map = mapLoader.load(\"");
          String _map = screen.getMap();
          _builder_1.append(_map);
          _builder_1.append("\");");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("renderer = new OrthogonalTiledMapRenderer(map, 1 / ");
          String _simpleName_4 = gameClass.getSimpleName();
          _builder_1.append(_simpleName_4);
          _builder_1.append(".PPM);");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);");
          _builder_1.newLine();
          _builder_1.append("world = new World(new ");
          it_2.append(_builder_1);
          it_2.append(Vector2.class);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("(0, -10), true);");
          _builder_2.newLine();
          {
            boolean _isDebug = root.isDebug();
            if (_isDebug) {
              _builder_2.append("b2dr = new Box2DDebugRenderer();");
            }
          }
          _builder_2.newLineIfNotEmpty();
          {
            GameScene _scene = screen.getScene();
            boolean _tripleNotEquals = (_scene != null);
            if (_tripleNotEquals) {
              String _firstLower = StringExtensions.toFirstLower(screen.getScene().getName());
              _builder_2.append(_firstLower);
              _builder_2.append(" = new ");
              String _firstUpper = StringExtensions.toFirstUpper(screen.getScene().getName());
              _builder_2.append(_firstUpper);
              _builder_2.append("(game.batch);");
            }
          }
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("creator = new ");
          QualifiedName _fullyQualifiedName_2 = this._iQualifiedNameProvider.getFullyQualifiedName(creatorClass);
          _builder_2.append(_fullyQualifiedName_2);
          _builder_2.append("(this);");
          _builder_2.newLineIfNotEmpty();
          {
            if ((playerClass != null)) {
              _builder_2.append("player = new ");
              QualifiedName _fullyQualifiedName_3 = this._iQualifiedNameProvider.getFullyQualifiedName(playerClass);
              _builder_2.append(_fullyQualifiedName_3);
              _builder_2.append("(this);");
            }
          }
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("world.setContactListener(new ");
          QualifiedName _fullyQualifiedName_4 = this._iQualifiedNameProvider.getFullyQualifiedName(contactClass);
          _builder_2.append(_fullyQualifiedName_4);
          _builder_2.append("());");
          _builder_2.newLineIfNotEmpty();
          it_2.append(_builder_2);
        };
        this._jvmTypesBuilder.setBody(it_1, _function_3);
      };
      JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(screen, _function_2);
      this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
      this.toOperations(it, screen, playerSprite, root);
    };
    acceptor.<JvmGenericType>accept(screenClass, _function_1);
    final Consumer<GameSprite> _function_2 = (GameSprite it) -> {
      this.createSprite(acceptor, gamePkg, gameClass, screenClass, it);
    };
    screen.getSprites().forEach(_function_2);
    final Consumer<GameTile> _function_3 = (GameTile it) -> {
      this.createTile(acceptor, gamePkg, gameClass, screenClass, it, root);
    };
    screen.getTiles().forEach(_function_3);
  }
  
  public void toFields(final JvmGenericType type, final GamePackage gamePkg, final GameRoot game, final GameScreen screen, final JvmGenericType gameClass, final JvmGenericType creatorClass, final JvmGenericType contactClass, final JvmGenericType playerClass) {
    JvmField field = null;
    EList<JvmMember> _members = type.getMembers();
    JvmField _field = this._jvmTypesBuilder.toField(screen, "game", this._typeReferenceBuilder.typeRef(gameClass));
    this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
    EList<JvmMember> _members_1 = type.getMembers();
    JvmField _field_1 = this._jvmTypesBuilder.toField(screen, "atlas", this._typeReferenceBuilder.typeRef(TextureAtlas.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_1, _field_1);
    EList<JvmMember> _members_2 = type.getMembers();
    JvmField _field_2 = this._jvmTypesBuilder.toField(screen, "gamecam", this._typeReferenceBuilder.typeRef(OrthographicCamera.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_2, _field_2);
    EList<JvmMember> _members_3 = type.getMembers();
    JvmField _field_3 = this._jvmTypesBuilder.toField(screen, "gamePort", this._typeReferenceBuilder.typeRef(Viewport.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_3, _field_3);
    EList<JvmMember> _members_4 = type.getMembers();
    JvmField _field_4 = this._jvmTypesBuilder.toField(screen, "mapLoader", this._typeReferenceBuilder.typeRef(TmxMapLoader.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_4, _field_4);
    EList<JvmMember> _members_5 = type.getMembers();
    JvmField _field_5 = this._jvmTypesBuilder.toField(screen, "map", this._typeReferenceBuilder.typeRef(TiledMap.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_5, _field_5);
    EList<JvmMember> _members_6 = type.getMembers();
    JvmField _field_6 = this._jvmTypesBuilder.toField(screen, "renderer", this._typeReferenceBuilder.typeRef(OrthogonalTiledMapRenderer.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_6, _field_6);
    EList<JvmMember> _members_7 = type.getMembers();
    JvmField _field_7 = this._jvmTypesBuilder.toField(screen, "world", this._typeReferenceBuilder.typeRef(World.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_7, _field_7);
    boolean _isDebug = game.isDebug();
    if (_isDebug) {
      EList<JvmMember> _members_8 = type.getMembers();
      JvmField _field_8 = this._jvmTypesBuilder.toField(screen, "b2dr", this._typeReferenceBuilder.typeRef(Box2DDebugRenderer.class));
      this._jvmTypesBuilder.<JvmField>operator_add(_members_8, _field_8);
    }
    EList<JvmMember> _members_9 = type.getMembers();
    JvmField _field_9 = this._jvmTypesBuilder.toField(screen, "music", this._typeReferenceBuilder.typeRef(Music.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_9, _field_9);
    EList<JvmMember> _members_10 = type.getMembers();
    JvmField _field_10 = this._jvmTypesBuilder.toField(screen, "creator", this._typeReferenceBuilder.typeRef(creatorClass));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_10, _field_10);
    if ((playerClass != null)) {
      EList<JvmMember> _members_11 = type.getMembers();
      JvmField _field_11 = this._jvmTypesBuilder.toField(screen, "player", this._typeReferenceBuilder.typeRef(playerClass));
      this._jvmTypesBuilder.<JvmField>operator_add(_members_11, _field_11);
    }
    GameScene _scene = screen.getScene();
    boolean _tripleNotEquals = (_scene != null);
    if (_tripleNotEquals) {
      field = this._jvmTypesBuilder.toField(screen, StringExtensions.toFirstLower(screen.getScene().getName()), this._typeReferenceBuilder.typeRef(this._jvmTypesBuilder.toClass(gamePkg, this._iQualifiedNameProvider.getFullyQualifiedName(screen.getScene()))));
      field.setVisibility(JvmVisibility.PUBLIC);
      EList<JvmMember> _members_12 = type.getMembers();
      this._jvmTypesBuilder.<JvmField>operator_add(_members_12, field);
    }
  }
  
  public void toOperations(final JvmGenericType type, final GameScreen screen, final GameSprite playerSprite, final GameRoot game) {
    EList<JvmMember> _members = type.getMembers();
    JvmOperation _getter = this._jvmTypesBuilder.toGetter(screen, "atlas", this._typeReferenceBuilder.typeRef(TextureAtlas.class));
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _getter);
    EList<JvmMember> _members_1 = type.getMembers();
    JvmOperation _getter_1 = this._jvmTypesBuilder.toGetter(screen, "map", this._typeReferenceBuilder.typeRef(TiledMap.class));
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _getter_1);
    EList<JvmMember> _members_2 = type.getMembers();
    JvmOperation _getter_2 = this._jvmTypesBuilder.toGetter(screen, "world", this._typeReferenceBuilder.typeRef(World.class));
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _getter_2);
    EList<JvmMember> _members_3 = type.getMembers();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(screen, "width", this._typeReferenceBuilder.typeRef(int.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      JvmFormalParameter _parameter_1 = this._jvmTypesBuilder.toParameter(screen, "height", this._typeReferenceBuilder.typeRef(int.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
      final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("gamePort.update(width, height);");
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_1);
    };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(screen, "resize", this._typeReferenceBuilder.typeRef(Void.TYPE), _function);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _method);
    EList<JvmMember> _members_4 = type.getMembers();
    final Procedure1<JvmOperation> _function_1 = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_2);
    };
    JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(screen, "pause", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_1);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_4, _method_1);
    EList<JvmMember> _members_5 = type.getMembers();
    final Procedure1<JvmOperation> _function_2 = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_3);
    };
    JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(screen, "resume", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_2);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_2);
    EList<JvmMember> _members_6 = type.getMembers();
    final Procedure1<JvmOperation> _function_3 = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Procedure1<ITreeAppendable> _function_4 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("map.dispose();");
        _builder.newLine();
        _builder.append("renderer.dispose();");
        _builder.newLine();
        _builder.append("world.dispose();");
        _builder.newLine();
        {
          boolean _isDebug = game.isDebug();
          if (_isDebug) {
            _builder.append("b2dr.dispose();");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          GameScene _scene = screen.getScene();
          boolean _tripleNotEquals = (_scene != null);
          if (_tripleNotEquals) {
            String _firstLower = StringExtensions.toFirstLower(screen.getScene().getName());
            _builder.append(_firstLower);
            _builder.append(".dispose();");
          }
        }
        _builder.newLineIfNotEmpty();
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_4);
    };
    JvmOperation _method_3 = this._jvmTypesBuilder.toMethod(screen, "dispose", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_3);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_6, _method_3);
    EList<JvmMember> _members_7 = type.getMembers();
    final Procedure1<JvmOperation> _function_4 = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Procedure1<ITreeAppendable> _function_5 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_5);
    };
    JvmOperation _method_4 = this._jvmTypesBuilder.toMethod(screen, "show", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_4);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_7, _method_4);
    EList<JvmMember> _members_8 = type.getMembers();
    final Procedure1<JvmOperation> _function_5 = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(screen, "delta", this._typeReferenceBuilder.typeRef(float.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      final Procedure1<ITreeAppendable> _function_6 = (ITreeAppendable it_1) -> {
        boolean _isEmpty = playerSprite.getInputs().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          final ITreeAppendable current = it_1;
          final Consumer<GameInput> _function_7 = (GameInput it_2) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("if(");
            current.append(_builder);
            current.append(Gdx.class);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append(".input.isKey");
            String _firstUpper = StringExtensions.toFirstUpper(it_2.getKeyType().getName());
            _builder_1.append(_firstUpper);
            _builder_1.append("(");
            current.append(_builder_1);
            current.append(Input.class);
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append(".Keys.");
            String _upperCase = it_2.getKey().getName().toUpperCase();
            _builder_2.append(_upperCase);
            _builder_2.append(")) {");
            _builder_2.newLineIfNotEmpty();
            current.append(_builder_2);
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("\t");
            _builder_3.append("player.");
            String _name = it_2.getTrigger().getName();
            _builder_3.append(_name, "\t");
            _builder_3.append("();");
            _builder_3.newLineIfNotEmpty();
            current.append(_builder_3);
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("}");
            _builder_4.newLine();
            current.append(_builder_4);
          };
          playerSprite.getInputs().forEach(_function_7);
        }
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("world.step(");
        float _timeStep = game.getTimeStep();
        _builder.append(_timeStep);
        _builder.append("f, ");
        int _velocityIterations = game.getVelocityIterations();
        _builder.append(_velocityIterations);
        _builder.append(", ");
        int _positionIterations = game.getPositionIterations();
        _builder.append(_positionIterations);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("player.update(delta);");
        _builder.newLine();
        _builder.append("creator.updateSprites(delta, player.getX());");
        _builder.newLine();
        _builder.append("hud.update(delta);");
        _builder.newLine();
        _builder.append("gamecam.position.x = player.body.getPosition().x;");
        _builder.newLine();
        _builder.append("gamecam.update();");
        _builder.newLine();
        _builder.append("renderer.setView(gamecam);");
        _builder.newLine();
        it_1.append(_builder);
        it_1.append(Gdx.class);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(".gl.glClearColor(0, 0, 0, 1);");
        _builder_1.newLine();
        _builder_1.append("Gdx.gl.glClear(");
        it_1.append(_builder_1);
        it_1.append(GL20.class);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(".GL_COLOR_BUFFER_BIT);");
        _builder_2.newLine();
        _builder_2.append("renderer.render();");
        _builder_2.newLine();
        _builder_2.append("game.batch.setProjectionMatrix(gamecam.combined);");
        _builder_2.newLine();
        _builder_2.append("game.batch.begin();");
        _builder_2.newLine();
        _builder_2.append("player.draw(game.batch);");
        _builder_2.newLine();
        _builder_2.append("creator.drawSprites(game.batch);");
        _builder_2.newLine();
        _builder_2.append("game.batch.end();");
        _builder_2.newLine();
        {
          boolean _isDebug = game.isDebug();
          if (_isDebug) {
            _builder_2.append("b2dr.render(world, gamecam.combined);");
          }
        }
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("game.batch.setProjectionMatrix(hud.stage.getCamera().combined);");
        _builder_2.newLine();
        _builder_2.append("hud.stage.draw();");
        _builder_2.newLine();
        it_1.append(_builder_2);
      };
      this._jvmTypesBuilder.setBody(it, _function_6);
    };
    JvmOperation _method_5 = this._jvmTypesBuilder.toMethod(screen, "render", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_5);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_8, _method_5);
    EList<JvmMember> _members_9 = type.getMembers();
    final Procedure1<JvmOperation> _function_6 = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Procedure1<ITreeAppendable> _function_7 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_7);
    };
    JvmOperation _method_6 = this._jvmTypesBuilder.toMethod(screen, "hide", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_6);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_9, _method_6);
  }
  
  public void createScene(final IJvmDeclaredTypeAcceptor acceptor, final GamePackage gamePkg, final JvmGenericType gameClass, final GameScene scene) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<JvmTypeReference> _superTypes = it.getSuperTypes();
      JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(Disposable.class);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
      it.setPackageName(this._iQualifiedNameProvider.getFullyQualifiedName(scene).skipLast(1).toString());
      this._jvmTypesBuilder.setDocumentation(it, this.genInfo);
      this.toFields(it, scene, gameClass);
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmConstructor> _function_1 = (JvmConstructor it_1) -> {
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(gamePkg, "spriteBatch", this._typeReferenceBuilder.typeRef(SpriteBatch.class));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
          it_2.append("viewport = new ");
          it_2.append(FitViewport.class);
          it_2.append("(");
          it_2.append(this._jvmTypesBuilder.toClass(gamePkg, this._iQualifiedNameProvider.getFullyQualifiedName(gameClass)));
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(".V_WIDTH, ");
          String _simpleName = gameClass.getSimpleName();
          _builder.append(_simpleName);
          _builder.append(".V_HEIGHT, new ");
          it_2.append(_builder);
          it_2.append(OrthographicCamera.class);
          it_2.append("());\n");
          it_2.append("stage = new ");
          it_2.append(Stage.class);
          it_2.append("(viewport, spriteBatch);\n");
          it_2.append(Table.class);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(" ");
          _builder_1.append("table = new Table();");
          _builder_1.newLine();
          _builder_1.append("table.top();");
          _builder_1.newLine();
          _builder_1.append("table.setFillParent(true);");
          _builder_1.newLine();
          _builder_1.append("stage.addActor(table);");
          _builder_1.newLine();
          it_2.append(_builder_1);
          final ITreeAppendable current = it_2;
          boolean _isHasScore = scene.isHasScore();
          if (_isHasScore) {
            final Consumer<GameDisplay> _function_3 = (GameDisplay it_3) -> {
              StringConcatenation _builder_2 = new StringConcatenation();
              String _name = it_3.getName();
              _builder_2.append(_name);
              _builder_2.append("TitleLabel = new Label(\"");
              String _upperCase = it_3.getName().toUpperCase();
              _builder_2.append(_upperCase);
              _builder_2.append("\", new Label.LabelStyle(new ");
              current.append(_builder_2);
              current.append(BitmapFont.class);
              current.append("(), ");
              current.append(Color.class);
              current.append(".WHITE));\n");
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("table.add(");
              String _name_1 = it_3.getName();
              _builder_3.append(_name_1);
              _builder_3.append("TitleLabel).expandX().padTop(");
              int _topPadding = scene.getScore().getTopPadding();
              _builder_3.append(_topPadding);
              _builder_3.append(");");
              _builder_3.newLineIfNotEmpty();
              current.append(_builder_3);
            };
            scene.getScore().getDisplays().forEach(_function_3);
            it_2.append("table.row();\n");
            final Consumer<GameDisplay> _function_4 = (GameDisplay it_3) -> {
              StringConcatenation _builder_2 = new StringConcatenation();
              String _name = it_3.getName();
              _builder_2.append(_name);
              _builder_2.append("ValueLabel = new Label(String.format(\"");
              String _format = it_3.getFormat();
              _builder_2.append(_format);
              _builder_2.append("\", ");
              String _name_1 = it_3.getName();
              _builder_2.append(_name_1);
              _builder_2.append("), new Label.LabelStyle(new BitmapFont(), Color.WHITE));");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("table.add(");
              String _name_2 = it_3.getName();
              _builder_2.append(_name_2);
              _builder_2.append("ValueLabel).expandX();");
              _builder_2.newLineIfNotEmpty();
              current.append(_builder_2);
            };
            scene.getScore().getDisplays().forEach(_function_4);
          }
        };
        this._jvmTypesBuilder.setBody(it_1, _function_2);
      };
      JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(scene, _function_1);
      this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
      this.toOperations(it, scene);
    };
    acceptor.<JvmGenericType>accept(
      this._jvmTypesBuilder.toClass(gamePkg, this._iQualifiedNameProvider.getFullyQualifiedName(scene)), _function);
  }
  
  public void toFields(final JvmGenericType type, final GameScene scene, final JvmGenericType gameClass) {
    JvmField field = this._jvmTypesBuilder.toField(scene, "stage", this._typeReferenceBuilder.typeRef(Stage.class));
    field.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmMember> _members = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members, field);
    EList<JvmMember> _members_1 = type.getMembers();
    JvmField _field = this._jvmTypesBuilder.toField(scene, "viewport", this._typeReferenceBuilder.typeRef(Viewport.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_1, _field);
    boolean _isHasScore = scene.isHasScore();
    if (_isHasScore) {
      final Consumer<GameDisplay> _function = (GameDisplay it) -> {
        EList<JvmMember> _members_2 = type.getMembers();
        StringConcatenation _builder = new StringConcatenation();
        String _name = it.getName();
        _builder.append(_name);
        _builder.append("TimeCount");
        final Procedure1<JvmField> _function_1 = (JvmField it_1) -> {
          final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
            it_2.append("0");
          };
          this._jvmTypesBuilder.setInitializer(it_1, _function_2);
        };
        JvmField _field_1 = this._jvmTypesBuilder.toField(scene, _builder.toString(), this._typeReferenceBuilder.typeRef(float.class), _function_1);
        this._jvmTypesBuilder.<JvmField>operator_add(_members_2, _field_1);
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = it.getName();
        _builder_1.append(_name_1);
        JvmField displayField = this._jvmTypesBuilder.toField(scene, _builder_1.toString(), this._typeReferenceBuilder.typeRef(it.getType().getName()));
        final GameDisplay current = it;
        final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_1) -> {
          StringConcatenation _builder_2 = new StringConcatenation();
          {
            boolean _isHasInitial = current.isHasInitial();
            if (_isHasInitial) {
              {
                GameDisplayValueType _type = current.getType();
                boolean _equals = Objects.equal(_type, GameDisplayValueType.STRING);
                if (_equals) {
                  _builder_2.append("\"");
                  String _initialStringValue = current.getInitialStringValue();
                  _builder_2.append(_initialStringValue);
                  _builder_2.append("\"");
                } else {
                  GameDisplayValueType _type_1 = current.getType();
                  boolean _equals_1 = Objects.equal(_type_1, GameDisplayValueType.FLOAT);
                  if (_equals_1) {
                    float _initialNumberValue = current.getInitialNumberValue();
                    _builder_2.append(_initialNumberValue);
                  } else {
                    GameDisplayValueType _type_2 = current.getType();
                    boolean _equals_2 = Objects.equal(_type_2, GameDisplayValueType.INT);
                    if (_equals_2) {
                      int _initialIntValue = current.getInitialIntValue();
                      _builder_2.append(_initialIntValue);
                    }
                  }
                }
              }
            } else {
              {
                GameDisplayValueType _type_3 = current.getType();
                boolean _equals_3 = Objects.equal(_type_3, GameDisplayValueType.STRING);
                if (_equals_3) {
                  _builder_2.append("\"\"");
                } else {
                  GameDisplayValueType _type_4 = current.getType();
                  boolean _equals_4 = Objects.equal(_type_4, GameDisplayValueType.FLOAT);
                  if (_equals_4) {
                    _builder_2.append("0.0");
                  } else {
                    GameDisplayValueType _type_5 = current.getType();
                    boolean _equals_5 = Objects.equal(_type_5, GameDisplayValueType.INT);
                    if (_equals_5) {
                      _builder_2.append("0");
                    }
                  }
                }
              }
            }
          }
          it_1.append(_builder_2);
        };
        this._jvmTypesBuilder.setInitializer(displayField, _function_2);
        if ((it.isHasAdder() || it.isHasSetter())) {
          displayField.setStatic(true);
        }
        EList<JvmMember> _members_3 = type.getMembers();
        this._jvmTypesBuilder.<JvmField>operator_add(_members_3, displayField);
        EList<JvmMember> _members_4 = type.getMembers();
        StringConcatenation _builder_2 = new StringConcatenation();
        String _name_2 = it.getName();
        _builder_2.append(_name_2);
        _builder_2.append("TitleLabel");
        JvmField _field_2 = this._jvmTypesBuilder.toField(scene, _builder_2.toString(), this._typeReferenceBuilder.typeRef(Label.class));
        this._jvmTypesBuilder.<JvmField>operator_add(_members_4, _field_2);
        StringConcatenation _builder_3 = new StringConcatenation();
        String _name_3 = it.getName();
        _builder_3.append(_name_3);
        _builder_3.append("ValueLabel");
        JvmField valueField = this._jvmTypesBuilder.toField(scene, _builder_3.toString(), this._typeReferenceBuilder.typeRef(Label.class));
        if ((it.isHasAdder() || it.isHasSetter())) {
          valueField.setStatic(true);
        }
        EList<JvmMember> _members_5 = type.getMembers();
        this._jvmTypesBuilder.<JvmField>operator_add(_members_5, valueField);
      };
      scene.getScore().getDisplays().forEach(_function);
    }
  }
  
  public void toOperations(final JvmGenericType type, final GameScene scene) {
    EList<JvmMember> _members = type.getMembers();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(scene, "dt", this._typeReferenceBuilder.typeRef(float.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it_1) -> {
        final ITreeAppendable current = it_1;
        boolean _isHasScore = scene.isHasScore();
        if (_isHasScore) {
          final Function1<GameDisplay, Boolean> _function_2 = (GameDisplay it_2) -> {
            return Boolean.valueOf(it_2.isHasDelta());
          };
          final Consumer<GameDisplay> _function_3 = (GameDisplay it_2) -> {
            StringConcatenation _builder = new StringConcatenation();
            String _name = it_2.getName();
            _builder.append(_name);
            _builder.append("TimeCount += dt;");
            _builder.newLineIfNotEmpty();
            _builder.append("if (");
            String _name_1 = it_2.getName();
            _builder.append(_name_1);
            _builder.append("TimeCount >= ");
            float _timePeriod = it_2.getTimePeriod();
            _builder.append(_timePeriod);
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _name_2 = it_2.getName();
            _builder.append(_name_2, "\t");
            _builder.append(" += ");
            float _deltaValue = it_2.getDeltaValue();
            _builder.append(_deltaValue, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _name_3 = it_2.getName();
            _builder.append(_name_3, "\t");
            _builder.append("ValueLabel.setText(String.format(\"");
            String _format = it_2.getFormat();
            _builder.append(_format, "\t");
            _builder.append("\", ");
            String _name_4 = it_2.getName();
            _builder.append(_name_4, "\t");
            _builder.append("));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _name_5 = it_2.getName();
            _builder.append(_name_5, "\t");
            _builder.append("TimeCount = 0;");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
            current.append(_builder);
          };
          IterableExtensions.<GameDisplay>filter(scene.getScore().getDisplays(), _function_2).forEach(_function_3);
        }
      };
      this._jvmTypesBuilder.setBody(it, _function_1);
    };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(scene, "update", this._typeReferenceBuilder.typeRef(Void.TYPE), _function);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    EList<JvmMember> _members_1 = type.getMembers();
    final Procedure1<JvmOperation> _function_1 = (JvmOperation it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("stage.dispose();");
        _builder.newLine();
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_2);
    };
    JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(scene, "dispose", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_1);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
    boolean _isHasScore = scene.isHasScore();
    if (_isHasScore) {
      final Function1<GameDisplay, Boolean> _function_2 = (GameDisplay it) -> {
        return Boolean.valueOf(it.isHasAdder());
      };
      final Consumer<GameDisplay> _function_3 = (GameDisplay it) -> {
        final GameDisplay current = it;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("add");
        String _firstUpper = StringExtensions.toFirstUpper(it.getName());
        _builder.append(_firstUpper);
        final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(scene, "value", this._typeReferenceBuilder.typeRef(current.getType().getName()));
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          final Procedure1<ITreeAppendable> _function_5 = (ITreeAppendable it_2) -> {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _name = current.getName();
            _builder_1.append(_name);
            _builder_1.append(" += value;");
            _builder_1.newLineIfNotEmpty();
            String _name_1 = current.getName();
            _builder_1.append(_name_1);
            _builder_1.append("ValueLabel.setText(String.format(\"");
            String _format = current.getFormat();
            _builder_1.append(_format);
            _builder_1.append("\", ");
            String _name_2 = current.getName();
            _builder_1.append(_name_2);
            _builder_1.append("));");
            _builder_1.newLineIfNotEmpty();
            it_2.append(_builder_1);
          };
          this._jvmTypesBuilder.setBody(it_1, _function_5);
        };
        JvmOperation operation = this._jvmTypesBuilder.toMethod(scene, _builder.toString(), this._typeReferenceBuilder.typeRef(Void.TYPE), _function_4);
        operation.setStatic(true);
        EList<JvmMember> _members_2 = type.getMembers();
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, operation);
      };
      IterableExtensions.<GameDisplay>filter(scene.getScore().getDisplays(), _function_2).forEach(_function_3);
      final Function1<GameDisplay, Boolean> _function_4 = (GameDisplay it) -> {
        return Boolean.valueOf(it.isHasSetter());
      };
      final Consumer<GameDisplay> _function_5 = (GameDisplay it) -> {
        final GameDisplay current = it;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("set");
        String _firstUpper = StringExtensions.toFirstUpper(it.getName());
        _builder.append(_firstUpper);
        final Procedure1<JvmOperation> _function_6 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(scene, "value", this._typeReferenceBuilder.typeRef(current.getType().getName()));
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          final Procedure1<ITreeAppendable> _function_7 = (ITreeAppendable it_2) -> {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _name = current.getName();
            _builder_1.append(_name);
            _builder_1.append(" = value;");
            _builder_1.newLineIfNotEmpty();
            String _name_1 = current.getName();
            _builder_1.append(_name_1);
            _builder_1.append("ValueLabel.setText(String.format(\"");
            String _format = current.getFormat();
            _builder_1.append(_format);
            _builder_1.append("\", ");
            String _name_2 = current.getName();
            _builder_1.append(_name_2);
            _builder_1.append("));");
            _builder_1.newLineIfNotEmpty();
            it_2.append(_builder_1);
          };
          this._jvmTypesBuilder.setBody(it_1, _function_7);
        };
        JvmOperation operation = this._jvmTypesBuilder.toMethod(scene, _builder.toString(), this._typeReferenceBuilder.typeRef(Void.TYPE), _function_6);
        operation.setStatic(true);
        EList<JvmMember> _members_2 = type.getMembers();
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, operation);
      };
      IterableExtensions.<GameDisplay>filter(scene.getScore().getDisplays(), _function_4).forEach(_function_5);
    }
  }
  
  public void createSprite(final IJvmDeclaredTypeAcceptor acceptor, final GamePackage gamePkg, final JvmGenericType gameClass, final JvmGenericType screenClass, final GameSprite sprite) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<JvmTypeReference> _superTypes = it.getSuperTypes();
      JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(Sprite.class);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
      it.setPackageName(this._iQualifiedNameProvider.getFullyQualifiedName(sprite).skipLast(1).toString());
      this._jvmTypesBuilder.setDocumentation(it, this.genInfo);
      this.toFields(it, sprite);
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmConstructor> _function_1 = (JvmConstructor it_1) -> {
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(gamePkg, "screen", this._typeReferenceBuilder.typeRef(screenClass));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        boolean _isHasStartPosition = sprite.isHasStartPosition();
        boolean _not = (!_isHasStartPosition);
        if (_not) {
          EList<JvmFormalParameter> _parameters_1 = it_1.getParameters();
          JvmFormalParameter _parameter_1 = this._jvmTypesBuilder.toParameter(gamePkg, "x", this._typeReferenceBuilder.typeRef(float.class));
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
          EList<JvmFormalParameter> _parameters_2 = it_1.getParameters();
          JvmFormalParameter _parameter_2 = this._jvmTypesBuilder.toParameter(gamePkg, "y", this._typeReferenceBuilder.typeRef(float.class));
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_2, _parameter_2);
        }
        final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("world = screen.getWorld();");
          _builder.newLine();
          _builder.append("stateTimer = 0;");
          _builder.newLine();
          _builder.append("float xPosition = ");
          {
            boolean _isHasStartPosition_1 = sprite.isHasStartPosition();
            if (_isHasStartPosition_1) {
              float _x = sprite.getStartPosition().getX();
              _builder.append(_x);
              _builder.append("f");
            } else {
              _builder.append("x");
            }
          }
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("float yPosition = ");
          {
            boolean _isHasStartPosition_2 = sprite.isHasStartPosition();
            if (_isHasStartPosition_2) {
              float _y = sprite.getStartPosition().getY();
              _builder.append(_y);
              _builder.append("f");
            } else {
              _builder.append("y");
            }
          }
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          it_2.append(_builder);
          it_2.append(Array.class);
          it_2.append("<");
          it_2.append(TextureRegion.class);
          it_2.append("> frames = new Array<TextureRegion>();\n");
          final ITreeAppendable current = it_2;
          final Consumer<GameSpriteState> _function_3 = (GameSpriteState it_3) -> {
            GameSpriteAnimation _animation = it_3.getAnimation();
            boolean _tripleNotEquals = (_animation != null);
            if (_tripleNotEquals) {
              boolean _isHasFrames = it_3.getAnimation().isHasFrames();
              if (_isHasFrames) {
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("for (int i = ");
                int _offset = it_3.getAnimation().getOffset();
                _builder_1.append(_offset);
                _builder_1.append("; i < ");
                int _frames = it_3.getAnimation().getFrames();
                int _offset_1 = it_3.getAnimation().getOffset();
                int _plus = (_frames + _offset_1);
                _builder_1.append(_plus);
                _builder_1.append("; i++) {");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("\t");
                _builder_1.append("TextureRegion ");
                String _name = it_3.getAnimation().getName();
                _builder_1.append(_name, "\t");
                _builder_1.append("TextureRegion = new TextureRegion(screen.getAtlas().findRegion(\"");
                String _region = it_3.getAnimation().getRegion().getRegion();
                _builder_1.append(_region, "\t");
                _builder_1.append("\"), i * ");
                int _width = it_3.getAnimation().getRegion().getWidth();
                _builder_1.append(_width, "\t");
                _builder_1.append(", 0, ");
                int _width_1 = it_3.getAnimation().getRegion().getWidth();
                _builder_1.append(_width_1, "\t");
                _builder_1.append(", ");
                int _height = it_3.getAnimation().getRegion().getHeight();
                _builder_1.append(_height, "\t");
                _builder_1.append(");");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("\t");
                {
                  if ((it_3.getAnimation().getRegion().isFlipX() || it_3.getAnimation().getRegion().isFlipY())) {
                    String _name_1 = it_3.getAnimation().getName();
                    _builder_1.append(_name_1, "\t");
                    _builder_1.append("TextureRegion.flip(");
                    boolean _booleanValue = Boolean.valueOf(it_3.getAnimation().getRegion().isFlipX()).booleanValue();
                    _builder_1.append(_booleanValue, "\t");
                    _builder_1.append(", ");
                    boolean _booleanValue_1 = Boolean.valueOf(it_3.getAnimation().getRegion().isFlipY()).booleanValue();
                    _builder_1.append(_booleanValue_1, "\t");
                    _builder_1.append(");");
                  }
                }
                _builder_1.append(" ");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("\t");
                _builder_1.append("frames.add(");
                String _name_2 = it_3.getAnimation().getName();
                _builder_1.append(_name_2, "\t");
                _builder_1.append("TextureRegion);");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("}");
                _builder_1.newLine();
                current.append(_builder_1);
              }
              boolean _isHasStands = it_3.getAnimation().isHasStands();
              if (_isHasStands) {
                final Consumer<GameSpriteStand> _function_4 = (GameSpriteStand it_4) -> {
                  StringConcatenation _builder_2 = new StringConcatenation();
                  _builder_2.append("TextureRegion ");
                  String _name_3 = it_4.getName();
                  _builder_2.append(_name_3);
                  _builder_2.append("TextureRegion = new TextureRegion(screen.getAtlas().findRegion(\"");
                  String _region_1 = it_4.getRegion().getRegion();
                  _builder_2.append(_region_1);
                  _builder_2.append("\"), ");
                  int _offset_2 = it_4.getOffset();
                  int _width_2 = it_4.getRegion().getWidth();
                  int _multiply = (_offset_2 * _width_2);
                  _builder_2.append(_multiply);
                  _builder_2.append(", 0, ");
                  int _width_3 = it_4.getRegion().getWidth();
                  _builder_2.append(_width_3);
                  _builder_2.append(", ");
                  int _height_1 = it_4.getRegion().getHeight();
                  _builder_2.append(_height_1);
                  _builder_2.append(");");
                  _builder_2.newLineIfNotEmpty();
                  {
                    if ((it_4.getRegion().isFlipX() || it_4.getRegion().isFlipY())) {
                      String _name_4 = it_4.getName();
                      _builder_2.append(_name_4);
                      _builder_2.append("TextureRegion.flip(");
                      boolean _booleanValue_2 = Boolean.valueOf(it_4.getRegion().isFlipX()).booleanValue();
                      _builder_2.append(_booleanValue_2);
                      _builder_2.append(", ");
                      boolean _booleanValue_3 = Boolean.valueOf(it_4.getRegion().isFlipY()).booleanValue();
                      _builder_2.append(_booleanValue_3);
                      _builder_2.append(");");
                    }
                  }
                  _builder_2.append(" ");
                  _builder_2.newLineIfNotEmpty();
                  _builder_2.append("frames.add(");
                  String _name_5 = it_4.getName();
                  _builder_2.append(_name_5);
                  _builder_2.append("TextureRegion);");
                  _builder_2.newLineIfNotEmpty();
                  current.append(_builder_2);
                };
                it_3.getAnimation().getStands().forEach(_function_4);
              }
              StringConcatenation _builder_2 = new StringConcatenation();
              String _name_3 = it_3.getAnimation().getName();
              _builder_2.append(_name_3);
              _builder_2.append(" = new ");
              current.append(_builder_2);
              current.append(Animation.class);
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("<TextureRegion>(");
              float _duration = it_3.getAnimation().getDuration();
              _builder_3.append(_duration);
              _builder_3.append("f, frames);");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append("frames.clear();");
              _builder_3.newLine();
              current.append(_builder_3);
            }
            GameSpriteStand _stand = it_3.getStand();
            boolean _tripleNotEquals_1 = (_stand != null);
            if (_tripleNotEquals_1) {
              StringConcatenation _builder_4 = new StringConcatenation();
              String _name_4 = it_3.getStand().getName();
              _builder_4.append(_name_4);
              _builder_4.append(" = new TextureRegion(screen.getAtlas().findRegion(\"");
              String _region_1 = it_3.getStand().getRegion().getRegion();
              _builder_4.append(_region_1);
              _builder_4.append("\"), ");
              int _offset_2 = it_3.getStand().getOffset();
              int _width_2 = it_3.getStand().getRegion().getWidth();
              int _multiply = (_offset_2 * _width_2);
              _builder_4.append(_multiply);
              _builder_4.append(", 0, ");
              int _width_3 = it_3.getStand().getRegion().getWidth();
              _builder_4.append(_width_3);
              _builder_4.append(", ");
              int _height_1 = it_3.getStand().getRegion().getHeight();
              _builder_4.append(_height_1);
              _builder_4.append(");");
              _builder_4.newLineIfNotEmpty();
              {
                if ((it_3.getStand().getRegion().isFlipX() || it_3.getStand().getRegion().isFlipY())) {
                  String _name_5 = it_3.getStand().getName();
                  _builder_4.append(_name_5);
                  _builder_4.append(".flip(");
                  boolean _booleanValue_2 = Boolean.valueOf(it_3.getStand().getRegion().isFlipX()).booleanValue();
                  _builder_4.append(_booleanValue_2);
                  _builder_4.append(", ");
                  boolean _booleanValue_3 = Boolean.valueOf(it_3.getStand().getRegion().isFlipY()).booleanValue();
                  _builder_4.append(_booleanValue_3);
                  _builder_4.append(");");
                }
              }
              _builder_4.append(" ");
              _builder_4.newLineIfNotEmpty();
              current.append(_builder_4);
            }
          };
          sprite.getStates().forEach(_function_3);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("define");
          String _firstUpper = StringExtensions.toFirstUpper(sprite.getName());
          _builder_1.append(_firstUpper);
          _builder_1.append("(new Vector2(xPosition / ");
          it_2.append(_builder_1);
          it_2.append(gameClass);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append(".PPM, yPosition / ");
          String _simpleName = gameClass.getSimpleName();
          _builder_2.append(_simpleName);
          _builder_2.append(".PPM));");
          _builder_2.newLineIfNotEmpty();
          it_2.append(_builder_2);
          it_2.append("setRegion(getFrame(0.0f));\n");
        };
        this._jvmTypesBuilder.setBody(it_1, _function_2);
      };
      JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(sprite, _function_1);
      this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
      this.toOperations(it, sprite, gameClass);
    };
    acceptor.<JvmGenericType>accept(
      this._jvmTypesBuilder.toClass(gamePkg, this._iQualifiedNameProvider.getFullyQualifiedName(sprite)), _function);
  }
  
  public void toFields(final JvmGenericType type, final GameSprite sprite) {
    JvmField field = this._jvmTypesBuilder.toField(sprite, "world", this._typeReferenceBuilder.typeRef(World.class));
    field.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmMember> _members = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members, field);
    field = this._jvmTypesBuilder.toField(sprite, "body", this._typeReferenceBuilder.typeRef(Body.class));
    field.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmMember> _members_1 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_1, field);
    EList<JvmMember> _members_2 = type.getMembers();
    JvmField _field = this._jvmTypesBuilder.toField(sprite, "stateTimer", this._typeReferenceBuilder.typeRef(float.class));
    this._jvmTypesBuilder.<JvmField>operator_add(_members_2, _field);
    final Procedure1<JvmEnumerationType> _function = (JvmEnumerationType it) -> {
      final Consumer<GameSpriteState> _function_1 = (GameSpriteState state) -> {
        EList<JvmMember> _members_3 = it.getMembers();
        JvmEnumerationLiteral _enumerationLiteral = this._jvmTypesBuilder.toEnumerationLiteral(state, state.getName().toUpperCase());
        this._jvmTypesBuilder.<JvmEnumerationLiteral>operator_add(_members_3, _enumerationLiteral);
      };
      sprite.getStates().forEach(_function_1);
    };
    JvmEnumerationType stateType = this._jvmTypesBuilder.toEnumerationType(sprite, "State", _function);
    final Consumer<GameSpriteState> _function_1 = (GameSpriteState state) -> {
      GameSpriteAnimation _animation = state.getAnimation();
      boolean _tripleNotEquals = (_animation != null);
      if (_tripleNotEquals) {
        EList<JvmMember> _members_3 = type.getMembers();
        JvmField _field_1 = this._jvmTypesBuilder.toField(sprite, state.getAnimation().getName(), this._typeReferenceBuilder.typeRef(Animation.class, this._typeReferenceBuilder.typeRef(TextureRegion.class)));
        this._jvmTypesBuilder.<JvmField>operator_add(_members_3, _field_1);
      }
      GameSpriteStand _stand = state.getStand();
      boolean _tripleNotEquals_1 = (_stand != null);
      if (_tripleNotEquals_1) {
        EList<JvmMember> _members_4 = type.getMembers();
        JvmField _field_2 = this._jvmTypesBuilder.toField(sprite, state.getStand().getName(), this._typeReferenceBuilder.typeRef(TextureRegion.class));
        this._jvmTypesBuilder.<JvmField>operator_add(_members_4, _field_2);
      }
    };
    sprite.getStates().forEach(_function_1);
    EList<JvmMember> _members_3 = type.getMembers();
    this._jvmTypesBuilder.<JvmEnumerationType>operator_add(_members_3, stateType);
    EList<JvmMember> _members_4 = type.getMembers();
    final Procedure1<JvmField> _function_2 = (JvmField it) -> {
      final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("State.");
        String _upperCase = sprite.getInitialState().getName().toUpperCase();
        _builder.append(_upperCase);
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setInitializer(it, _function_3);
    };
    JvmField _field_1 = this._jvmTypesBuilder.toField(sprite, "currentState", this._typeReferenceBuilder.typeRef(stateType), _function_2);
    this._jvmTypesBuilder.<JvmField>operator_add(_members_4, _field_1);
    EList<JvmMember> _members_5 = type.getMembers();
    final Procedure1<JvmField> _function_3 = (JvmField it) -> {
      final Procedure1<ITreeAppendable> _function_4 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("State.");
        String _upperCase = sprite.getInitialState().getName().toUpperCase();
        _builder.append(_upperCase);
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setInitializer(it, _function_4);
    };
    JvmField _field_2 = this._jvmTypesBuilder.toField(sprite, "previousState", this._typeReferenceBuilder.typeRef(stateType), _function_3);
    this._jvmTypesBuilder.<JvmField>operator_add(_members_5, _field_2);
    EList<JvmMember> _members_6 = type.getMembers();
    final Procedure1<JvmField> _function_4 = (JvmField it) -> {
      final Procedure1<ITreeAppendable> _function_5 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("0.0f");
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setInitializer(it, _function_5);
    };
    JvmField _field_3 = this._jvmTypesBuilder.toField(sprite, "positionOffsetX", this._typeReferenceBuilder.typeRef(float.class), _function_4);
    this._jvmTypesBuilder.<JvmField>operator_add(_members_6, _field_3);
    EList<JvmMember> _members_7 = type.getMembers();
    final Procedure1<JvmField> _function_5 = (JvmField it) -> {
      final Procedure1<ITreeAppendable> _function_6 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("0.0f");
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setInitializer(it, _function_6);
    };
    JvmField _field_4 = this._jvmTypesBuilder.toField(sprite, "positionOffsetY", this._typeReferenceBuilder.typeRef(float.class), _function_5);
    this._jvmTypesBuilder.<JvmField>operator_add(_members_7, _field_4);
    boolean _isHasVelocity = sprite.isHasVelocity();
    if (_isHasVelocity) {
      EList<JvmMember> _members_8 = type.getMembers();
      final Procedure1<JvmField> _function_6 = (JvmField it) -> {
        final Procedure1<ITreeAppendable> _function_7 = (ITreeAppendable it_1) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("new Vector2(");
          float _x = sprite.getVelocity().getX();
          _builder.append(_x);
          _builder.append("f,");
          float _y = sprite.getVelocity().getY();
          _builder.append(_y);
          _builder.append("f)");
          it_1.append(_builder);
        };
        this._jvmTypesBuilder.setInitializer(it, _function_7);
      };
      JvmField _field_5 = this._jvmTypesBuilder.toField(sprite, "velocity", this._typeReferenceBuilder.typeRef(Vector2.class), _function_6);
      this._jvmTypesBuilder.<JvmField>operator_add(_members_8, _field_5);
    }
    final GameSprite fsprite = sprite;
    final Consumer<GameBodyProperty> _function_7 = (GameBodyProperty it) -> {
      EList<JvmMember> _members_9 = type.getMembers();
      StringConcatenation _builder = new StringConcatenation();
      String _name = it.getName();
      _builder.append(_name);
      final Procedure1<JvmField> _function_8 = (JvmField it_1) -> {
        final Procedure1<ITreeAppendable> _function_9 = (ITreeAppendable it_2) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("false");
          it_2.append(_builder_1);
        };
        this._jvmTypesBuilder.setInitializer(it_1, _function_9);
      };
      JvmField _field_6 = this._jvmTypesBuilder.toField(fsprite, _builder.toString(), this._typeReferenceBuilder.typeRef(Boolean.class), _function_8);
      this._jvmTypesBuilder.<JvmField>operator_add(_members_9, _field_6);
    };
    sprite.getProperties().forEach(_function_7);
    EList<JvmMember> _members_9 = type.getMembers();
    JvmOperation _getter = this._jvmTypesBuilder.toGetter(sprite, "currentState", this._typeReferenceBuilder.typeRef(stateType));
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_9, _getter);
  }
  
  public void toOperations(final JvmGenericType type, final GameSprite sprite, final JvmGenericType gameClass) {
    final int i = ((int) 0);
    EList<GameSpriteState> _states = sprite.getStates();
    for (final GameSpriteState state : _states) {
      EList<JvmMember> _members = type.getMembers();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("is");
      String _firstUpper = StringExtensions.toFirstUpper(state.getRule().getName());
      _builder.append(_firstUpper);
      final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
        this._jvmTypesBuilder.setDocumentation(it, this._jvmTypesBuilder.getDocumentation(state.getRule()));
        EList<JvmFormalParameter> _params = state.getRule().getParams();
        for (final JvmFormalParameter p : _params) {
          EList<JvmFormalParameter> _parameters = it.getParameters();
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(p, p.getName(), p.getParameterType());
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        }
        this._jvmTypesBuilder.setBody(it, state.getRule().getBody());
      };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(sprite, _builder.toString(), this._typeReferenceBuilder.typeRef(boolean.class), _function);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    }
    final GameSprite fsprite = sprite;
    final Consumer<GameBodyProperty> _function_1 = (GameBodyProperty it) -> {
      final GameBodyProperty prop = it;
      EList<JvmMember> _members_1 = type.getMembers();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("is");
      String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
      _builder_1.append(_firstUpper_1);
      final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
        final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_2) -> {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("return ");
          String _name = prop.getName();
          _builder_2.append(_name);
          _builder_2.append(";");
          _builder_2.newLineIfNotEmpty();
          it_2.append(_builder_2);
        };
        this._jvmTypesBuilder.setBody(it_1, _function_3);
      };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(fsprite, _builder_1.toString(), this._typeReferenceBuilder.typeRef(Boolean.class), _function_2);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
    };
    sprite.getProperties().forEach(_function_1);
    final Consumer<GameBodyProperty> _function_2 = (GameBodyProperty it) -> {
      final GameBodyProperty prop = it;
      EList<JvmMember> _members_1 = type.getMembers();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("set");
      String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
      _builder_1.append(_firstUpper_1);
      final Procedure1<JvmOperation> _function_3 = (JvmOperation it_1) -> {
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(sprite, "value", this._typeReferenceBuilder.typeRef(Boolean.class));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        final Procedure1<ITreeAppendable> _function_4 = (ITreeAppendable it_2) -> {
          StringConcatenation _builder_2 = new StringConcatenation();
          String _name = prop.getName();
          _builder_2.append(_name);
          _builder_2.append(" = value;");
          _builder_2.newLineIfNotEmpty();
          it_2.append(_builder_2);
        };
        this._jvmTypesBuilder.setBody(it_1, _function_4);
      };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(fsprite, _builder_1.toString(), this._typeReferenceBuilder.typeRef(Void.TYPE), _function_3);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
    };
    sprite.getProperties().forEach(_function_2);
    final Function1<GameBodyProperty, Boolean> _function_3 = (GameBodyProperty it) -> {
      return Boolean.valueOf(it.isOnUpdateTrue());
    };
    final Consumer<GameBodyProperty> _function_4 = (GameBodyProperty it) -> {
      final GameBodyProperty prop = it;
      EList<JvmMember> _members_1 = type.getMembers();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("doTrue");
      String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
      _builder_1.append(_firstUpper_1);
      final Procedure1<JvmOperation> _function_5 = (JvmOperation it_1) -> {
        this._jvmTypesBuilder.setDocumentation(it_1, this._jvmTypesBuilder.getDocumentation(prop));
        this._jvmTypesBuilder.setBody(it_1, prop.getBody());
      };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(sprite, _builder_1.toString(), this._typeReferenceBuilder.typeRef(Void.TYPE), _function_5);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
    };
    IterableExtensions.<GameBodyProperty>filter(sprite.getProperties(), _function_3).forEach(_function_4);
    final Function1<GameBodyProperty, Boolean> _function_5 = (GameBodyProperty it) -> {
      return Boolean.valueOf(it.isOnUpdateFalse());
    };
    final Consumer<GameBodyProperty> _function_6 = (GameBodyProperty it) -> {
      final GameBodyProperty prop = it;
      EList<JvmMember> _members_1 = type.getMembers();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("doFalse");
      String _firstUpper_1 = StringExtensions.toFirstUpper(it.getName());
      _builder_1.append(_firstUpper_1);
      final Procedure1<JvmOperation> _function_7 = (JvmOperation it_1) -> {
        this._jvmTypesBuilder.setDocumentation(it_1, this._jvmTypesBuilder.getDocumentation(prop));
        this._jvmTypesBuilder.setBody(it_1, prop.getBody());
      };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(sprite, _builder_1.toString(), this._typeReferenceBuilder.typeRef(Void.TYPE), _function_7);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
    };
    IterableExtensions.<GameBodyProperty>filter(sprite.getProperties(), _function_5).forEach(_function_6);
    EList<JvmMember> _members_1 = type.getMembers();
    final Procedure1<JvmOperation> _function_7 = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(sprite, "dt", this._typeReferenceBuilder.typeRef(float.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      final Procedure1<ITreeAppendable> _function_8 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2);");
        _builder_1.newLine();
        it_1.append(_builder_1);
        final ITreeAppendable current = it_1;
        final Function1<GameBodyProperty, Boolean> _function_9 = (GameBodyProperty it_2) -> {
          return Boolean.valueOf(it_2.isOnUpdateTrue());
        };
        final Consumer<GameBodyProperty> _function_10 = (GameBodyProperty it_2) -> {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("if(");
          String _name = it_2.getName();
          _builder_2.append(_name);
          _builder_2.append(") {");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("doTrue");
          String _firstUpper_1 = StringExtensions.toFirstUpper(it_2.getName());
          _builder_2.append(_firstUpper_1, "\t");
          _builder_2.append("();");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("}");
          _builder_2.newLine();
          current.append(_builder_2);
        };
        IterableExtensions.<GameBodyProperty>filter(sprite.getProperties(), _function_9).forEach(_function_10);
        final Function1<GameBodyProperty, Boolean> _function_11 = (GameBodyProperty it_2) -> {
          return Boolean.valueOf(it_2.isOnUpdateFalse());
        };
        final Consumer<GameBodyProperty> _function_12 = (GameBodyProperty it_2) -> {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("if(!");
          String _name = it_2.getName();
          _builder_2.append(_name);
          _builder_2.append(") {");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("doFalse");
          String _firstUpper_1 = StringExtensions.toFirstUpper(it_2.getName());
          _builder_2.append(_firstUpper_1, "\t");
          _builder_2.append("();");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("}");
          _builder_2.newLine();
          current.append(_builder_2);
        };
        IterableExtensions.<GameBodyProperty>filter(sprite.getProperties(), _function_11).forEach(_function_12);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("setRegion(getFrame(dt));");
        _builder_2.newLine();
        it_1.append(_builder_2);
      };
      this._jvmTypesBuilder.setBody(it, _function_8);
    };
    JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(sprite, "update", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_7);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
    EList<JvmMember> _members_2 = type.getMembers();
    final Procedure1<JvmOperation> _function_8 = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(sprite, "dt", this._typeReferenceBuilder.typeRef(float.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      final Procedure1<ITreeAppendable> _function_9 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("currentState = getState();");
        _builder_1.newLine();
        _builder_1.append("TextureRegion region = null;");
        _builder_1.newLine();
        _builder_1.append("switch (currentState) {");
        _builder_1.newLine();
        it_1.append(_builder_1);
        final ITreeAppendable current = it_1;
        final Consumer<GameSpriteState> _function_10 = (GameSpriteState it_2) -> {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("case ");
          String _upperCase = it_2.getName().toUpperCase();
          _builder_2.append(_upperCase);
          _builder_2.append(":");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("region = ");
          {
            GameSpriteAnimation _animation = it_2.getAnimation();
            boolean _tripleNotEquals = (_animation != null);
            if (_tripleNotEquals) {
              String _name = it_2.getAnimation().getName();
              _builder_2.append(_name, "\t");
              _builder_2.append(".getKeyFrame(stateTimer)");
            } else {
              GameSpriteStand _stand = it_2.getStand();
              boolean _tripleNotEquals_1 = (_stand != null);
              if (_tripleNotEquals_1) {
                String _name_1 = it_2.getStand().getName();
                _builder_2.append(_name_1, "\t");
              }
            }
          }
          _builder_2.append(";");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          {
            if (((it_2.getAnimation() != null) && it_2.isIfFinished())) {
              _builder_2.append("if(");
              String _name_2 = it_2.getAnimation().getName();
              _builder_2.append(_name_2, "\t");
              _builder_2.append(".isAnimationFinished(stateTimer)) {");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("\t");
              _builder_2.append("\t");
              _builder_2.append("set");
              String _firstUpper_1 = StringExtensions.toFirstUpper(it_2.getSetFalse().getName());
              _builder_2.append(_firstUpper_1, "\t\t");
              _builder_2.append("(false);");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("\t");
              _builder_2.append("}");
            }
          }
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("positionOffsetX = ");
          {
            GameSpriteAnimation _animation_1 = it_2.getAnimation();
            boolean _tripleNotEquals_2 = (_animation_1 != null);
            if (_tripleNotEquals_2) {
              {
                boolean _isHasFrames = it_2.getAnimation().isHasFrames();
                if (_isHasFrames) {
                  float _offsetX = it_2.getAnimation().getRegion().getOffsetX();
                  _builder_2.append(_offsetX, "\t");
                  _builder_2.append("f");
                } else {
                  boolean _isHasStands = it_2.getAnimation().isHasStands();
                  if (_isHasStands) {
                    float _offsetX_1 = it_2.getAnimation().getStands().get(0).getRegion().getOffsetX();
                    _builder_2.append(_offsetX_1, "\t");
                    _builder_2.append("f");
                  }
                }
              }
            } else {
              GameSpriteStand _stand_1 = it_2.getStand();
              boolean _tripleNotEquals_3 = (_stand_1 != null);
              if (_tripleNotEquals_3) {
                float _offsetX_2 = it_2.getStand().getRegion().getOffsetX();
                _builder_2.append(_offsetX_2, "\t");
                _builder_2.append("f");
              }
            }
          }
          _builder_2.append(";");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("positionOffsetY = ");
          {
            GameSpriteAnimation _animation_2 = it_2.getAnimation();
            boolean _tripleNotEquals_4 = (_animation_2 != null);
            if (_tripleNotEquals_4) {
              {
                boolean _isHasFrames_1 = it_2.getAnimation().isHasFrames();
                if (_isHasFrames_1) {
                  float _offsetY = it_2.getAnimation().getRegion().getOffsetY();
                  _builder_2.append(_offsetY, "\t");
                  _builder_2.append("f");
                } else {
                  boolean _isHasStands_1 = it_2.getAnimation().isHasStands();
                  if (_isHasStands_1) {
                    float _offsetY_1 = it_2.getAnimation().getStands().get(0).getRegion().getOffsetY();
                    _builder_2.append(_offsetY_1, "\t");
                    _builder_2.append("f");
                  }
                }
              }
            } else {
              GameSpriteStand _stand_2 = it_2.getStand();
              boolean _tripleNotEquals_5 = (_stand_2 != null);
              if (_tripleNotEquals_5) {
                float _offsetY_2 = it_2.getStand().getRegion().getOffsetY();
                _builder_2.append(_offsetY_2, "\t");
                _builder_2.append("f");
              }
            }
          }
          _builder_2.append(";");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("break;");
          _builder_2.newLine();
          current.append(_builder_2);
        };
        sprite.getStates().forEach(_function_10);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("}");
        _builder_2.newLine();
        _builder_2.append("stateTimer = currentState == previousState ? stateTimer + dt : 0;");
        _builder_2.newLine();
        _builder_2.append("previousState = currentState;");
        _builder_2.newLine();
        _builder_2.append("return region;");
        _builder_2.newLine();
        it_1.append(_builder_2);
      };
      this._jvmTypesBuilder.setBody(it, _function_9);
    };
    JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(sprite, "getFrame", this._typeReferenceBuilder.typeRef(TextureRegion.class), _function_8);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method_2);
    EList<JvmMember> _members_3 = type.getMembers();
    final Procedure1<JvmOperation> _function_9 = (JvmOperation it) -> {
      final Procedure1<ITreeAppendable> _function_10 = (ITreeAppendable it_1) -> {
        EList<GameSpriteState> _states_1 = sprite.getStates();
        for (final GameSpriteState state_1 : _states_1) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("if(is");
          String _firstUpper_1 = StringExtensions.toFirstUpper(state_1.getRule().getName());
          _builder_1.append(_firstUpper_1);
          _builder_1.append("()) {");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("return State.");
          String _upperCase = state_1.getName().toUpperCase();
          _builder_1.append(_upperCase, "\t");
          _builder_1.append(";");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          it_1.append(_builder_1);
        }
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("return State.");
        String _upperCase_1 = sprite.getInitialState().getName().toUpperCase();
        _builder_2.append(_upperCase_1);
        _builder_2.append(";");
        _builder_2.newLineIfNotEmpty();
        it_1.append(_builder_2);
      };
      this._jvmTypesBuilder.setBody(it, _function_10);
    };
    JvmOperation _method_3 = this._jvmTypesBuilder.toMethod(sprite, "getState", this._typeReferenceBuilder.typeRef("State"), _function_9);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _method_3);
    EList<JvmMember> _members_4 = type.getMembers();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("redefine");
    String _firstUpper_1 = StringExtensions.toFirstUpper(sprite.getName());
    _builder_1.append(_firstUpper_1);
    final Procedure1<JvmOperation> _function_10 = (JvmOperation it) -> {
      final Procedure1<ITreeAppendable> _function_11 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Vector2 position = body.getPosition();");
        _builder_2.newLine();
        _builder_2.append("world.destroyBody(body);");
        _builder_2.newLine();
        _builder_2.append("position.add(positionOffsetX / ");
        String _simpleName = gameClass.getSimpleName();
        _builder_2.append(_simpleName);
        _builder_2.append(".PPM, positionOffsetY / ");
        String _simpleName_1 = gameClass.getSimpleName();
        _builder_2.append(_simpleName_1);
        _builder_2.append(".PPM); ");
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("define");
        String _firstUpper_2 = StringExtensions.toFirstUpper(sprite.getName());
        _builder_2.append(_firstUpper_2);
        _builder_2.append("(position);");
        _builder_2.newLineIfNotEmpty();
        it_1.append(_builder_2);
      };
      this._jvmTypesBuilder.setBody(it, _function_11);
    };
    JvmOperation _method_4 = this._jvmTypesBuilder.toMethod(sprite, _builder_1.toString(), this._typeReferenceBuilder.typeRef(Void.TYPE), _function_10);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_4, _method_4);
    EList<JvmMember> _members_5 = type.getMembers();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("define");
    String _firstUpper_2 = StringExtensions.toFirstUpper(sprite.getName());
    _builder_2.append(_firstUpper_2);
    final Procedure1<JvmOperation> _function_11 = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(sprite, "position", this._typeReferenceBuilder.typeRef(Vector2.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      final Procedure1<ITreeAppendable> _function_12 = (ITreeAppendable it_1) -> {
        it_1.append(BodyDef.class);
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(" ");
        _builder_3.append("bdef = new BodyDef();");
        _builder_3.newLine();
        _builder_3.append("bdef.position.set(position);");
        _builder_3.newLine();
        _builder_3.append("bdef.type = BodyDef.BodyType.DynamicBody;");
        _builder_3.newLine();
        _builder_3.append("body = world.createBody(bdef);");
        _builder_3.newLine();
        it_1.append(_builder_3);
        it_1.append(FixtureDef.class);
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append(" ");
        _builder_4.append("fdef = new FixtureDef();");
        _builder_4.newLine();
        it_1.append(_builder_4);
        it_1.append(CircleShape.class);
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append(" ");
        _builder_5.append("shape = new CircleShape();");
        _builder_5.newLine();
        _builder_5.append("shape.setRadius(");
        int _radius = sprite.getRadius();
        _builder_5.append(_radius);
        _builder_5.append(" / ");
        String _simpleName = gameClass.getSimpleName();
        _builder_5.append(_simpleName);
        _builder_5.append(".PPM);");
        _builder_5.newLineIfNotEmpty();
        _builder_5.append("fdef.filter.categoryBits = ");
        int _id = sprite.getId();
        double _power = Math.pow(2, _id);
        _builder_5.append(((int) _power));
        _builder_5.append(";");
        _builder_5.newLineIfNotEmpty();
        it_1.append(_builder_5);
        double mask = 0.0;
        EList<GameActor> _actors = sprite.getActors();
        for (final GameActor actor : _actors) {
          GameSprite _sprite = actor.getSprite();
          boolean _tripleNotEquals = (_sprite != null);
          if (_tripleNotEquals) {
            int _id_1 = actor.getSprite().getId();
            double _power_1 = Math.pow(2, _id_1);
            double _plus = (mask + _power_1);
            mask = _plus;
          } else {
            GameTile _tile = actor.getTile();
            boolean _tripleNotEquals_1 = (_tile != null);
            if (_tripleNotEquals_1) {
              int _id_2 = actor.getTile().getId();
              double _power_2 = Math.pow(2, _id_2);
              double _plus_1 = (mask + _power_2);
              mask = _plus_1;
            }
          }
        }
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("fdef.filter.maskBits = ");
        _builder_6.append(((int) mask));
        _builder_6.append(";");
        _builder_6.newLineIfNotEmpty();
        _builder_6.append("fdef.shape = shape;");
        _builder_6.newLine();
        _builder_6.append("shape.setPosition(new Vector2(-positionOffsetX / ");
        String _simpleName_1 = gameClass.getSimpleName();
        _builder_6.append(_simpleName_1);
        _builder_6.append(".PPM, -positionOffsetY / ");
        String _simpleName_2 = gameClass.getSimpleName();
        _builder_6.append(_simpleName_2);
        _builder_6.append(".PPM));");
        _builder_6.newLineIfNotEmpty();
        _builder_6.append("body.createFixture(fdef).setUserData(this);");
        _builder_6.newLine();
        it_1.append(_builder_6);
        boolean _isHasSensor = sprite.isHasSensor();
        if (_isHasSensor) {
          int _length = ((Object[])Conversions.unwrapArray(sprite.getVectors2d(), Object.class)).length;
          boolean _equals = (_length == 2);
          if (_equals) {
            it_1.append(EdgeShape.class);
          } else {
            it_1.append(PolygonShape.class);
          }
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append(" ");
          _builder_7.append("head = new ");
          {
            int _length_1 = ((Object[])Conversions.unwrapArray(sprite.getVectors2d(), Object.class)).length;
            boolean _equals_1 = (_length_1 == 2);
            if (_equals_1) {
              _builder_7.append("Edge");
            } else {
              _builder_7.append("Polygon");
            }
          }
          _builder_7.append("Shape();");
          _builder_7.newLineIfNotEmpty();
          it_1.append(_builder_7);
          int _length_2 = ((Object[])Conversions.unwrapArray(sprite.getVectors2d(), Object.class)).length;
          boolean _equals_2 = (_length_2 == 2);
          if (_equals_2) {
            StringConcatenation _builder_8 = new StringConcatenation();
            _builder_8.append("head.set(new Vector2(");
            float _x = sprite.getVectors2d().get(0).getX();
            _builder_8.append(_x);
            _builder_8.append("f / 2 / ");
            String _simpleName_3 = gameClass.getSimpleName();
            _builder_8.append(_simpleName_3);
            _builder_8.append(".PPM, ");
            int _radius_1 = sprite.getRadius();
            _builder_8.append(_radius_1);
            _builder_8.append(" / ");
            String _simpleName_4 = gameClass.getSimpleName();
            _builder_8.append(_simpleName_4);
            _builder_8.append(".PPM), new Vector2(");
            float _y = sprite.getVectors2d().get(0).getY();
            _builder_8.append(_y);
            _builder_8.append("f / 2 / ");
            String _simpleName_5 = gameClass.getSimpleName();
            _builder_8.append(_simpleName_5);
            _builder_8.append(".PPM, ");
            int _radius_2 = sprite.getRadius();
            _builder_8.append(_radius_2);
            _builder_8.append(" / ");
            String _simpleName_6 = gameClass.getSimpleName();
            _builder_8.append(_simpleName_6);
            _builder_8.append(".PPM));");
            _builder_8.newLineIfNotEmpty();
            it_1.append(_builder_8);
          } else {
            StringConcatenation _builder_9 = new StringConcatenation();
            _builder_9.append("Vector2[] vertice = new Vector2[");
            int _length_3 = ((Object[])Conversions.unwrapArray(sprite.getVectors2d(), Object.class)).length;
            _builder_9.append(_length_3);
            _builder_9.append("];");
            _builder_9.newLineIfNotEmpty();
            it_1.append(_builder_9);
            for (int idx = 0; (idx < ((Object[])Conversions.unwrapArray(sprite.getVectors2d(), Object.class)).length); idx++) {
              StringConcatenation _builder_10 = new StringConcatenation();
              _builder_10.append("vertice[");
              _builder_10.append(idx);
              _builder_10.append("] = new Vector2(");
              float _x_1 = sprite.getVectors2d().get(idx).getX();
              _builder_10.append(_x_1);
              _builder_10.append("f, ");
              float _y_1 = sprite.getVectors2d().get(idx).getY();
              _builder_10.append(_y_1);
              _builder_10.append("f).scl(1 / ");
              String _simpleName_7 = gameClass.getSimpleName();
              _builder_10.append(_simpleName_7);
              _builder_10.append(".PPM);");
              _builder_10.newLineIfNotEmpty();
              it_1.append(_builder_10);
            }
            StringConcatenation _builder_10 = new StringConcatenation();
            _builder_10.append("head.set(vertice);");
            _builder_10.newLine();
            it_1.append(_builder_10);
          }
          StringConcatenation _builder_11 = new StringConcatenation();
          _builder_11.append("fdef.filter.categoryBits = ");
          int _sensorID = sprite.getSensorID();
          double _power_3 = Math.pow(2, _sensorID);
          _builder_11.append(((int) _power_3));
          _builder_11.append(";");
          _builder_11.newLineIfNotEmpty();
          _builder_11.append("fdef.shape = head;");
          _builder_11.newLine();
          _builder_11.append("fdef.isSensor = true;");
          _builder_11.newLine();
          _builder_11.append("body.createFixture(fdef).setUserData(this);");
          _builder_11.newLine();
          it_1.append(_builder_11);
        }
        GameSpriteAnimation _animation = sprite.getInitialState().getAnimation();
        boolean _tripleNotEquals_2 = (_animation != null);
        if (_tripleNotEquals_2) {
          boolean _isHasFrames = sprite.getInitialState().getAnimation().isHasFrames();
          if (_isHasFrames) {
            StringConcatenation _builder_12 = new StringConcatenation();
            _builder_12.append("setBounds(position.x, position.y, ");
            int _width = sprite.getInitialState().getAnimation().getRegion().getWidth();
            _builder_12.append(_width);
            _builder_12.append(" / ");
            String _simpleName_7 = gameClass.getSimpleName();
            _builder_12.append(_simpleName_7);
            _builder_12.append(".PPM, ");
            int _height = sprite.getInitialState().getAnimation().getRegion().getHeight();
            _builder_12.append(_height);
            _builder_12.append(" / ");
            String _simpleName_8 = gameClass.getSimpleName();
            _builder_12.append(_simpleName_8);
            _builder_12.append(".PPM);");
            _builder_12.newLineIfNotEmpty();
            it_1.append(_builder_12);
          }
          boolean _isHasStands = sprite.getInitialState().getAnimation().isHasStands();
          if (_isHasStands) {
            StringConcatenation _builder_13 = new StringConcatenation();
            _builder_13.append("setBounds(position.x, position.y, ");
            int _width_1 = sprite.getInitialState().getAnimation().getStands().get(0).getRegion().getWidth();
            _builder_13.append(_width_1);
            _builder_13.append(" / ");
            String _simpleName_9 = gameClass.getSimpleName();
            _builder_13.append(_simpleName_9);
            _builder_13.append(".PPM, ");
            int _height_1 = sprite.getInitialState().getAnimation().getStands().get(0).getRegion().getHeight();
            _builder_13.append(_height_1);
            _builder_13.append(" / ");
            String _simpleName_10 = gameClass.getSimpleName();
            _builder_13.append(_simpleName_10);
            _builder_13.append(".PPM);");
            _builder_13.newLineIfNotEmpty();
            it_1.append(_builder_13);
          }
        }
        GameSpriteStand _stand = sprite.getInitialState().getStand();
        boolean _tripleNotEquals_3 = (_stand != null);
        if (_tripleNotEquals_3) {
          StringConcatenation _builder_14 = new StringConcatenation();
          _builder_14.append("setBounds(position.x, position.y, ");
          int _width_2 = sprite.getInitialState().getStand().getRegion().getWidth();
          _builder_14.append(_width_2);
          _builder_14.append(" / ");
          String _simpleName_11 = gameClass.getSimpleName();
          _builder_14.append(_simpleName_11);
          _builder_14.append(".PPM, ");
          int _height_2 = sprite.getInitialState().getStand().getRegion().getHeight();
          _builder_14.append(_height_2);
          _builder_14.append(" / ");
          String _simpleName_12 = gameClass.getSimpleName();
          _builder_14.append(_simpleName_12);
          _builder_14.append(".PPM);");
          _builder_14.newLineIfNotEmpty();
          it_1.append(_builder_14);
        }
      };
      this._jvmTypesBuilder.setBody(it, _function_12);
    };
    JvmOperation _method_5 = this._jvmTypesBuilder.toMethod(sprite, _builder_2.toString(), this._typeReferenceBuilder.typeRef(Void.TYPE), _function_11);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_5);
    final Consumer<GameEvent> _function_12 = (GameEvent it) -> {
      final GameEvent event = it;
      EList<JvmMember> _members_6 = type.getMembers();
      StringConcatenation _builder_3 = new StringConcatenation();
      String _name = it.getName();
      _builder_3.append(_name);
      final Procedure1<JvmOperation> _function_13 = (JvmOperation it_1) -> {
        this._jvmTypesBuilder.setDocumentation(it_1, this._jvmTypesBuilder.getDocumentation(it_1));
        EList<JvmFormalParameter> _params = event.getParams();
        for (final JvmFormalParameter p : _params) {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(p, p.getName(), p.getParameterType());
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        }
        this._jvmTypesBuilder.setBody(it_1, event.getBody());
      };
      JvmOperation _method_6 = this._jvmTypesBuilder.toMethod(sprite, _builder_3.toString(), this._typeReferenceBuilder.typeRef(Void.TYPE), _function_13);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_6, _method_6);
    };
    sprite.getEvents().forEach(_function_12);
  }
  
  public void createTile(final IJvmDeclaredTypeAcceptor acceptor, final GamePackage gamePkg, final JvmGenericType gameClass, final JvmGenericType screenClass, final GameTile tile, final GameRoot root) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      it.setPackageName(this._iQualifiedNameProvider.getFullyQualifiedName(tile).skipLast(1).toString());
      this._jvmTypesBuilder.setDocumentation(it, this.genInfo);
      this.toFields(it, tile, screenClass);
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmConstructor> _function_1 = (JvmConstructor it_1) -> {
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(gamePkg, "screen", this._typeReferenceBuilder.typeRef(screenClass));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        EList<JvmFormalParameter> _parameters_1 = it_1.getParameters();
        JvmFormalParameter _parameter_1 = this._jvmTypesBuilder.toParameter(gamePkg, "object", this._typeReferenceBuilder.typeRef(MapObject.class));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
        final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("this.screen = screen;");
          _builder.newLine();
          _builder.append("this.object = object;");
          _builder.newLine();
          _builder.append("world = screen.getWorld();");
          _builder.newLine();
          _builder.append("map = screen.getMap();");
          _builder.newLine();
          _builder.append("bounds = ((");
          it_2.append(_builder);
          it_2.append(RectangleMapObject.class);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(")object).getRectangle();");
          _builder_1.newLine();
          it_2.append(_builder_1);
          it_2.append(BodyDef.class);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append(" ");
          _builder_2.append("bdef = new BodyDef();");
          _builder_2.newLine();
          it_2.append(_builder_2);
          it_2.append(FixtureDef.class);
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append(" ");
          _builder_3.append("fdef = new FixtureDef();");
          _builder_3.newLine();
          it_2.append(_builder_3);
          it_2.append(PolygonShape.class);
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append(" ");
          _builder_4.append("shape = new PolygonShape();");
          _builder_4.newLine();
          _builder_4.append("bdef.type = BodyDef.BodyType.StaticBody;");
          _builder_4.newLine();
          _builder_4.append("bdef.position.set((bounds.getX() + bounds.getWidth() / 2) /");
          it_2.append(_builder_4);
          it_2.append(gameClass);
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append(".PPM, (bounds.getY() + bounds.getHeight() / 2) / ");
          String _simpleName = gameClass.getSimpleName();
          _builder_5.append(_simpleName);
          _builder_5.append(".PPM);");
          _builder_5.newLineIfNotEmpty();
          _builder_5.append("body = world.createBody(bdef);");
          _builder_5.newLine();
          _builder_5.append("shape.setAsBox(bounds.getWidth() / 2 / ");
          String _simpleName_1 = gameClass.getSimpleName();
          _builder_5.append(_simpleName_1);
          _builder_5.append(".PPM, bounds.getHeight() / 2 / ");
          String _simpleName_2 = gameClass.getSimpleName();
          _builder_5.append(_simpleName_2);
          _builder_5.append(".PPM);");
          _builder_5.newLineIfNotEmpty();
          _builder_5.append("fdef.filter.categoryBits = ");
          int _id = tile.getId();
          double _power = Math.pow(2, _id);
          _builder_5.append(((int) _power));
          _builder_5.append(";");
          _builder_5.newLineIfNotEmpty();
          _builder_5.append("fdef.shape = shape;");
          _builder_5.newLine();
          _builder_5.append("fixture = body.createFixture(fdef);");
          _builder_5.newLine();
          _builder_5.append("fixture.setUserData(this);");
          _builder_5.newLine();
          it_2.append(_builder_5);
        };
        this._jvmTypesBuilder.setBody(it_1, _function_2);
      };
      JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(tile, _function_1);
      this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
      boolean _isHasTileLayer = tile.isHasTileLayer();
      if (_isHasTileLayer) {
        this.toOperations(it, tile, gameClass, root);
      }
    };
    acceptor.<JvmGenericType>accept(
      this._jvmTypesBuilder.toClass(gamePkg, this._iQualifiedNameProvider.getFullyQualifiedName(tile)), _function);
  }
  
  public void toFields(final JvmGenericType type, final GameTile tile, final JvmGenericType screenClass) {
    JvmField field = this._jvmTypesBuilder.toField(tile, "world", this._typeReferenceBuilder.typeRef(World.class));
    EList<JvmMember> _members = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members, field);
    field = this._jvmTypesBuilder.toField(tile, "map", this._typeReferenceBuilder.typeRef(TiledMap.class));
    EList<JvmMember> _members_1 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_1, field);
    field = this._jvmTypesBuilder.toField(tile, "tile", this._typeReferenceBuilder.typeRef(TiledMapTile.class));
    EList<JvmMember> _members_2 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_2, field);
    field = this._jvmTypesBuilder.toField(tile, "bounds", this._typeReferenceBuilder.typeRef(Rectangle.class));
    EList<JvmMember> _members_3 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_3, field);
    field = this._jvmTypesBuilder.toField(tile, "body", this._typeReferenceBuilder.typeRef(Body.class));
    EList<JvmMember> _members_4 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_4, field);
    field = this._jvmTypesBuilder.toField(tile, "screen", this._typeReferenceBuilder.typeRef(screenClass));
    EList<JvmMember> _members_5 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_5, field);
    field = this._jvmTypesBuilder.toField(tile, "object", this._typeReferenceBuilder.typeRef(MapObject.class));
    EList<JvmMember> _members_6 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_6, field);
    field = this._jvmTypesBuilder.toField(tile, "fixture", this._typeReferenceBuilder.typeRef(Fixture.class));
    EList<JvmMember> _members_7 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_7, field);
  }
  
  public void toOperations(final JvmGenericType type, final GameTile tile, final JvmGenericType gameClass, final GameRoot root) {
    EList<JvmMember> _members = type.getMembers();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("return map;");
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_1);
    };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(tile, "getMap", this._typeReferenceBuilder.typeRef(TiledMap.class), _function);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    EList<JvmMember> _members_1 = type.getMembers();
    final Procedure1<JvmOperation> _function_1 = (JvmOperation it) -> {
      final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_1) -> {
        it_1.append(TiledMapTileLayer.class);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        _builder.append("layer = (TiledMapTileLayer) map.getLayers().get(");
        int _index = tile.getTileLayer().getIndex();
        _builder.append(_index, " ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        it_1.append(_builder);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("return  layer.getCell((int) (body.getPosition().x * ");
        String _simpleName = gameClass.getSimpleName();
        _builder_1.append(_simpleName);
        _builder_1.append(".PPM / ");
        int _tileWidth = root.getTileWidth();
        _builder_1.append(_tileWidth);
        _builder_1.append("), (int) (body.getPosition().y * ");
        String _simpleName_1 = gameClass.getSimpleName();
        _builder_1.append(_simpleName_1);
        _builder_1.append(".PPM / ");
        int _tileHeight = root.getTileHeight();
        _builder_1.append(_tileHeight);
        _builder_1.append("));");
        _builder_1.newLineIfNotEmpty();
        it_1.append(_builder_1);
      };
      this._jvmTypesBuilder.setBody(it, _function_2);
    };
    JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(tile, "getCell", this._typeReferenceBuilder.typeRef(TiledMapTileLayer.Cell.class), _function_1);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
    EList<JvmMember> _members_2 = type.getMembers();
    final Procedure1<JvmOperation> _function_2 = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(tile, "filterBit", this._typeReferenceBuilder.typeRef(int.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_1) -> {
        it_1.append(Filter.class);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        _builder.append("filter = new Filter();");
        _builder.newLine();
        it_1.append(_builder);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("filter.categoryBits = (short)filterBit;");
        _builder_1.newLine();
        _builder_1.append("fixture.setFilterData(filter);");
        _builder_1.newLine();
        it_1.append(_builder_1);
      };
      this._jvmTypesBuilder.setBody(it, _function_3);
    };
    JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(tile, "setCategoryFilter", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_2);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method_2);
  }
  
  public void createCreator(final IJvmDeclaredTypeAcceptor acceptor, final GamePackage gamePkg, final JvmGenericType creatorClass, final JvmGenericType gameClass, final JvmGenericType screenClass, final GameScreen screen, final GameRoot game) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      it.setPackageName(this._iQualifiedNameProvider.getFullyQualifiedName(game).skipLast(1).toString());
      this._jvmTypesBuilder.setDocumentation(it, this.genInfo);
      this.toCreatorFields(it, game, screen);
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmConstructor> _function_1 = (JvmConstructor it_1) -> {
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(gamePkg, "screen", this._typeReferenceBuilder.typeRef(screenClass));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_2) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("world = screen.getWorld();");
          _builder.newLine();
          _builder.append("map = screen.getMap();");
          _builder.newLine();
          it_2.append(_builder);
          final ITreeAppendable current = it_2;
          final Function1<GameTile, Boolean> _function_3 = (GameTile it_3) -> {
            return Boolean.valueOf(it_3.isHasObjectLayer());
          };
          final Consumer<GameTile> _function_4 = (GameTile it_3) -> {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("for(");
            current.append(_builder_1);
            current.append(MapObject.class);
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append(" ");
            _builder_2.append("object : map.getLayers().get(");
            int _index = it_3.getObjectLayer().getIndex();
            _builder_2.append(_index, " ");
            _builder_2.append(").getObjects().getByType(");
            current.append(_builder_2);
            current.append(RectangleMapObject.class);
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append(".class)){");
            _builder_3.newLine();
            current.append(_builder_3);
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("\t");
            _builder_4.append("new ");
            String _string = this._iQualifiedNameProvider.getFullyQualifiedName(it_3).skipLast(1).toString();
            _builder_4.append(_string, "\t");
            _builder_4.append(".");
            String _firstUpper = StringExtensions.toFirstUpper(it_3.getName());
            _builder_4.append(_firstUpper, "\t");
            _builder_4.append("(screen, object);");
            current.append(_builder_4);
            current.append("\n}\n");
          };
          IterableExtensions.<GameTile>filter(screen.getTiles(), _function_3).forEach(_function_4);
          final Function1<GameSprite, Boolean> _function_5 = (GameSprite it_3) -> {
            return Boolean.valueOf(it_3.isHasLayer());
          };
          final Consumer<GameSprite> _function_6 = (GameSprite it_3) -> {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _string = this._iQualifiedNameProvider.getFullyQualifiedName(it_3).skipLast(1).toString();
            _builder_1.append(_string);
            _builder_1.append(".");
            String _firstUpper = StringExtensions.toFirstUpper(it_3.getName());
            _builder_1.append(_firstUpper);
            String spriteFQN = _builder_1.toString();
            StringConcatenation _builder_2 = new StringConcatenation();
            String _firstLower = StringExtensions.toFirstLower(it_3.getName());
            _builder_2.append(_firstLower);
            _builder_2.append(" = new ");
            current.append(_builder_2);
            current.append(Array.class);
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("<");
            _builder_3.append(spriteFQN);
            _builder_3.append(">();");
            _builder_3.newLineIfNotEmpty();
            current.append(_builder_3);
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("for(");
            current.append(_builder_4);
            current.append(MapObject.class);
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append(" ");
            _builder_5.append("object : map.getLayers().get(");
            int _index = it_3.getLayer().getIndex();
            _builder_5.append(_index, " ");
            _builder_5.append(").getObjects().getByType(");
            current.append(_builder_5);
            current.append(RectangleMapObject.class);
            StringConcatenation _builder_6 = new StringConcatenation();
            _builder_6.append(".class)){");
            _builder_6.newLine();
            current.append(_builder_6);
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append("\t");
            current.append(_builder_7);
            current.append(Rectangle.class);
            StringConcatenation _builder_8 = new StringConcatenation();
            _builder_8.append(" ");
            _builder_8.append("rect = ((");
            current.append(_builder_8);
            current.append(RectangleMapObject.class);
            StringConcatenation _builder_9 = new StringConcatenation();
            _builder_9.append(") object).getRectangle();");
            _builder_9.newLine();
            current.append(_builder_9);
            StringConcatenation _builder_10 = new StringConcatenation();
            _builder_10.append("\t");
            String _firstLower_1 = StringExtensions.toFirstLower(it_3.getName());
            _builder_10.append(_firstLower_1, "\t");
            _builder_10.append(".add(new ");
            _builder_10.append(spriteFQN, "\t");
            _builder_10.append("(screen, rect.getX() / ");
            String _simpleName = gameClass.getSimpleName();
            _builder_10.append(_simpleName, "\t");
            _builder_10.append(".PPM, rect.getY() / ");
            String _simpleName_1 = gameClass.getSimpleName();
            _builder_10.append(_simpleName_1, "\t");
            _builder_10.append(".PPM));");
            _builder_10.newLineIfNotEmpty();
            current.append(_builder_10);
            current.append("\n}\n");
          };
          IterableExtensions.<GameSprite>filter(screen.getSprites(), _function_5).forEach(_function_6);
        };
        this._jvmTypesBuilder.setBody(it_1, _function_2);
      };
      JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(game, _function_1);
      this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
      this.toCreatorOperations(it, game, screen, gameClass);
    };
    acceptor.<JvmGenericType>accept(creatorClass, _function);
  }
  
  public void toCreatorFields(final JvmGenericType type, final GameRoot game, final GameScreen screen) {
    JvmField field = this._jvmTypesBuilder.toField(game, "world", this._typeReferenceBuilder.typeRef(World.class));
    EList<JvmMember> _members = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members, field);
    field = this._jvmTypesBuilder.toField(game, "map", this._typeReferenceBuilder.typeRef(TiledMap.class));
    EList<JvmMember> _members_1 = type.getMembers();
    this._jvmTypesBuilder.<JvmField>operator_add(_members_1, field);
    final Function1<GameSprite, Boolean> _function = (GameSprite it) -> {
      return Boolean.valueOf(it.isHasLayer());
    };
    final Consumer<GameSprite> _function_1 = (GameSprite it) -> {
      StringConcatenation _builder = new StringConcatenation();
      String _string = this._iQualifiedNameProvider.getFullyQualifiedName(it).skipLast(1).toString();
      _builder.append(_string);
      _builder.append(".");
      String _firstUpper = StringExtensions.toFirstUpper(it.getName());
      _builder.append(_firstUpper);
      String spriteFQN = _builder.toString();
      JvmField array = this._jvmTypesBuilder.toField(game, StringExtensions.toFirstLower(it.getName()), this._typeReferenceBuilder.typeRef(Array.class, this._typeReferenceBuilder.typeRef(spriteFQN)));
      array.setVisibility(JvmVisibility.PRIVATE);
      EList<JvmMember> _members_2 = type.getMembers();
      this._jvmTypesBuilder.<JvmField>operator_add(_members_2, array);
    };
    IterableExtensions.<GameSprite>filter(screen.getSprites(), _function).forEach(_function_1);
  }
  
  public void toCreatorOperations(final JvmGenericType type, final GameRoot game, final GameScreen screen, final JvmGenericType gameClass) {
    EList<JvmMember> _members = type.getMembers();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "dt", this._typeReferenceBuilder.typeRef(float.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      JvmFormalParameter _parameter_1 = this._jvmTypesBuilder.toParameter(game, "playerXPosition", this._typeReferenceBuilder.typeRef(float.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
      final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it_1) -> {
        final ITreeAppendable current = it_1;
        final Function1<GameSprite, Boolean> _function_2 = (GameSprite it_2) -> {
          return Boolean.valueOf(it_2.isHasLayer());
        };
        final Consumer<GameSprite> _function_3 = (GameSprite it_2) -> {
          StringConcatenation _builder = new StringConcatenation();
          String _string = this._iQualifiedNameProvider.getFullyQualifiedName(it_2).skipLast(1).toString();
          _builder.append(_string);
          _builder.append(".");
          String _firstUpper = StringExtensions.toFirstUpper(it_2.getName());
          _builder.append(_firstUpper);
          final String spriteFQN = _builder.toString();
          JvmField array = this._jvmTypesBuilder.toField(game, StringExtensions.toFirstLower(it_2.getName()), this._typeReferenceBuilder.typeRef(Array.class, this._typeReferenceBuilder.typeRef(spriteFQN)));
          current.append("for(");
          current.append(spriteFQN);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(" ");
          _builder_1.append("sprite:");
          String _firstLower = StringExtensions.toFirstLower(it_2.getName());
          _builder_1.append(_firstLower, " ");
          _builder_1.append(") {");
          _builder_1.newLineIfNotEmpty();
          current.append(_builder_1);
          current.append("\tsprite.update(dt);\n");
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("\t");
          _builder_2.append("if(sprite.getX() < playerXPosition + ");
          int _worldWidth = game.getWorldWidth();
          int _tileWidth = game.getTileWidth();
          int _minus = (_worldWidth - _tileWidth);
          _builder_2.append(_minus, "\t");
          _builder_2.append(" / ");
          String _simpleName = gameClass.getSimpleName();
          _builder_2.append(_simpleName, "\t");
          _builder_2.append(".PPM) {");
          _builder_2.newLineIfNotEmpty();
          current.append(_builder_2);
          current.append("\t\tsprite.body.setActive(true);\n");
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("\t");
          _builder_3.append("}");
          _builder_3.newLine();
          current.append(_builder_3);
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("}");
          current.append(_builder_4);
        };
        IterableExtensions.<GameSprite>filter(screen.getSprites(), _function_2).forEach(_function_3);
      };
      this._jvmTypesBuilder.setBody(it, _function_1);
    };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(game, "updateSprites", this._typeReferenceBuilder.typeRef(Void.TYPE), _function);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    EList<JvmMember> _members_1 = type.getMembers();
    final Procedure1<JvmOperation> _function_1 = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "batch", this._typeReferenceBuilder.typeRef(Batch.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_1) -> {
        final ITreeAppendable current = it_1;
        final Function1<GameSprite, Boolean> _function_3 = (GameSprite it_2) -> {
          return Boolean.valueOf(it_2.isHasLayer());
        };
        final Consumer<GameSprite> _function_4 = (GameSprite it_2) -> {
          StringConcatenation _builder = new StringConcatenation();
          String _string = this._iQualifiedNameProvider.getFullyQualifiedName(it_2).skipLast(1).toString();
          _builder.append(_string);
          _builder.append(".");
          String _firstUpper = StringExtensions.toFirstUpper(it_2.getName());
          _builder.append(_firstUpper);
          final String spriteFQN = _builder.toString();
          JvmField array = this._jvmTypesBuilder.toField(game, StringExtensions.toFirstLower(it_2.getName()), this._typeReferenceBuilder.typeRef(Array.class, this._typeReferenceBuilder.typeRef(spriteFQN)));
          current.append("for(");
          current.append(spriteFQN);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(" ");
          _builder_1.append("sprite:");
          String _firstLower = StringExtensions.toFirstLower(it_2.getName());
          _builder_1.append(_firstLower, " ");
          _builder_1.append(") {");
          _builder_1.newLineIfNotEmpty();
          current.append(_builder_1);
          current.append("\tsprite.draw(batch);\n");
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("}");
          current.append(_builder_2);
        };
        IterableExtensions.<GameSprite>filter(screen.getSprites(), _function_3).forEach(_function_4);
      };
      this._jvmTypesBuilder.setBody(it, _function_2);
    };
    JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(game, "drawSprites", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_1);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
  }
  
  public void createContactListener(final IJvmDeclaredTypeAcceptor acceptor, final GamePackage gamePkg, final JvmGenericType contactClass, final GameRoot game) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<JvmTypeReference> _superTypes = it.getSuperTypes();
      JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(ContactListener.class);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
      it.setPackageName(this._iQualifiedNameProvider.getFullyQualifiedName(game).skipLast(1).toString());
      this._jvmTypesBuilder.setDocumentation(it, this.genInfo);
      this.toContactOperations(it, game);
    };
    acceptor.<JvmGenericType>accept(contactClass, _function);
  }
  
  public void toContactOperations(final JvmGenericType type, final GameRoot game) {
    EList<JvmMember> _members = type.getMembers();
    final Procedure1<JvmOperation> _function = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "contact", this._typeReferenceBuilder.typeRef(Contact.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      final Procedure1<ITreeAppendable> _function_1 = (ITreeAppendable it_1) -> {
        it_1.append(Fixture.class);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        _builder.append("fixA = contact.getFixtureA();");
        _builder.newLine();
        it_1.append(_builder);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Fixture fixB = contact.getFixtureB();");
        _builder_1.newLine();
        _builder_1.append("int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;");
        _builder_1.newLine();
        _builder_1.append("switch(cDef) {");
        _builder_1.newLine();
        it_1.append(_builder_1);
        final ITreeAppendable current = it_1;
        final Consumer<GameScreen> _function_2 = (GameScreen screen) -> {
          final Consumer<GameSprite> _function_3 = (GameSprite sprite) -> {
            final Function1<GameActor, Boolean> _function_4 = (GameActor it_2) -> {
              return Boolean.valueOf((it_2.isHasCollision() && (it_2.getBeginContact() != null)));
            };
            final Consumer<GameActor> _function_5 = (GameActor actor) -> {
              current.append(this.decodeCollision(actor, sprite, actor.getBeginContact().getName()));
            };
            IterableExtensions.<GameActor>filter(sprite.getActors(), _function_4).forEach(_function_5);
          };
          screen.getSprites().forEach(_function_3);
        };
        game.getScreens().forEach(_function_2);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("}");
        _builder_2.newLine();
        it_1.append(_builder_2);
      };
      this._jvmTypesBuilder.setBody(it, _function_1);
    };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(game, "beginContact", this._typeReferenceBuilder.typeRef(Void.TYPE), _function);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    EList<JvmMember> _members_1 = type.getMembers();
    final Procedure1<JvmOperation> _function_1 = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "contact", this._typeReferenceBuilder.typeRef(Contact.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      final Procedure1<ITreeAppendable> _function_2 = (ITreeAppendable it_1) -> {
        it_1.append(Fixture.class);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        _builder.append("fixA = contact.getFixtureA();");
        _builder.newLine();
        it_1.append(_builder);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Fixture fixB = contact.getFixtureB();");
        _builder_1.newLine();
        _builder_1.append("int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;");
        _builder_1.newLine();
        _builder_1.append("switch(cDef) {");
        _builder_1.newLine();
        it_1.append(_builder_1);
        final ITreeAppendable current = it_1;
        final Consumer<GameScreen> _function_3 = (GameScreen screen) -> {
          final Consumer<GameSprite> _function_4 = (GameSprite sprite) -> {
            final Function1<GameActor, Boolean> _function_5 = (GameActor it_2) -> {
              return Boolean.valueOf((it_2.isHasCollision() && (it_2.getEndContact() != null)));
            };
            final Consumer<GameActor> _function_6 = (GameActor actor) -> {
              current.append(this.decodeCollision(actor, sprite, actor.getEndContact().getName()));
            };
            IterableExtensions.<GameActor>filter(sprite.getActors(), _function_5).forEach(_function_6);
          };
          screen.getSprites().forEach(_function_4);
        };
        game.getScreens().forEach(_function_3);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("}");
        _builder_2.newLine();
        it_1.append(_builder_2);
      };
      this._jvmTypesBuilder.setBody(it, _function_2);
    };
    JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(game, "endContact", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_1);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
    EList<JvmMember> _members_2 = type.getMembers();
    final Procedure1<JvmOperation> _function_2 = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "contact", this._typeReferenceBuilder.typeRef(Contact.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      JvmFormalParameter _parameter_1 = this._jvmTypesBuilder.toParameter(game, "oldManifold", this._typeReferenceBuilder.typeRef(Manifold.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
      final Procedure1<ITreeAppendable> _function_3 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_3);
    };
    JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(game, "preSolve", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_2);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method_2);
    EList<JvmMember> _members_3 = type.getMembers();
    final Procedure1<JvmOperation> _function_3 = (JvmOperation it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(game, "contact", this._typeReferenceBuilder.typeRef(Contact.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      JvmFormalParameter _parameter_1 = this._jvmTypesBuilder.toParameter(game, "impulse", this._typeReferenceBuilder.typeRef(ContactImpulse.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
      final Procedure1<ITreeAppendable> _function_4 = (ITreeAppendable it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        it_1.append(_builder);
      };
      this._jvmTypesBuilder.setBody(it, _function_4);
    };
    JvmOperation _method_3 = this._jvmTypesBuilder.toMethod(game, "postSolve", this._typeReferenceBuilder.typeRef(Void.TYPE), _function_3);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _method_3);
  }
  
  protected String decodeCollision(final GameActor actor, final GameSprite sprite, final String methodName) {
    int id1 = 0;
    GameContactType _typeA = actor.getTypeA();
    boolean _equals = Objects.equal(_typeA, GameContactType.FIXTURE);
    if (_equals) {
      int _id = sprite.getId();
      double _power = Math.pow(2, _id);
      id1 = ((int) _power);
    } else {
      GameContactType _typeA_1 = actor.getTypeA();
      boolean _equals_1 = Objects.equal(_typeA_1, GameContactType.SENSOR);
      if (_equals_1) {
        int _sensorID = sprite.getSensorID();
        double _power_1 = Math.pow(2, _sensorID);
        id1 = ((int) _power_1);
      }
    }
    int id2 = 0;
    GameSprite _sprite = actor.getSprite();
    boolean _tripleNotEquals = (_sprite != null);
    if (_tripleNotEquals) {
      GameContactType _typeB = actor.getTypeB();
      boolean _equals_2 = Objects.equal(_typeB, GameContactType.FIXTURE);
      if (_equals_2) {
        int _id_1 = actor.getSprite().getId();
        double _power_2 = Math.pow(2, _id_1);
        id2 = ((int) _power_2);
      } else {
        GameContactType _typeB_1 = actor.getTypeB();
        boolean _equals_3 = Objects.equal(_typeB_1, GameContactType.SENSOR);
        if (_equals_3) {
          int _sensorID_1 = actor.getSprite().getSensorID();
          double _power_3 = Math.pow(2, _sensorID_1);
          id2 = ((int) _power_3);
        }
      }
    } else {
      GameTile _tile = actor.getTile();
      boolean _tripleNotEquals_1 = (_tile != null);
      if (_tripleNotEquals_1) {
        int _id_2 = actor.getTile().getId();
        double _power_4 = Math.pow(2, _id_2);
        id2 = ((int) _power_4);
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("case ");
    _builder.append((id1 + id2));
    _builder.append(":");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if(fixA.getFilterData().categoryBits == ");
    _builder.append(id1, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("((");
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(sprite);
    _builder.append(_fullyQualifiedName, "\t\t");
    _builder.append(")fixA.getUserData()).");
    _builder.append(methodName, "\t\t");
    _builder.append("((");
    {
      GameSprite _sprite_1 = actor.getSprite();
      boolean _tripleNotEquals_2 = (_sprite_1 != null);
      if (_tripleNotEquals_2) {
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(actor.getSprite());
        _builder.append(_fullyQualifiedName_1, "\t\t");
      } else {
        GameTile _tile_1 = actor.getTile();
        boolean _tripleNotEquals_3 = (_tile_1 != null);
        if (_tripleNotEquals_3) {
          QualifiedName _fullyQualifiedName_2 = this._iQualifiedNameProvider.getFullyQualifiedName(actor.getTile());
          _builder.append(_fullyQualifiedName_2, "\t\t");
        }
      }
    }
    _builder.append(")fixB.getUserData());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((");
    QualifiedName _fullyQualifiedName_3 = this._iQualifiedNameProvider.getFullyQualifiedName(sprite);
    _builder.append(_fullyQualifiedName_3, "\t\t");
    _builder.append(")fixB.getUserData()).");
    _builder.append(methodName, "\t\t");
    _builder.append("((");
    {
      GameSprite _sprite_2 = actor.getSprite();
      boolean _tripleNotEquals_4 = (_sprite_2 != null);
      if (_tripleNotEquals_4) {
        QualifiedName _fullyQualifiedName_4 = this._iQualifiedNameProvider.getFullyQualifiedName(actor.getSprite());
        _builder.append(_fullyQualifiedName_4, "\t\t");
      } else {
        GameTile _tile_2 = actor.getTile();
        boolean _tripleNotEquals_5 = (_tile_2 != null);
        if (_tripleNotEquals_5) {
          QualifiedName _fullyQualifiedName_5 = this._iQualifiedNameProvider.getFullyQualifiedName(actor.getTile());
          _builder.append(_fullyQualifiedName_5, "\t\t");
        }
      }
    }
    _builder.append(")fixA.getUserData());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("break;");
    _builder.newLine();
    return _builder.toString();
  }
  
  public void infer(final EObject gamePkg, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (gamePkg instanceof GamePackage) {
      _infer((GamePackage)gamePkg, acceptor, isPreIndexingPhase);
      return;
    } else if (gamePkg != null) {
      _infer(gamePkg, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(gamePkg, acceptor, isPreIndexingPhase).toString());
    }
  }
}
