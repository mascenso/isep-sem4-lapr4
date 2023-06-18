package eCourse.app.backoffice.console.presentation.students;

import eCourse.application.CourseEnrollmentRequestService;
import eCourse.course.application.ApproveAndRejectEnrollmentsController;
import eCourse.domain.Course;
import eCourse.domain.Student;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class ApproveAndRejectEnrollmentsUI extends AbstractUI {

    private ApproveAndRejectEnrollmentsController theController = new ApproveAndRejectEnrollmentsController();

    private CourseEnrollmentRequestService enrollService = new CourseEnrollmentRequestService();

    @Override
    protected boolean doShow() {

        List<Course> enrollCourses = theController.getEnrollmentCourses();

        if (enrollCourses.size() != 0) {
            final Map<Integer, Designation> courseMap = new HashMap<>();
            System.out.println("Select the Course:");

            int selectedOption = showInfo(enrollCourses, courseMap);
            final Course selectedCourse = enrollCourses.get(selectedOption - 1);


            List<Student> studentsRequests = theController.studentsCourseEnrollment(selectedCourse);

            Set<Student> approvals = new HashSet<>();
            Set<Student> rejections = new HashSet<>();

            if (studentsRequests.size() != 0) {
                showAllUsers(studentsRequests, approvals, rejections);

                theController.approveStudentsEnrollment(approvals, selectedCourse);

                theController.rejectStudentsEnrollment(rejections, selectedCourse);
                return false;
            } else {
                System.out.println("There's no student enrollment request for this course!");
                return false;
            }
        } else {
            System.out.println("There's no course in ENROLL state!");
            return false;
        }
    }


    protected int showInfo(List<Course> courses, Map<Integer, Designation> map) {
        int index = 1;
        for (Course c : courses) {
            map.put(index, c.identity());
            System.out.println(index + ". " + c.identity());
            index++;
        }
        return Console.readOption(1, index - 1, 0);
    }

    private void showAllUsers(List<Student> allUsers, Set<Student> approvals, Set<Student> rejections) {
        //copies the list
        List<Student> users = new ArrayList<>();
        for (Student user : allUsers) {
            users.add(user);
        }

        //Scanner to read option from user
        Scanner scanner = new Scanner(System.in);

        //show a list of users and ask to choose users
        while (!users.isEmpty()) {
            System.out.println("Select Student or 0 to exit:");
            int index = 1;
            for (Student user : users) {
                System.out.println(index + ". " + user.identity() + " - " + user.user().username());
                index++;
            }
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            System.out.println("Choose an option, 0 to exit:");
            System.out.println("1. Approve Enrollment");
            System.out.println("2. Reject Enrollment");
            int option = Console.readOption(1, 2, 0);

            if (option == 1) {
                approvals.add(allUsers.get(choice - 1));
            } else {
                rejections.add(allUsers.get(choice));
            }

            if (choice > 0 && choice <= users.size()) {
                users.remove(choice - 1);
            } else {
                System.out.println("Invalid selection. Try again.");
            }
        }

    }

    @Override
    public String headline() {
        return "Approve or Reject Enrollments";
    }
}
