package eapli.base.domain;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import org.springframework.stereotype.Component;

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

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Designation identity() {
        return name;
    }
}
