/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL.impl;

import com.hypermodel.games.engine.gameDSL.GameDSLPackage;
import com.hypermodel.games.engine.gameDSL.GameSpriteAnimation;
import com.hypermodel.games.engine.gameDSL.GameSpriteStand;
import com.hypermodel.games.engine.gameDSL.GameTextureRegion;

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
 * An implementation of the model object '<em><b>Game Sprite Animation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteAnimationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteAnimationImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteAnimationImpl#isHasFrames <em>Has Frames</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteAnimationImpl#getFrames <em>Frames</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteAnimationImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteAnimationImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteAnimationImpl#isHasStands <em>Has Stands</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameSpriteAnimationImpl#getStands <em>Stands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameSpriteAnimationImpl extends MinimalEObjectImpl.Container implements GameSpriteAnimation
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
   * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected static final float DURATION_EDEFAULT = 0.0F;

  /**
   * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected float duration = DURATION_EDEFAULT;

  /**
   * The default value of the '{@link #isHasFrames() <em>Has Frames</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasFrames()
   * @generated
   * @ordered
   */
  protected static final boolean HAS_FRAMES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHasFrames() <em>Has Frames</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasFrames()
   * @generated
   * @ordered
   */
  protected boolean hasFrames = HAS_FRAMES_EDEFAULT;

  /**
   * The default value of the '{@link #getFrames() <em>Frames</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrames()
   * @generated
   * @ordered
   */
  protected static final int FRAMES_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFrames() <em>Frames</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrames()
   * @generated
   * @ordered
   */
  protected int frames = FRAMES_EDEFAULT;

  /**
   * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOffset()
   * @generated
   * @ordered
   */
  protected static final int OFFSET_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOffset()
   * @generated
   * @ordered
   */
  protected int offset = OFFSET_EDEFAULT;

  /**
   * The cached value of the '{@link #getRegion() <em>Region</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegion()
   * @generated
   * @ordered
   */
  protected GameTextureRegion region;

  /**
   * The default value of the '{@link #isHasStands() <em>Has Stands</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasStands()
   * @generated
   * @ordered
   */
  protected static final boolean HAS_STANDS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHasStands() <em>Has Stands</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHasStands()
   * @generated
   * @ordered
   */
  protected boolean hasStands = HAS_STANDS_EDEFAULT;

  /**
   * The cached value of the '{@link #getStands() <em>Stands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStands()
   * @generated
   * @ordered
   */
  protected EList<GameSpriteStand> stands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GameSpriteAnimationImpl()
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
    return GameDSLPackage.Literals.GAME_SPRITE_ANIMATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE_ANIMATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public float getDuration()
  {
    return duration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDuration(float newDuration)
  {
    float oldDuration = duration;
    duration = newDuration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE_ANIMATION__DURATION, oldDuration, duration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHasFrames()
  {
    return hasFrames;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHasFrames(boolean newHasFrames)
  {
    boolean oldHasFrames = hasFrames;
    hasFrames = newHasFrames;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_FRAMES, oldHasFrames, hasFrames));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getFrames()
  {
    return frames;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFrames(int newFrames)
  {
    int oldFrames = frames;
    frames = newFrames;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE_ANIMATION__FRAMES, oldFrames, frames));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getOffset()
  {
    return offset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOffset(int newOffset)
  {
    int oldOffset = offset;
    offset = newOffset;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE_ANIMATION__OFFSET, oldOffset, offset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GameTextureRegion getRegion()
  {
    if (region != null && region.eIsProxy())
    {
      InternalEObject oldRegion = (InternalEObject)region;
      region = (GameTextureRegion)eResolveProxy(oldRegion);
      if (region != oldRegion)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GameDSLPackage.GAME_SPRITE_ANIMATION__REGION, oldRegion, region));
      }
    }
    return region;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GameTextureRegion basicGetRegion()
  {
    return region;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRegion(GameTextureRegion newRegion)
  {
    GameTextureRegion oldRegion = region;
    region = newRegion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE_ANIMATION__REGION, oldRegion, region));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHasStands()
  {
    return hasStands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHasStands(boolean newHasStands)
  {
    boolean oldHasStands = hasStands;
    hasStands = newHasStands;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_STANDS, oldHasStands, hasStands));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameSpriteStand> getStands()
  {
    if (stands == null)
    {
      stands = new EObjectContainmentEList<GameSpriteStand>(GameSpriteStand.class, this, GameDSLPackage.GAME_SPRITE_ANIMATION__STANDS);
    }
    return stands;
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
      case GameDSLPackage.GAME_SPRITE_ANIMATION__STANDS:
        return ((InternalEList<?>)getStands()).basicRemove(otherEnd, msgs);
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
      case GameDSLPackage.GAME_SPRITE_ANIMATION__NAME:
        return getName();
      case GameDSLPackage.GAME_SPRITE_ANIMATION__DURATION:
        return getDuration();
      case GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_FRAMES:
        return isHasFrames();
      case GameDSLPackage.GAME_SPRITE_ANIMATION__FRAMES:
        return getFrames();
      case GameDSLPackage.GAME_SPRITE_ANIMATION__OFFSET:
        return getOffset();
      case GameDSLPackage.GAME_SPRITE_ANIMATION__REGION:
        if (resolve) return getRegion();
        return basicGetRegion();
      case GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_STANDS:
        return isHasStands();
      case GameDSLPackage.GAME_SPRITE_ANIMATION__STANDS:
        return getStands();
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
      case GameDSLPackage.GAME_SPRITE_ANIMATION__NAME:
        setName((String)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__DURATION:
        setDuration((Float)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_FRAMES:
        setHasFrames((Boolean)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__FRAMES:
        setFrames((Integer)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__OFFSET:
        setOffset((Integer)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__REGION:
        setRegion((GameTextureRegion)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_STANDS:
        setHasStands((Boolean)newValue);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__STANDS:
        getStands().clear();
        getStands().addAll((Collection<? extends GameSpriteStand>)newValue);
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
      case GameDSLPackage.GAME_SPRITE_ANIMATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__DURATION:
        setDuration(DURATION_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_FRAMES:
        setHasFrames(HAS_FRAMES_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__FRAMES:
        setFrames(FRAMES_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__OFFSET:
        setOffset(OFFSET_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__REGION:
        setRegion((GameTextureRegion)null);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_STANDS:
        setHasStands(HAS_STANDS_EDEFAULT);
        return;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__STANDS:
        getStands().clear();
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
      case GameDSLPackage.GAME_SPRITE_ANIMATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GameDSLPackage.GAME_SPRITE_ANIMATION__DURATION:
        return duration != DURATION_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_FRAMES:
        return hasFrames != HAS_FRAMES_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__FRAMES:
        return frames != FRAMES_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__OFFSET:
        return offset != OFFSET_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__REGION:
        return region != null;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__HAS_STANDS:
        return hasStands != HAS_STANDS_EDEFAULT;
      case GameDSLPackage.GAME_SPRITE_ANIMATION__STANDS:
        return stands != null && !stands.isEmpty();
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
    result.append(", duration: ");
    result.append(duration);
    result.append(", hasFrames: ");
    result.append(hasFrames);
    result.append(", frames: ");
    result.append(frames);
    result.append(", offset: ");
    result.append(offset);
    result.append(", hasStands: ");
    result.append(hasStands);
    result.append(')');
    return result.toString();
  }

} //GameSpriteAnimationImpl
