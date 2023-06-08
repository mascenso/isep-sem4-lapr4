package eCourse.exam.application;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Map;

public class TakeExameController {

    validateExamService service = new validateExamService();
    public Map<String, Map<String, Object>> buildExameForTaken(ParseTree parseTree) {
        return service.buildExam(parseTree);
    }

    public boolean isAValidTrueOrFalseAnswer(String userAnswer) {
        return service.validTrueOrFalseOption(userAnswer);
    }

    public float validateTheAnswerTrueOrFalse(String userAnswer, Map.Entry<String, Map<String, Object>> question) {
        return service.validateTheAnswerTrueOrFalse(userAnswer,question);
    }

    public float validateTheShortAnswer(String userAnswer, Map.Entry<String, Map<String, Object>> question) {
        return service.validateTheShortAnswer(userAnswer,question);
    }

    public float validateNumericalQuestion(float userAnswer, Map.Entry<String, Map<String, Object>> question) {
        return service.validateNumericalQuestion(userAnswer,question);
    }

    public float validateMatchingQuestion(List<String> userAnswer, Map.Entry<String, Map<String, Object>> question) {
        return service.validateMatchingQuestion(userAnswer,question);
    }

    public float validateMultipleChoiceQuestion(List<String> userAnswer, Map.Entry<String, Map<String, Object>> question) {
        return service.validateMultipleChoiceQuestion(userAnswer,question);
    }

    public float validateMissingWordQuestion(List<String> userAnswer, Map.Entry<String, Map<String, Object>> question) {
        return service.validateMissingWordQuestion(userAnswer,question);
    }
}
