package eCourse.infrastructure.bootstrapers.demo;

import eCourse.*;
import eCourse.domain.ECourseRoles;
import eCourse.domain.SBColumn;
import eCourse.domain.SBRow;
import eCourse.domain.SharedBoard;
import eCourse.domain.enums.AccessType;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.io.util.Console;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;

public class SharedBoardBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(SharedBoardBootstrapper.class);


    CreateSharedBoardController createSharedBoardController = new CreateSharedBoardController();
    ShareABoardController shareABoardController = new ShareABoardController();
    private final UserManagementService userManagementService = AuthzRegistry.userService();
    private final CreatePostItController createPostItController = new CreatePostItController();


    @Override
    public boolean execute() {

        List<SBRow> linhas = new ArrayList<>();
        List<SBColumn> colunas = new ArrayList<>();

        List<SBRow> linhas2 = new ArrayList<>();
        List<SBColumn> colunas2 = new ArrayList<>();

        colunas.add(new SBColumn("Todo"));
        colunas.add(new SBColumn("Doing"));
        colunas.add(new SBColumn("Done"));

        colunas2.add(new SBColumn("Testing"));
        colunas2.add(new SBColumn("Ta La Quase"));

        linhas.add(new SBRow("Linha1"));
        linhas.add(new SBRow("Linha2"));
        linhas.add(new SBRow("Linha3"));
        linhas2.add(new SBRow("LinhaA"));
        linhas2.add(new SBRow("LinhaB"));

        SharedBoard sharedBoard = createSharedBoardController.addSharedBoard(
                "Warm Board", 3, 3, colunas, linhas);

        SharedBoard sharedBoard2 = createSharedBoardController.addSharedBoard(
                "Cool Board", 2, 2, colunas2, linhas2);

        addSharedBoardUsers(sharedBoard);
        addSharedBoardUsers(sharedBoard2);

        addPostIt(sharedBoard, 0, 0, "Lalalala", "download.png");
        addPostIt(sharedBoard, 0, 1, "Projeto integration");
        addPostIt(sharedBoard, 0, 2, "Mariana");

        addPostIt(sharedBoard2, 1, 0, "Sao Joao Sao Joao");
        addPostIt(sharedBoard2, 1, 1, "Postei");



        return true;
    }

    private SystemUser getUser(final Username name) {
        SystemUser u = userManagementService.userOfIdentity(name).orElseThrow(IllegalStateException::new);
        return u;
    }

    private void addSharedBoardUsers(SharedBoard sharedBoard){

        Map<SystemUser, AccessType> usersSB = new HashMap<>();
        usersSB.put(getUser(Username.valueOf("poweruser")), AccessType.WRITE);
        usersSB.put(getUser(Username.valueOf("student1")), AccessType.WRITE);
        usersSB.put(getUser(Username.valueOf("student2")), AccessType.WRITE);
        usersSB.put(getUser(Username.valueOf("student3")), AccessType.WRITE);
        usersSB.put(getUser(Username.valueOf("student4")), AccessType.WRITE);
        usersSB.put(getUser(Username.valueOf("student5")), AccessType.WRITE);
        usersSB.put(getUser(Username.valueOf("teacher01")), AccessType.WRITE);
        usersSB.put(getUser(Username.valueOf("teacher02")), AccessType.WRITE);
        usersSB.put(getUser(Username.valueOf("teacher03")), AccessType.WRITE);

        shareABoardController.createShareBoardUsersNoThread(usersSB, sharedBoard);
    }


    private void addPostIt(SharedBoard theBoard, int x, int y, String textContent, final String imageFilename) {

        // getting the input stream is a responsibility of the presentation layer
        final InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(imageFilename);

        if (inputStream == null) {
            LOGGER.warn("Could not load image {}", imageFilename);
            // fallback to registration without image
            addPostIt(theBoard, x, y, textContent);
        }
        else{
            try {
                createPostItController.registerPostIt(theBoard, x, y, textContent, inputStream);
                LOGGER.info(textContent + " registered.");
            } catch (final IOException e) {
                LOGGER.warn("Assuming {} already exists (activate trace log for details)", textContent);
                LOGGER.trace("Assuming existing record", e);
            }
        }
    }

    private void addPostIt(SharedBoard theBoard, int x, int y, String textContent) {
        try {
            createPostItController.registerPostIt(theBoard, x, y, textContent);
            LOGGER.info(textContent + " registered.");
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", textContent);
            LOGGER.trace("Assuming existing record", e);
        }
    }



}