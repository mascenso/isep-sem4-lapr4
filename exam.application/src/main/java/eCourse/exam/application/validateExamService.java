package eCourse.exam.application;

import eCourse.antlr.ExamVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class validateExamService {

    public Map<String, Map<String, Object>> buildExam(ParseTree parseTree) {
        ExamVisitor visitor = new ExamVisitor();
        visitor.visit(parseTree);

        return visitor.getMemory();
    }

    public boolean validTrueOrFalseOption(String userAnswer) {
        if(userAnswer.equalsIgnoreCase("true") || userAnswer.equalsIgnoreCase("false")){
            return true;
        }
        return false;
    }

    public float validateTheAnswerTrueOrFalse(String userAnswer, Map.Entry<String, Map<String, Object>> question) {
        if(userAnswer.equalsIgnoreCase(question.getValue().get("CorrectAnswer").toString())){
            return Float.parseFloat(question.getValue().get("Grade").toString());
        }
            return 0;
    }

    public float validateTheShortAnswer(String userAnswer, Map.Entry<String, Map<String, Object>> question) {

        List <String> correctAnwer = (List<String>) question.getValue().get("CorrectAnswer");
        List <Float> gradeByAnswer = (List<Float>) question.getValue().get("Grade");
        for (int i = 0; i < correctAnwer.size(); i++) {
            if(userAnswer.equalsIgnoreCase(correctAnwer.get(i))){
                float cenas = gradeByAnswer.get(i);
                return gradeByAnswer.get(i);
            }
        }
        //if(userAnswer.equalsIgnoreCase(question.getValue().get()))
        return 0;
    }

    public float validateNumericalQuestion(float userAnswer, Map.Entry<String, Map<String, Object>> question) {
        float correctAnswer = Float.parseFloat(question.getValue().get("CorrectAnswer").toString());
        float acceptanceError = Float.parseFloat(question.getValue().get("AcceptanceError").toString());
        float grade = Float.parseFloat(question.getValue().get("Grade").toString());

        if(Math.abs(userAnswer - correctAnswer) <= acceptanceError){
            return grade;
        }
        return 0;
    }

    public float validateMatchingQuestion(List<String> userAnswer, Map.Entry<String, Map<String, Object>> question) {
        List <String> correcAnswer = (List<String>) question.getValue().get("CorrectAnswer");
        List <Float> grade = (List<Float>) question.getValue().get("Grade");
        float gradeToSubmit =0;

        for (int i = 0; i < correcAnswer.size(); i++) {
            if (correcAnswer.get(i).equalsIgnoreCase(userAnswer.get(i))){
                gradeToSubmit += grade.get(i);
            }
        }
        return gradeToSubmit;
    }

    public float validateMultipleChoiceQuestion(List<String> userAnswer, Map.Entry<String, Map<String, Object>> question) {
        List<String> correctAnswer = (List<String>) question.getValue().get("CorrectAnswer");
        List <Float> grades = (List<Float>) question.getValue().get("Grade");
        float gradeToSubmit = 0;
        for (int i = 0; i < correctAnswer.size(); i++) {
            if (userAnswer.size()> i && userAnswer.get(i).equalsIgnoreCase(correctAnswer.get(i).toString())){
                gradeToSubmit += grades.get(i);
            }
        }
        return gradeToSubmit;
    }

    public float validateMissingWordQuestion(List<String> userAnswer, Map.Entry<String, Map<String, Object>> question) {
        List<Float> grades = (List<Float>) question.getValue().get("Grade");
        List<String> correctAnswer = (List<String>) question.getValue().get("CorrectAnswer");
        float gradeToSubmit =0;

        for (int i = 0; i < correctAnswer.size(); i++) {
            if(userAnswer.size()>i && userAnswer.get(i).equalsIgnoreCase(correctAnswer.get(i))){
                gradeToSubmit += grades.get(i);
            }
        }
        return gradeToSubmit;
    }

    public float getExamGradeOnPercentage(float studentGrade, float maxExamGrade) {
        float gradeToSubmit = 0;
        if(studentGrade==maxExamGrade){
            gradeToSubmit =100;
        }else{
            gradeToSubmit = (studentGrade/maxExamGrade)*100;
        }
        return gradeToSubmit;
    }
}
