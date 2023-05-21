package eCourse.course.application;

import eCourse.MechanographicNumber;
import eCourse.domain.Student;
import eCourse.domain.StudentBuilder;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.UUID;

public class StudentManagementService {
    private final StudentRepository studentRepository = PersistenceContext.repositories().students();

    public Student registerNewStudent(SystemUser user) {

        String uuid = UUID.randomUUID().toString();//TODO replace by a correct implementation of the MechanographicNumber

        MechanographicNumber number = MechanographicNumber.valueOf(uuid);

        Student student = new StudentBuilder()
                .systemUser(user)
                .mechanographicNumber(number).build();

        return studentRepository.save(student);
    }
}
