package eCourse.app.student.console.presentation.Exams;

import eCourse.app.common.console.ExamGradePrinter;
import eCourse.domain.GradeOfExam;
import eCourse.exam.application.ListStudentExamGradesController;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListExamsGradesUI extends AbstractListUI {

    private final ListStudentExamGradesController listStudentExamGradesController = new ListStudentExamGradesController();


    @Override
    public String headline() {
        return "List Exams Grades";
    }

    @Override
    protected String emptyMessage() {
        return "No Exams grades available yet.\n";
    }


    @Override
    protected Iterable<GradeOfExam> elements() {
        return listStudentExamGradesController.examGradesOfLoggedStudent();
    }

    @Override
    protected Visitor<GradeOfExam> elementPrinter() {
        return new ExamGradePrinter();
    }

    @Override
    protected String elementName() {
        return "Exam Grades";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-20s%-20s%-20s", "Course", "Exam Name", "Grade", "Student Name");
    }
}
