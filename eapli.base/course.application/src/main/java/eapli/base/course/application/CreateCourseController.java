package eapli.base.course.application;

import eapli.base.course.domain.model.CourseStates;


public class CreateCourseController {

    public String [] getCourseStates(){
        return CourseStates.stateValues();
    }


}
