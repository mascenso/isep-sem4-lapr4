package eCourse.domain.postit;

import eCourse.domain.Coluna;
import eCourse.domain.Linha;
import eCourse.domain.SharedBoard;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Arrays;

public class PostIt implements ValueObject{

    private final String textContent;

    @Lob
    private byte[] image;

    public PostIt() {
        textContent = null;
    }

    public PostIt(final String textContent, final byte[] image) {
        this(textContent);
        Preconditions.nonNull(image);
        changeImage(image);
    }

    public PostIt(String textContent) {
        Preconditions.nonNull(textContent);
        this.textContent = textContent;
    }

    public byte[] image() {
        // defensive copy
        return Arrays.copyOf(image, image.length);
    }

    public void changeImage(final byte[] image) {
        // defensive copy
        this.image = Arrays.copyOf(image, image.length);
    }

    public boolean hasImage() {
        return image != null && image.length != 0;
    }

    public String getDescription() {
        return String.format(textContent);
    }

    @Override
    public String toString() {
        return String.format("PostIt with text content %s; has image? %s", textContent, hasImage());
    }

}
