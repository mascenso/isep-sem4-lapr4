package eCourse.domain.postit;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Embeddable
public class PostItId implements ValueObject, Comparable<PostItId> {

    private Long id;


    @Override
    public int compareTo(PostItId o) {

        return id.compareTo(o.id);
    }
}
