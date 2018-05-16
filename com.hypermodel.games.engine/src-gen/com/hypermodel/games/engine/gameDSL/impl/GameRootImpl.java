/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL.impl;

import com.hypermodel.games.engine.gameDSL.GameDSLPackage;
import com.hypermodel.games.engine.gameDSL.GameLayer;
import com.hypermodel.games.engine.gameDSL.GameRoot;
import com.hypermodel.games.engine.gameDSL.GameScreen;
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
 * An implementation of the model object '<em><b>Game Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getPpm <em>Ppm</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getTimeStep <em>Time Step</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getVelocityIterations <em>Velocity Iterations</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getPositionIterations <em>Position Iterations</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getWorldWidth <em>World Width</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getWorldHeight <em>World Height</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getTileWidth <em>Tile Width</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getTileHeight <em>Tile Height</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#isDebug <em>Debug</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getLayers <em>Layers</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getScreens <em>Screens</em>}</li>
 *   <li>{@link com.hypermodel.games.engine.gameDSL.impl.GameRootImpl#getRegions <em>Regions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GameRootImpl extends MinimalEObjectImpl.Container implements GameRoot
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
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected static final String TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected String title = TITLE_EDEFAULT;

  /**
   * The default value of the '{@link #getPpm() <em>Ppm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPpm()
   * @generated
   * @ordered
   */
  protected static final int PPM_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPpm() <em>Ppm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPpm()
   * @generated
   * @ordered
   */
  protected int ppm = PPM_EDEFAULT;

  /**
   * The default value of the '{@link #getTimeStep() <em>Time Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeStep()
   * @generated
   * @ordered
   */
  protected static final float TIME_STEP_EDEFAULT = 0.0F;

  /**
   * The cached value of the '{@link #getTimeStep() <em>Time Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeStep()
   * @generated
   * @ordered
   */
  protected float timeStep = TIME_STEP_EDEFAULT;

  /**
   * The default value of the '{@link #getVelocityIterations() <em>Velocity Iterations</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVelocityIterations()
   * @generated
   * @ordered
   */
  protected static final int VELOCITY_ITERATIONS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getVelocityIterations() <em>Velocity Iterations</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVelocityIterations()
   * @generated
   * @ordered
   */
  protected int velocityIterations = VELOCITY_ITERATIONS_EDEFAULT;

  /**
   * The default value of the '{@link #getPositionIterations() <em>Position Iterations</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPositionIterations()
   * @generated
   * @ordered
   */
  protected static final int POSITION_ITERATIONS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPositionIterations() <em>Position Iterations</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPositionIterations()
   * @generated
   * @ordered
   */
  protected int positionIterations = POSITION_ITERATIONS_EDEFAULT;

  /**
   * The default value of the '{@link #getWorldWidth() <em>World Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorldWidth()
   * @generated
   * @ordered
   */
  protected static final int WORLD_WIDTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWorldWidth() <em>World Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorldWidth()
   * @generated
   * @ordered
   */
  protected int worldWidth = WORLD_WIDTH_EDEFAULT;

  /**
   * The default value of the '{@link #getWorldHeight() <em>World Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorldHeight()
   * @generated
   * @ordered
   */
  protected static final int WORLD_HEIGHT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWorldHeight() <em>World Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorldHeight()
   * @generated
   * @ordered
   */
  protected int worldHeight = WORLD_HEIGHT_EDEFAULT;

  /**
   * The default value of the '{@link #getTileWidth() <em>Tile Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTileWidth()
   * @generated
   * @ordered
   */
  protected static final int TILE_WIDTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTileWidth() <em>Tile Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTileWidth()
   * @generated
   * @ordered
   */
  protected int tileWidth = TILE_WIDTH_EDEFAULT;

  /**
   * The default value of the '{@link #getTileHeight() <em>Tile Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTileHeight()
   * @generated
   * @ordered
   */
  protected static final int TILE_HEIGHT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTileHeight() <em>Tile Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTileHeight()
   * @generated
   * @ordered
   */
  protected int tileHeight = TILE_HEIGHT_EDEFAULT;

  /**
   * The default value of the '{@link #isDebug() <em>Debug</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDebug()
   * @generated
   * @ordered
   */
  protected static final boolean DEBUG_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDebug() <em>Debug</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDebug()
   * @generated
   * @ordered
   */
  protected boolean debug = DEBUG_EDEFAULT;

  /**
   * The cached value of the '{@link #getLayers() <em>Layers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayers()
   * @generated
   * @ordered
   */
  protected EList<GameLayer> layers;

  /**
   * The cached value of the '{@link #getScreens() <em>Screens</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScreens()
   * @generated
   * @ordered
   */
  protected EList<GameScreen> screens;

  /**
   * The cached value of the '{@link #getRegions() <em>Regions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegions()
   * @generated
   * @ordered
   */
  protected EList<GameTextureRegion> regions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GameRootImpl()
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
    return GameDSLPackage.Literals.GAME_ROOT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__WIDTH, oldWidth, width));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__HEIGHT, oldHeight, height));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTitle(String newTitle)
  {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPpm()
  {
    return ppm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPpm(int newPpm)
  {
    int oldPpm = ppm;
    ppm = newPpm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__PPM, oldPpm, ppm));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public float getTimeStep()
  {
    return timeStep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeStep(float newTimeStep)
  {
    float oldTimeStep = timeStep;
    timeStep = newTimeStep;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__TIME_STEP, oldTimeStep, timeStep));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getVelocityIterations()
  {
    return velocityIterations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVelocityIterations(int newVelocityIterations)
  {
    int oldVelocityIterations = velocityIterations;
    velocityIterations = newVelocityIterations;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__VELOCITY_ITERATIONS, oldVelocityIterations, velocityIterations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPositionIterations()
  {
    return positionIterations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPositionIterations(int newPositionIterations)
  {
    int oldPositionIterations = positionIterations;
    positionIterations = newPositionIterations;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__POSITION_ITERATIONS, oldPositionIterations, positionIterations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWorldWidth()
  {
    return worldWidth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorldWidth(int newWorldWidth)
  {
    int oldWorldWidth = worldWidth;
    worldWidth = newWorldWidth;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__WORLD_WIDTH, oldWorldWidth, worldWidth));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWorldHeight()
  {
    return worldHeight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorldHeight(int newWorldHeight)
  {
    int oldWorldHeight = worldHeight;
    worldHeight = newWorldHeight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__WORLD_HEIGHT, oldWorldHeight, worldHeight));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTileWidth()
  {
    return tileWidth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTileWidth(int newTileWidth)
  {
    int oldTileWidth = tileWidth;
    tileWidth = newTileWidth;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__TILE_WIDTH, oldTileWidth, tileWidth));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTileHeight()
  {
    return tileHeight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTileHeight(int newTileHeight)
  {
    int oldTileHeight = tileHeight;
    tileHeight = newTileHeight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__TILE_HEIGHT, oldTileHeight, tileHeight));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDebug()
  {
    return debug;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDebug(boolean newDebug)
  {
    boolean oldDebug = debug;
    debug = newDebug;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GameDSLPackage.GAME_ROOT__DEBUG, oldDebug, debug));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameLayer> getLayers()
  {
    if (layers == null)
    {
      layers = new EObjectContainmentEList<GameLayer>(GameLayer.class, this, GameDSLPackage.GAME_ROOT__LAYERS);
    }
    return layers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameScreen> getScreens()
  {
    if (screens == null)
    {
      screens = new EObjectContainmentEList<GameScreen>(GameScreen.class, this, GameDSLPackage.GAME_ROOT__SCREENS);
    }
    return screens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameTextureRegion> getRegions()
  {
    if (regions == null)
    {
      regions = new EObjectContainmentEList<GameTextureRegion>(GameTextureRegion.class, this, GameDSLPackage.GAME_ROOT__REGIONS);
    }
    return regions;
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
      case GameDSLPackage.GAME_ROOT__LAYERS:
        return ((InternalEList<?>)getLayers()).basicRemove(otherEnd, msgs);
      case GameDSLPackage.GAME_ROOT__SCREENS:
        return ((InternalEList<?>)getScreens()).basicRemove(otherEnd, msgs);
      case GameDSLPackage.GAME_ROOT__REGIONS:
        return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
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
      case GameDSLPackage.GAME_ROOT__NAME:
        return getName();
      case GameDSLPackage.GAME_ROOT__WIDTH:
        return getWidth();
      case GameDSLPackage.GAME_ROOT__HEIGHT:
        return getHeight();
      case GameDSLPackage.GAME_ROOT__TITLE:
        return getTitle();
      case GameDSLPackage.GAME_ROOT__PPM:
        return getPpm();
      case GameDSLPackage.GAME_ROOT__TIME_STEP:
        return getTimeStep();
      case GameDSLPackage.GAME_ROOT__VELOCITY_ITERATIONS:
        return getVelocityIterations();
      case GameDSLPackage.GAME_ROOT__POSITION_ITERATIONS:
        return getPositionIterations();
      case GameDSLPackage.GAME_ROOT__WORLD_WIDTH:
        return getWorldWidth();
      case GameDSLPackage.GAME_ROOT__WORLD_HEIGHT:
        return getWorldHeight();
      case GameDSLPackage.GAME_ROOT__TILE_WIDTH:
        return getTileWidth();
      case GameDSLPackage.GAME_ROOT__TILE_HEIGHT:
        return getTileHeight();
      case GameDSLPackage.GAME_ROOT__DEBUG:
        return isDebug();
      case GameDSLPackage.GAME_ROOT__LAYERS:
        return getLayers();
      case GameDSLPackage.GAME_ROOT__SCREENS:
        return getScreens();
      case GameDSLPackage.GAME_ROOT__REGIONS:
        return getRegions();
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
      case GameDSLPackage.GAME_ROOT__NAME:
        setName((String)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__WIDTH:
        setWidth((Integer)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__HEIGHT:
        setHeight((Integer)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__TITLE:
        setTitle((String)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__PPM:
        setPpm((Integer)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__TIME_STEP:
        setTimeStep((Float)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__VELOCITY_ITERATIONS:
        setVelocityIterations((Integer)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__POSITION_ITERATIONS:
        setPositionIterations((Integer)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__WORLD_WIDTH:
        setWorldWidth((Integer)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__WORLD_HEIGHT:
        setWorldHeight((Integer)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__TILE_WIDTH:
        setTileWidth((Integer)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__TILE_HEIGHT:
        setTileHeight((Integer)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__DEBUG:
        setDebug((Boolean)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__LAYERS:
        getLayers().clear();
        getLayers().addAll((Collection<? extends GameLayer>)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__SCREENS:
        getScreens().clear();
        getScreens().addAll((Collection<? extends GameScreen>)newValue);
        return;
      case GameDSLPackage.GAME_ROOT__REGIONS:
        getRegions().clear();
        getRegions().addAll((Collection<? extends GameTextureRegion>)newValue);
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
      case GameDSLPackage.GAME_ROOT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__WIDTH:
        setWidth(WIDTH_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__HEIGHT:
        setHeight(HEIGHT_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__PPM:
        setPpm(PPM_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__TIME_STEP:
        setTimeStep(TIME_STEP_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__VELOCITY_ITERATIONS:
        setVelocityIterations(VELOCITY_ITERATIONS_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__POSITION_ITERATIONS:
        setPositionIterations(POSITION_ITERATIONS_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__WORLD_WIDTH:
        setWorldWidth(WORLD_WIDTH_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__WORLD_HEIGHT:
        setWorldHeight(WORLD_HEIGHT_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__TILE_WIDTH:
        setTileWidth(TILE_WIDTH_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__TILE_HEIGHT:
        setTileHeight(TILE_HEIGHT_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__DEBUG:
        setDebug(DEBUG_EDEFAULT);
        return;
      case GameDSLPackage.GAME_ROOT__LAYERS:
        getLayers().clear();
        return;
      case GameDSLPackage.GAME_ROOT__SCREENS:
        getScreens().clear();
        return;
      case GameDSLPackage.GAME_ROOT__REGIONS:
        getRegions().clear();
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
      case GameDSLPackage.GAME_ROOT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GameDSLPackage.GAME_ROOT__WIDTH:
        return width != WIDTH_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__HEIGHT:
        return height != HEIGHT_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case GameDSLPackage.GAME_ROOT__PPM:
        return ppm != PPM_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__TIME_STEP:
        return timeStep != TIME_STEP_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__VELOCITY_ITERATIONS:
        return velocityIterations != VELOCITY_ITERATIONS_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__POSITION_ITERATIONS:
        return positionIterations != POSITION_ITERATIONS_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__WORLD_WIDTH:
        return worldWidth != WORLD_WIDTH_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__WORLD_HEIGHT:
        return worldHeight != WORLD_HEIGHT_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__TILE_WIDTH:
        return tileWidth != TILE_WIDTH_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__TILE_HEIGHT:
        return tileHeight != TILE_HEIGHT_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__DEBUG:
        return debug != DEBUG_EDEFAULT;
      case GameDSLPackage.GAME_ROOT__LAYERS:
        return layers != null && !layers.isEmpty();
      case GameDSLPackage.GAME_ROOT__SCREENS:
        return screens != null && !screens.isEmpty();
      case GameDSLPackage.GAME_ROOT__REGIONS:
        return regions != null && !regions.isEmpty();
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
    result.append(", width: ");
    result.append(width);
    result.append(", height: ");
    result.append(height);
    result.append(", title: ");
    result.append(title);
    result.append(", ppm: ");
    result.append(ppm);
    result.append(", timeStep: ");
    result.append(timeStep);
    result.append(", velocityIterations: ");
    result.append(velocityIterations);
    result.append(", positionIterations: ");
    result.append(positionIterations);
    result.append(", worldWidth: ");
    result.append(worldWidth);
    result.append(", worldHeight: ");
    result.append(worldHeight);
    result.append(", tileWidth: ");
    result.append(tileWidth);
    result.append(", tileHeight: ");
    result.append(tileHeight);
    result.append(", debug: ");
    result.append(debug);
    result.append(')');
    return result.toString();
  }

} //GameRootImpl
