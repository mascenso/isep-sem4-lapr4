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
package eCourse.app.student.console.presentation;

import eCourse.app.common.console.presentation.authz.MyUserMenu;
import eCourse.Application;
import eCourse.app.student.console.presentation.Courses.ListCoursesStudentUI;
import eCourse.app.student.console.presentation.Courses.RequestEnrollmentCoursesStudentUI;
import eCourse.app.student.console.presentation.Exams.ListExamsUI;
import eCourse.app.student.console.presentation.Exams.TakeAutomaticExamUI;
import eCourse.app.student.console.presentation.Exams.TakeExamUI;
import eCourse.app.student.console.presentation.meetings.ScheduleMeetingsUI;
import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
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

    private static final String SEPARATOR_LABEL = "--------------";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int STUDENT_COURSES_OPTION = 2;
    private static final int STUDENT_EXAMS_OPTION= 3;
    private static final int STUDENT_MEETING_OPTION= 4;
    private static final int SHAREDBOARD_OPTION=5;

    private static final int TAKE_EXAM= 6;


    private static final int VIEW_STUDENT_EXAMS_LIST_OPTION = 2;
    private static final int SIGNUP_FOR_A_CURSE_OPTION = 2;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final Menu menu;
    private final MenuRenderer renderer;


    //Take exam menu
    private static final int TAKE_EXAME = 1;
    private static final int TAKE_AUTOMATIC_EXAME = 2;
    // Courses Menu
    private static final int COURSE_OPEN = 1;

    // Meeting Menu
    private static final int SCHEEDULE_MEETING = 1;
    public MainMenu() {
        menu = buildMainMenu();
        renderer = getRenderer(menu);
    }

    private MenuRenderer getRenderer(final Menu menu) {
        final MenuRenderer theRenderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            theRenderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            theRenderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return theRenderer;
    }

    @Override
    public boolean doShow() {
        return renderer.render();
    }

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu(ECourseRoles.STUDENT);

        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.STUDENT)) {
            final Menu coursesMenu = buildCoursesMenu();
            final Menu examsMenu = buildExamsMenu();
            final Menu MeetingsMenu = buildMeetingMenu();
            final Menu takeExamMenu = buildTakeExamMenu();

            mainMenu.addSubMenu(STUDENT_COURSES_OPTION, coursesMenu);
            mainMenu.addSubMenu(STUDENT_EXAMS_OPTION, examsMenu);
            mainMenu.addSubMenu(STUDENT_MEETING_OPTION, MeetingsMenu);
            mainMenu.addSubMenu(TAKE_EXAM, takeExamMenu);
        }


        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildTakeExamMenu() {
        final Menu studentMenu = new Menu("TakeExam  >");
        studentMenu.addItem(TAKE_EXAME, "Take a Exam", new TakeExamUI()::show);
        studentMenu.addItem(TAKE_AUTOMATIC_EXAME, "Take A AUTOMATIC Exam", new TakeAutomaticExamUI()::show);
        studentMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return studentMenu;
    }

    private Menu buildMeetingMenu() {
        final Menu studentMenu = new Menu("Meeting  >");
        studentMenu.addItem(SCHEEDULE_MEETING, "Schedule a meeting", new ScheduleMeetingsUI()::show);
        studentMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return studentMenu;
    }

    private Menu buildCoursesMenu() {
        final Menu studentMenu = new Menu("Courses  >");
        studentMenu.addItem(COURSE_OPEN, "List All Courses", new ListCoursesStudentUI()::show);
        studentMenu.addItem(SIGNUP_FOR_A_CURSE_OPTION, "Request Enrollment", new RequestEnrollmentCoursesStudentUI());
        studentMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return studentMenu;
    }

    private Menu buildExamsMenu() {
        final Menu studentMenu = new Menu("Exams  >");

        studentMenu.addItem(VIEW_STUDENT_EXAMS_LIST_OPTION, "View my Exams", new ListExamsUI()::show);
        studentMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return studentMenu;
    }

}
