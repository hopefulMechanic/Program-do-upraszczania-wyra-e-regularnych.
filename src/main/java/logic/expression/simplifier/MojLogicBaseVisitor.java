package logic.expression.simplifier;

import java.util.Map;

class MojLogicBaseVisitor extends LogicBaseVisitor<Object> {

    private final Map<String, Object> zmienne;

    public MojLogicBaseVisitor(Map<String, Object> zmienne) {
        this.zmienne = zmienne;
    }

    @Override
    public Object visitParse(LogicParser.ParseContext ctx) {
        return super.visit(ctx.expression());
    }

    @Override
    public Object visitIdentifierExpression(LogicParser.IdentifierExpressionContext ctx) {
        return zmienne.get(ctx.IDENTIFIER().getText());
    }

    @Override
    public Object visitNotExpression(LogicParser.NotExpressionContext ctx) {
        return !((Boolean)this.visit(ctx.expression()));
    }

    @Override
    public Object visitParenExpression(LogicParser.ParenExpressionContext ctx) {
        return super.visit(ctx.expression());
    }

    @Override
    public Object visitBinaryExpression(LogicParser.BinaryExpressionContext ctx) {
        if (ctx.op.AND() != null)
        {
            return visitIRzutujNaBoolean(ctx.left) && visitIRzutujNaBoolean(ctx.right);
        }
        else if (ctx.op.OR() != null)
        {
            return visitIRzutujNaBoolean(ctx.left) || visitIRzutujNaBoolean(ctx.right);
        }
        else if (ctx.op.XOR() != null)
        {
            return visitIRzutujNaBoolean(ctx.left) ^ visitIRzutujNaBoolean(ctx.right);
        }
        else if (ctx.op.XNOR() != null)
        {
            return visitIRzutujNaBoolean(ctx.left) == visitIRzutujNaBoolean(ctx.right);
        }
        else if (ctx.op.NAND() != null)
        {
            return !(visitIRzutujNaBoolean(ctx.left) && visitIRzutujNaBoolean(ctx.right));
        }
        else if (ctx.op.NOR() != null)
        {
            return !(visitIRzutujNaBoolean(ctx.left) || visitIRzutujNaBoolean(ctx.right));
        }
        throw new RuntimeException("\nBlad !!!: " + ctx.op.getText());
    }

    @Override
    public Object visitPosExpression(LogicParser.PosExpressionContext ctx) {
        return (Boolean) visit(ctx.left) && (Boolean) visit(ctx.right);
    }

    @Override
    public Object visitBoolExpression(LogicParser.BoolExpressionContext ctx) {
        return Boolean.valueOf(ctx.getText());
    }

    private boolean visitIRzutujNaBoolean(LogicParser.ExpressionContext ctx) {
        return (boolean)visit(ctx);
    }
}
