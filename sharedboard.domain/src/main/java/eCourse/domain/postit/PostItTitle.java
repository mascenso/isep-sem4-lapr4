package eCourse.domain.postit;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PostItTitle implements ValueObject {
@Column(name="title")
    private String title;

    public String getTitle() {
        return String.format(title);
    }
}
