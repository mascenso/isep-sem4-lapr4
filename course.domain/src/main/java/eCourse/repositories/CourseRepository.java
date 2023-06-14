package eCourse.repositories;

import eCourse.domain.Course;
import eCourse.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CourseRepository extends DomainRepository<Designation, Course>{

    Iterable<Course> findAllCourses();


    Optional<Course> findByDesignation(Designation name);

    Iterable<Course> findByTeacher(Teacher teacher);
}
