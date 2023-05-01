package eapli.base.course.domain.model;

import eapli.framework.validations.Preconditions;

public class CourseEdition {

    private final String edition;

    protected CourseEdition(final String yearEdition){this.edition = yearEdition;}

    protected CourseEdition(){this.edition="";}

    public static CourseEdition valueOf(final String yearEdition){
        Preconditions.nonEmpty(yearEdition, "Edition cannot be empty");
        return new CourseEdition(yearEdition);
    }

}
