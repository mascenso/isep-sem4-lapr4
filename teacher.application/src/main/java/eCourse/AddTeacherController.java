package eCourse;

import eCourse.domain.Teacher;
import eCourse.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Set;

public class AddTeacherController {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserManagementService userManagementService = AuthzRegistry.userService();
    private final TeacherService teacherManagementService = new TeacherService();


    @Transactional
    public Teacher addTeacher(final String username, final String password, final String firstName,
                                      final String lastName, final String email, final Set<Role> roles, String acronym, final Calendar createdOn) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER, ECourseRoles.ADMIN);

        /* Register the user */
        SystemUser user = userManagementService.registerNewUser(username, password, firstName, lastName, email, roles, createdOn);

        /* Register the student */
        return teacherManagementService.createTeacher(user, acronym);
    }

    public Teacher addTeacher(final String username, final String password, final String firstName,
                              final String lastName, final String email, final Set<Role> roles, String acronym) {

        return addTeacher(username, password, firstName, lastName, email, roles, acronym, CurrentTimeCalendars.now());
    }


}
