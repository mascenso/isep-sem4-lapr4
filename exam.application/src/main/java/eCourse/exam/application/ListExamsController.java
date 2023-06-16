package eCourse.exam.application;

import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.stereotype.Component;

@Component
@UseCaseController
public class ListExamsController {

    private final ListExamsService service = new ListExamsService();

    public Iterable<Exam> allExams() {

        return service.allExams();
    }

    public Iterable<GradeOfExam> examOfLoggedStudent() {
        return service.examOfLoggedStudent();
    }
}
