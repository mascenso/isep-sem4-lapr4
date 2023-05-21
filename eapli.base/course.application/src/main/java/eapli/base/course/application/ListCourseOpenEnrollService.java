package eapli.base.course.application;

import eapli.base.domain.Course;
import eapli.base.domain.CourseStates;
import eapli.base.repositories.CourseRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

public class ListCourseOpenEnrollService {

    private final AuthorizationService authz;

    private final CourseRepository repo;

    public ListCourseOpenEnrollService(final AuthorizationService authz, final CourseRepository repo) {
        this.authz = authz;
        this.repo = repo;
    }

    /*

    public Iterable<Course> findByState() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.STUDENT, BaseRoles.STUDENT);
        if(state.equals(repo.equals(state state))) {
            return repo.
        }
    }

     */
}
