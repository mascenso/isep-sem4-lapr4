// Generated from /Users/miguelcardoso/Library/CloudStorage/OneDrive-InstitutoSuperiordeEngenhariadoPorto/Licenciatura Engenharia Informatica/2 ano/2 semestre/LAPR4/projeto-v2/sem4pi-22-23-49/LPROG-module/exams/grammar/ExamSpecification.g4 by ANTLR 4.12.0
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
	 * Visit a parse tree produced by {@link ExamSpecificationParser#listOne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListOne(ExamSpecificationParser.ListOneContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#listTwo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListTwo(ExamSpecificationParser.ListTwoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#questionText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionText(ExamSpecificationParser.QuestionTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(ExamSpecificationParser.MultipleChoiceQuestionContext ctx);
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
	 * Visit a parse tree produced by {@link ExamSpecificationParser#acceptedError}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceptedError(ExamSpecificationParser.AcceptedErrorContext ctx);
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
	 * Visit a parse tree produced by {@link ExamSpecificationParser#wordGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWordGroup(ExamSpecificationParser.WordGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(ExamSpecificationParser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseQuestion(ExamSpecificationParser.TrueFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(ExamSpecificationParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptions(ExamSpecificationParser.OptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrade(ExamSpecificationParser.GradeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(ExamSpecificationParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamSpecificationParser#penalty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenalty(ExamSpecificationParser.PenaltyContext ctx);
}