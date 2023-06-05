package eCourse.infrastructure.bootstrapers.demo;

import eCourse.course.application.UpdateCourseStateController;
import eCourse.domain.*;
import eCourse.exam.application.CreateExamController;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CreateExamBootstrapper implements Action {

    CreateExamController createExamController = new CreateExamController();
    private final UserManagementService userManagementService = AuthzRegistry.userService();
    UpdateCourseStateController updateCourseStateController = new UpdateCourseStateController();

    @Override
    public boolean execute() {
        Date openDate;
        Date closeDate;

        Course course1 = RegisterCourse("Course for race conditions", "SCOMP", "2022/2023", "Open",8);
       // Course course2 = RegisterCourse("Course for network", "RCOMP", "2022/2023", "Open",11);

        try {
            openDate = new SimpleDateFormat("dd/MM/yyyy").parse("05/06/2023");
            closeDate = new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2023");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        File examFile1 = new File("exam1.txt");
       // File examFile2 = new File("exam2.txt");
        updateCourseStateController.updateCourseState("SCOMP", "Open");

        createExamController.createExam(course1, "SCOMP EPOCA NORMAL 2022/2023", openDate, closeDate, examFile1);
        //createExamController.createExam(course2, "RCOMP EPOCA NORMAL 2022/2023", openDate, closeDate, examFile2);


        return true;
    }


    public boolean registerExam(final Course course, final String title, Date openDate, Date endDate, final File file) {

        ExamTitle examTitle = ExamTitle.valueOf(title);
        final Exam newExam = new ExamBuilder().theCourse(course).theExamTitle(examTitle).theOpenDate(openDate)
                .theCloseDate(endDate).theFile(file).build();
        PersistenceContext.repositories().exams().save(newExam);
        return true;
    }

    private Course RegisterCourse(final String description, final String name, final String edition, final String state, int number){
        final Set<Role> roleTypes = new HashSet<>();
        roleTypes.add(ECourseRoles.TEACHER);
        SystemUser user = userManagementService.registerNewUser("teacher"+number, "Password1", "John", "Doe", "teacher1@isep.ipp.pt",roleTypes);
        final Course newCourse = new CourseBuilder().descriptioned(Description.valueOf(description)).named(Designation.valueOf(name))
                .edition(CourseEdition.valueOf(edition)).teacherCoordinator(user).build();
        PersistenceContext.repositories().courses().save(newCourse);
        return newCourse;
    }


}
