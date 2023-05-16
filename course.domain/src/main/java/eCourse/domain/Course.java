package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class Course implements AggregateRoot<Designation> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    @Embedded
    private Designation name;

    @Embedded
    private Description description;

    @Embedded
    private CourseEdition edition;

    @Embedded
    private CourseStates state;

    protected Course (final Designation name, final Description description, final CourseEdition edition, CourseStates state){
        Preconditions.noneNull(name,description,edition,state);

        this.name = name;
        this.edition = edition;
        this.state= state;
        this.description = description;
    }

    protected Course(){
        //for ORM only
    }

    public Designation designation (){return name;}

    public Description description (){return description;}

    public CourseStates state (){return state;}

    public CourseEdition edition (){return edition;}

    public CourseStates updateState(CourseStates newState) {
        if (!this.state.equals(newState)) {
            this.state = newState;
        }
        return newState;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Course)) {
            return false;
        }

        final Course otherCourse = (Course) other;

        return name.equals(otherCourse.name)
                && description.equals(otherCourse.description)
                && edition.equals(otherCourse.edition)
                && state.equals(otherCourse.state);
    }

    @Override
    public Designation identity() {
        return name;
    }

    public CourseStates getCourseState() {
        return state;
    }



}
