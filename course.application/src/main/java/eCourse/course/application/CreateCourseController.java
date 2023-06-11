package eCourse.course.application;

import eCourse.domain.Teacher;
import eCourse.domain.*;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Component
@UseCaseController
public class CreateCourseController {

    @Autowired
    private CourseRepository courseRepository;

    /*public String [] getCourseStates(){
        return CourseStates.stateValues();
    }*/

    public String [] getCourseStates(){
        return Arrays.stream(BaseCourseStates.allCourseStates()).map(CourseState::toString).toArray(String[]::new);
    }

    @Transactional
    public Course createCourse (final String name, final String edition, final String description, SystemUser teacher){

        final Course newCourse = new CourseBuilder().descriptioned(Description.valueOf(description)).named(Designation.valueOf(name))
                .edition(CourseEdition.valueOf(edition)).teacherCoordinator(teacher).build();
        return PersistenceContext.repositories().courses().save(newCourse);
    }

    public List<Teacher> listOfTeachers() {
        List<Teacher> listOfTeachers = (List<Teacher>) PersistenceContext.repositories().teachers().findAll();
        return listOfTeachers;
    }

    /*public void changeCourseState(Long idCourse, String newState) {
        Optional<Course> optionalCourse = Optional.ofNullable(courseRepository.findById(idCourse));
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.changeState(CourseStates.valueOf(newState));
            courseRepository.save(course);
            System.out.println("Course state changed to " + newState);
        } else {
            System.out.println("Course not found");
        }
    }*/
}
