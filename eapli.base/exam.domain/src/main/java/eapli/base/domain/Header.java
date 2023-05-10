package eapli.base.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Header {


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

}
