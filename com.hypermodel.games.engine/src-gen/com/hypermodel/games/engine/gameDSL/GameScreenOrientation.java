/**
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.gameDSL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Game Screen Orientation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.hypermodel.games.engine.gameDSL.GameDSLPackage#getGameScreenOrientation()
 * @model
 * @generated
 */
public enum GameScreenOrientation implements Enumerator
{
  /**
   * The '<em><b>Landscape</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LANDSCAPE_VALUE
   * @generated
   * @ordered
   */
  LANDSCAPE(0, "landscape", "landscape"),

  /**
   * The '<em><b>Portrait</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PORTRAIT_VALUE
   * @generated
   * @ordered
   */
  PORTRAIT(1, "portrait", "portrait");

  /**
   * The '<em><b>Landscape</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Landscape</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LANDSCAPE
   * @model name="landscape"
   * @generated
   * @ordered
   */
  public static final int LANDSCAPE_VALUE = 0;

  /**
   * The '<em><b>Portrait</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Portrait</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PORTRAIT
   * @model name="portrait"
   * @generated
   * @ordered
   */
  public static final int PORTRAIT_VALUE = 1;

  /**
   * An array of all the '<em><b>Game Screen Orientation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final GameScreenOrientation[] VALUES_ARRAY =
    new GameScreenOrientation[]
    {
      LANDSCAPE,
      PORTRAIT,
    };

  /**
   * A public read-only list of all the '<em><b>Game Screen Orientation</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<GameScreenOrientation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Game Screen Orientation</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static GameScreenOrientation get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      GameScreenOrientation result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Game Screen Orientation</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static GameScreenOrientation getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      GameScreenOrientation result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Game Screen Orientation</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static GameScreenOrientation get(int value)
  {
    switch (value)
    {
      case LANDSCAPE_VALUE: return LANDSCAPE;
      case PORTRAIT_VALUE: return PORTRAIT;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private GameScreenOrientation(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
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
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //GameScreenOrientation
