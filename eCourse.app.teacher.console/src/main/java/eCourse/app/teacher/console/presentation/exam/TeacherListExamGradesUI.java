package eCourse.app.teacher.console.presentation.exam;

import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eCourse.exam.application.ListStudentExamGradesController;
import eCourse.exam.application.ListTeacherExamGradesController;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class TeacherListExamGradesUI extends AbstractListUI {

    private final ListTeacherExamGradesController listExamsController = new ListTeacherExamGradesController();


    @Override
    public String headline() {
        return "List Exams";
    }

    @Override
    protected String emptyMessage() {
        return "No Exams available yet.\n";
    }


    @Override
    protected Iterable<GradeOfExam> elements() {
        return listExamsController.examGradesOfLoggedTeacher();

    }

    @Override
    protected Visitor<GradeOfExam> elementPrinter() {
        return new TeacherExamGradesPrinter();
    }

    @Override
    protected String elementName() {
        return "Exam";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-20s%-20s%-20s%-20s", "Course", "Exam Title", "Teacher", "Grade", "Student Name");
    }
}
