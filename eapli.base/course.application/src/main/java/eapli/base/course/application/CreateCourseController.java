package eapli.base.course.application;

import eapli.base.domain.Course;
import eapli.base.domain.CourseBuilder;
import eapli.base.domain.CourseEdition;
import eapli.base.domain.CourseStates;
import eapli.base.repositories.CourseRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component
@UseCaseController
public class CreateCourseController {

    @Autowired
    private CourseRepository courseRepository;

    public String [] getCourseStates(){
        return CourseStates.stateValues();
    }

    @Transactional
    public Course createCourse (final String name, final String edition, final String description, final String state){

        final Course newCourse = new CourseBuilder().descriptioned(Description.valueOf(description)).named(Designation.valueOf(name))
                .edition(CourseEdition.valueOf(edition)).state(CourseStates.valueOf(state)).build();
        return PersistenceContext.repositories().courses().save(newCourse);
    }
}
