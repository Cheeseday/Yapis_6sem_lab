import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Visitor extends GrammarBaseVisitor<String> {
    private final List<String> errors = new ArrayList<>();
    private final List<String> globalSetVars = new ArrayList<>();
    private final List<String> globalElementVars = new ArrayList<>();

    @Override
    public String visitProgram(GrammarParser.ProgramContext ctx) {
        Variable.getInstance().incrementStack();
        String buffer = Template.PROGRAM;

        String buffer1 = "";
        for (GrammarParser.Declare_funcContext context : ctx.declare_func()) {
            buffer1 = visitDeclare_func(context);
        }

        buffer += "{";

        for (GrammarParser.OperatorContext context : ctx.operator()) {
            buffer = visitOperator(context);
        }
        buffer += "}";
        buffer += buffer1;
        buffer += "}";

        String error = "";
        if (!errors.isEmpty()) {
            for (String string : errors) {
                error = string + "\n";
            }
            JOptionPane.showMessageDialog(null, error);
            throw new RuntimeException(error);
        }
        return buffer;
    }

    @Override
    public String visitOperator(GrammarParser.OperatorContext ctx) {
        if (ctx.print() != null) {
            return visitPrint(ctx.print());
        }

        if (ctx.call_func() != null) {
            return visitCall_func(ctx.call_func());
        }

        if (ctx.for_op() != null) {
            return visitFor_op(ctx.for_op());
        }

        if (ctx.declare_var() != null) {
            return visitDeclare_var(ctx.declare_var());
        }

        if (ctx.assign_op() != null) {
            return visitAssign_op(ctx.assign_op());
        }

        if (ctx.if_op() != null) {
            return visitIf_op(ctx.if_op());
        }

        if (ctx.add() != null) {
            return visitAdd(ctx.add());
        }

        if (ctx.delete() != null) {
            return visitDelete(ctx.delete());
        }

        if (ctx.get() != null) {
            return visitGet(ctx.get());
        }

        if (ctx.list_operator() != null) {
            return visitList_operator(ctx.list_operator());
        }

        return "";
    }

    @Override
    public String visitType(GrammarParser.TypeContext ctx) {
        if (ctx.TYPE_ELEMENT() != null) {
            return "Element";
        }

        if (ctx.TYPE_SET() != null) {
            return "Set";
        }

        if (ctx.TYPE_VOID() != null) {
            return "Void";
        }
        return "";
    }

    @Override
    public String visitDeclare_func(GrammarParser.Declare_funcContext ctx) {
        String functionName = ctx.NAME().get(0).getText();
        if (Variable.getInstance().containsFunction(functionName)) {
            errors.add("Function " + functionName + " already exists - (Declare_func)");
        }

        Variable.getInstance().addFunction(functionName);

        String buffer = "functionType " + functionName + "(";

        for (int index = 1; index < ctx.NAME().size(); index++) {
            String type = visitType(ctx.type(index - 1));
            String name = ctx.NAME().get(index).getText();

            if (type.equals("Set")) {
                globalSetVars.add(name);
            } else {
                globalElementVars.add(name);
            }

            buffer = type + " " + name;
        }

        buffer += ") throws Exception";
        buffer += "{";
        buffer += visitList_operator((GrammarParser.List_operatorContext) ctx.list_operator());
        buffer += "}";
        return buffer;
    }

    @Override
    public String visitCall_func(GrammarParser.Call_funcContext ctx) {
        String functionName = ctx.NAME().getText();
        if (!Variable.getInstance().containsFunction(functionName)) {
            errors.add("Function " + functionName + " doesn't exists - (Call_func)");
        }
        String buffer = functionName + "(";

        buffer += visitArg_list(ctx.arg_list());
        buffer += ")";
        return buffer;
    }

    @Override
    public String visitFor_op(GrammarParser.For_opContext ctx) {
        String name1 = ctx.NAME().get(0).getText();
        String name2 = ctx.NAME().get(1).getText();

        if (!Variable.getInstance().containsSet(name1)) {
            errors.add("Variable set " + name1 + " doesn't exist - (for_op)");
        }

        if (Variable.getInstance().containsElement(name2)) {
            errors.add("Variable element" + name2 + " already exists - (for_op)");
        }

        globalElementVars.add(name2);

        String buffer = "for (Element " + name2 + ":" + name1 + ".getSet()" + ")";
        buffer += visitOperator(ctx.operator());

        return buffer;
    }

    @Override
    public String visitPrint(GrammarParser.PrintContext ctx) {
        if (ctx.STRING() != null) {
            return "System.out.println(" + ctx.STRING().getText() + ");";
        }

        if (ctx.NAME() != null) {
            String s = ctx.NAME().getText();
            if (!(Variable.getInstance().containsElement(s) | Variable.getInstance().containsSet(s))) {
                errors.add("Variable " + s + " doesn't exists - (Print)");
            }
            return "System.out.println(" + s + ");";
        }

        if (ctx.size() != null) {
            return "System.out.println(" + visitSize(ctx.size()) + ");";
        }

        return "";
    }

    @Override
    public String visitIf_op(GrammarParser.If_opContext ctx) {
        String buffer = "";
        buffer += "if(" + visitExpr(ctx.expr()) + ")" + visitOperator((GrammarParser.OperatorContext) ctx.operator());
        if (ctx.operator() != null) {
            buffer += "else";
            buffer += visitOperator((GrammarParser.OperatorContext) ctx.operator());
        }
        return buffer;
    }

    @Override
    public String visitExpr(GrammarParser.ExprContext ctx){
        if (ctx.get() != null) {
            return visitPrint(ctx.get());
        }

        if (ctx.call_func() != null) {
            return visitCall_func(ctx.call_func());
        }
        String name = ctx.NAME().getText();
        String buffer = "";

        if (ctx.NAME() != null) {
            if (Variable.getInstance().containsElement(name)) {
                errors.add("Variable element " + name + " already exists - (expr)");
            }
            Variable.getInstance().addElement(name);
            buffer += "Element " + name + "=";
        } else {
                if (!Variable.getInstance().containsSet(name)) {
                    errors.add("Variable set " + name + " doesn't exists - (expr)");
                }
                buffer += name + "=";

                if (Variable.getInstance().containsSet(name)) {
                    errors.add("Variable set " + name + " already exists - (expr)");
                }
                else {
                    Variable.getInstance().addSet(name);
                    buffer += "Set " + name + "=";

                    if (!Variable.getInstance().containsElement(name)) {
                        errors.add("Variable element " + name + " doesn't exists - (expr)");
                    }
                    buffer += name + "=";
                }
        }

        if (ctx.STRING() != null) {
            buffer += "new Element(" + ctx.STRING().getText() + ");";
        } else if (ctx.get() != null) {
            buffer += "new Element(" + ");";
        } else {
            String name2 = ctx.NAME().getText();
            if (!Variable.getInstance().containsElement(name2)) {
                errors.add("Variable element " + name2 + " doesn't exists - (expr)");
            }
            buffer += "new Element(" + name2 + ".toString());";
        }
        return buffer;
    }

    @Override public String visitArg_list(GrammarParser.Arg_listContext ctx){
        String buffer = "";
        if (ctx.expr() != null){
            return visitExpr((GrammarParser.ExprContext) ctx.expr());
        }
        buffer += ',';
        if (ctx.expr() != null){
            return visitExpr((GrammarParser.ExprContext) ctx.expr());
        }
        return buffer;
    }

    @Override public String visitAssign_op(GrammarParser.Assign_opContext ctx){
        String name = ctx.NAME().getText();
        String buffer = "";

        if (ctx.NAME() != null) {
            if (Variable.getInstance().containsElement(name)) {
                errors.add("Variable element " + name + " already exists - (Assign_op)");
            }
            Variable.getInstance().addElement(name);
            buffer += "Element " + name + "=";
        } else {
            if (!Variable.getInstance().containsElement(name)) {
                errors.add("Variable element " + name + " doesn't exists - (Assign_op)");
            }
            buffer += name + "=";
        }
        return buffer;
    }

    @Override public String visitDeclare_var(GrammarParser.Declare_varContext ctx){
        String type = visitType(ctx.type());
        String name = ctx.NAME().getText();
        String buffer = "";
        if(type.equals("Element")){
            if (ctx.NAME() != null) {
                if (Variable.getInstance().containsElement(name)) {
                    errors.add("Variable element " + name + " already exists - (Declare_var)");
                }
                Variable.getInstance().addElement(name);
                buffer += "Element " + name + "=";
            } else {
                if (!Variable.getInstance().containsElement(name)) {
                    errors.add("Variable element " + name + " doesn't exists - (Declare_var)");
                }
                buffer += name + "=";
            }
        }
        if(type.equals("Set")){
            if (ctx.NAME() != null) {
                if (Variable.getInstance().containsElement(name)) {
                    errors.add("Variable set " + name + " already exists - (Declare_var)");
                }
                Variable.getInstance().addElement(name);
                buffer += "Set " + name + "=";
            } else {
                if (!Variable.getInstance().containsElement(name)) {
                    errors.add("Variable set " + name + " doesn't exists - (Declare_var)");
                }
                buffer += name + "=";
            }
        }
        return buffer;
    }

    @Override public String visitList_operator(GrammarParser.List_operatorContext ctx){

            return visitOperator((GrammarParser.OperatorContext) ctx.operator());
    }

    @Override
    public String visitAdd(GrammarParser.AddContext ctx) {
        String name1 = ctx.NAME().get(0).getText();
        String name2 = ctx.NAME().get(1).getText();

        if (!Variable.getInstance().containsSet(name1)) {
            errors.add("Variable set " + name1 + " doesn't exists - (Add)");
        }

        if (!Variable.getInstance().containsElement(name2)) {
            errors.add("Variable element " + name2 + " doesn't exists - (Add)");
        }

        return name1 + ".add(" + name2 + ");";
    }

    @Override
    public String visitGet(GrammarParser.GetContext ctx) {
        String name1 = ctx.NAME().getText();

        if (!Variable.getInstance().containsSet(name1)) {
            errors.add("Variable set " + name1 + " doesn't exists - (Get)");
        }

        return name1 + ".get(" + ctx.NUMBER().getText() + ")";
    }

    @Override
    public String visitDelete(GrammarParser.DeleteContext ctx) {
        String name1 = ctx.NAME().get(0).getText();

        if (!Variable.getInstance().containsSet(name1)) {
            errors.add("Variable set " + name1 + " doesn't exists - (Delete)");
        }

        String buffer = "";
        if (ctx.NUMBER() != null) {
            buffer += name1 + ".delete(" + ctx.NUMBER().getText() + ");";
        } else {
            String name2 = ctx.NAME().get(1).getText();

            if (!Variable.getInstance().containsElement(name2)) {
                errors.add("Variable element " + name2 + " doesn't exists - (Delete)");
            }

            buffer += name1 + ".delete(" + name2 + ");";
        }

        return buffer;
    }

    @Override
    public String visitSize(GrammarParser.SizeContext ctx) {
        String name1 = ctx.NAME().getText();

        if (!Variable.getInstance().containsSet(name1)) {
            errors.add("Variable set " + name1 + " doesn't exists - (Size)");
        }

        return name1 + ".getSet().size()";
    }

}