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
package eCourse.app.backoffice.console.presentation.students;

import eCourse.AddStudentUserController;
import eCourse.app.user.console.presentation.myuser.UserDataWidget;
import eCourse.usermanagement.application.ECourseRoles;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.Set;

/**
 * UI for adding a user to the application.
 *
 * Created by nuno on 22/03/16.
 */
public class AddStudentUI extends AbstractUI {

    private final AddStudentUserController theController = new AddStudentUserController();

    @Override
    protected boolean doShow() {
        final UserDataWidget userData = new UserDataWidget();

        userData.show();

        final String taxPayNumber = Console.readLine("Tax Pay Number:");

        final String birthDate = Console.readLine("Birth Date dd/mm/yyyy:");


        final Set<Role> roleTypes = new HashSet<>();
        roleTypes.add(ECourseRoles.STUDENT);

        try {
            this.theController.addStudentUser(
                    userData.username(),
                    userData.password(),
                    userData.firstName(),
                    userData.firstName(),
                    userData.email(),
                    roleTypes,
                    taxPayNumber
                    );
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That username is already in use.");
        }

        return false;
    }



    @Override
    public String headline() {
        return "Add User";
    }
}
