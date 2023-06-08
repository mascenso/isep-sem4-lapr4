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
package eCourse.persistence.impl.inmemory;

import eCourse.lesson.domain.repositories.RecurringLessonRepository;
import eCourse.repositories.*;
import eCourse.infrastructure.bootstrapers.BaseBootstrapper;
import eCourse.infrastructure.persistence.RepositoryFactory;
import eCourse.repositories.TeacherUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

public class InMemoryRepositoryFactory implements RepositoryFactory {

	static {
		// only needed because of the in memory persistence
		new BaseBootstrapper().execute();
	}

	@Override
	public UserRepository users(final TransactionalContext tx) {
		return new InMemoryUserRepository();
	}

	@Override
	public UserRepository users() {
		return users(null);
	}

	@Override
	public StudentUserRepository clientUsers(final TransactionalContext tx) {

		return new InMemoryClientUserRepository();
	}

	@Override
	public StudentUserRepository clientUsers() {
		return clientUsers(null);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}


	@Override
	public MeetingRequestRepository meetingResquests() {
		return null;
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}

	@Override
	public SharedBoardRepository sharedBoards() {
		return null;
	}

	@Override
	public CourseRepository courses() {
		return null;
	}

	@Override
	public ExamRepository exams() {
		return null;
	}

	@Override
	public QuestionRepository questions() {
		return null;
	}

	@Override
	public RecurringLessonRepository recurringLessons() { return null;}

	@Override
	public MeetingsRepository meetings() {
		return null;
	}

	@Override
	public StudentUserRepository studentUsers() {
		return null;
	}

	@Override
	public TeacherUserRepository teacherUsers() {
		return null;
	}

	@Override
	public NotificationRepository notifications() {
		return null;
	}

	@Override
	public CourseEnrollmentRequestRepository courseEnrollmentRequests() { return null;}

	@Override
	public SharedBoardUserRepository sharedBoardUser() {
		return null;
	}


	@Override
	public GradesRepository gradesForExam() {
		return null;
	}


}
