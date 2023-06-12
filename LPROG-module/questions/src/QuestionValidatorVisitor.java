// Generated from /Users/patricia/Documents/ISEP/2ºano/2ºsemestre/PI/sem4pi-22-23-49/LPROG-module/questions/grammar/QuestionValidator.g4 by ANTLR 4.12.0
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
	 * Visit a parse tree produced by {@link QuestionValidatorParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuestionValidatorParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#matchingQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingQuestion(QuestionValidatorParser.MatchingQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#listOne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListOne(QuestionValidatorParser.ListOneContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#listTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListTwo(QuestionValidatorParser.ListTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#questionText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionText(QuestionValidatorParser.QuestionTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(QuestionValidatorParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerQuestion(QuestionValidatorParser.ShortAnswerQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#possibleAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleAnswer(QuestionValidatorParser.PossibleAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#numericalQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalQuestion(QuestionValidatorParser.NumericalQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#acceptedError}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceptedError(QuestionValidatorParser.AcceptedErrorContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectMissingWordsQuestion(QuestionValidatorParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#missingWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingWord(QuestionValidatorParser.MissingWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#wordGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWordGroup(QuestionValidatorParser.WordGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(QuestionValidatorParser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseQuestion(QuestionValidatorParser.TrueFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(QuestionValidatorParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptions(QuestionValidatorParser.OptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrade(QuestionValidatorParser.GradeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(QuestionValidatorParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionValidatorParser#penalty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenalty(QuestionValidatorParser.PenaltyContext ctx);
}