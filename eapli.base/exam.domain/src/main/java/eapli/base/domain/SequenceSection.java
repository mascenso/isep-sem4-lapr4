package eapli.base.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class SequenceSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int sectionNumber;

    @Column(nullable = false)
    private String description;

    @Embedded
    private Question question;

    private List<Question> questionsList = new ArrayList<>();


    protected SequenceSection(final int sectionNumber, final String description, final List<Question> questionsList) {
        Preconditions.noneNull(sectionNumber, questionsList);
        this.sectionNumber = sectionNumber;
        this.description = description;
        this.questionsList=questionsList;

    }


    protected SequenceSection() {
        //for ORM only
    }

    public static SequenceSection valueOf(final int sectionNumber, final String description, final List<Question> questionsList) {
        Preconditions.nonEmpty(String.valueOf(sectionNumber), "Section Number cannot be empty");
        Preconditions.nonEmpty(description, "Description cannot be empty");
        return new SequenceSection(sectionNumber, description, questionsList);
    }


}
