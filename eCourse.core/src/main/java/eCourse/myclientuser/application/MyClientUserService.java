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
package eCourse.myclientuser.application;

import java.util.Optional;

import eCourse.studentusermanagement.domain.StudentUser;
import eCourse.studentusermanagement.repositories.StudentUserRepository;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 *
 * @author Paulo Gandra de Sousa
 */
public class MyClientUserService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final StudentUserRepository repo = PersistenceContext.repositories().clientUsers();

    public StudentUser me() {
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser myUser = s.authenticatedUser();
        // TODO cache the client user object
        final Optional<StudentUser> me = repo.findByUsername(myUser.identity());
        return me.orElseThrow(IllegalStateException::new);
    }

    public StudentUser myUser() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.STUDENT);
        final UserSession s = authz.session().orElseThrow(IllegalStateException::new);
        final SystemUser me = s.authenticatedUser();
        return repo.findByUsername(me.identity()).orElseThrow(IllegalStateException::new);
    }

}
