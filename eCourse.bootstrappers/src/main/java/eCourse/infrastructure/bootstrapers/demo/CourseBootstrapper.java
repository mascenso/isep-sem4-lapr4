package eCourse.infrastructure.bootstrapers.demo;

import eCourse.course.application.UpdateCourseStateController;
import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

public class CourseBootstrapper implements Action {

    UpdateCourseStateController updateCourseStateController = new UpdateCourseStateController();

    @Override
    public boolean execute() {
        RegisterCourse("Course for developers", "Informatica","2022/2023","Open");
        RegisterCourse("Course for big brains", "Inteligencia Artificial","2022/2023","Open");
        RegisterCourse("Course for grammar", "LPROG","2022/2023","Open");
        RegisterCourse("Course for all", "RCOMP","2022/2023","Open");

        updateCourseStateController.updateCourseState("Informatica", "Open");
        updateCourseStateController.updateCourseState("Inteligencia Artificial", "Open");
        //updateCourseStateController.updateCourseState("LPROG", "Open");
       // updateCourseStateController.updateCourseState("RCOMP", "Open");
        return true;
    }

    private boolean RegisterCourse(final String description, final String name, final String edition, final String state){
        final Course newCourse = new CourseBuilder().descriptioned(Description.valueOf(description)).named(Designation.valueOf(name))
                .edition(CourseEdition.valueOf(edition)).build();
        PersistenceContext.repositories().courses().save(newCourse);
        return true;
    }


}
