package eCourse.app.backoffice.console.presentation.courses;

import eCourse.domain.Teacher;
import eCourse.app.common.console.teachers.TeacherPrinter;
import eCourse.course.application.SetTeachersOfCourseController;
import eCourse.domain.Course;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.HashSet;
import java.util.Set;

public class SetTeachersOfCourseUI extends AbstractUI {

    private final SetTeachersOfCourseController theController = new SetTeachersOfCourseController();

    @Override
    protected boolean doShow() {

        Set<Teacher> teachersOfCourse = new HashSet<>();

        final Iterable<Course> courses = theController.allCourses();
        final SelectWidget<Course> selectorCourse = new SelectWidget<>("Select a course", courses, new CoursesPrinter());
        selectorCourse.show();
        final Course theCourse = selectorCourse.selectedElement();

        if (theCourse != null) {
            while (true) {
                final Iterable<Teacher> listOfTeachers = theController.allTeachers();
                final SelectWidget<Teacher> selectorTeacher = new SelectWidget<>("Select a teacher", listOfTeachers, new TeacherPrinter());
                selectorTeacher.show();
                final Teacher theTeacher = selectorTeacher.selectedElement();

                if (theTeacher != null) {
                    teachersOfCourse.add(theTeacher);
                } else {
                    break;
                }

            }

                if (!teachersOfCourse.isEmpty()) {
                    try {
                        theController.addTeachersToCourse(theCourse, teachersOfCourse);
                    } catch (final ConcurrencyException | IntegrityViolationException exMerge) {
                        System.out.println("Data has changed or been deleted since it was last read. Please try again.");
                    }
                }
                else {
                    System.out.println("No teachers were selected.");
                }

        }
        return false;
    }




    @Override
    public String headline() {
        return "Create new course";
    }
}
