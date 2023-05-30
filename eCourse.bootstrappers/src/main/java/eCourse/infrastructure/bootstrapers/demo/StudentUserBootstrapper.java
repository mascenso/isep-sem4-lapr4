/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eCourse.infrastructure.bootstrapers.demo;

import eCourse.infrastructure.bootstrapers.TestDataConstants;
import eCourse.studentusermanagement.application.AddStudentUserController;
import eCourse.teacherusermanagement.application.AddTeacherUserController;
import eCourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eCourse.studentusermanagement.application.AcceptRefuseSignupFactory;
import eCourse.studentusermanagement.application.AcceptRefuseSignupRequestController;
import eCourse.studentusermanagement.domain.SignupRequest;
import eCourse.myclientuser.application.SignupController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Paulo Sousa
 */
public class StudentUserBootstrapper implements Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentUserBootstrapper.class);

	private final AddStudentUserController addStudentUserController = new AddStudentUserController();
	private final AddTeacherUserController addTeacherUserController = new AddTeacherUserController();

	@Override
	public boolean execute() {

		Set<Role> roleStu= new HashSet<>();
		roleStu.add(ECourseRoles.STUDENT);

		Set<Role> roleTea= new HashSet<>();
		roleTea.add(ECourseRoles.TEACHER);

		addStudentUserController.addStudentUser("student1", "Password1", "Mary", "Rock", "mary@isep.ipp.pt", roleStu , "111111111");
		addStudentUserController.addStudentUser("student2", "Password1", "Michael", "Rock", "michael@isep.ipp.pt",  roleStu , "222222222");
		addStudentUserController.addStudentUser("student3", "Password1", "Patty", "Tex", "patty@isep.ipp.pt",  roleStu , "333333333");
		addStudentUserController.addStudentUser("student4", "Password1", "Michael", "Cards", "cards@isep.ipp.pt",  roleStu , "444444444");
		addStudentUserController.addStudentUser("student5", "Password1", "Armands", "Fons", "armands@isep.ipp.pt",  roleStu , "555555555");

		addTeacherUserController.addTeacherUser("teacher1", "Password1", "John", "Doe", "teacher1@isep.ipp.pt", roleTea , "abc");
		addTeacherUserController.addTeacherUser("teacher2", "Password1", "Jane", "Doe", "teacher2@isep.ipp.pt", roleTea , "def");
		addTeacherUserController.addTeacherUser("teacher3", "Password1", "John", "Smith", "teacher2@isep.ipp.pt", roleTea , "ghi");

		return true;
	}

}
