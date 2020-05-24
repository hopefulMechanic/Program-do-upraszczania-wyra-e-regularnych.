// Generated from Logic.g4 by ANTLR 4.7.2
package logic.expression.simplifier;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogicParser}.
 */
public interface LogicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LogicParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(LogicParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(LogicParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(LogicParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(LogicParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(LogicParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(LogicParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(LogicParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(LogicParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(LogicParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(LogicParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(LogicParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(LogicParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code posExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPosExpression(LogicParser.PosExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code posExpression}
	 * labeled alternative in {@link LogicParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPosExpression(LogicParser.PosExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicParser#binary}.
	 * @param ctx the parse tree
	 */
	void enterBinary(LogicParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicParser#binary}.
	 * @param ctx the parse tree
	 */
	void exitBinary(LogicParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(LogicParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(LogicParser.BoolContext ctx);
}