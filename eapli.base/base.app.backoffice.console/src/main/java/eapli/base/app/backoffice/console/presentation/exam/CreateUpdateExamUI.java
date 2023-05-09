package eapli.base.app.backoffice.console.presentation.exam;

import eapli.base.exam.application.CreateUpdateExamController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class CreateUpdateExamUI extends AbstractUI {

    private final CreateUpdateExamController createUpdateExamController = new CreateUpdateExamController();

    protected boolean doShow() {
        final Integer numberOfSections = Integer.valueOf(Console.readNonEmptyLine("Number of Sections","The number of sections should not be empty!"));
        final Integer numberOfQuestions = Integer.valueOf(Console.readNonEmptyLine("Number of Questions","The number of questions should not be empty!"));
        final String description = Console.readNonEmptyLine("Description","The description should not be empty");

        String show = null;

        do {
            show = showStates();
        } while(show == null);

        final String state = show;

        theController.createCourse(name,edition,description,state);
        return false;
    }

    @Override
    public String headline() {
        return "Create/Update Exam";
    }
}
