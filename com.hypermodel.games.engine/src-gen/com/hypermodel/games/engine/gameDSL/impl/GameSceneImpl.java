/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL.impl;

import com.hypermodel.games.engine.gameDSL.GameDSLPackage;
import com.hypermodel.games.engine.gameDSL.GameDisplay;
import com.hypermodel.games.engine.gameDSL.GameMessage;
import com.hypermodel.games.engine.gameDSL.GameScene;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game Scene</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSceneImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSceneImpl#getTopPadding <em>Top Padding</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSceneImpl#getDisplays <em>Displays</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSceneImpl#getMessages <em>Messages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameSceneImpl extends MinimalEObjectImpl.Container implements GameScene
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getTopPadding() <em>Top Padding</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTopPadding()
   * @generated
   * @ordered
   */
  protected static final int TOP_PADDING_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTopPadding() <em>Top Padding</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTopPadding()
   * @generated
   * @ordered
   */
  protected int topPadding = TOP_PADDING_EDEFAULT;

  /**
   * The cached value of the '{@link #getDisplays() <em>Displays</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDisplays()
   * @generated
   * @ordered
   */
  protected EList<GameDisplay> displays;

  /**
   * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessages()
   * @generated
   * @ordered
   */
  protected EList<GameMessage> messages;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GameSceneImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GameDSLPackage.Literals.GAME_SCENE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SCENE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTopPadding()
  {
    return topPadding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTopPadding(int newTopPadding)
  {
    int oldTopPadding = topPadding;
    topPadding = newTopPadding;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SCENE__TOP_PADDING, oldTopPadding, topPadding));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameDisplay> getDisplays()
  {
    if (displays == null)
    {
      displays = new EObjectContainmentEList<GameDisplay>(GameDisplay.class, this, GameDSLPackage.GAME_SCENE__DISPLAYS);
    }
    return displays;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameMessage> getMessages()
  {
    if (messages == null)
    {
      messages = new EObjectContainmentEList<GameMessage>(GameMessage.class, this, GameDSLPackage.GAME_SCENE__MESSAGES);
    }
    return messages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GameDSLPackage.GAME_SCENE__DISPLAYS:
        return ((InternalEList<?>)getDisplays()).basicRemove(otherEnd, msgs);
      case GameDSLPackage.GAME_SCENE__MESSAGES:
        return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GameDSLPackage.GAME_SCENE__NAME:
        return getName();
      case GameDSLPackage.GAME_SCENE__TOP_PADDING:
        return getTopPadding();
      case GameDSLPackage.GAME_SCENE__DISPLAYS:
        return getDisplays();
      case GameDSLPackage.GAME_SCENE__MESSAGES:
        return getMessages();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GameDSLPackage.GAME_SCENE__NAME:
        setName((String)newValue);
        return;
      case GameDSLPackage.GAME_SCENE__TOP_PADDING:
        setTopPadding((Integer)newValue);
        return;
      case GameDSLPackage.GAME_SCENE__DISPLAYS:
        getDisplays().clear();
        getDisplays().addAll((Collection<? extends GameDisplay>)newValue);
        return;
      case GameDSLPackage.GAME_SCENE__MESSAGES:
        getMessages().clear();
        getMessages().addAll((Collection<? extends GameMessage>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GameDSLPackage.GAME_SCENE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SCENE__TOP_PADDING:
        setTopPadding(TOP_PADDING_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SCENE__DISPLAYS:
        getDisplays().clear();
        return;
      case GameDSLPackage.GAME_SCENE__MESSAGES:
        getMessages().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GameDSLPackage.GAME_SCENE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GameDSLPackage.GAME_SCENE__TOP_PADDING:
        return topPadding != TOP_PADDING_EDEFAULT;
      case GameDSLPackage.GAME_SCENE__DISPLAYS:
        return displays != null && !displays.isEmpty();
      case GameDSLPackage.GAME_SCENE__MESSAGES:
        return messages != null && !messages.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", topPadding: ");
    result.append(topPadding);
    result.append(')');
    return result.toString();
  }

} //GameSceneImpl
