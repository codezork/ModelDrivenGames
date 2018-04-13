/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL.impl;

import com.hypermodel.games.engine.gameDSL.GameDSLPackage;
import com.hypermodel.games.engine.gameDSL.GameTile;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game Tile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameTileImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameTileImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameTileImpl#isHasMapLevel <em>Has Map Level</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameTileImpl#getMapLevel <em>Map Level</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameTileImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameTileImpl#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameTileImpl extends MinimalEObjectImpl.Container implements GameTile
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
   * The default value of the '{@link #isHasMapLevel() <em>Has Map Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasMapLevel()
   * @generated
   * @ordered
   */
  protected static final boolean HAS_MAP_LEVEL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHasMapLevel() <em>Has Map Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasMapLevel()
   * @generated
   * @ordered
   */
  protected boolean hasMapLevel = HAS_MAP_LEVEL_EDEFAULT;

  /**
   * The default value of the '{@link #getMapLevel() <em>Map Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMapLevel()
   * @generated
   * @ordered
   */
  protected static final int MAP_LEVEL_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMapLevel() <em>Map Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMapLevel()
   * @generated
   * @ordered
   */
  protected int mapLevel = MAP_LEVEL_EDEFAULT;

  /**
   * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidth()
   * @generated
   * @ordered
   */
  protected static final int WIDTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidth()
   * @generated
   * @ordered
   */
  protected int width = WIDTH_EDEFAULT;

  /**
   * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeight()
   * @generated
   * @ordered
   */
  protected static final int HEIGHT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeight()
   * @generated
   * @ordered
   */
  protected int height = HEIGHT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GameTileImpl()
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
    return GameDSLPackage.Literals.GAME_TILE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_TILE__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_TILE__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHasMapLevel()
  {
    return hasMapLevel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHasMapLevel(boolean newHasMapLevel)
  {
    boolean oldHasMapLevel = hasMapLevel;
    hasMapLevel = newHasMapLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_TILE__HAS_MAP_LEVEL, oldHasMapLevel, hasMapLevel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMapLevel()
  {
    return mapLevel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMapLevel(int newMapLevel)
  {
    int oldMapLevel = mapLevel;
    mapLevel = newMapLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_TILE__MAP_LEVEL, oldMapLevel, mapLevel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWidth()
  {
    return width;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWidth(int newWidth)
  {
    int oldWidth = width;
    width = newWidth;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_TILE__WIDTH, oldWidth, width));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getHeight()
  {
    return height;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHeight(int newHeight)
  {
    int oldHeight = height;
    height = newHeight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_TILE__HEIGHT, oldHeight, height));
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
      case GameDSLPackage.GAME_TILE__NAME:
        return getName();
      case GameDSLPackage.GAME_TILE__ID:
        return getId();
      case GameDSLPackage.GAME_TILE__HAS_MAP_LEVEL:
        return isHasMapLevel();
      case GameDSLPackage.GAME_TILE__MAP_LEVEL:
        return getMapLevel();
      case GameDSLPackage.GAME_TILE__WIDTH:
        return getWidth();
      case GameDSLPackage.GAME_TILE__HEIGHT:
        return getHeight();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GameDSLPackage.GAME_TILE__NAME:
        setName((String)newValue);
        return;
      case GameDSLPackage.GAME_TILE__ID:
        setId((Integer)newValue);
        return;
      case GameDSLPackage.GAME_TILE__HAS_MAP_LEVEL:
        setHasMapLevel((Boolean)newValue);
        return;
      case GameDSLPackage.GAME_TILE__MAP_LEVEL:
        setMapLevel((Integer)newValue);
        return;
      case GameDSLPackage.GAME_TILE__WIDTH:
        setWidth((Integer)newValue);
        return;
      case GameDSLPackage.GAME_TILE__HEIGHT:
        setHeight((Integer)newValue);
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
      case GameDSLPackage.GAME_TILE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GameDSLPackage.GAME_TILE__ID:
        setId(ID_EDEFAULT);
        return;
      case GameDSLPackage.GAME_TILE__HAS_MAP_LEVEL:
        setHasMapLevel(HAS_MAP_LEVEL_EDEFAULT);
        return;
      case GameDSLPackage.GAME_TILE__MAP_LEVEL:
        setMapLevel(MAP_LEVEL_EDEFAULT);
        return;
      case GameDSLPackage.GAME_TILE__WIDTH:
        setWidth(WIDTH_EDEFAULT);
        return;
      case GameDSLPackage.GAME_TILE__HEIGHT:
        setHeight(HEIGHT_EDEFAULT);
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
      case GameDSLPackage.GAME_TILE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GameDSLPackage.GAME_TILE__ID:
        return id != ID_EDEFAULT;
      case GameDSLPackage.GAME_TILE__HAS_MAP_LEVEL:
        return hasMapLevel != HAS_MAP_LEVEL_EDEFAULT;
      case GameDSLPackage.GAME_TILE__MAP_LEVEL:
        return mapLevel != MAP_LEVEL_EDEFAULT;
      case GameDSLPackage.GAME_TILE__WIDTH:
        return width != WIDTH_EDEFAULT;
      case GameDSLPackage.GAME_TILE__HEIGHT:
        return height != HEIGHT_EDEFAULT;
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
    result.append(", hasMapLevel: ");
    result.append(hasMapLevel);
    result.append(", mapLevel: ");
    result.append(mapLevel);
    result.append(", width: ");
    result.append(width);
    result.append(", height: ");
    result.append(height);
    result.append(')');
    return result.toString();
  }

} //GameTileImpl
