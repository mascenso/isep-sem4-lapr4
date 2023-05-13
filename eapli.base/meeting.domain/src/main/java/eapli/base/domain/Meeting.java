package eapli.base.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public class Meeting implements AggregateRoot<Designation> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeeting;

    private Designation title;

    private List<SystemUser> participants;

    //duration on minuts
    private int duration;

    //date on format dd/mm/yyyy hh:mm
    private Date schedule;

    public Meeting(Designation name, List<SystemUser> participants, Date schedule, int duration){
        Preconditions.noneNull(name,participants,schedule,duration);

        this.title = name;
        this.participants = participants;
        this.duration = duration;
        this.schedule = schedule;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Designation identity() {
        return title;
    }
}
