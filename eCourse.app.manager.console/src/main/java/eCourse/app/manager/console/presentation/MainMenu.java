package eCourse.app.manager.console.presentation;

import eCourse.app.backoffice.console.presentation.courses.UpdateCourseStateUI;
import eCourse.app.common.console.presentation.authz.MyUserMenu;
import eCourse.Application;
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

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int COURSES_OPTION = 2;
    private static final int STUDENT_EXAMS_OPTION= 3;
    private static final int STUDENT_MEETING_OPTION= 4;

    private static final int VIEW_STUDENT_EXAMS_LIST_OPTION = 2;
    private static final int SIGNUP_FOR_A_CURSE_OPTION = 2;


    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final Menu menu;
    private final MenuRenderer renderer;


    // Courses Menu
    private static final int UPDATE_STATE = 1;

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

        final Menu myUserMenu = new MyUserMenu(ECourseRoles.MANAGER);

        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER)) {
            final Menu coursesMenu = buildCoursesMenu();
            //final Menu examsMenu = buildExamsMenu();
            //final Menu MeetingsMenu = buildMeetingMenu();

            mainMenu.addSubMenu(COURSES_OPTION, coursesMenu);
            //mainMenu.addSubMenu(STUDENT_EXAMS_OPTION, examsMenu);
            //mainMenu.addSubMenu(STUDENT_MEETING_OPTION, MeetingsMenu);
        }


        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    /*private Menu buildMeetingMenu() {
        final Menu studentMenu = new Menu("Meeting  >");
        studentMenu.addItem(SCHEEDULE_MEETING, "Schedule a meeting", new ScheduleMeetingsUI()::show);
        studentMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return studentMenu;
    }*/

    private Menu buildCoursesMenu() {
        final Menu managerMenu = new Menu("Courses  >");
        managerMenu.addItem(UPDATE_STATE, "List All Courses", new UpdateCourseStateUI()::show);
        //studentMenu.addItem(SIGNUP_FOR_A_CURSE_OPTION, "Sign up", new SignupRequestAction());
        managerMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return managerMenu;
    }



}

