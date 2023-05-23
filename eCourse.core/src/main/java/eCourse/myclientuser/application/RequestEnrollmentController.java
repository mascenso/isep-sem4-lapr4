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
package eCourse.myclientuser.application;

import java.util.Calendar;

import eCourse.domain.Course;
import eCourse.studentusermanagement.domain.SignupRequest;
import eCourse.studentusermanagement.domain.SignupRequestBuilder;
import eCourse.studentusermanagement.domain.StudentUser;
import eCourse.studentusermanagement.repositories.RequestEnrollmentRepository;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.domain.UserBuilderHelper;
import eapli.framework.application.UseCaseController;
import eapli.framework.time.util.CurrentTimeCalendars;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@UseCaseController
public class RequestEnrollmentController {

	private final RequestEnrollmentRepository signupRequestRepository = PersistenceContext.repositories().enrollmentRequests();
	private final MyStudentUserService myStudentUserService = new MyStudentUserService();

	public SignupRequest requestEnrollment(final Course selCourse, final Calendar createdOn) {

		StudentUser me = myStudentUserService.me();

		final SignupRequestBuilder signupRequestBuilder = UserBuilderHelper.signupBuilder();
		signupRequestBuilder.withData(selCourse, me);

		final SignupRequest newSignupRequest = signupRequestBuilder.build();
		return this.signupRequestRepository.save(newSignupRequest);
	}

	public SignupRequest requestEnrollment(Course selCourse) {
		return requestEnrollment(selCourse, CurrentTimeCalendars.now());
	}
}
