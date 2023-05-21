package eCourse.app.manager.console.presentation;

import eCourse.app.common.console.presentation.authz.LoginUI;
import eCourse.usermanagement.domain.ECourseRoles;
import eapli.framework.actions.ChainedAction;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * @author Paulo Gandra Sousa
 */
public class FrontMenu extends AbstractUI {

    private static final int EXIT_OPTION = 0;

    private static final int LOGIN_OPTION = 1;

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
        final Menu menu = new Menu();
        menu.addItem(LOGIN_OPTION, "Login", new ChainedAction(new LoginUI(
                ECourseRoles.STUDENT)::show, () -> {
            new MainMenu().mainLoop();
            return true;
        }));
        //TODO: instead of leaving the app, return to the main menu again
        menu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        final MenuRenderer renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    @Override
    public String headline() {
        return "eCourse";
    }
}

