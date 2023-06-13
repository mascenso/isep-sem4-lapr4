package eCourse.domain.postit;

import eCourse.domain.Coluna;
import eCourse.domain.Linha;
import eCourse.domain.SharedBoard;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
@Table(name = "T_POST_IT")
public class PostIt implements AggregateRoot<PostItId> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PostItId id;

    @Embedded
    private  PostItTitle title;

    @Embedded
    PostItContent description;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private SharedBoard shareBoard;

    @JoinColumn(name = "row_id")
    private Linha row;

    @JoinColumn(name = "column_id")
    private Coluna column;


    public PostIt(PostItId id, PostItTitle title, PostItContent description, SharedBoard shareBoard, Linha row, Coluna column) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.shareBoard = shareBoard;
        this.row = row;
        this.column = column;
    }

    public PostIt() {

    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(PostItId other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public PostItId identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(PostItId id) {
        return AggregateRoot.super.hasIdentity(id);
    }


}
