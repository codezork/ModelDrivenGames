/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL.util;

import com.hypermodel.games.engine.gameDSL.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage
 * @generated
 */
public class GameDSLAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GameDSLPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GameDSLAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = GameDSLPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GameDSLSwitch<Adapter> modelSwitch =
    new GameDSLSwitch<Adapter>()
    {
      @Override
      public Adapter caseGameModel(GameModel object)
      {
        return createGameModelAdapter();
      }
      @Override
      public Adapter caseGamePackage(GamePackage object)
      {
        return createGamePackageAdapter();
      }
      @Override
      public Adapter caseGamePlatformConfig(GamePlatformConfig object)
      {
        return createGamePlatformConfigAdapter();
      }
      @Override
      public Adapter caseGamePlatformConfigAndroid(GamePlatformConfigAndroid object)
      {
        return createGamePlatformConfigAndroidAdapter();
      }
      @Override
      public Adapter caseGamePlatformConfigIOS(GamePlatformConfigIOS object)
      {
        return createGamePlatformConfigIOSAdapter();
      }
      @Override
      public Adapter caseGamePlatformConfigIOSMOE(GamePlatformConfigIOSMOE object)
      {
        return createGamePlatformConfigIOSMOEAdapter();
      }
      @Override
      public Adapter caseGameRoot(GameRoot object)
      {
        return createGameRootAdapter();
      }
      @Override
      public Adapter caseGameLayer(GameLayer object)
      {
        return createGameLayerAdapter();
      }
      @Override
      public Adapter caseGameScreen(GameScreen object)
      {
        return createGameScreenAdapter();
      }
      @Override
      public Adapter caseGameScene(GameScene object)
      {
        return createGameSceneAdapter();
      }
      @Override
      public Adapter caseGameScore(GameScore object)
      {
        return createGameScoreAdapter();
      }
      @Override
      public Adapter caseGameDisplay(GameDisplay object)
      {
        return createGameDisplayAdapter();
      }
      @Override
      public Adapter caseGameTile(GameTile object)
      {
        return createGameTileAdapter();
      }
      @Override
      public Adapter caseGameSprite(GameSprite object)
      {
        return createGameSpriteAdapter();
      }
      @Override
      public Adapter caseGameInput(GameInput object)
      {
        return createGameInputAdapter();
      }
      @Override
      public Adapter caseGameActor(GameActor object)
      {
        return createGameActorAdapter();
      }
      @Override
      public Adapter caseGameVector2d(GameVector2d object)
      {
        return createGameVector2dAdapter();
      }
      @Override
      public Adapter caseGameSpriteState(GameSpriteState object)
      {
        return createGameSpriteStateAdapter();
      }
      @Override
      public Adapter caseGameBodyProperty(GameBodyProperty object)
      {
        return createGameBodyPropertyAdapter();
      }
      @Override
      public Adapter caseGameRule(GameRule object)
      {
        return createGameRuleAdapter();
      }
      @Override
      public Adapter caseGameSpriteAnimation(GameSpriteAnimation object)
      {
        return createGameSpriteAnimationAdapter();
      }
      @Override
      public Adapter caseGameSpriteStand(GameSpriteStand object)
      {
        return createGameSpriteStandAdapter();
      }
      @Override
      public Adapter caseGameTextureRegion(GameTextureRegion object)
      {
        return createGameTextureRegionAdapter();
      }
      @Override
      public Adapter caseGameEvent(GameEvent object)
      {
        return createGameEventAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameModel <em>Game Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameModel
   * @generated
   */
  public Adapter createGameModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GamePackage <em>Game Package</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GamePackage
   * @generated
   */
  public Adapter createGamePackageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GamePlatformConfig <em>Game Platform Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GamePlatformConfig
   * @generated
   */
  public Adapter createGamePlatformConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GamePlatformConfigAndroid <em>Game Platform Config Android</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GamePlatformConfigAndroid
   * @generated
   */
  public Adapter createGamePlatformConfigAndroidAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GamePlatformConfigIOS <em>Game Platform Config IOS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GamePlatformConfigIOS
   * @generated
   */
  public Adapter createGamePlatformConfigIOSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GamePlatformConfigIOSMOE <em>Game Platform Config IOSMOE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GamePlatformConfigIOSMOE
   * @generated
   */
  public Adapter createGamePlatformConfigIOSMOEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameRoot <em>Game Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameRoot
   * @generated
   */
  public Adapter createGameRootAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameLayer <em>Game Layer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameLayer
   * @generated
   */
  public Adapter createGameLayerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameScreen <em>Game Screen</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameScreen
   * @generated
   */
  public Adapter createGameScreenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameScene <em>Game Scene</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameScene
   * @generated
   */
  public Adapter createGameSceneAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameScore <em>Game Score</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameScore
   * @generated
   */
  public Adapter createGameScoreAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameDisplay <em>Game Display</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameDisplay
   * @generated
   */
  public Adapter createGameDisplayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameTile <em>Game Tile</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameTile
   * @generated
   */
  public Adapter createGameTileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameSprite <em>Game Sprite</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameSprite
   * @generated
   */
  public Adapter createGameSpriteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameInput <em>Game Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameInput
   * @generated
   */
  public Adapter createGameInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameActor <em>Game Actor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameActor
   * @generated
   */
  public Adapter createGameActorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameVector2d <em>Game Vector2d</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameVector2d
   * @generated
   */
  public Adapter createGameVector2dAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameSpriteState <em>Game Sprite State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameSpriteState
   * @generated
   */
  public Adapter createGameSpriteStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameBodyProperty <em>Game Body Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameBodyProperty
   * @generated
   */
  public Adapter createGameBodyPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameRule <em>Game Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameRule
   * @generated
   */
  public Adapter createGameRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameSpriteAnimation <em>Game Sprite Animation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameSpriteAnimation
   * @generated
   */
  public Adapter createGameSpriteAnimationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameSpriteStand <em>Game Sprite Stand</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameSpriteStand
   * @generated
   */
  public Adapter createGameSpriteStandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameTextureRegion <em>Game Texture Region</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameTextureRegion
   * @generated
   */
  public Adapter createGameTextureRegionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.hypermodel.games.engine.gameDSL.GameEvent <em>Game Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.hypermodel.games.engine.gameDSL.GameEvent
   * @generated
   */
  public Adapter createGameEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //GameDSLAdapterFactory
