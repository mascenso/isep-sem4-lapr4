package eCourse;

import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.Calendar;
import java.util.Set;

public class AddTeacherUserController {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserManagementService userManagementService = AuthzRegistry.userService();
    private final TeacherUserService teacherManagementService = new TeacherUserService();


    public void addTeacherUser(final String username, final String password, final String firstName,
                                      final String lastName, final String email, final Set<Role> roles, String acronym, final Calendar createdOn) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER, ECourseRoles.ADMIN);

        //TODO: should be the begin of a transaction!

        /* Register the user */
        SystemUser user = userManagementService.registerNewUser(username, password, firstName, lastName, email, roles, createdOn);

        /* Register the student */
        teacherManagementService.createTeacherUser(user, acronym);

        //TODO: should be the end of a transaction!

    }

    public void addTeacherUser(final String username, final String password, final String firstName,
                              final String lastName, final String email, final Set<Role> roles, String acronym) {

        addTeacherUser(username, password, firstName, lastName, email, roles, acronym, CurrentTimeCalendars.now());
    }


}
