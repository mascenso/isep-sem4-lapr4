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
package eCourse.app.teacher.console.presentation;

import eCourse.app.common.console.presentation.authz.MyUserMenu;
import eCourse.Application;
import eCourse.app.teacher.console.presentation.RecurringLessons.CreateRecurringLessonsUI;
import eCourse.app.teacher.console.presentation.RecurringLessons.UpdateScheduleRecurringLessonUI;
import eCourse.app.teacher.console.presentation.exam.CreateExamUI;
import eCourse.app.teacher.console.presentation.exam.UpdateExamUI;
import eCourse.usermanagement.domain.ECourseRoles;
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
    private static final String RETURN_LABEL = "Return ";


    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int EXAMS_OPTION = 2;
    private static final int CLASSES_OPTION = 3;
    private static final int RECURRING_LESSON_OPTION = 4;


    // EXAMS

    private static final int ADD_NEW_EXAM_OPTION = 1;
    private static final int UPDATE_EXAM_OPTION = 2;

    //RECURRING LESSONS

    private static final int CREATE_RECURRING_LESSON_OPTION = 1;
    private static final int UPDATE_SCHEDULE_RECURRING_LESSON_OPTION = 2;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final Menu menu;
    private final MenuRenderer renderer;

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

        final Menu myUserMenu = new MyUserMenu(ECourseRoles.TEACHER);
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.POWER_USER, ECourseRoles.TEACHER)) {
            final Menu examsMenu = buildExamsMenu();
            mainMenu.addSubMenu(EXAMS_OPTION, examsMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.POWER_USER, ECourseRoles.TEACHER)) {
            final Menu classesMenu = buildClassesMenu();
            mainMenu.addSubMenu(CLASSES_OPTION, classesMenu);

        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.POWER_USER, ECourseRoles.TEACHER)) {

            final Menu recurringLessonMenu = buildRecurringLessonMenu();
            mainMenu.addSubMenu(RECURRING_LESSON_OPTION, recurringLessonMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildExamsMenu() {
        final Menu menu = new Menu("Exam >");

        menu.addItem(ADD_NEW_EXAM_OPTION, "Create Exam", new CreateExamUI()::show);
        menu.addItem(UPDATE_EXAM_OPTION, "Update Exam", new UpdateExamUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildClassesMenu() {
        final Menu teacherMenu = new Menu("Classes  >");

        teacherMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return teacherMenu;
    }

    private Menu buildRecurringLessonMenu() {
        final Menu menu = new Menu("Recurring Lesson >");

        menu.addItem(CREATE_RECURRING_LESSON_OPTION, "Create Recurring Lesson", new CreateRecurringLessonsUI()::show);
        menu.addItem(UPDATE_SCHEDULE_RECURRING_LESSON_OPTION, "Update Recurring Lesson", new UpdateScheduleRecurringLessonUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }


}
