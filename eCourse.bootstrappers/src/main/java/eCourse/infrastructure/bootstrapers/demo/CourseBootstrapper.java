package eCourse.infrastructure.bootstrapers.demo;

import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

public class CourseBootstrapper implements Action {

    @Override
    public boolean execute() {
        RegisterCourse("Course for developers", "Infomatica","2022/2023","Open");
        RegisterCourse("Course for big brains", "Inteligencia Artificial","2022/2023","Open");
        RegisterCourse("Course for grammar", "LPROG","2022/2023","Open");
        RegisterCourse("Course for all", "EAPLI","2022/2023","Open");
        return true;
    }

    private boolean RegisterCourse(final String description, final String name, final String edition, final String state){
        final Course newCourse = new CourseBuilder().descriptioned(Description.valueOf(description)).named(Designation.valueOf(name))
                .edition(CourseEdition.valueOf(edition)).state(CourseState.valueOf(state)).build();
        PersistenceContext.repositories().courses().save(newCourse);
        return true;
    }
}
