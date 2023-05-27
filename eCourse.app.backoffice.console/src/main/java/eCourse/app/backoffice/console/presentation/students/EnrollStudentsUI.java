package eCourse.app.backoffice.console.presentation.students;

import eCourse.course.application.BulkCsvValidateResult;
import eCourse.course.application.EnrollStudentController;
import eCourse.domain.Course;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnrollStudentsUI extends AbstractUI {
    private final EnrollStudentController enrollStudentController = new EnrollStudentController();
    final Iterable<Course> allCourses= enrollStudentController.allCourses();

    private final String typeOfFile = ".csv";


    @Override
    protected boolean doShow() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the name of the file");
        String fileName = sc.nextLine() + typeOfFile;
        try {
            String csvContent = Files.readString(Paths.get(fileName));
            BulkCsvValidateResult result = this.enrollStudentController.BulkCsvValidate(csvContent);

            if (result.validStudents().size() > 0) {
                final Course courseSelected = showAllCourses(allCourses);
                //the valid students can be enrolled with the course
                this.enrollStudentController.enrollStudent(courseSelected.identity().toString(), result.validStudents());
            }
        }
             catch (Exception e) {
        System.out.println("File not found: " + e.getMessage());
    }

        return false;
    }

    private Course showAllCourses(Iterable<Course> allCourses) {
        //copy of list
        List<Course> courses = new ArrayList<>();
        for (Course course : allCourses) {
            courses.add(course);
        }


        //Scanner to read option from user
        Scanner scanner = new Scanner(System.in);

        //show a list of users and ask to choose participants
        System.out.println("Select Course or 0 to exit:");
        int index = 1;
        for (Course course : courses) {
            System.out.println(index + ". " + course.designation());
            index++;
        }
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= courses.size()) {
            return courses.get(choice-1);
        } else {
            System.out.println("Invalid selection. Try again.");
        }


        return null;
    }

    @Override
    public String headline() {
        return "Enroll students from a csv file";
    }
}
