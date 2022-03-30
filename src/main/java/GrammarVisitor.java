// Generated from C:/Users/Александр/IdeaProjects/Lab_1/src/main/java\Grammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#declare_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_func(GrammarParser.Declare_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#list_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_operator(GrammarParser.List_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(GrammarParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#declare_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_var(GrammarParser.Declare_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#assign_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_op(GrammarParser.Assign_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#call_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_func(GrammarParser.Call_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#if_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_op(GrammarParser.If_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#for_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_op(GrammarParser.For_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(GrammarParser.Arg_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(GrammarParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#delete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete(GrammarParser.DeleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#get}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGet(GrammarParser.GetContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#size}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize(GrammarParser.SizeContext ctx);
}