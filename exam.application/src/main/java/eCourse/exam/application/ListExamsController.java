package eCourse.exam.application;

import eCourse.domain.Exam;
import eapli.framework.application.UseCaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@UseCaseController
public class ListExamsController {
    @Autowired
    private ListExamsService service = new ListExamsService();

    public Iterable<Exam> allExams() {

        return service.allExams();
    }
}
