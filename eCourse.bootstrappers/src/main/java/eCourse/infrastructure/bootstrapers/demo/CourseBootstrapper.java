package eCourse.infrastructure.bootstrapers.demo;

import eCourse.AddTeacherController;
import eCourse.domain.Teacher;
import eCourse.TeacherService;
import eCourse.course.application.ListCoursesService;
import eCourse.course.application.SetTeachersOfCourseController;
import eCourse.course.application.UpdateCourseStateController;
import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.domain.ECourseRoles;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CourseBootstrapper implements Action {

    UpdateCourseStateController updateCourseStateController = new UpdateCourseStateController();
    SetTeachersOfCourseController setTeachersOfCourseController = new SetTeachersOfCourseController();
    ListCoursesService listCoursesService = new ListCoursesService();
    TeacherService teacherService = new TeacherService();
    private final AddTeacherController userManagementService = new AddTeacherController();

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

        Optional<Course> c = listCoursesService.findCourseByDesignation(Designation.valueOf("Informatica"));
        Optional<Teacher> t = teacherService.findTeacherByAcronym(Acronym.valueOf("abc"));
        Set<Teacher> teachers = new HashSet<>();
        teachers.add(t.get());

        setTeachersOfCourseController.addTeachersToCourse(c.get(), teachers);

        return true;
    }

    private boolean RegisterCourse(final String description, final String name, final String edition, final String state, int number){
        final Set<Role> roleTypes = new HashSet<>();
        roleTypes.add(ECourseRoles.TEACHER);
        Teacher t = userManagementService.addTeacher("teacher"+number, "Password1", "John", "Doe", "teacher"+ number + "@isep.ipp.pt",roleTypes, "ab"+ (char) (number+99));
        SystemUser user = t.user();

        final Course newCourse = new CourseBuilder().descriptioned(Description.valueOf(description)).named(Designation.valueOf(name))
                .edition(CourseEdition.valueOf(edition)).teacherCoordinator(user).build();
        PersistenceContext.repositories().courses().save(newCourse);
        return true;
    }


}