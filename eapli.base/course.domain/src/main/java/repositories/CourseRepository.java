package repositories;

import eapli.base.course.domain.model.Course;
import eapli.framework.domain.repositories.DomainRepository;

public interface CourseRepository extends DomainRepository<String, Course>{

    Iterable<Course> findAllCourses();
}
