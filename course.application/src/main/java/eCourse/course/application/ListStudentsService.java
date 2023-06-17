package eCourse.course.application;


import eCourse.domain.Student;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ApplicationService
public class ListStudentsService {


    public Iterable<SystemUser> allUsers() {
        return PersistenceContext.repositories().users().findAll();
    }
    public Optional<Student> findAllStudents(SystemUser user){
        return PersistenceContext.repositories().clientUsers().findByUsername(user.username());
    }



}
