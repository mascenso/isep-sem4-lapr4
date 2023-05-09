package eapli.base.course.application;

import eapli.base.domain.Course;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CourseRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ApplicationService
public class ListCoursesService {

    public Iterable<Course> allCourses(){

        return PersistenceContext.repositories().courses().findAll();
    }
}
