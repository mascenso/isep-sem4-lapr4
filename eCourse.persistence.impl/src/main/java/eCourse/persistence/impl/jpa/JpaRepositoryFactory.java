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
package eCourse.persistence.impl.jpa;

import eCourse.repositories.*;

import eCourse.Application;
import eCourse.studentusermanagement.repositories.SignupRequestRepository;
import eCourse.infrastructure.persistence.RepositoryFactory;

import eCourse.lesson.domain.repositories.RecurringLessonRepository;
import eCourse.studentusermanagement.repositories.StudentUserRepository;
import eCourse.teacherusermanagement.repositories.TeacherUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * @author nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public UserRepository users(final TransactionalContext autoTx) {
		return new JpaAutoTxUserRepository(autoTx);
	}

	@Override
	public UserRepository users() {
		return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}

	@Override
	public JpaStudentUserRepository clientUsers(final TransactionalContext autoTx) {
		return new JpaStudentUserRepository(autoTx);
	}

	@Override
	public JpaStudentUserRepository clientUsers() {
		return new JpaStudentUserRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
		return new JpaSignupRequestRepository(autoTx);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public JpaSharedBoardRepository sharedBoards() {
		return new JpaSharedBoardRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public CourseRepository courses() {
		return new JpaCourseRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ExamRepository exams() {
		return new JpaExamRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public QuestionRepository questions() {
		return new JpaQuestionRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public RecurringLessonRepository recurringLessons() { return new JpaRecurringLessonRepository(Application.settings().getPersistenceUnitName());}

	@Override
	public MeetingsRepository meetings()  {
		return new JpaMeetingRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public CourseEnrollmentRequestRepository courseEnrollmentRequests() {
		return new JpaCourseEnrollmentRequestRepository(Application.settings().getPersistenceUnitName());
	}



	@Override
	public StudentUserRepository studentUsers() {
		return new JpaStudentUserRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TeacherUserRepository teacherUsers() {
		return new JpaTeacherUserRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public StudentRepository students() {
		return new JpaStudentRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}

}
