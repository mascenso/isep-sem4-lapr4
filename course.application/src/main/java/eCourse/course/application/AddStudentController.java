package eCourse.course.application;

import eCourse.domain.Student;
import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.Calendar;
import java.util.Set;

public class AddStudentController {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserManagementService userManagementService = AuthzRegistry.userService();
    private final StudentManagementService studentManagementService = new StudentManagementService();


    public Student addStudent(final String username, final String password, final String firstName,
                              final String lastName, final String email, final Set<Role> roles, final Calendar createdOn) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER, ECourseRoles.ADMIN);

        SystemUser user = userManagementService.registerNewUser(username, password, firstName, lastName, email, roles, createdOn);
        Student student = studentManagementService.registerNewStudent(user);
        return student;
    }

    public Student addStudent(final String username, final String password, final String firstName,
                              final String lastName, final String email, final Set<Role> roles) {
        return addStudent(username, password, firstName, lastName, email, roles, CurrentTimeCalendars.now());
    }
}
