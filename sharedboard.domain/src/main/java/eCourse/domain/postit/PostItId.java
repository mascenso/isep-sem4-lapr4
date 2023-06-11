package eCourse.domain.postit;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PostItId implements ValueObject, Comparable<PostItId> {
@Column(name= "id")
    private Long id;


    @Override
    public int compareTo(PostItId o) {

        return id.compareTo(o.id);
    }
}
