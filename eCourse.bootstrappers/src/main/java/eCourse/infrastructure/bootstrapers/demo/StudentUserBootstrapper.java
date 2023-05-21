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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eCourse.studentusermanagement.application.AcceptRefuseSignupFactory;
import eCourse.studentusermanagement.application.AcceptRefuseSignupRequestController;
import eCourse.studentusermanagement.domain.SignupRequest;
import eCourse.myclientuser.application.SignupController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

/**
 *
 * @author Paulo Sousa
 */
public class StudentUserBootstrapper implements Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentUserBootstrapper.class);

	private final SignupController signupController = new SignupController();
	private final AcceptRefuseSignupRequestController acceptController = AcceptRefuseSignupFactory.build();

	@Override
	public boolean execute() {
		// some users that signup and are approved
		signupAndApprove(TestDataConstants.USER_TEST1, "Password1", "John", "Smith", "john@smith.com",
				TestDataConstants.USER_TEST1);
		signupAndApprove("student1", "Password1", "Mary", "Rock", "mary@isep.ipp.pt", "202300001");
		signupAndApprove("student2", "Password1", "Michael", "Rock", "michael@isep.ipp.pt", "202300002");
		signupAndApprove("student3", "Password1", "Patty", "Tex", "patty@isep.ipp.pt", "202300003");
		signupAndApprove("student4", "Password1", "Michael", "Cards", "cards@isep.ipp.pt", "202300004");
		signupAndApprove("student5", "Password1", "Armands", "Fons", "armands@isep.ipp.pt", "202300005");

		// some users that signup but the approval is pending. use the backoffice
		// application to approve these
		signup("isep111", "Password1", "Mary", "Smith One", "mary1@smith.com", "202311111");
		signup("isep222", "Password1", "Mary", "Smith Two", "mary2@smith.com", "202322222");
		signup("isep333", "Password1", "Mary", "Smith Three", "mary3@smith.com", "202333333");
		signup("isep444", "Password1", "Mary", "Smith Four", "mary4@smith.com", "202344444");

		return true;
	}

	private SignupRequest signupAndApprove(final String username, final String password, final String firstName,
			final String lastName, final String email, final String mecanographicNumber) {
		SignupRequest request = null;
		try {
			request = signupController.signup(username, password, firstName, lastName, email, mecanographicNumber);
			acceptController.acceptSignupRequest(request);
		} catch (final ConcurrencyException | IntegrityViolationException e) {
			// ignoring exception. assuming it is just a primary key violation
			// due to the tentative of inserting a duplicated user
			LOGGER.warn("Assuming {} already exists (activate trace log for details)", username);
			LOGGER.trace("Assuming existing record", e);
		}
		return request;
	}

	private SignupRequest signup(final String username, final String password, final String firstName,
			final String lastName, final String email, final String mecanographicNumber) {
		SignupRequest request = null;
		try {
			request = signupController.signup(username, password, firstName, lastName, email, mecanographicNumber);
		} catch (final ConcurrencyException | IntegrityViolationException e) {
			// ignoring exception. assuming it is just a primary key violation
			// due to the tentative of inserting a duplicated user
			LOGGER.warn("Assuming {} already exists (activate trace log for details)", username);
			LOGGER.trace("Assuming existing record", e);
		}
		return request;
	}
}
