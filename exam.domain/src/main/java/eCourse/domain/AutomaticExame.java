package eCourse.domain;

import java.util.List;

public class AutomaticExame {

    private String title;

    private List<Question> questions;
    public AutomaticExame(String title, List<Question> questionsForAutomaticExam) {
        this.title = title;
        this.questions = questionsForAutomaticExam;
    }
}
