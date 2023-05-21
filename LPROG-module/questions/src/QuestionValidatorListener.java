// Generated from /Users/patricia/Documents/ISEP/2ºano/2ºsemestre/LPROG/questions/grammar/QuestionValidator.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionValidatorParser}.
 */
public interface QuestionValidatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(QuestionValidatorParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(QuestionValidatorParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shortAnswerQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswerQuestion(QuestionValidatorParser.ShortAnswerQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shortAnswerQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswerQuestion(QuestionValidatorParser.ShortAnswerQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multichoiceQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterMultichoiceQuestion(QuestionValidatorParser.MultichoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multichoiceQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitMultichoiceQuestion(QuestionValidatorParser.MultichoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matchingQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterMatchingQuestion(QuestionValidatorParser.MatchingQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matchingQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitMatchingQuestion(QuestionValidatorParser.MatchingQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueFalseQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalseQuestion(QuestionValidatorParser.TrueFalseQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueFalseQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalseQuestion(QuestionValidatorParser.TrueFalseQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectMissingWordsQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSelectMissingWordsQuestion(QuestionValidatorParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectMissingWordsQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSelectMissingWordsQuestion(QuestionValidatorParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericalQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterNumericalQuestion(QuestionValidatorParser.NumericalQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericalQuestion}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitNumericalQuestion(QuestionValidatorParser.NumericalQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(QuestionValidatorParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link QuestionValidatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(QuestionValidatorParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#shortAnswer}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswer(QuestionValidatorParser.ShortAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#shortAnswer}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswer(QuestionValidatorParser.ShortAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#multichoice}.
	 * @param ctx the parse tree
	 */
	void enterMultichoice(QuestionValidatorParser.MultichoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#multichoice}.
	 * @param ctx the parse tree
	 */
	void exitMultichoice(QuestionValidatorParser.MultichoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#matching}.
	 * @param ctx the parse tree
	 */
	void enterMatching(QuestionValidatorParser.MatchingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#matching}.
	 * @param ctx the parse tree
	 */
	void exitMatching(QuestionValidatorParser.MatchingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#trueFalse}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalse(QuestionValidatorParser.TrueFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#trueFalse}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalse(QuestionValidatorParser.TrueFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#selectMissingWords}.
	 * @param ctx the parse tree
	 */
	void enterSelectMissingWords(QuestionValidatorParser.SelectMissingWordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#selectMissingWords}.
	 * @param ctx the parse tree
	 */
	void exitSelectMissingWords(QuestionValidatorParser.SelectMissingWordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#numerical}.
	 * @param ctx the parse tree
	 */
	void enterNumerical(QuestionValidatorParser.NumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#numerical}.
	 * @param ctx the parse tree
	 */
	void exitNumerical(QuestionValidatorParser.NumericalContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterChoice(QuestionValidatorParser.ChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitChoice(QuestionValidatorParser.ChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionValidatorParser#subQuestion}.
	 * @param ctx the parse tree
	 */
	void enterSubQuestion(QuestionValidatorParser.SubQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionValidatorParser#subQuestion}.
	 * @param ctx the parse tree
	 */
	void exitSubQuestion(QuestionValidatorParser.SubQuestionContext ctx);
}