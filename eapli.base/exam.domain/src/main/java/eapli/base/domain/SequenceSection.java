package eapli.base.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "section_question")
public class SequenceSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int sectionNumber;

    private String description;
    @ManyToOne
    private Exam exam;
    @ManyToOne
    private Question question;
    @OneToMany(mappedBy = "sequenceSection", cascade = CascadeType.ALL)
    private List<SectionQuestion> sectionQuestions = new ArrayList<>();

    protected SequenceSection(final int sectionNumber, final String description, final List<Question> questionsList) {
        Preconditions.noneNull(sectionNumber, sectionQuestions);
        this.sectionNumber = sectionNumber;
        this.description = description;
        for (Question question : questionsList) {
            this.sectionQuestions.add(new SectionQuestion(this, question));
        }
    }

    protected SequenceSection() {
        //for ORM only
    }

    public static SequenceSection valueOf(final int sectionNumber, final String description, final List<Question> questionsList) {
        Preconditions.nonEmpty(String.valueOf(sectionNumber), "Section Number cannot be empty");
        return new SequenceSection(sectionNumber, description, questionsList);
    }
}
