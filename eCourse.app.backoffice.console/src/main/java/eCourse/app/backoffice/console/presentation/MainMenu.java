/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eCourse.app.backoffice.console.presentation;

import eCourse.app.backoffice.console.presentation.authz.AddUserUI;
import eCourse.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eCourse.app.backoffice.console.presentation.authz.ListUsersAction;
import eCourse.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eCourse.app.backoffice.console.presentation.courses.CreateCourseUI;
import eCourse.app.backoffice.console.presentation.courses.ListCoursesUI;
import eCourse.app.backoffice.console.presentation.courses.SetTeachersOfCourseUI;
import eCourse.app.backoffice.console.presentation.courses.UpdateCourseStateUI;
import eCourse.app.backoffice.console.presentation.meetings.AcceptRejectMeetingUI;
import eCourse.app.backoffice.console.presentation.meetings.CancelMeetingUI;
import eCourse.app.backoffice.console.presentation.meetings.ListMeetingsUI;
import eCourse.app.backoffice.console.presentation.meetings.ScheduleMeetingsUI;
import eCourse.app.backoffice.console.presentation.sharedboard.ListSharedBoardUI;
import eCourse.app.backoffice.console.presentation.sharedboard.NotificationUI;
import eCourse.app.backoffice.console.presentation.sharedboard.ShareABoardUI;
import eCourse.app.backoffice.console.presentation.sharedboard.SharedBoardUI;
import eCourse.app.backoffice.console.presentation.students.AddStudentUI;
import eCourse.app.backoffice.console.presentation.students.EnrollStudentsUI;
import eCourse.app.backoffice.console.presentation.teachers.AddTeacherUI;
import eCourse.app.common.console.presentation.authz.MyUserMenu;
import eCourse.Application;
import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // STUDENTS
    private static final int ADD_STUDENT_OPTION = 1;

    // TEACHERS
    private static final int ADD_TEACHER_OPTION = 1;


    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int STUDENTS_OPTION = 3;
    private static final int TEACHERS_OPTION = 4;
    private static final int SETTINGS_OPTION = 5;
    private static final int COURSE_OPTION = 6;
    private static final int SHAREDBOARD_OPTION = 7;
    private static final int MEETING_OPTION = 8 ;
    private static final int ENROLLMENT_OPTION = 9;

    //COURSE

    private static final int LIST_ALL_COURSES =1;
    private static final int ADD_NEW_COURSE =2;
    private static final int UPDATE_COURSE_STATE =3;

    private static final int COURSE_ENROLLMENT_OPTION = 2;

    private static final int REQUEST_COURSE_ENROLLMENT_OPTION = 1;
    private static final int SET_TEACHERS_OF_COURSE = 5;


    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    //SHAREDBOARD
    private static final int CREATE_BOARD_OPTION = 1;
    private static final int LIST_BOARDS_OPTION = 2;
    private static final int SHARE_A_BOARD=3;
    private static final int BOARD_NOTIFICATION=4;



    //MEETING
    private static final int SCHEDULE_MEETING = 1;
    private static final int CANCEL_MEETING = 2;
    private static final int LIST_MEETING = 3;
    private static final int ACCEPT_REJECT_MEETING = 4;


    //ENROLLMENT
    private static final int ENROLLMENT_CSV = 1;

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.POWER_USER, ECourseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);

            final Menu studentsMenu = buildStudentsMenu();
            mainMenu.addSubMenu(STUDENTS_OPTION, studentsMenu);

            final Menu teachersMenu = buildTeachersMenu();
            mainMenu.addSubMenu(TEACHERS_OPTION, teachersMenu);


            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.POWER_USER, ECourseRoles.ADMIN)) {
            final Menu courseMenu = buildCourseMenu();
            mainMenu.addSubMenu(COURSE_OPTION, courseMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.POWER_USER, ECourseRoles.ADMIN)){
            final Menu sharedBoardMenu = buildSharedBoardMenu();
            mainMenu.addSubMenu(SHAREDBOARD_OPTION, sharedBoardMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.POWER_USER, ECourseRoles.ADMIN)){
            final Menu meetingMenu = buildMeetingMenu();
            mainMenu.addSubMenu(MEETING_OPTION, meetingMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.POWER_USER, ECourseRoles.ADMIN)){
            final Menu enrollmentMenu = buildEnrollmentMenu();
            mainMenu.addSubMenu(ENROLLMENT_OPTION, enrollmentMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }


        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildStudentsMenu() {
        final Menu menu = new Menu("Students >");

        menu.addItem(ADD_STUDENT_OPTION, "Add Student", new AddStudentUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildTeachersMenu() {
        final Menu menu = new Menu("Teachers >");

        menu.addItem(ADD_TEACHER_OPTION, "Add Teacher", new AddTeacherUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCourseMenu(){
        final Menu menu = new Menu("Course >");
        menu.addItem(LIST_ALL_COURSES,"List all Courses", new ListCoursesUI()::show);
        menu.addItem(ADD_NEW_COURSE, "Add new Course", new CreateCourseUI()::show);
        menu.addItem(UPDATE_COURSE_STATE, "Update Course State", new UpdateCourseStateUI()::show);
        menu.addItem(SET_TEACHERS_OF_COURSE, "Set Teachers of Course", new SetTeachersOfCourseUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildMeetingMenu(){
        final Menu menu = new Menu("Meeting >");
        menu.addItem(SCHEDULE_MEETING,"Schedule new meeting", new ScheduleMeetingsUI()::show);
        menu.addItem(CANCEL_MEETING,"Cancel meeting", new CancelMeetingUI()::show);
        menu.addItem(LIST_MEETING, "List Meeting", new ListMeetingsUI()::show);
        menu.addItem(ACCEPT_REJECT_MEETING, "Accept/Reject Meeting", new AcceptRejectMeetingUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildSharedBoardMenu() {
        final Menu menu = new Menu("Boards >");

        menu.addItem(CREATE_BOARD_OPTION, "Create board", new SharedBoardUI()::show);
        menu.addItem(LIST_BOARDS_OPTION, "List Boards", new ListSharedBoardUI()::show);
        menu.addItem(SHARE_A_BOARD, "Share a Board", new ShareABoardUI()::show);
        menu.addItem(BOARD_NOTIFICATION, "My notifications", new NotificationUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildEnrollmentMenu() {
        final Menu menu = new Menu("Enrollments >");

        menu.addItem(ENROLLMENT_CSV, "Enrollment from csv file", new EnrollStudentsUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
