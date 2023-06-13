package eCourse.domain.postit;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.util.Arrays;

@Embeddable
public class PostItContent implements ValueObject {

    @Column(name="Content")
    private String textContent;

    @Lob
    private byte[] image;

    public PostItContent() {
        textContent = null;
    }

    public PostItContent(final String textContent, final byte[] image) {
        this(textContent);
        Preconditions.nonNull(image);

        changeImage(image);
    }

    public PostItContent(String textContent) {
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


    public String getDescription() {
        return String.format(textContent);
    }
}
