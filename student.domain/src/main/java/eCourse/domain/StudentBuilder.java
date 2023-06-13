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
package eCourse.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDate;

public class StudentBuilder implements DomainFactory<Student> {

    private SystemUser systemUser;
    private MecanographicNumber mecanographicNumber;
    private TaxPayNumber taxPayNumber;
    private Birthdate birthDate;

    public StudentBuilder withSystemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    public StudentBuilder withMecNumber(final MecanographicNumber mecNumber) {
        this.mecanographicNumber = mecNumber;
        return this;
    }

    public StudentBuilder withTaxPayNumber(final String taxPayNumber) {
        this.taxPayNumber = new TaxPayNumber(taxPayNumber);
        return this;
    }

    public StudentBuilder withBirthDate(final LocalDate birthDate) {
        this.birthDate = Birthdate.valueOf(birthDate);
        return this;
    }

    @Override
    public Student build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        return new Student(this.systemUser, this.mecanographicNumber, this.taxPayNumber, this.birthDate);
    }

    public Student build(SystemUser systemUser, String aMecanographicNumber) {
        return new Student(systemUser, new MecanographicNumber(aMecanographicNumber));
    }


}
