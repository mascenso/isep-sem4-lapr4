package eCourse.infrastructure.bootstrapers.demo;

import eCourse.AddTeacherUserController;
import eCourse.course.application.UpdateCourseStateController;
import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.HashSet;
import java.util.Set;

public class CourseBootstrapper implements Action {

    UpdateCourseStateController updateCourseStateController = new UpdateCourseStateController();
    private final AddTeacherUserController addTeacherUserController = new AddTeacherUserController();
    private final UserManagementService userManagementService = AuthzRegistry.userService();
    @Override
    public boolean execute() {
        RegisterCourse("Course for developers", "Informatica","2022/2023","Open",4);
        RegisterCourse("Course for big brains", "Inteligencia Artificial","2022/2023","Open",5);
        RegisterCourse("Course for grammar", "LPROG","2022/2023","Open",6);
        RegisterCourse("Course for all", "RCOMP","2022/2023","Open",7);

        updateCourseStateController.updateCourseState("Informatica", "Open");
        updateCourseStateController.updateCourseState("Inteligencia Artificial", "Open");
        //updateCourseStateController.updateCourseState("LPROG", "Open");
       // updateCourseStateController.updateCourseState("RCOMP", "Open");
        return true;
    }

    private boolean RegisterCourse(final String description, final String name, final String edition, final String state, int number){
        final Set<Role> roleTypes = new HashSet<>();
        roleTypes.add(ECourseRoles.TEACHER);
        SystemUser user = userManagementService.registerNewUser("teacher"+number, "Password1", "John", "Doe", "teacher1@isep.ipp.pt",roleTypes);
        final Course newCourse = new CourseBuilder().descriptioned(Description.valueOf(description)).named(Designation.valueOf(name))
                .edition(CourseEdition.valueOf(edition)).teacherCoordinator(user).build();
        PersistenceContext.repositories().courses().save(newCourse);
        return true;
    }


}
