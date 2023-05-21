// Generated from /Users/miguelseixas/Desktop/Calc/Calc/grammar/ExamSpecification.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExamSpecificationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExamSpecificationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#exam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExam(ExamSpecificationParser.ExamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(ExamSpecificationParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#feedbackType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedbackType(ExamSpecificationParser.FeedbackTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#gradeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGradeType(ExamSpecificationParser.GradeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(ExamSpecificationParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(ExamSpecificationParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(ExamSpecificationParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#matchingQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingQuestion(ExamSpecificationParser.MatchingQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#matchPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchPair(ExamSpecificationParser.MatchPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(ExamSpecificationParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(ExamSpecificationParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswerQuestion(ExamSpecificationParser.ShortAnswerQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#possibleAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossibleAnswer(ExamSpecificationParser.PossibleAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#numericalQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalQuestion(ExamSpecificationParser.NumericalQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectMissingWordsQuestion(ExamSpecificationParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#missingWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingWord(ExamSpecificationParser.MissingWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseQuestion(ExamSpecificationParser.TrueFalseQuestionContext ctx);
}