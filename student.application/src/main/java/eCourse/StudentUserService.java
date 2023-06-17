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
package eCourse;


import eCourse.domain.MecanographicNumber;
import eCourse.domain.MecanographicNumberDomainService;
import eCourse.domain.Student;
import eCourse.domain.StudentBuilder;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.StudentUserRepository;
import eCourse.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

/**
 * @author mcn
 */
public class StudentUserService {

    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();
    private final StudentUserRepository repo =
            PersistenceContext.repositories().clientUsers();

    private final UserManagementService userService = AuthzRegistry.userService();


    public Optional<Student> findClientUserByMecNumber(
            final String mecNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER,
                ECourseRoles.ADMIN,
                ECourseRoles.TEACHER);
        return repo.ofIdentity(MecanographicNumber.valueOf(mecNumber));
    }

    public Optional<MecanographicNumber> findMaxMecNumber() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER,
                ECourseRoles.ADMIN,
                ECourseRoles.TEACHER);
        return repo.findMaxMecNumber().map(Student::mecanographicNumber);
    }


    public Optional<Student> findClientUserByUsername(
            final Username user) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER,
                ECourseRoles.ADMIN);
        return repo.findByUsername(user);
    }

    /**
     * Creates a new Student for the given SystemUser, and saves it to the
     * repository.
     */
    @Transactional /* Generates a new mec number and saves it to the repository */
    public Student createStudentUser(final SystemUser newUser, final String taxPayNumber, final LocalDate birthDate) {
        final StudentBuilder studentUserBuilder = new StudentBuilder();
        studentUserBuilder
                .withSystemUser(newUser)
                .withTaxPayNumber(taxPayNumber)
                .withBirthDate(birthDate);

        final Optional<MecanographicNumber> maxMecNumber = findMaxMecNumber();

        if (maxMecNumber.isPresent()) {

            studentUserBuilder.withMecNumber( MecanographicNumberDomainService.generateFromLast(maxMecNumber.get()) );

        } else {
            /* First student user */
            studentUserBuilder.withMecNumber( MecanographicNumberDomainService.generateFirst() );
        }

        this.repo.save(studentUserBuilder.build());
        return null;
    }


}
