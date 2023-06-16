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

import eCourse.AddStudentUserController;
import eCourse.AddTeacherController;
import eCourse.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.framework.actions.Action;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Paulo Sousa
 */
public class StudentUserBootstrapper implements Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentUserBootstrapper.class);

	private final AddStudentUserController addStudentUserController = new AddStudentUserController();
	private final AddTeacherController addTeacherController = new AddTeacherController();

	@Override
	public boolean execute() {

		Set<Role> roleStu= new HashSet<>();
		roleStu.add(ECourseRoles.STUDENT);

		Set<Role> roleTea= new HashSet<>();
		roleTea.add(ECourseRoles.TEACHER);

		addStudentUserController.addStudentUser("student1", "Password1", "Mary", "Rock", "mary@isep.ipp.pt", roleStu , "111111111", LocalDate.of(1990, 1, 1));
		addStudentUserController.addStudentUser("student2", "Password1", "Michael", "Rock", "michael@isep.ipp.pt",  roleStu , "222222222", LocalDate.of(1993, 3, 10));
		addStudentUserController.addStudentUser("student3", "Password1", "Patty", "Tex", "patty@isep.ipp.pt",  roleStu , "333333333", LocalDate.of(1993, 5, 20));
		addStudentUserController.addStudentUser("student4", "Password1", "Michael", "Cards", "cards@isep.ipp.pt",  roleStu , "444444444", LocalDate.of(1995, 7, 30));
		addStudentUserController.addStudentUser("student5", "Password1", "Armands", "Fons", "armands@isep.ipp.pt",  roleStu , "555555555", LocalDate.of(1992, 9, 10));

		addTeacherController.addTeacher("teacher01", "Password1", "John", "Doe", "teacher1@isep.ipp.pt", roleTea , "abc");
		addTeacherController.addTeacher("teacher02", "Password1", "Jane", "Doe", "teacher2@isep.ipp.pt", roleTea , "def");
		addTeacherController.addTeacher("teacher03", "Password1", "John", "Smith", "teacher2@isep.ipp.pt", roleTea , "ghi");

		return true;
	}

}
