package eCourse.exam.application;

import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationService
public class ListExamsService {
    public Iterable<Exam> allExams(){

        return PersistenceContext.repositories().exams().findAll();
    }

    public List<Exam> getOpenCourses() {
        List<Exam> openExams = new ArrayList<>();
        for (Exam exam : allExams()) {
            // falta aqui a validação que o aluno tem que estar inscrito no curso
            openExams.add(exam);
        }
        return openExams;
    }

}
