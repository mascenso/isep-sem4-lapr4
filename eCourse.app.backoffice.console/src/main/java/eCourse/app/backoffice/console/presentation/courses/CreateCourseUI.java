package eCourse.app.backoffice.console.presentation.courses;

import eCourse.course.application.CreateCourseController;
import eCourse.teacherusermanagement.domain.TeacherUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;
import java.util.Scanner;

public class CreateCourseUI extends AbstractUI {

    private final CreateCourseController theController = new CreateCourseController();
    @Override
    protected boolean doShow() {
        List<TeacherUser> listOfTeachers =theController.listOfTeachers();
        final String name = Console.readNonEmptyLine("Name","The name should not be empty");
        final String edition = Console.readNonEmptyLine("Edition","The edition should not be empty");
        final String description = Console.readNonEmptyLine("Description","The description should not be empty");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose the Teacher responsible for the course.");
        for (int i = 0; i < listOfTeachers.size(); i++) {
            System.out.printf("(%d) %s\n",i,listOfTeachers.get(i).identity());
        }
        int choose =-1;
        do{
            System.out.print("Answer: ");
            choose= scanner.nextInt();
            if(choose<0 || choose>= listOfTeachers.size()){
                System.out.println("-----------------------------");
                System.out.println("Please choose a valid teacher");
                System.out.println("-----------------------------");
            }
        }while(choose<0 || choose>= listOfTeachers.size());
        theController.createCourse(name,edition,description,listOfTeachers.get(choose).user());
        return false;
    }


    private String [] buildCourseStates() {
        final String [] courseStates = theController.getCourseStates();
        return courseStates;
    }

    @Override
    public String headline() {
        return "Create new course";
    }
}
