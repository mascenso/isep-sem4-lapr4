package eCourse.app.student.console.presentation.Exams;

import eCourse.domain.Exam;
import eCourse.domain.SharedBoard;
import eCourse.exam.application.ListExamsController;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListExamsUI extends AbstractListUI {

    private final ListExamsController listExamsController = new ListExamsController();


    @Override
    public String headline() {
        return "List Exams";
    }

    @Override
    protected String emptyMessage() {
        return "No Exams available yet.\n";
    }


    @Override
    protected Iterable<Exam> elements() {
        return listExamsController.allExams();

    }

    @Override
    protected Visitor<Exam> elementPrinter() {
        return new ExamPrinter();
    }

    @Override
    protected String elementName() {
        return "Exam";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-20s%-20s%-20s%-20s", "Exam Name", "Course", "NumberRows", "Grade", "Student Name");
    }
}
