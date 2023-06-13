// Generated from /Users/miguelcardoso/Library/CloudStorage/OneDrive-InstitutoSuperiordeEngenhariadoPorto/Licenciatura Engenharia Informatica/2 ano/2 semestre/LAPR4/projeto-v2/sem4pi-22-23-49/LPROG-module/exams/grammar/QuestionSpecification.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionSpecificationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionSpecificationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuestionSpecificationParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#matchingQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingQuestion(QuestionSpecificationParser.MatchingQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#listOne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListOne(QuestionSpecificationParser.ListOneContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#listTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListTwo(QuestionSpecificationParser.ListTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#questionText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionText(QuestionSpecificationParser.QuestionTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(QuestionSpecificationParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerQuestion(QuestionSpecificationParser.ShortAnswerQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#possibleAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleAnswer(QuestionSpecificationParser.PossibleAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#numericalQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalQuestion(QuestionSpecificationParser.NumericalQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#acceptedError}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceptedError(QuestionSpecificationParser.AcceptedErrorContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectMissingWordsQuestion(QuestionSpecificationParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#missingWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingWord(QuestionSpecificationParser.MissingWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#wordGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWordGroup(QuestionSpecificationParser.WordGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(QuestionSpecificationParser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseQuestion(QuestionSpecificationParser.TrueFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(QuestionSpecificationParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptions(QuestionSpecificationParser.OptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrade(QuestionSpecificationParser.GradeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(QuestionSpecificationParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionSpecificationParser#penalty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenalty(QuestionSpecificationParser.PenaltyContext ctx);
}