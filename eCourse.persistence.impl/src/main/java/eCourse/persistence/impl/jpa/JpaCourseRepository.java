package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Course;
import eCourse.domain.CourseEdition;
import eCourse.repositories.CourseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaCourseRepository  extends JpaAutoTxRepository<Course, CourseEdition,CourseEdition>
implements CourseRepository {


    public JpaCourseRepository(final TransactionalContext autoTx) {
        super(autoTx, "CourseName");
    }

    public JpaCourseRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "CourseName");
    }
    @Override
    public Iterable<Course> findAllCourses() {
        return null;
    }

    @Override
    public Optional<Course> findByDesignation(final Designation name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.name=:name", params);
    }

    @Override
    public Optional<Course> ofIdentity(Designation id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Designation entityId) {

    }
}
