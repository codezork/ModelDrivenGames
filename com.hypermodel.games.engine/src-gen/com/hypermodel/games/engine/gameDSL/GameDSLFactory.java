/**
 * generated by Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage
 * @generated
 */
public interface GameDSLFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GameDSLFactory eINSTANCE = com.hypermodel.games.engine.gameDSL.impl.GameDSLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Game Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Model</em>'.
   * @generated
   */
  GameModel createGameModel();

  /**
   * Returns a new object of class '<em>Game Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Import</em>'.
   * @generated
   */
  GameImport createGameImport();

  /**
   * Returns a new object of class '<em>Game Package</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Package</em>'.
   * @generated
   */
  GamePackage createGamePackage();

  /**
   * Returns a new object of class '<em>Game Platform Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Platform Config</em>'.
   * @generated
   */
  GamePlatformConfig createGamePlatformConfig();

  /**
   * Returns a new object of class '<em>Game Platform Config Android</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Platform Config Android</em>'.
   * @generated
   */
  GamePlatformConfigAndroid createGamePlatformConfigAndroid();

  /**
   * Returns a new object of class '<em>Game Platform Config IOS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Platform Config IOS</em>'.
   * @generated
   */
  GamePlatformConfigIOS createGamePlatformConfigIOS();

  /**
   * Returns a new object of class '<em>Game Platform Config IOSMOE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Platform Config IOSMOE</em>'.
   * @generated
   */
  GamePlatformConfigIOSMOE createGamePlatformConfigIOSMOE();

  /**
   * Returns a new object of class '<em>Game Platform Configuration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Platform Configuration</em>'.
   * @generated
   */
  GamePlatformConfiguration createGamePlatformConfiguration();

  /**
   * Returns a new object of class '<em>Game Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Root</em>'.
   * @generated
   */
  GameRoot createGameRoot();

  /**
   * Returns a new object of class '<em>Game Screen</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Game Screen</em>'.
   * @generated
   */
  GameScreen createGameScreen();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GameDSLPackage getGameDSLPackage();

} //GameDSLFactory
