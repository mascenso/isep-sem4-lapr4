package eCourse;

import eCourse.domain.Teacher;
import eCourse.domain.TeacherBuilder;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.TeacherRepository;
import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

public class TeacherService {

    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();

    private final TeacherRepository repo =
            PersistenceContext.repositories().teachers();

    public Optional<Teacher> findTeacherByAcronym(
            final String acronym) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER,
                ECourseRoles.ADMIN,
                ECourseRoles.TEACHER);
        return repo.ofIdentity(acronym);
    }

    public Iterable<Teacher> allTeachers() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER,
                ECourseRoles.ADMIN, ECourseRoles.TEACHER);
        return repo.findAll();
    }

    public Optional<Teacher> findTeacherByUsername(
            final Username user) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER,
                ECourseRoles.ADMIN);
        return repo.findByUsername(user);
    }
    /**
     * Creates a new Student for the given SystemUser, and saves it to the
     * repository.
     * @param newUser
     */
    protected void createTeacher(final SystemUser newUser, String acronym) {
        final TeacherBuilder TeacherBuilder = new TeacherBuilder();
        TeacherBuilder
                .withSystemUser(newUser).withAcronym(acronym);

        this.repo.save(TeacherBuilder.build());
    }



}
