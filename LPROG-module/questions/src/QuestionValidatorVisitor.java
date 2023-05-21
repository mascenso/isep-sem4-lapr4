// Generated from /Users/patricia/Documents/ISEP/2ºano/2ºsemestre/LPROG/questions/grammar/QuestionValidator.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionValidatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionValidatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(QuestionValidatorParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shortAnswerQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerQuestion(QuestionValidatorParser.ShortAnswerQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multichoiceQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultichoiceQuestion(QuestionValidatorParser.MultichoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code matchingQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingQuestion(QuestionValidatorParser.MatchingQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueFalseQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseQuestion(QuestionValidatorParser.TrueFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectMissingWordsQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectMissingWordsQuestion(QuestionValidatorParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericalQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalQuestion(QuestionValidatorParser.NumericalQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(QuestionValidatorParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#shortAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswer(QuestionValidatorParser.ShortAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#multichoice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultichoice(QuestionValidatorParser.MultichoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#matching}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching(QuestionValidatorParser.MatchingContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#trueFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalse(QuestionValidatorParser.TrueFalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#selectMissingWords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectMissingWords(QuestionValidatorParser.SelectMissingWordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#numerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical(QuestionValidatorParser.NumericalContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(QuestionValidatorParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#subQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubQuestion(QuestionValidatorParser.SubQuestionContext ctx);
}