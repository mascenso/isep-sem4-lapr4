package eCourse.exam.application;

import eCourse.domain.AutomaticExame;
import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TakeAutomaticExameController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final validateExamService service = new validateExamService();

    private ListExamsService listExamService = new ListExamsService();
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

    public float getExamGradeOnPercentage(float studentGrade, float maxExamGrade) {
        return service.getExamGradeOnPercentage(studentGrade,maxExamGrade);
    }

    public void saveGrade(float examGradeOnPercentage, AutomaticExame examSelected) {
        SystemUser user  = authz.session().get().authenticatedUser();
        GradeOfExam grade = new GradeOfExam(user, examGradeOnPercentage,examSelected);
        PersistenceContext.repositories().gradesForExam().save(grade);
    }

    public List<AutomaticExame> AutomaticExamsUnsolved() {
        return listExamService.AutomaticExamsUnsolved();
    }
}
