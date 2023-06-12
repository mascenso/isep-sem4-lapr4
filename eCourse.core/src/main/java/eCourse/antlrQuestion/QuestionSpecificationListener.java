// Generated from /Users/miguelcardoso/Library/CloudStorage/OneDrive-InstitutoSuperiordeEngenhariadoPorto/Licenciatura Engenharia Informatica/2 ano/2 semestre/LAPR4/projeto-v2/sem4pi-22-23-49/LPROG-module/exams/grammar/QuestionSpecification.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionSpecificationParser}.
 */
public interface QuestionSpecificationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QuestionSpecificationParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QuestionSpecificationParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#matchingQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMatchingQuestion(QuestionSpecificationParser.MatchingQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#matchingQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMatchingQuestion(QuestionSpecificationParser.MatchingQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#listOne}.
	 * @param ctx the parse tree
	 */
	void enterListOne(QuestionSpecificationParser.ListOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#listOne}.
	 * @param ctx the parse tree
	 */
	void exitListOne(QuestionSpecificationParser.ListOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#listTwo}.
	 * @param ctx the parse tree
	 */
	void enterListTwo(QuestionSpecificationParser.ListTwoContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#listTwo}.
	 * @param ctx the parse tree
	 */
	void exitListTwo(QuestionSpecificationParser.ListTwoContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#questionText}.
	 * @param ctx the parse tree
	 */
	void enterQuestionText(QuestionSpecificationParser.QuestionTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#questionText}.
	 * @param ctx the parse tree
	 */
	void exitQuestionText(QuestionSpecificationParser.QuestionTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoiceQuestion(QuestionSpecificationParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoiceQuestion(QuestionSpecificationParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswerQuestion(QuestionSpecificationParser.ShortAnswerQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswerQuestion(QuestionSpecificationParser.ShortAnswerQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#possibleAnswer}.
	 * @param ctx the parse tree
	 */
	void enterPossibleAnswer(QuestionSpecificationParser.PossibleAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#possibleAnswer}.
	 * @param ctx the parse tree
	 */
	void exitPossibleAnswer(QuestionSpecificationParser.PossibleAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#numericalQuestion}.
	 * @param ctx the parse tree
	 */
	void enterNumericalQuestion(QuestionSpecificationParser.NumericalQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#numericalQuestion}.
	 * @param ctx the parse tree
	 */
	void exitNumericalQuestion(QuestionSpecificationParser.NumericalQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#acceptedError}.
	 * @param ctx the parse tree
	 */
	void enterAcceptedError(QuestionSpecificationParser.AcceptedErrorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#acceptedError}.
	 * @param ctx the parse tree
	 */
	void exitAcceptedError(QuestionSpecificationParser.AcceptedErrorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 */
	void enterSelectMissingWordsQuestion(QuestionSpecificationParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 */
	void exitSelectMissingWordsQuestion(QuestionSpecificationParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#missingWord}.
	 * @param ctx the parse tree
	 */
	void enterMissingWord(QuestionSpecificationParser.MissingWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#missingWord}.
	 * @param ctx the parse tree
	 */
	void exitMissingWord(QuestionSpecificationParser.MissingWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#wordGroup}.
	 * @param ctx the parse tree
	 */
	void enterWordGroup(QuestionSpecificationParser.WordGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#wordGroup}.
	 * @param ctx the parse tree
	 */
	void exitWordGroup(QuestionSpecificationParser.WordGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(QuestionSpecificationParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(QuestionSpecificationParser.WordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalseQuestion(QuestionSpecificationParser.TrueFalseQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalseQuestion(QuestionSpecificationParser.TrueFalseQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#feedback}.
	 * @param ctx the parse tree
	 */
	void enterFeedback(QuestionSpecificationParser.FeedbackContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#feedback}.
	 * @param ctx the parse tree
	 */
	void exitFeedback(QuestionSpecificationParser.FeedbackContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#options}.
	 * @param ctx the parse tree
	 */
	void enterOptions(QuestionSpecificationParser.OptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#options}.
	 * @param ctx the parse tree
	 */
	void exitOptions(QuestionSpecificationParser.OptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#grade}.
	 * @param ctx the parse tree
	 */
	void enterGrade(QuestionSpecificationParser.GradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#grade}.
	 * @param ctx the parse tree
	 */
	void exitGrade(QuestionSpecificationParser.GradeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(QuestionSpecificationParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(QuestionSpecificationParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionSpecificationParser#penalty}.
	 * @param ctx the parse tree
	 */
	void enterPenalty(QuestionSpecificationParser.PenaltyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionSpecificationParser#penalty}.
	 * @param ctx the parse tree
	 */
	void exitPenalty(QuestionSpecificationParser.PenaltyContext ctx);
}