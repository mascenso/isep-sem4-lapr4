package eCourse.infrastructure.bootstrapers.demo;

import eCourse.CreateSharedBoardController;
import eCourse.domain.valueobjects.SBColumn;
import eCourse.domain.valueobjects.SBRow;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import java.util.*;

public class SharedBoardBootstrapper implements Action {

    CreateSharedBoardController createSharedBoardController = new CreateSharedBoardController();
    private final UserManagementService userManagementService = AuthzRegistry.userService();

    @Override
    public boolean execute() {

        List<SBRow> linhas = new ArrayList<>();
        List<SBColumn> colunas = new ArrayList<>();

        List<SBRow> linhas2 = new ArrayList<>();
        List<SBColumn> colunas2 = new ArrayList<>();

        colunas.add(new SBColumn("Todo"));
        colunas.add(new SBColumn("Doing"));
        colunas.add(new SBColumn("Done"));
        colunas2.add(new SBColumn("BlaBla"));
        colunas2.add(new SBColumn("Ta La Quase"));

        linhas.add(new SBRow("Linha1"));
        linhas.add(new SBRow("Lalala"));
        linhas.add(new SBRow("Amendoins"));
        linhas2.add(new SBRow("Coco"));
        linhas2.add(new SBRow("Meet the team"));

        createSharedBoardController.addSharedBoard(
                "Treino Canino", 3, 3, colunas, linhas);

        createSharedBoardController.addSharedBoard(
                "Treino Equino", 2, 2, colunas, linhas);
        return true;
    }




}