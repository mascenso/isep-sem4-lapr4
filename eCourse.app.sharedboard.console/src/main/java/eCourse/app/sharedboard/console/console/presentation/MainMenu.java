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
package eCourse.app.sharedboard.console.console.presentation;

import eCourse.Application;
import eCourse.app.common.console.presentation.authz.MyUserMenu;
import eCourse.app.sharedboard.console.console.presentation.meals.BookAMealThruKioskUI;
import eCourse.app.sharedboard.console.console.presentation.sharedboard.*;
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

public class MainMenu extends AbstractUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int SHAREDBOARD_OPTION=2;

    //SHAREDBOARD
    private static final int CREATE_BOARD_OPTION = 1;
    private static final int LIST_BOARDS_OPTION = 2;
    private static final int BOOK_A_MEAL = 99;
    private static final int SHARE_A_BOARD=3;
    private static final int BOARD_NOTIFICATION=4;
    private static final int UPDATE_SHARED_BOARD=5;
    private static final int CREATE_POST_IT=6;


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

        final Menu myUserMenu = new MyUserMenu(ECourseRoles.STUDENT);

        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.STUDENT, ECourseRoles.TEACHER, ECourseRoles.ADMIN)) {
            final Menu SharedBoardMenu =buildSharedBoardMenu();
            mainMenu.addSubMenu(SHAREDBOARD_OPTION,SharedBoardMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }



    private Menu buildSharedBoardMenu() {
        final Menu menu = new Menu("Boards >");
        menu.addItem(CREATE_BOARD_OPTION, "Create board", new SharedBoardUI()::show);
        menu.addItem(LIST_BOARDS_OPTION, "List Boards", new ListSharedBoardUI()::show);


        menu.addItem(SHARE_A_BOARD, "Share a board", new ShareABoardUI()::show);
        menu.addItem(UPDATE_SHARED_BOARD,"Update a board", new UpdateSharedBoardUI()::show);
        menu.addItem(BOARD_NOTIFICATION, "My notifications", new NotificationUI()::show);

        menu.addItem(CREATE_POST_IT, "Create post-it", new CreateAPostItUI()::show);

        menu.addItem(BOOK_A_MEAL, "BookaMealExampleCafet", new BookAMealThruKioskUI()::show);
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return menu;
    }

}
