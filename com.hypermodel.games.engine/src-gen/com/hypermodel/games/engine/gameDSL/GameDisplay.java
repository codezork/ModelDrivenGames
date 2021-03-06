/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game Display</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getName <em>Name</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getType <em>Type</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getFormat <em>Format</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#isHasInitial <em>Has Initial</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getInitialNumberValue <em>Initial Number Value</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getInitialIntValue <em>Initial Int Value</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getInitialStringValue <em>Initial String Value</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#isHasDelta <em>Has Delta</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getDeltaValue <em>Delta Value</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getTimePeriod <em>Time Period</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#isHasAdder <em>Has Adder</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameDisplay#isHasSetter <em>Has Setter</em>}</li>
 * </ul>
 *
 * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay()
 * @model
 * @generated
 */
public interface GameDisplay extends EObject
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
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.hypermodel.games.engine.gameDSL.GameDisplayValueType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see com.hypermodel.games.engine.gameDSL.GameDisplayValueType
   * @see #setType(GameDisplayValueType)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_Type()
   * @model
   * @generated
   */
  GameDisplayValueType getType();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see com.hypermodel.games.engine.gameDSL.GameDisplayValueType
   * @see #getType()
   * @generated
   */
  void setType(GameDisplayValueType value);

  /**
   * Returns the value of the '<em><b>Format</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Format</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Format</em>' attribute.
   * @see #setFormat(String)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_Format()
   * @model
   * @generated
   */
  String getFormat();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getFormat <em>Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Format</em>' attribute.
   * @see #getFormat()
   * @generated
   */
  void setFormat(String value);

  /**
   * Returns the value of the '<em><b>Has Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Initial</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Initial</em>' attribute.
   * @see #setHasInitial(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_HasInitial()
   * @model
   * @generated
   */
  boolean isHasInitial();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#isHasInitial <em>Has Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Initial</em>' attribute.
   * @see #isHasInitial()
   * @generated
   */
  void setHasInitial(boolean value);

  /**
   * Returns the value of the '<em><b>Initial Number Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial Number Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Number Value</em>' attribute.
   * @see #setInitialNumberValue(float)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_InitialNumberValue()
   * @model
   * @generated
   */
  float getInitialNumberValue();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getInitialNumberValue <em>Initial Number Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Number Value</em>' attribute.
   * @see #getInitialNumberValue()
   * @generated
   */
  void setInitialNumberValue(float value);

  /**
   * Returns the value of the '<em><b>Initial Int Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial Int Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Int Value</em>' attribute.
   * @see #setInitialIntValue(int)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_InitialIntValue()
   * @model
   * @generated
   */
  int getInitialIntValue();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getInitialIntValue <em>Initial Int Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Int Value</em>' attribute.
   * @see #getInitialIntValue()
   * @generated
   */
  void setInitialIntValue(int value);

  /**
   * Returns the value of the '<em><b>Initial String Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial String Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial String Value</em>' attribute.
   * @see #setInitialStringValue(String)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_InitialStringValue()
   * @model
   * @generated
   */
  String getInitialStringValue();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getInitialStringValue <em>Initial String Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial String Value</em>' attribute.
   * @see #getInitialStringValue()
   * @generated
   */
  void setInitialStringValue(String value);

  /**
   * Returns the value of the '<em><b>Has Delta</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Delta</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Delta</em>' attribute.
   * @see #setHasDelta(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_HasDelta()
   * @model
   * @generated
   */
  boolean isHasDelta();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#isHasDelta <em>Has Delta</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Delta</em>' attribute.
   * @see #isHasDelta()
   * @generated
   */
  void setHasDelta(boolean value);

  /**
   * Returns the value of the '<em><b>Delta Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Delta Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delta Value</em>' attribute.
   * @see #setDeltaValue(float)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_DeltaValue()
   * @model
   * @generated
   */
  float getDeltaValue();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getDeltaValue <em>Delta Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delta Value</em>' attribute.
   * @see #getDeltaValue()
   * @generated
   */
  void setDeltaValue(float value);

  /**
   * Returns the value of the '<em><b>Time Period</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time Period</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time Period</em>' attribute.
   * @see #setTimePeriod(float)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_TimePeriod()
   * @model
   * @generated
   */
  float getTimePeriod();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#getTimePeriod <em>Time Period</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Period</em>' attribute.
   * @see #getTimePeriod()
   * @generated
   */
  void setTimePeriod(float value);

  /**
   * Returns the value of the '<em><b>Has Adder</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Adder</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Adder</em>' attribute.
   * @see #setHasAdder(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_HasAdder()
   * @model
   * @generated
   */
  boolean isHasAdder();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#isHasAdder <em>Has Adder</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Adder</em>' attribute.
   * @see #isHasAdder()
   * @generated
   */
  void setHasAdder(boolean value);

  /**
   * Returns the value of the '<em><b>Has Setter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Setter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Setter</em>' attribute.
   * @see #setHasSetter(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameDisplay_HasSetter()
   * @model
   * @generated
   */
  boolean isHasSetter();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameDisplay#isHasSetter <em>Has Setter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Setter</em>' attribute.
   * @see #isHasSetter()
   * @generated
   */
  void setHasSetter(boolean value);

} // GameDisplay
