package eCourse.domain.postit;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Embeddable
public class Position implements ValueObject {

    public final Integer horCoord;
    public final Integer vertCoord;

    public Position(Integer horCoord, Integer vertCoord) {
        this.horCoord = horCoord;
        this.vertCoord = vertCoord;
    }
    public Position() {
        this(null, null);
    }

    public Position(String coordEncoded) { //1,2
        String pos[] = coordEncoded.split(",");
        horCoord = Integer.parseInt(pos[0]);
        vertCoord = Integer.parseInt(pos[1]);
    }


    @Override
    public String toString() {
        return String.format("[%d,%d]", horCoord, vertCoord);
    }

}
