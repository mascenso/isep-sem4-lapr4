package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.course.application.CreateCourseController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

public class CreateCourseUI extends AbstractUI {

    private final CreateCourseController theController = new CreateCourseController();
    @Override
    protected boolean doShow() {
        final String name = Console.readNonEmptyLine("Name","The name should not be empty");
        final String edition = Console.readNonEmptyLine("Edition","The edition should not be empty");
        final String description = Console.readNonEmptyLine("Description","The description should not be empty");

        String show = null;

        do {
            show = showStates();
        } while(show == null);

        final String state = show;

        theController.createCourse(name,edition,description,state);
        return false;
    }

    private String showStates(){
        final String [] courseStates = buildCourseStates();
        for (int i = 0; i < courseStates.length; i++) {
            System.out.println("("+i+") " + courseStates[i]);
        }
        int choose = Console.readInteger("State");
        return choose < courseStates.length ? courseStates[choose] : null;
    }

    private String [] buildCourseStates() {
        final String [] courseStates = theController.getCourseStates();
        return courseStates;
    }
/*
    private boolean showStates(String state){
        final Menu courseStates = buildCourseStates();
        final MenuRenderer renderer = new VerticalMenuRenderer(courseStates,MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildCourseStates() {
        final Menu courseStates = new Menu();
        int counter = 0;
        courseStates.addItem(MenuItem.of(counter++, "No State", Actions.SUCCESS));
        for (final String states : theController.getCourseStates()) {
            courseStates.addItem(MenuItem.of(counter++, states, Actions.SUCCESS));
        }
        return courseStates;
    }
    */

    @Override
    public String headline() {
        return "Create new course";
    }
}
