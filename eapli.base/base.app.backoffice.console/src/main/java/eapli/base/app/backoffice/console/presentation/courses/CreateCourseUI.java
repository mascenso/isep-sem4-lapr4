package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.course.application.CreateCourseController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.Set;

public class CreateCourseUI extends AbstractUI {

    private final CreateCourseController theController = new CreateCourseController();
    @Override
    protected boolean doShow() {
        final String id = Console.readLine("id");
        final String name = Console.readLine("Name");
        final String edition = Console.readLine("Edition");
        final String description = Console.readLine("Description");

        boolean show;

        do {
            show = showStates();
        } while(!show);


        return false;
    }

    private boolean showStates(){
        final Menu courseStates = buildCourseStates();
        final MenuRenderer renderer = new VerticalMenuRenderer(courseStates,MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildCourseStates() {
        final Menu courseStates = new Menu();
        int counter = 0;
        courseStates.addItem(MenuItem.of(counter++, "No State", Actions.SUCCESS));
        for (final String state : theController.getCourseStates()) {
            courseStates.addItem(MenuItem.of(counter++, state, Actions.SUCCESS));
        }
        return courseStates;
    }
    @Override
    public String headline() {
        return "Create new course";
    }
}
