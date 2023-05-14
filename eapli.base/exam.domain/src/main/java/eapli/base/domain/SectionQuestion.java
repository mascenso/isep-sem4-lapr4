package eapli.base.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.*;


@Entity
public class SectionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sequence_section_id")
    private SequenceSection sequenceSection;


    @ManyToOne
    private Question question;

    protected SectionQuestion() {
        //for ORM only
    }

    public SectionQuestion(final SequenceSection sequenceSection, final Question question) {
        Preconditions.noneNull(sequenceSection, question);
        this.sequenceSection = sequenceSection;
        this.question = question;
    }
}
