/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game Layer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameLayer#getName <em>Name</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameLayer#getIndex <em>Index</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameLayer#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameLayer()
 * @model
 * @generated
 */
public interface GameLayer extends EObject
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
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameLayer_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameLayer#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' attribute.
   * @see #setIndex(int)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameLayer_Index()
   * @model
   * @generated
   */
  int getIndex();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameLayer#getIndex <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' attribute.
   * @see #getIndex()
   * @generated
   */
  void setIndex(int value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.hypermodel.games.engine.gameDSL.GameLayerType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see com.hypermodel.games.engine.gameDSL.GameLayerType
   * @see #setType(GameLayerType)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameLayer_Type()
   * @model
   * @generated
   */
  GameLayerType getType();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameLayer#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see com.hypermodel.games.engine.gameDSL.GameLayerType
   * @see #getType()
   * @generated
   */
  void setType(GameLayerType value);

} // GameLayer