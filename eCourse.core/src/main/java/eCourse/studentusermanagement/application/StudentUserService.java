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
package eCourse.studentusermanagement.application;

import eCourse.studentusermanagement.domain.StudentUser;
import eCourse.studentusermanagement.domain.MecanographicNumber;
import eCourse.studentusermanagement.repositories.StudentUserRepository;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

/**
 * @author mcn
 */
public class StudentUserService {

    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();
    private final StudentUserRepository repo =
            PersistenceContext.repositories().clientUsers();

    public Optional<StudentUser> findClientUserByMecNumber(
            final String mecNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER,
                ECourseRoles.ADMIN,
                ECourseRoles.TEACHER);
        return repo.ofIdentity(MecanographicNumber.valueOf(mecNumber));
    }

    public Optional<StudentUser> findClientUserByUsername(
            final Username user) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.POWER_USER,
                ECourseRoles.ADMIN);
        return repo.findByUsername(user);
    }
}