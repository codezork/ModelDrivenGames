/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameActor#isHasCollisionCondition <em>Has Collision Condition</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameActor#getTypeA <em>Type A</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameActor#getTypeB <em>Type B</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameActor#getSprite <em>Sprite</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameActor#getTile <em>Tile</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameActor#isHasCollisionConsequence <em>Has Collision Consequence</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameActor#getBeginContact <em>Begin Contact</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.GameActor#getEndContact <em>End Contact</em>}</li>
 * </ul>
 *
 * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameActor()
 * @model
 * @generated
 */
public interface GameActor extends EObject
{
  /**
   * Returns the value of the '<em><b>Has Collision Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Collision Condition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Collision Condition</em>' attribute.
   * @see #setHasCollisionCondition(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameActor_HasCollisionCondition()
   * @model
   * @generated
   */
  boolean isHasCollisionCondition();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameActor#isHasCollisionCondition <em>Has Collision Condition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Collision Condition</em>' attribute.
   * @see #isHasCollisionCondition()
   * @generated
   */
  void setHasCollisionCondition(boolean value);

  /**
   * Returns the value of the '<em><b>Type A</b></em>' attribute.
   * The literals are from the enumeration {@link com.hypermodel.games.engine.gameDSL.GameContactType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type A</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type A</em>' attribute.
   * @see com.hypermodel.games.engine.gameDSL.GameContactType
   * @see #setTypeA(GameContactType)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameActor_TypeA()
   * @model
   * @generated
   */
  GameContactType getTypeA();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameActor#getTypeA <em>Type A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type A</em>' attribute.
   * @see com.hypermodel.games.engine.gameDSL.GameContactType
   * @see #getTypeA()
   * @generated
   */
  void setTypeA(GameContactType value);

  /**
   * Returns the value of the '<em><b>Type B</b></em>' attribute.
   * The literals are from the enumeration {@link com.hypermodel.games.engine.gameDSL.GameContactType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type B</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type B</em>' attribute.
   * @see com.hypermodel.games.engine.gameDSL.GameContactType
   * @see #setTypeB(GameContactType)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameActor_TypeB()
   * @model
   * @generated
   */
  GameContactType getTypeB();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameActor#getTypeB <em>Type B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type B</em>' attribute.
   * @see com.hypermodel.games.engine.gameDSL.GameContactType
   * @see #getTypeB()
   * @generated
   */
  void setTypeB(GameContactType value);

  /**
   * Returns the value of the '<em><b>Sprite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sprite</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sprite</em>' reference.
   * @see #setSprite(GameSprite)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameActor_Sprite()
   * @model
   * @generated
   */
  GameSprite getSprite();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameActor#getSprite <em>Sprite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sprite</em>' reference.
   * @see #getSprite()
   * @generated
   */
  void setSprite(GameSprite value);

  /**
   * Returns the value of the '<em><b>Tile</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tile</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tile</em>' reference.
   * @see #setTile(GameTile)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameActor_Tile()
   * @model
   * @generated
   */
  GameTile getTile();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameActor#getTile <em>Tile</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tile</em>' reference.
   * @see #getTile()
   * @generated
   */
  void setTile(GameTile value);

  /**
   * Returns the value of the '<em><b>Has Collision Consequence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Has Collision Consequence</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Collision Consequence</em>' attribute.
   * @see #setHasCollisionConsequence(boolean)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameActor_HasCollisionConsequence()
   * @model
   * @generated
   */
  boolean isHasCollisionConsequence();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameActor#isHasCollisionConsequence <em>Has Collision Consequence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Collision Consequence</em>' attribute.
   * @see #isHasCollisionConsequence()
   * @generated
   */
  void setHasCollisionConsequence(boolean value);

  /**
   * Returns the value of the '<em><b>Begin Contact</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Begin Contact</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Begin Contact</em>' reference.
   * @see #setBeginContact(GameEvent)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameActor_BeginContact()
   * @model
   * @generated
   */
  GameEvent getBeginContact();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameActor#getBeginContact <em>Begin Contact</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Begin Contact</em>' reference.
   * @see #getBeginContact()
   * @generated
   */
  void setBeginContact(GameEvent value);

  /**
   * Returns the value of the '<em><b>End Contact</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End Contact</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Contact</em>' reference.
   * @see #setEndContact(GameEvent)
   * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameActor_EndContact()
   * @model
   * @generated
   */
  GameEvent getEndContact();

  /**
   * Sets the value of the '{@link com.hypermodel.games.engine.gameDSL.GameActor#getEndContact <em>End Contact</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End Contact</em>' reference.
   * @see #getEndContact()
   * @generated
   */
  void setEndContact(GameEvent value);

} // GameActor
