package eCourse.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class CourseBuilder implements DomainFactory<Course> {

    private Course theCourse;

    private Designation name;

    private Description description;

    private CourseEdition edition;

    private SystemUser teacherCordinator;


    public CourseBuilder named(final Designation name){
        this.name = name;
        return this;
    }

    public CourseBuilder descriptioned (final Description description){
        this.description = description;
        return this;
    }

    public CourseBuilder edition(final CourseEdition edition){
        this.edition = edition;
        return this;
    }
    public CourseBuilder teacherCoordinator (final SystemUser teacher){
        this.teacherCordinator = teacher;
        return this;
    }

    private Course buildOrThrow() {
        // we will create the actual instance inside the builder during the building
        // process, but that is hidden from the client code. conceptually, the client
        // code only sees the new instance (it is only built) in the build method
        if (theCourse != null) {
            return theCourse;
        }
        if (name != null && description != null && edition != null && teacherCordinator != null) {
            theCourse = new Course(name, description,edition, teacherCordinator);
            return theCourse;
        }
        throw new IllegalStateException();

    }
    @Override
    public Course build() {
        final var ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do
        // not change the previously built course.
        theCourse = null;
        return ret;
    }
}
