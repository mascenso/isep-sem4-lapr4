package eCourse.exam.application;

import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eapli.framework.application.UseCaseController;
import org.springframework.stereotype.Component;

@Component
@UseCaseController
public class ListStudentExamGradesController {

    private final ListExamsService service = new ListExamsService();

    public Iterable<Exam> allExams() {

        return service.allExams();
    }

    public Iterable<GradeOfExam> examOfLoggedStudent() {
        return service.examOfLoggedStudent();
    }
}
