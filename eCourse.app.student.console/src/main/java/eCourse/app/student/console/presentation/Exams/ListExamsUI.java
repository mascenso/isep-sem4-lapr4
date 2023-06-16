package eCourse.app.student.console.presentation.Exams;

import eCourse.app.common.console.ExamGradePrinter;
import eCourse.domain.GradeOfExam;
import eCourse.exam.application.ListStudentExamGradesController;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListExamsUI extends AbstractListUI {

    private final ListStudentExamGradesController listStudentExamGradesController = new ListStudentExamGradesController();


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
        return listStudentExamGradesController.examOfLoggedStudent();
    }

    @Override
    protected Visitor<GradeOfExam> elementPrinter() {
        return new ExamGradePrinter();
    }

    @Override
    protected String elementName() {
        return "Exam";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-20s%-20s%-20s", "Exam Name", "Course", "Grade", "Student Name");
    }
}
