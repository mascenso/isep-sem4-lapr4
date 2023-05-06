package eapli.base.course.application;

import eapli.base.course.domain.CourseStates;


public class CreateCourseController {

    public String [] getCourseStates(){
        return CourseStates.stateValues();
    }
}
