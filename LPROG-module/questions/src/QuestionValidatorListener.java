// Generated from /Users/patricia/Documents/ISEP/2ºano/2ºsemestre/PI/sem4pi-22-23-49/LPROG-module/questions/grammar/QuestionValidator.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionValidatorParser}.
 */
public interface QuestionValidatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QuestionValidatorParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QuestionValidatorParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#matchingQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMatchingQuestion(QuestionValidatorParser.MatchingQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#matchingQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMatchingQuestion(QuestionValidatorParser.MatchingQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#listOne}.
	 * @param ctx the parse tree
	 */
	void enterListOne(QuestionValidatorParser.ListOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#listOne}.
	 * @param ctx the parse tree
	 */
	void exitListOne(QuestionValidatorParser.ListOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#listTwo}.
	 * @param ctx the parse tree
	 */
	void enterListTwo(QuestionValidatorParser.ListTwoContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#listTwo}.
	 * @param ctx the parse tree
	 */
	void exitListTwo(QuestionValidatorParser.ListTwoContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#questionText}.
	 * @param ctx the parse tree
	 */
	void enterQuestionText(QuestionValidatorParser.QuestionTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#questionText}.
	 * @param ctx the parse tree
	 */
	void exitQuestionText(QuestionValidatorParser.QuestionTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoiceQuestion(QuestionValidatorParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoiceQuestion(QuestionValidatorParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswerQuestion(QuestionValidatorParser.ShortAnswerQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#shortAnswerQuestion}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswerQuestion(QuestionValidatorParser.ShortAnswerQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#possibleAnswer}.
	 * @param ctx the parse tree
	 */
	void enterPossibleAnswer(QuestionValidatorParser.PossibleAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#possibleAnswer}.
	 * @param ctx the parse tree
	 */
	void exitPossibleAnswer(QuestionValidatorParser.PossibleAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#numericalQuestion}.
	 * @param ctx the parse tree
	 */
	void enterNumericalQuestion(QuestionValidatorParser.NumericalQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#numericalQuestion}.
	 * @param ctx the parse tree
	 */
	void exitNumericalQuestion(QuestionValidatorParser.NumericalQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#acceptedError}.
	 * @param ctx the parse tree
	 */
	void enterAcceptedError(QuestionValidatorParser.AcceptedErrorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#acceptedError}.
	 * @param ctx the parse tree
	 */
	void exitAcceptedError(QuestionValidatorParser.AcceptedErrorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 */
	void enterSelectMissingWordsQuestion(QuestionValidatorParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 */
	void exitSelectMissingWordsQuestion(QuestionValidatorParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#missingWord}.
	 * @param ctx the parse tree
	 */
	void enterMissingWord(QuestionValidatorParser.MissingWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#missingWord}.
	 * @param ctx the parse tree
	 */
	void exitMissingWord(QuestionValidatorParser.MissingWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#wordGroup}.
	 * @param ctx the parse tree
	 */
	void enterWordGroup(QuestionValidatorParser.WordGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#wordGroup}.
	 * @param ctx the parse tree
	 */
	void exitWordGroup(QuestionValidatorParser.WordGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(QuestionValidatorParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(QuestionValidatorParser.WordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalseQuestion(QuestionValidatorParser.TrueFalseQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalseQuestion(QuestionValidatorParser.TrueFalseQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#feedback}.
	 * @param ctx the parse tree
	 */
	void enterFeedback(QuestionValidatorParser.FeedbackContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#feedback}.
	 * @param ctx the parse tree
	 */
	void exitFeedback(QuestionValidatorParser.FeedbackContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#options}.
	 * @param ctx the parse tree
	 */
	void enterOptions(QuestionValidatorParser.OptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#options}.
	 * @param ctx the parse tree
	 */
	void exitOptions(QuestionValidatorParser.OptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#grade}.
	 * @param ctx the parse tree
	 */
	void enterGrade(QuestionValidatorParser.GradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#grade}.
	 * @param ctx the parse tree
	 */
	void exitGrade(QuestionValidatorParser.GradeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(QuestionValidatorParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(QuestionValidatorParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#penalty}.
	 * @param ctx the parse tree
	 */
	void enterPenalty(QuestionValidatorParser.PenaltyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#penalty}.
	 * @param ctx the parse tree
	 */
	void exitPenalty(QuestionValidatorParser.PenaltyContext ctx);
}