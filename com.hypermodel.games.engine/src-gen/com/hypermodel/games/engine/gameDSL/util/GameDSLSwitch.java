/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL.util;

import com.hypermodel.games.engine.gameDSL.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage
 * @generated
 */
public class GameDSLSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GameDSLPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GameDSLSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = GameDSLPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case GameDSLPackage.GAME_MODEL:
      {
        GameModel gameModel = (GameModel)theEObject;
        T result = caseGameModel(gameModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_PACKAGE:
      {
        GamePackage gamePackage = (GamePackage)theEObject;
        T result = caseGamePackage(gamePackage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_PLATFORM_CONFIG:
      {
        GamePlatformConfig gamePlatformConfig = (GamePlatformConfig)theEObject;
        T result = caseGamePlatformConfig(gamePlatformConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_PLATFORM_CONFIG_ANDROID:
      {
        GamePlatformConfigAndroid gamePlatformConfigAndroid = (GamePlatformConfigAndroid)theEObject;
        T result = caseGamePlatformConfigAndroid(gamePlatformConfigAndroid);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_PLATFORM_CONFIG_IOS:
      {
        GamePlatformConfigIOS gamePlatformConfigIOS = (GamePlatformConfigIOS)theEObject;
        T result = caseGamePlatformConfigIOS(gamePlatformConfigIOS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_PLATFORM_CONFIG_IOSMOE:
      {
        GamePlatformConfigIOSMOE gamePlatformConfigIOSMOE = (GamePlatformConfigIOSMOE)theEObject;
        T result = caseGamePlatformConfigIOSMOE(gamePlatformConfigIOSMOE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_ROOT:
      {
        GameRoot gameRoot = (GameRoot)theEObject;
        T result = caseGameRoot(gameRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_SCREEN:
      {
        GameScreen gameScreen = (GameScreen)theEObject;
        T result = caseGameScreen(gameScreen);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_SCENE:
      {
        GameScene gameScene = (GameScene)theEObject;
        T result = caseGameScene(gameScene);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_SCORE:
      {
        GameScore gameScore = (GameScore)theEObject;
        T result = caseGameScore(gameScore);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_DISPLAY:
      {
        GameDisplay gameDisplay = (GameDisplay)theEObject;
        T result = caseGameDisplay(gameDisplay);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_TILE:
      {
        GameTile gameTile = (GameTile)theEObject;
        T result = caseGameTile(gameTile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_SPRITE:
      {
        GameSprite gameSprite = (GameSprite)theEObject;
        T result = caseGameSprite(gameSprite);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_VECTOR2D:
      {
        GameVector2d gameVector2d = (GameVector2d)theEObject;
        T result = caseGameVector2d(gameVector2d);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_SPRITE_STATE:
      {
        GameSpriteState gameSpriteState = (GameSpriteState)theEObject;
        T result = caseGameSpriteState(gameSpriteState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_BODY_PROPERTY:
      {
        GameBodyProperty gameBodyProperty = (GameBodyProperty)theEObject;
        T result = caseGameBodyProperty(gameBodyProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_RULE:
      {
        GameRule gameRule = (GameRule)theEObject;
        T result = caseGameRule(gameRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_SPRITE_ANIMATION:
      {
        GameSpriteAnimation gameSpriteAnimation = (GameSpriteAnimation)theEObject;
        T result = caseGameSpriteAnimation(gameSpriteAnimation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_SPRITE_STAND:
      {
        GameSpriteStand gameSpriteStand = (GameSpriteStand)theEObject;
        T result = caseGameSpriteStand(gameSpriteStand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_TEXTURE_REGION:
      {
        GameTextureRegion gameTextureRegion = (GameTextureRegion)theEObject;
        T result = caseGameTextureRegion(gameTextureRegion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GameDSLPackage.GAME_SPRITE_EVENT:
      {
        GameSpriteEvent gameSpriteEvent = (GameSpriteEvent)theEObject;
        T result = caseGameSpriteEvent(gameSpriteEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameModel(GameModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Package</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Package</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGamePackage(GamePackage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Platform Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Platform Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGamePlatformConfig(GamePlatformConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Platform Config Android</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Platform Config Android</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGamePlatformConfigAndroid(GamePlatformConfigAndroid object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Platform Config IOS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Platform Config IOS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGamePlatformConfigIOS(GamePlatformConfigIOS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Platform Config IOSMOE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Platform Config IOSMOE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGamePlatformConfigIOSMOE(GamePlatformConfigIOSMOE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameRoot(GameRoot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Screen</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Screen</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameScreen(GameScreen object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Scene</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Scene</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameScene(GameScene object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Score</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Score</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameScore(GameScore object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Display</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Display</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameDisplay(GameDisplay object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Tile</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Tile</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameTile(GameTile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Sprite</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Sprite</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameSprite(GameSprite object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Vector2d</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Vector2d</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameVector2d(GameVector2d object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Sprite State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Sprite State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameSpriteState(GameSpriteState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Body Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Body Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameBodyProperty(GameBodyProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameRule(GameRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Sprite Animation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Sprite Animation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameSpriteAnimation(GameSpriteAnimation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Sprite Stand</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Sprite Stand</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameSpriteStand(GameSpriteStand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Texture Region</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Texture Region</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameTextureRegion(GameTextureRegion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Sprite Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Sprite Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameSpriteEvent(GameSpriteEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //GameDSLSwitch
