/*
 * generated by hypermodels.com with Xtext 2.13.0
 */
package com.hypermodel.games.engine.serializer;

import com.google.inject.Inject;
import com.hypermodel.games.engine.gameDSL.GameActor;
import com.hypermodel.games.engine.gameDSL.GameBodyProperty;
import com.hypermodel.games.engine.gameDSL.GameDSLPackage;
import com.hypermodel.games.engine.gameDSL.GameDisplay;
import com.hypermodel.games.engine.gameDSL.GameEvent;
import com.hypermodel.games.engine.gameDSL.GameLayer;
import com.hypermodel.games.engine.gameDSL.GameModel;
import com.hypermodel.games.engine.gameDSL.GamePackage;
import com.hypermodel.games.engine.gameDSL.GamePlatformConfig;
import com.hypermodel.games.engine.gameDSL.GamePlatformConfigAndroid;
import com.hypermodel.games.engine.gameDSL.GamePlatformConfigIOS;
import com.hypermodel.games.engine.gameDSL.GamePlatformConfigIOSMOE;
import com.hypermodel.games.engine.gameDSL.GameRoot;
import com.hypermodel.games.engine.gameDSL.GameRule;
import com.hypermodel.games.engine.gameDSL.GameScene;
import com.hypermodel.games.engine.gameDSL.GameScore;
import com.hypermodel.games.engine.gameDSL.GameScreen;
import com.hypermodel.games.engine.gameDSL.GameSprite;
import com.hypermodel.games.engine.gameDSL.GameSpriteAnimation;
import com.hypermodel.games.engine.gameDSL.GameSpriteStand;
import com.hypermodel.games.engine.gameDSL.GameSpriteState;
import com.hypermodel.games.engine.gameDSL.GameTextureRegion;
import com.hypermodel.games.engine.gameDSL.GameTile;
import com.hypermodel.games.engine.gameDSL.GameVector2d;
import com.hypermodel.games.engine.services.GameDSLGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.serializer.XbaseWithAnnotationsSemanticSequencer;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public abstract class AbstractGameDSLSemanticSequencer extends XbaseWithAnnotationsSemanticSequencer {

	@Inject
	private GameDSLGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == GameDSLPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case GameDSLPackage.GAME_ACTOR:
				sequence_GameActor(context, (GameActor) semanticObject); 
				return; 
			case GameDSLPackage.GAME_BODY_PROPERTY:
				sequence_GameBodyProperty(context, (GameBodyProperty) semanticObject); 
				return; 
			case GameDSLPackage.GAME_DISPLAY:
				sequence_GameDisplay(context, (GameDisplay) semanticObject); 
				return; 
			case GameDSLPackage.GAME_EVENT:
				sequence_GameEvent(context, (GameEvent) semanticObject); 
				return; 
			case GameDSLPackage.GAME_LAYER:
				sequence_GameLayer(context, (GameLayer) semanticObject); 
				return; 
			case GameDSLPackage.GAME_MODEL:
				sequence_GameModel(context, (GameModel) semanticObject); 
				return; 
			case GameDSLPackage.GAME_PACKAGE:
				sequence_GamePackage(context, (GamePackage) semanticObject); 
				return; 
			case GameDSLPackage.GAME_PLATFORM_CONFIG:
				sequence_GamePlatformConfig(context, (GamePlatformConfig) semanticObject); 
				return; 
			case GameDSLPackage.GAME_PLATFORM_CONFIG_ANDROID:
				sequence_GamePlatformConfigAndroid(context, (GamePlatformConfigAndroid) semanticObject); 
				return; 
			case GameDSLPackage.GAME_PLATFORM_CONFIG_IOS:
				sequence_GamePlatformConfigIOS(context, (GamePlatformConfigIOS) semanticObject); 
				return; 
			case GameDSLPackage.GAME_PLATFORM_CONFIG_IOSMOE:
				sequence_GamePlatformConfigIOSMOE(context, (GamePlatformConfigIOSMOE) semanticObject); 
				return; 
			case GameDSLPackage.GAME_ROOT:
				sequence_GameRoot(context, (GameRoot) semanticObject); 
				return; 
			case GameDSLPackage.GAME_RULE:
				sequence_GameRule(context, (GameRule) semanticObject); 
				return; 
			case GameDSLPackage.GAME_SCENE:
				sequence_GameScene(context, (GameScene) semanticObject); 
				return; 
			case GameDSLPackage.GAME_SCORE:
				sequence_GameScore(context, (GameScore) semanticObject); 
				return; 
			case GameDSLPackage.GAME_SCREEN:
				sequence_GameScreen(context, (GameScreen) semanticObject); 
				return; 
			case GameDSLPackage.GAME_SPRITE:
				sequence_GameSprite(context, (GameSprite) semanticObject); 
				return; 
			case GameDSLPackage.GAME_SPRITE_ANIMATION:
				sequence_GameSpriteAnimation(context, (GameSpriteAnimation) semanticObject); 
				return; 
			case GameDSLPackage.GAME_SPRITE_STAND:
				sequence_GameSpriteStand(context, (GameSpriteStand) semanticObject); 
				return; 
			case GameDSLPackage.GAME_SPRITE_STATE:
				sequence_GameSpriteState(context, (GameSpriteState) semanticObject); 
				return; 
			case GameDSLPackage.GAME_TEXTURE_REGION:
				sequence_GameTextureRegion(context, (GameTextureRegion) semanticObject); 
				return; 
			case GameDSLPackage.GAME_TILE:
				sequence_GameTile(context, (GameTile) semanticObject); 
				return; 
			case GameDSLPackage.GAME_VECTOR2D:
				sequence_GameVector2d(context, (GameVector2d) semanticObject); 
				return; 
			}
		else if (epackage == TypesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_FORMAL_PARAMETER:
				if (rule == grammarAccess.getFullJvmFormalParameterRule()) {
					sequence_FullJvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
				sequence_JvmParameterizedTypeReference(context, (JvmInnerTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_LOWER_BOUND:
				if (rule == grammarAccess.getJvmLowerBoundAndedRule()) {
					sequence_JvmLowerBoundAnded(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if (action == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()) {
					sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmTypeReferenceRule()
						|| action == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getJvmParameterizedTypeReferenceRule()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
				return; 
			case TypesPackage.JVM_UPPER_BOUND:
				if (rule == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
				return; 
			}
		else if (epackage == XAnnotationsPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XAnnotationsPackage.XANNOTATION:
				sequence_XAnnotation(context, (XAnnotation) semanticObject); 
				return; 
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_PAIR:
				sequence_XAnnotationElementValuePair(context, (XAnnotationElementValuePair) semanticObject); 
				return; 
			}
		else if (epackage == XbasePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XbasePackage.XASSIGNMENT:
				sequence_XAssignment_XMemberFeatureCall(context, (XAssignment) semanticObject); 
				return; 
			case XbasePackage.XBASIC_FOR_LOOP_EXPRESSION:
				sequence_XBasicForLoopExpression(context, (XBasicForLoopExpression) semanticObject); 
				return; 
			case XbasePackage.XBINARY_OPERATION:
				sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(context, (XBinaryOperation) semanticObject); 
				return; 
			case XbasePackage.XBLOCK_EXPRESSION:
				if (rule == grammarAccess.getXAnnotationElementValueOrCommaListRule()
						|| action == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0()
						|| rule == grammarAccess.getXAnnotationElementValueRule()
						|| rule == grammarAccess.getXAnnotationOrExpressionRule()
						|| rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXBlockExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XBlockExpression(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXExpressionInClosureRule()) {
					sequence_XExpressionInClosure(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBOOLEAN_LITERAL:
				sequence_XBooleanLiteral(context, (XBooleanLiteral) semanticObject); 
				return; 
			case XbasePackage.XCASE_PART:
				sequence_XCasePart(context, (XCasePart) semanticObject); 
				return; 
			case XbasePackage.XCASTED_EXPRESSION:
				sequence_XCastedExpression(context, (XCastedExpression) semanticObject); 
				return; 
			case XbasePackage.XCATCH_CLAUSE:
				sequence_XCatchClause(context, (XCatchClause) semanticObject); 
				return; 
			case XbasePackage.XCLOSURE:
				if (rule == grammarAccess.getXAnnotationElementValueOrCommaListRule()
						|| action == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0()
						|| rule == grammarAccess.getXAnnotationElementValueRule()
						|| rule == grammarAccess.getXAnnotationOrExpressionRule()
						|| rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXLiteralRule()
						|| rule == grammarAccess.getXClosureRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXShortClosureRule()) {
					sequence_XShortClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONSTRUCTOR_CALL:
				sequence_XConstructorCall(context, (XConstructorCall) semanticObject); 
				return; 
			case XbasePackage.XDO_WHILE_EXPRESSION:
				sequence_XDoWhileExpression(context, (XDoWhileExpression) semanticObject); 
				return; 
			case XbasePackage.XFEATURE_CALL:
				sequence_XFeatureCall(context, (XFeatureCall) semanticObject); 
				return; 
			case XbasePackage.XFOR_LOOP_EXPRESSION:
				sequence_XForLoopExpression(context, (XForLoopExpression) semanticObject); 
				return; 
			case XbasePackage.XIF_EXPRESSION:
				sequence_XIfExpression(context, (XIfExpression) semanticObject); 
				return; 
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
				sequence_XRelationalExpression(context, (XInstanceOfExpression) semanticObject); 
				return; 
			case XbasePackage.XLIST_LITERAL:
				if (rule == grammarAccess.getXAnnotationElementValueOrCommaListRule()) {
					sequence_XAnnotationElementValueOrCommaList_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXAnnotationElementValueRule()) {
					sequence_XAnnotationElementValue_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0()
						|| rule == grammarAccess.getXAnnotationOrExpressionRule()
						|| rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXLiteralRule()
						|| rule == grammarAccess.getXCollectionLiteralRule()
						|| rule == grammarAccess.getXListLiteralRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XMEMBER_FEATURE_CALL:
				sequence_XMemberFeatureCall(context, (XMemberFeatureCall) semanticObject); 
				return; 
			case XbasePackage.XNULL_LITERAL:
				sequence_XNullLiteral(context, (XNullLiteral) semanticObject); 
				return; 
			case XbasePackage.XNUMBER_LITERAL:
				sequence_XNumberLiteral(context, (XNumberLiteral) semanticObject); 
				return; 
			case XbasePackage.XPOSTFIX_OPERATION:
				sequence_XPostfixOperation(context, (XPostfixOperation) semanticObject); 
				return; 
			case XbasePackage.XRETURN_EXPRESSION:
				sequence_XReturnExpression(context, (XReturnExpression) semanticObject); 
				return; 
			case XbasePackage.XSET_LITERAL:
				sequence_XSetLiteral(context, (XSetLiteral) semanticObject); 
				return; 
			case XbasePackage.XSTRING_LITERAL:
				sequence_XStringLiteral(context, (XStringLiteral) semanticObject); 
				return; 
			case XbasePackage.XSWITCH_EXPRESSION:
				sequence_XSwitchExpression(context, (XSwitchExpression) semanticObject); 
				return; 
			case XbasePackage.XSYNCHRONIZED_EXPRESSION:
				sequence_XSynchronizedExpression(context, (XSynchronizedExpression) semanticObject); 
				return; 
			case XbasePackage.XTHROW_EXPRESSION:
				sequence_XThrowExpression(context, (XThrowExpression) semanticObject); 
				return; 
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION:
				sequence_XTryCatchFinallyExpression(context, (XTryCatchFinallyExpression) semanticObject); 
				return; 
			case XbasePackage.XTYPE_LITERAL:
				sequence_XTypeLiteral(context, (XTypeLiteral) semanticObject); 
				return; 
			case XbasePackage.XUNARY_OPERATION:
				sequence_XUnaryOperation(context, (XUnaryOperation) semanticObject); 
				return; 
			case XbasePackage.XVARIABLE_DECLARATION:
				sequence_XVariableDeclaration(context, (XVariableDeclaration) semanticObject); 
				return; 
			case XbasePackage.XWHILE_EXPRESSION:
				sequence_XWhileExpression(context, (XWhileExpression) semanticObject); 
				return; 
			}
		else if (epackage == XtypePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_DECLARATION:
				sequence_XImportDeclaration(context, (XImportDeclaration) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_SECTION:
				sequence_XImportSection(context, (XImportSection) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     GameActor returns GameActor
	 *
	 * Constraint:
	 *     (
	 *         (sprite=[GameSprite|ID] | tile=[GameTile|ID]) 
	 *         (typeA=GameContactType hasCollision?='collidesWith' typeB=GameContactType (beginContact=[GameEvent|ID] | endContact=[GameEvent|ID]))?
	 *     )
	 */
	protected void sequence_GameActor(ISerializationContext context, GameActor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameBodyProperty returns GameBodyProperty
	 *
	 * Constraint:
	 *     (name=ValidID (onUpdateTrue?='onUpdateIfTrue' body=XBlockExpression)? (onUpdateFalse?='onUpdateIfFalse' body=XBlockExpression)?)
	 */
	protected void sequence_GameBodyProperty(ISerializationContext context, GameBodyProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameDisplay returns GameDisplay
	 *
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         type=GameDisplayValueType 
	 *         format=STRING 
	 *         (hasInitial?='initialValue' (initialNumberValue=SignedNumber | initialIntValue=INT | initialStringValue=STRING))? 
	 *         (hasDelta?='deltaValue' deltaValue=SignedNumber timePeriod=UnsignedNumber)? 
	 *         hasAdder?='addValue'? 
	 *         hasSetter?='setValue'?
	 *     )
	 */
	protected void sequence_GameDisplay(ISerializationContext context, GameDisplay semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameEvent returns GameEvent
	 *
	 * Constraint:
	 *     (name=ValidID (params+=FullJvmFormalParameter params+=FullJvmFormalParameter?)? body=XBlockExpression)
	 */
	protected void sequence_GameEvent(ISerializationContext context, GameEvent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameLayer returns GameLayer
	 *
	 * Constraint:
	 *     (name=ValidID index=INT type=GameLayerType)
	 */
	protected void sequence_GameLayer(ISerializationContext context, GameLayer semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_LAYER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_LAYER__NAME));
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_LAYER__INDEX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_LAYER__INDEX));
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_LAYER__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_LAYER__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGameLayerAccess().getNameValidIDParserRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getGameLayerAccess().getIndexINTTerminalRuleCall_4_0(), semanticObject.getIndex());
		feeder.accept(grammarAccess.getGameLayerAccess().getTypeGameLayerTypeEnumRuleCall_6_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     GameModel returns GameModel
	 *
	 * Constraint:
	 *     ((importSection=XImportSection packages+=GamePackage+) | packages+=GamePackage+)?
	 */
	protected void sequence_GameModel(ISerializationContext context, GameModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamePackage returns GamePackage
	 *
	 * Constraint:
	 *     (name=QualifiedName config=GamePlatformConfig games+=GameRoot*)
	 */
	protected void sequence_GamePackage(ISerializationContext context, GamePackage semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamePlatformConfigAndroid returns GamePlatformConfigAndroid
	 *
	 * Constraint:
	 *     (
	 *         minAndroidVersion=INT 
	 *         targetAndroidVersion=INT 
	 *         apiLevel=INT 
	 *         orientation=GameScreenOrientation 
	 *         (appIcon=STRING | appName=STRING | appLabel=STRING)* 
	 *         useAccelerometer?='useAccelerometer'?
	 *     )
	 */
	protected void sequence_GamePlatformConfigAndroid(ISerializationContext context, GamePlatformConfigAndroid semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamePlatformConfigIOSMOE returns GamePlatformConfigIOSMOE
	 *
	 * Constraint:
	 *     useAccelerometer?='useAccelerometer'?
	 */
	protected void sequence_GamePlatformConfigIOSMOE(ISerializationContext context, GamePlatformConfigIOSMOE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamePlatformConfigIOS returns GamePlatformConfigIOS
	 *
	 * Constraint:
	 *     useAccelerometer?='useAccelerometer'?
	 */
	protected void sequence_GamePlatformConfigIOS(ISerializationContext context, GamePlatformConfigIOS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GamePlatformConfig returns GamePlatformConfig
	 *
	 * Constraint:
	 *     (android=GamePlatformConfigAndroid ios=GamePlatformConfigIOS iosmoe=GamePlatformConfigIOSMOE)
	 */
	protected void sequence_GamePlatformConfig(ISerializationContext context, GamePlatformConfig semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_PLATFORM_CONFIG__ANDROID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_PLATFORM_CONFIG__ANDROID));
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_PLATFORM_CONFIG__IOS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_PLATFORM_CONFIG__IOS));
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_PLATFORM_CONFIG__IOSMOE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_PLATFORM_CONFIG__IOSMOE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGamePlatformConfigAccess().getAndroidGamePlatformConfigAndroidParserRuleCall_3_0(), semanticObject.getAndroid());
		feeder.accept(grammarAccess.getGamePlatformConfigAccess().getIosGamePlatformConfigIOSParserRuleCall_4_0(), semanticObject.getIos());
		feeder.accept(grammarAccess.getGamePlatformConfigAccess().getIosmoeGamePlatformConfigIOSMOEParserRuleCall_5_0(), semanticObject.getIosmoe());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     GameRoot returns GameRoot
	 *
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         width=INT 
	 *         height=INT 
	 *         title=STRING 
	 *         ppm=INT 
	 *         tileWidth=INT 
	 *         tileHeight=INT 
	 *         (layers+=GameLayer | scenes+=GameScene | screens+=GameScreen | regions+=GameTextureRegion)*
	 *     )
	 */
	protected void sequence_GameRoot(ISerializationContext context, GameRoot semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameRule returns GameRule
	 *
	 * Constraint:
	 *     (name=ValidID (params+=FullJvmFormalParameter params+=FullJvmFormalParameter?)? body=XBlockExpression)
	 */
	protected void sequence_GameRule(ISerializationContext context, GameRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameScene returns GameScene
	 *
	 * Constraint:
	 *     (name=ValidID (hasScore?='isScore' score=GameScore)?)
	 */
	protected void sequence_GameScene(ISerializationContext context, GameScene semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameScore returns GameScore
	 *
	 * Constraint:
	 *     (topPadding=INT displays+=GameDisplay*)
	 */
	protected void sequence_GameScore(ISerializationContext context, GameScore semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameScreen returns GameScreen
	 *
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         atlasName=STRING 
	 *         map=STRING 
	 *         scene=[GameScene|ID] 
	 *         tiles+=GameTile* 
	 *         sprites+=GameSprite*
	 *     )
	 */
	protected void sequence_GameScreen(ISerializationContext context, GameScreen semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameSpriteAnimation returns GameSpriteAnimation
	 *
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         duration=UnsignedNumber 
	 *         (hasFrames?='frames' frames=INT offset=INT region=[GameTextureRegion|ID])? 
	 *         (hasStands?='stands' stands+=GameSpriteStand*)?
	 *     )
	 */
	protected void sequence_GameSpriteAnimation(ISerializationContext context, GameSpriteAnimation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameSpriteStand returns GameSpriteStand
	 *
	 * Constraint:
	 *     (name=ValidID offset=INT region=[GameTextureRegion|ID])
	 */
	protected void sequence_GameSpriteStand(ISerializationContext context, GameSpriteStand semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_SPRITE_STAND__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_SPRITE_STAND__NAME));
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_SPRITE_STAND__OFFSET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_SPRITE_STAND__OFFSET));
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_SPRITE_STAND__REGION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_SPRITE_STAND__REGION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGameSpriteStandAccess().getNameValidIDParserRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getGameSpriteStandAccess().getOffsetINTTerminalRuleCall_4_0(), semanticObject.getOffset());
		feeder.accept(grammarAccess.getGameSpriteStandAccess().getRegionGameTextureRegionIDTerminalRuleCall_6_0_1(), semanticObject.eGet(GameDSLPackage.Literals.GAME_SPRITE_STAND__REGION, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     GameSpriteState returns GameSpriteState
	 *
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         rule=GameRule 
	 *         ((animation=GameSpriteAnimation (ifFinished?='ifFinished' setFalse=[GameBodyProperty|ID])?) | stand=GameSpriteStand)?
	 *     )
	 */
	protected void sequence_GameSpriteState(ISerializationContext context, GameSpriteState semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameSprite returns GameSprite
	 *
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         id=INT 
	 *         radius=INT 
	 *         (
	 *             (actors+=GameActor | properties+=GameBodyProperty | events+=GameEvent)? 
	 *             (hasVelocity?='velocity' velocity=GameVector2d)? 
	 *             (hasLayer?='layer' layer=[GameLayer|ID])? 
	 *             (hasStartPosition?='startPosition' startPosition=GameVector2d)? 
	 *             (states+=GameSpriteState* initialState=[GameSpriteState|ID])? 
	 *             (hasSensor?='sensor' vectors2d+=GameVector2d* sensorID=INT)?
	 *         )+
	 *     )
	 */
	protected void sequence_GameSprite(ISerializationContext context, GameSprite semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameTextureRegion returns GameTextureRegion
	 *
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         region=STRING 
	 *         width=INT 
	 *         height=INT 
	 *         offsetX=SignedNumber? 
	 *         offsetY=SignedNumber? 
	 *         flipX?='flipX'? 
	 *         flipY?='flipY'?
	 *     )
	 */
	protected void sequence_GameTextureRegion(ISerializationContext context, GameTextureRegion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameTile returns GameTile
	 *
	 * Constraint:
	 *     (name=ValidID id=INT (hasObjectLayer?='objectLayer' objectLayer=[GameLayer|ID])? (hasTileLayer?='tileLayer' tileLayer=[GameLayer|ID])?)
	 */
	protected void sequence_GameTile(ISerializationContext context, GameTile semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GameVector2d returns GameVector2d
	 *
	 * Constraint:
	 *     (x=SignedNumber y=SignedNumber)
	 */
	protected void sequence_GameVector2d(ISerializationContext context, GameVector2d semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_VECTOR2D__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_VECTOR2D__X));
			if (transientValues.isValueTransient(semanticObject, GameDSLPackage.Literals.GAME_VECTOR2D__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GameDSLPackage.Literals.GAME_VECTOR2D__Y));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGameVector2dAccess().getXSignedNumberParserRuleCall_2_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getGameVector2dAccess().getYSignedNumberParserRuleCall_4_0(), semanticObject.getY());
		feeder.finish();
	}
	
	
}
