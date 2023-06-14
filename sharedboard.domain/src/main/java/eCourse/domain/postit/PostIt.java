package eCourse.domain.postit;

import eCourse.domain.Coluna;
import eCourse.domain.Linha;
import eCourse.domain.SharedBoard;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

public class PostIt implements ValueObject {

    @Embedded
    private  PostItTitle title;

    @Embedded
    PostItContent description;

    public PostIt(PostItTitle title, PostItContent description) {
        this.title = title;
        this.description = description;
    }

    public PostIt() {

    }


}
