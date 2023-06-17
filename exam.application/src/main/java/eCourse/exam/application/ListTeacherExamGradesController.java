package eCourse.exam.application;

import eCourse.domain.GradeOfExam;

public class ListTeacherExamGradesController {

    private final ListExamsService service = new ListExamsService();

    public Iterable<GradeOfExam> examGradesOfLoggedTeacher(){ return service.examGradesOfLoggedTeacher();}
}
