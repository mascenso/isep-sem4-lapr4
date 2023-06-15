package eCourse.infrastructure.bootstrapers.demo;

/*
public class CreateExamBootstrapper implements Action {

    private final CreateExamController createExamController = new CreateExamController();
    private final UserManagementService userManagementService = AuthzRegistry.userService();
    private final UpdateCourseStateController updateCourseStateController = new UpdateCourseStateController();

    @Override
    public boolean execute() {
        Date openDate;
        Date closeDate;

        Course course1 = registerCourse("Course for race conditions", "SCOMP", "2022/2023", "Open", 10);
        // Course course2 = registerCourse("Course for network", "RCOMP", "2022/2023", "Open", 11);

        try {
            openDate = new SimpleDateFormat("dd/MM/yyyy").parse("05/06/2023");
            closeDate = new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2023");
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing dates", e);
        }
/*
        File examFile1 = new File("docs/exams1.txt");
        // File examFile2 = new File("exam2.txt");
        updateCourseStateController.updateCourseState("SCOMP", "Open");

        createExamController.createExam(course1, "SCOMP EPOCA NORMAL 2022/2023", openDate, closeDate, examFile1);
        // createExamController.createExam(course2, "RCOMP EPOCA NORMAL 2022/2023", openDate, closeDate, examFile2);


        return true;
    }

    private boolean registerExam(final Course course, final String title, Date openDate, Date endDate, final File file) {
        ExamTitle examTitle = ExamTitle.valueOf(title);
        final Exam newExam = new ExamBuilder().theCourse(course).theExamTitle(examTitle).theOpenDate(openDate)
                .theCloseDate(endDate).theFile(file).build();
        PersistenceContext.repositories().exams().save(newExam);
        return true;
    }

    private Course registerCourse(final String description, final String name, final String edition, final String state, int number) {
        final Set<Role> roleTypes = new HashSet<>();
        roleTypes.add(ECourseRoles.TEACHER);
        SystemUser user = userManagementService.registerNewUser("teacher" + number, "Password1", "John", "Doe", "teacher1@isep.ipp.pt", roleTypes);
        final Course newCourse = new CourseBuilder().descriptioned(Description.valueOf(description)).named(Designation.valueOf(name))
                .edition(CourseEdition.valueOf(edition)).teacherCoordinator(user).build();
        PersistenceContext.repositories().courses().save(newCourse);
        return newCourse;
    }

}
*/
