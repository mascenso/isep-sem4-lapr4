package eapli.base.repositories;

import eapli.base.domain.Course;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;

import java.util.Optional;

public interface CourseRepository extends DomainRepository<Designation, Course>{

    Iterable<Course> findAllCourses();


    Optional<Course> findByDesignation(Designation name);
}
