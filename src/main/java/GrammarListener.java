// Generated from C:/Users/Александр/IdeaProjects/Lab_1/src/main/java\Grammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declare_func}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_func(GrammarParser.Declare_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declare_func}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_func(GrammarParser.Declare_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#list_operator}.
	 * @param ctx the parse tree
	 */
	void enterList_operator(GrammarParser.List_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#list_operator}.
	 * @param ctx the parse tree
	 */
	void exitList_operator(GrammarParser.List_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(GrammarParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(GrammarParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declare_var}.
	 * @param ctx the parse tree
	 */
	void enterDeclare_var(GrammarParser.Declare_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declare_var}.
	 * @param ctx the parse tree
	 */
	void exitDeclare_var(GrammarParser.Declare_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void enterAssign_op(GrammarParser.Assign_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void exitAssign_op(GrammarParser.Assign_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#call_func}.
	 * @param ctx the parse tree
	 */
	void enterCall_func(GrammarParser.Call_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#call_func}.
	 * @param ctx the parse tree
	 */
	void exitCall_func(GrammarParser.Call_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#if_op}.
	 * @param ctx the parse tree
	 */
	void enterIf_op(GrammarParser.If_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#if_op}.
	 * @param ctx the parse tree
	 */
	void exitIf_op(GrammarParser.If_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#for_op}.
	 * @param ctx the parse tree
	 */
	void enterFor_op(GrammarParser.For_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#for_op}.
	 * @param ctx the parse tree
	 */
	void exitFor_op(GrammarParser.For_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(GrammarParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(GrammarParser.Arg_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(GrammarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(GrammarParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(GrammarParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#delete}.
	 * @param ctx the parse tree
	 */
	void enterDelete(GrammarParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#delete}.
	 * @param ctx the parse tree
	 */
	void exitDelete(GrammarParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#get}.
	 * @param ctx the parse tree
	 */
	void enterGet(GrammarParser.GetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#get}.
	 * @param ctx the parse tree
	 */
	void exitGet(GrammarParser.GetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#size}.
	 * @param ctx the parse tree
	 */
	void enterSize(GrammarParser.SizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#size}.
	 * @param ctx the parse tree
	 */
	void exitSize(GrammarParser.SizeContext ctx);
}