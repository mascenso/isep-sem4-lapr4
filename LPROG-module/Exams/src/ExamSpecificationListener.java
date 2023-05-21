// Generated from /Users/miguelseixas/Desktop/Calc/Calc/grammar/ExamSpecification.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExamSpecificationParser}.
 */
public interface ExamSpecificationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#exam}.
	 * @param ctx the parse tree
	 */
	void enterExam(ExamSpecificationParser.ExamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#exam}.
	 * @param ctx the parse tree
	 */
	void exitExam(ExamSpecificationParser.ExamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(ExamSpecificationParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(ExamSpecificationParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#feedbackType}.
	 * @param ctx the parse tree
	 */
	void enterFeedbackType(ExamSpecificationParser.FeedbackTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#feedbackType}.
	 * @param ctx the parse tree
	 */
	void exitFeedbackType(ExamSpecificationParser.FeedbackTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#gradeType}.
	 * @param ctx the parse tree
	 */
	void enterGradeType(ExamSpecificationParser.GradeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#gradeType}.
	 * @param ctx the parse tree
	 */
	void exitGradeType(ExamSpecificationParser.GradeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(ExamSpecificationParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(ExamSpecificationParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(ExamSpecificationParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(ExamSpecificationParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(ExamSpecificationParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(ExamSpecificationParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#matchingQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMatchingQuestion(ExamSpecificationParser.MatchingQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#matchingQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMatchingQuestion(ExamSpecificationParser.MatchingQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#matchPair}.
	 * @param ctx the parse tree
	 */
	void enterMatchPair(ExamSpecificationParser.MatchPairContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#matchPair}.
	 * @param ctx the parse tree
	 */
	void exitMatchPair(ExamSpecificationParser.MatchPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoiceQuestion(ExamSpecificationParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoiceQuestion(ExamSpecificationParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(ExamSpecificationParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(ExamSpecificationParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswerQuestion(ExamSpecificationParser.ShortAnswerQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswerQuestion(ExamSpecificationParser.ShortAnswerQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#possibleAnswer}.
	 * @param ctx the parse tree
	 */
	void enterPossibleAnswer(ExamSpecificationParser.PossibleAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#possibleAnswer}.
	 * @param ctx the parse tree
	 */
	void exitPossibleAnswer(ExamSpecificationParser.PossibleAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#numericalQuestion}.
	 * @param ctx the parse tree
	 */
	void enterNumericalQuestion(ExamSpecificationParser.NumericalQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#numericalQuestion}.
	 * @param ctx the parse tree
	 */
	void exitNumericalQuestion(ExamSpecificationParser.NumericalQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 */
	void enterSelectMissingWordsQuestion(ExamSpecificationParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 */
	void exitSelectMissingWordsQuestion(ExamSpecificationParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#missingWord}.
	 * @param ctx the parse tree
	 */
	void enterMissingWord(ExamSpecificationParser.MissingWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#missingWord}.
	 * @param ctx the parse tree
	 */
	void exitMissingWord(ExamSpecificationParser.MissingWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamSpecificationParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalseQuestion(ExamSpecificationParser.TrueFalseQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamSpecificationParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalseQuestion(ExamSpecificationParser.TrueFalseQuestionContext ctx);
}