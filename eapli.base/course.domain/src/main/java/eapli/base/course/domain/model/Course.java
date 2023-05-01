package eapli.base.course.domain.model;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.identities.IdentityGenerators;
import eapli.framework.validations.Preconditions;

public class Course implements AggregateRoot<String> {

    private Designation name;

    private IdentityGenerators id;

    private Description description;

    private CourseEdition edition;

    private CourseStates state;
    protected Course (final Designation name, final IdentityGenerators id, final Description description, final CourseEdition edition, CourseStates state){
        Preconditions.noneNull(name, id,description,edition,state);

        this.name = name;
        this.id = id;
        this.edition = edition;
        this.state= state;
        this.description = description;
    }

    protected Course(){
        //for ORM only
    }

    public Designation designation (){return name;}

    public IdentityGenerators id (){return id;}

    public Description description (){return description;}

    public CourseStates state (){return state;}

    public CourseEdition edition (){return edition;}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return null;
    }
}
