package eCourse.app.student.console.presentation.Exams;

import eCourse.app.common.console.ExamGradePrinter;
import eCourse.app.common.console.ExamPrinter;
import eCourse.domain.Exam;
import eCourse.domain.GradeOfExam;
import eCourse.exam.application.ListStudentExamGradesController;
import eCourse.exam.application.ListStudentExamsController;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListExamsUI extends AbstractListUI {

    private final ListStudentExamsController listStudentExamsController = new ListStudentExamsController();


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
        return listStudentExamsController.examOfLoggedStudent();
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
        return String.format("#  %-30s%-20s%-20s%-30s%-20s", "Course", "Exam Name", "Teacher Name", "Start Date", "End Date");
    }
}
