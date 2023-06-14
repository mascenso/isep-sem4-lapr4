package eCourse.infrastructure.bootstrapers.demo;

import eCourse.CreateSharedBoardController;
import eCourse.domain.*;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import java.util.*;

public class SharedBoardBootstrapper implements Action {

    CreateSharedBoardController createSharedBoardController = new CreateSharedBoardController();
    private final UserManagementService userManagementService = AuthzRegistry.userService();

    @Override
    public boolean execute() {

        List<Linha> linhas = new ArrayList<>();
        List<Coluna> colunas = new ArrayList<>();

        List<Linha> linhas2 = new ArrayList<>();
        List<Coluna> colunas2 = new ArrayList<>();

        colunas.add(new Coluna("Todo"));
        colunas.add(new Coluna("Doing"));
        colunas.add(new Coluna("Done"));
        colunas2.add(new Coluna("BlaBla"));
        colunas2.add(new Coluna("Ta La Quase"));

        linhas.add(new Linha("Linha1"));
        linhas.add(new Linha("Lalala"));
        linhas.add(new Linha("Amendoins"));
        linhas2.add(new Linha("Coco"));
        linhas2.add(new Linha("Meet the team"));

        createSharedBoardController.addSharedBoard(
                "Treino Canino", 3, 3, colunas, linhas);

        createSharedBoardController.addSharedBoard(
                "Treino Equino", 2, 2, colunas, linhas);
        return true;
    }




}