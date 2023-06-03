package eCourse;

import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Set;

public class AddStudentUserController {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserManagementService userManagementService = AuthzRegistry.userService();
    private final StudentUserService studentManagementService = new StudentUserService();


    @Transactional
    public void addStudentUser(final String username, final String password, final String firstName,
                                      final String lastName, final String email, final Set<Role> roles, final String taxPayerNumber, final Calendar createdOn) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER, ECourseRoles.ADMIN);


        /* Register the user */
        SystemUser user = userManagementService.registerNewUser(username, password, firstName, lastName, email, roles, createdOn);

        /* Register the student */
        studentManagementService.createStudentUser(user, taxPayerNumber);


    }

    public void addStudentUser(final String username, final String password, final String firstName,
                              final String lastName, final String email, final Set<Role> roles, final String taxPayerNumber) {

        addStudentUser(username, password, firstName, lastName, email, roles, taxPayerNumber, CurrentTimeCalendars.now());
    }


}
