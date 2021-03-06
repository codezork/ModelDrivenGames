/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game Sprite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getName <em>Name</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getId <em>Id</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getRadius <em>Radius</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#isHasVelocity <em>Has Velocity</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getVelocity <em>Velocity</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#isHasLayer <em>Has Layer</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getLayer <em>Layer</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#isHasStartPosition <em>Has Start Position</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#isHasSensor <em>Has Sensor</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getVectors2d <em>Vectors2d</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getSensorID <em>Sensor ID</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getActors <em>Actors</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getStates <em>States</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getGameOverState <em>Game Over State</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getEvents <em>Events</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameSprite#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite()
 * @model
 * @generated
 */
public interface GameSprite extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(int)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Id()
   * @model
   * @generated
   */
  int getId();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(int value);

  /**
   * Returns the value of the '<em><b>Radius</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Radius</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Radius</em>' attribute.
   * @see #setRadius(int)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Radius()
   * @model
   * @generated
   */
  int getRadius();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#getRadius <em>Radius</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Radius</em>' attribute.
   * @see #getRadius()
   * @generated
   */
  void setRadius(int value);

  /**
   * Returns the value of the '<em><b>Has Velocity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Velocity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Velocity</em>' attribute.
   * @see #setHasVelocity(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_HasVelocity()
   * @model
   * @generated
   */
  boolean isHasVelocity();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#isHasVelocity <em>Has Velocity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Velocity</em>' attribute.
   * @see #isHasVelocity()
   * @generated
   */
  void setHasVelocity(boolean value);

  /**
   * Returns the value of the '<em><b>Velocity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Velocity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Velocity</em>' containment reference.
   * @see #setVelocity(GameVector2d)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Velocity()
   * @model containment="true"
   * @generated
   */
  GameVector2d getVelocity();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#getVelocity <em>Velocity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Velocity</em>' containment reference.
   * @see #getVelocity()
   * @generated
   */
  void setVelocity(GameVector2d value);

  /**
   * Returns the value of the '<em><b>Has Layer</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Layer</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Layer</em>' attribute.
   * @see #setHasLayer(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_HasLayer()
   * @model
   * @generated
   */
  boolean isHasLayer();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#isHasLayer <em>Has Layer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Layer</em>' attribute.
   * @see #isHasLayer()
   * @generated
   */
  void setHasLayer(boolean value);

  /**
   * Returns the value of the '<em><b>Layer</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Layer</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Layer</em>' reference.
   * @see #setLayer(GameLayer)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Layer()
   * @model
   * @generated
   */
  GameLayer getLayer();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#getLayer <em>Layer</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Layer</em>' reference.
   * @see #getLayer()
   * @generated
   */
  void setLayer(GameLayer value);

  /**
   * Returns the value of the '<em><b>Has Start Position</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Start Position</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Start Position</em>' attribute.
   * @see #setHasStartPosition(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_HasStartPosition()
   * @model
   * @generated
   */
  boolean isHasStartPosition();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#isHasStartPosition <em>Has Start Position</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Start Position</em>' attribute.
   * @see #isHasStartPosition()
   * @generated
   */
  void setHasStartPosition(boolean value);

  /**
   * Returns the value of the '<em><b>Start Position</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Position</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Position</em>' containment reference.
   * @see #setStartPosition(GameVector2d)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_StartPosition()
   * @model containment="true"
   * @generated
   */
  GameVector2d getStartPosition();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#getStartPosition <em>Start Position</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Position</em>' containment reference.
   * @see #getStartPosition()
   * @generated
   */
  void setStartPosition(GameVector2d value);

  /**
   * Returns the value of the '<em><b>Has Sensor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Sensor</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Sensor</em>' attribute.
   * @see #setHasSensor(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_HasSensor()
   * @model
   * @generated
   */
  boolean isHasSensor();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#isHasSensor <em>Has Sensor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Sensor</em>' attribute.
   * @see #isHasSensor()
   * @generated
   */
  void setHasSensor(boolean value);

  /**
   * Returns the value of the '<em><b>Vectors2d</b></em>' containment reference list.
   * The list contents are of type {@link com.hypermodel.games.engine.gameDSL.GameVector2d}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vectors2d</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vectors2d</em>' containment reference list.
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Vectors2d()
   * @model containment="true"
   * @generated
   */
  EList<GameVector2d> getVectors2d();

  /**
   * Returns the value of the '<em><b>Sensor ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sensor ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sensor ID</em>' attribute.
   * @see #setSensorID(int)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_SensorID()
   * @model
   * @generated
   */
  int getSensorID();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#getSensorID <em>Sensor ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sensor ID</em>' attribute.
   * @see #getSensorID()
   * @generated
   */
  void setSensorID(int value);

  /**
   * Returns the value of the '<em><b>Actors</b></em>' containment reference list.
   * The list contents are of type {@link com.hypermodel.games.engine.gameDSL.GameActor}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actors</em>' containment reference list.
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Actors()
   * @model containment="true"
   * @generated
   */
  EList<GameActor> getActors();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link com.hypermodel.games.engine.gameDSL.GameBodyProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Properties()
   * @model containment="true"
   * @generated
   */
  EList<GameBodyProperty> getProperties();

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link com.hypermodel.games.engine.gameDSL.GameSpriteState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_States()
   * @model containment="true"
   * @generated
   */
  EList<GameSpriteState> getStates();

  /**
   * Returns the value of the '<em><b>Initial State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial State</em>' reference.
   * @see #setInitialState(GameSpriteState)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_InitialState()
   * @model
   * @generated
   */
  GameSpriteState getInitialState();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#getInitialState <em>Initial State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial State</em>' reference.
   * @see #getInitialState()
   * @generated
   */
  void setInitialState(GameSpriteState value);

  /**
   * Returns the value of the '<em><b>Game Over State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Game Over State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Game Over State</em>' reference.
   * @see #setGameOverState(GameSpriteState)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_GameOverState()
   * @model
   * @generated
   */
  GameSpriteState getGameOverState();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameSprite#getGameOverState <em>Game Over State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Game Over State</em>' reference.
   * @see #getGameOverState()
   * @generated
   */
  void setGameOverState(GameSpriteState value);

  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link com.hypermodel.games.engine.gameDSL.GameEvent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Events()
   * @model containment="true"
   * @generated
   */
  EList<GameEvent> getEvents();

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link com.hypermodel.games.engine.gameDSL.GameInput}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameSprite_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<GameInput> getInputs();

} // GameSprite
