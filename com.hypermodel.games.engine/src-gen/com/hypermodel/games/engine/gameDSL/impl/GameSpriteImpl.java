/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL.impl;

import com.hypermodel.games.engine.gameDSL.GameBodyProperty;
import com.hypermodel.games.engine.gameDSL.GameDSLPackage;
import com.hypermodel.games.engine.gameDSL.GameSprite;
import com.hypermodel.games.engine.gameDSL.GameSpriteState;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game Sprite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getX <em>X</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getY <em>Y</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#isHasSensor <em>Has Sensor</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getSensorLength <em>Sensor Length</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getSensorID <em>Sensor ID</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getInteractionSprites <em>Interaction Sprites</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getStates <em>States</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteImpl#getInitialState <em>Initial State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameSpriteImpl extends MinimalEObjectImpl.Container implements GameSprite
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
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final int ID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected int id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getRadius() <em>Radius</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRadius()
   * @generated
   * @ordered
   */
  protected static final int RADIUS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRadius() <em>Radius</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRadius()
   * @generated
   * @ordered
   */
  protected int radius = RADIUS_EDEFAULT;

  /**
   * The default value of the '{@link #getX() <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX()
   * @generated
   * @ordered
   */
  protected static final int X_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getX() <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX()
   * @generated
   * @ordered
   */
  protected int x = X_EDEFAULT;

  /**
   * The default value of the '{@link #getY() <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY()
   * @generated
   * @ordered
   */
  protected static final int Y_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY()
   * @generated
   * @ordered
   */
  protected int y = Y_EDEFAULT;

  /**
   * The default value of the '{@link #isHasSensor() <em>Has Sensor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasSensor()
   * @generated
   * @ordered
   */
  protected static final boolean HAS_SENSOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHasSensor() <em>Has Sensor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasSensor()
   * @generated
   * @ordered
   */
  protected boolean hasSensor = HAS_SENSOR_EDEFAULT;

  /**
   * The default value of the '{@link #getSensorLength() <em>Sensor Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSensorLength()
   * @generated
   * @ordered
   */
  protected static final int SENSOR_LENGTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSensorLength() <em>Sensor Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSensorLength()
   * @generated
   * @ordered
   */
  protected int sensorLength = SENSOR_LENGTH_EDEFAULT;

  /**
   * The default value of the '{@link #getSensorID() <em>Sensor ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSensorID()
   * @generated
   * @ordered
   */
  protected static final int SENSOR_ID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSensorID() <em>Sensor ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSensorID()
   * @generated
   * @ordered
   */
  protected int sensorID = SENSOR_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getInteractionSprites() <em>Interaction Sprites</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInteractionSprites()
   * @generated
   * @ordered
   */
  protected EList<GameSprite> interactionSprites;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<GameBodyProperty> properties;

  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<GameSpriteState> states;

  /**
   * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialState()
   * @generated
   * @ordered
   */
  protected GameSpriteState initialState;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GameSpriteImpl()
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
    return GameDSLPackage.Literals.GAME_SPRITE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(int newId)
  {
    int oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRadius()
  {
    return radius;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRadius(int newRadius)
  {
    int oldRadius = radius;
    radius = newRadius;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE__RADIUS, oldRadius, radius));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getX()
  {
    return x;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX(int newX)
  {
    int oldX = x;
    x = newX;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE__X, oldX, x));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getY()
  {
    return y;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setY(int newY)
  {
    int oldY = y;
    y = newY;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE__Y, oldY, y));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHasSensor()
  {
    return hasSensor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHasSensor(boolean newHasSensor)
  {
    boolean oldHasSensor = hasSensor;
    hasSensor = newHasSensor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE__HAS_SENSOR, oldHasSensor, hasSensor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSensorLength()
  {
    return sensorLength;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSensorLength(int newSensorLength)
  {
    int oldSensorLength = sensorLength;
    sensorLength = newSensorLength;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE__SENSOR_LENGTH, oldSensorLength, sensorLength));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSensorID()
  {
    return sensorID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSensorID(int newSensorID)
  {
    int oldSensorID = sensorID;
    sensorID = newSensorID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE__SENSOR_ID, oldSensorID, sensorID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameSprite> getInteractionSprites()
  {
    if (interactionSprites == null)
    {
      interactionSprites = new EObjectResolvingEList<GameSprite>(GameSprite.class, this, GameDSLPackage.GAME_SPRITE__INTERACTION_SPRITES);
    }
    return interactionSprites;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameBodyProperty> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<GameBodyProperty>(GameBodyProperty.class, this, GameDSLPackage.GAME_SPRITE__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameSpriteState> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<GameSpriteState>(GameSpriteState.class, this, GameDSLPackage.GAME_SPRITE__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GameSpriteState getInitialState()
  {
    if (initialState != null && initialState.eIsProxy())
    {
      InternalEObject oldInitialState = (InternalEObject)initialState;
      initialState = (GameSpriteState)eResolveProxy(oldInitialState);
      if (initialState != oldInitialState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GameDSLPackage.GAME_SPRITE__INITIAL_STATE, oldInitialState, initialState));
      }
    }
    return initialState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GameSpriteState basicGetInitialState()
  {
    return initialState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitialState(GameSpriteState newInitialState)
  {
    GameSpriteState oldInitialState = initialState;
    initialState = newInitialState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE__INITIAL_STATE, oldInitialState, initialState));
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
      case GameDSLPackage.GAME_SPRITE__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
      case GameDSLPackage.GAME_SPRITE__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
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
      case GameDSLPackage.GAME_SPRITE__NAME:
        return getName();
      case GameDSLPackage.GAME_SPRITE__ID:
        return getId();
      case GameDSLPackage.GAME_SPRITE__RADIUS:
        return getRadius();
      case GameDSLPackage.GAME_SPRITE__X:
        return getX();
      case GameDSLPackage.GAME_SPRITE__Y:
        return getY();
      case GameDSLPackage.GAME_SPRITE__HAS_SENSOR:
        return isHasSensor();
      case GameDSLPackage.GAME_SPRITE__SENSOR_LENGTH:
        return getSensorLength();
      case GameDSLPackage.GAME_SPRITE__SENSOR_ID:
        return getSensorID();
      case GameDSLPackage.GAME_SPRITE__INTERACTION_SPRITES:
        return getInteractionSprites();
      case GameDSLPackage.GAME_SPRITE__PROPERTIES:
        return getProperties();
      case GameDSLPackage.GAME_SPRITE__STATES:
        return getStates();
      case GameDSLPackage.GAME_SPRITE__INITIAL_STATE:
        if (resolve) return getInitialState();
        return basicGetInitialState();
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
      case GameDSLPackage.GAME_SPRITE__NAME:
        setName((String)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__ID:
        setId((Integer)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__RADIUS:
        setRadius((Integer)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__X:
        setX((Integer)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__Y:
        setY((Integer)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__HAS_SENSOR:
        setHasSensor((Boolean)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__SENSOR_LENGTH:
        setSensorLength((Integer)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__SENSOR_ID:
        setSensorID((Integer)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__INTERACTION_SPRITES:
        getInteractionSprites().clear();
        getInteractionSprites().addAll((Collection<? extends GameSprite>)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends GameBodyProperty>)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends GameSpriteState>)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE__INITIAL_STATE:
        setInitialState((GameSpriteState)newValue);
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
      case GameDSLPackage.GAME_SPRITE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE__ID:
        setId(ID_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE__RADIUS:
        setRadius(RADIUS_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE__X:
        setX(X_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE__Y:
        setY(Y_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE__HAS_SENSOR:
        setHasSensor(HAS_SENSOR_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE__SENSOR_LENGTH:
        setSensorLength(SENSOR_LENGTH_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE__SENSOR_ID:
        setSensorID(SENSOR_ID_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE__INTERACTION_SPRITES:
        getInteractionSprites().clear();
        return;
      case GameDSLPackage.GAME_SPRITE__PROPERTIES:
        getProperties().clear();
        return;
      case GameDSLPackage.GAME_SPRITE__STATES:
        getStates().clear();
        return;
      case GameDSLPackage.GAME_SPRITE__INITIAL_STATE:
        setInitialState((GameSpriteState)null);
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
      case GameDSLPackage.GAME_SPRITE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GameDSLPackage.GAME_SPRITE__ID:
        return id != ID_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE__RADIUS:
        return radius != RADIUS_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE__X:
        return x != X_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE__Y:
        return y != Y_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE__HAS_SENSOR:
        return hasSensor != HAS_SENSOR_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE__SENSOR_LENGTH:
        return sensorLength != SENSOR_LENGTH_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE__SENSOR_ID:
        return sensorID != SENSOR_ID_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE__INTERACTION_SPRITES:
        return interactionSprites != null && !interactionSprites.isEmpty();
      case GameDSLPackage.GAME_SPRITE__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case GameDSLPackage.GAME_SPRITE__STATES:
        return states != null && !states.isEmpty();
      case GameDSLPackage.GAME_SPRITE__INITIAL_STATE:
        return initialState != null;
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
    result.append(", id: ");
    result.append(id);
    result.append(", radius: ");
    result.append(radius);
    result.append(", x: ");
    result.append(x);
    result.append(", y: ");
    result.append(y);
    result.append(", hasSensor: ");
    result.append(hasSensor);
    result.append(", sensorLength: ");
    result.append(sensorLength);
    result.append(", sensorID: ");
    result.append(sensorID);
    result.append(')');
    return result.toString();
  }

} //GameSpriteImpl
