package eapli.base.application;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Date;
import java.util.List;

public class ValidateSchedule {

    /**
     * For now this returns true only but in the future it will be to validate that no participant
     * has class or another meeting at the same time as the meeting
     * @param participants
     * @param schedule
     * @return
     */
    public boolean validateScheduleForAllParticipants(List<SystemUser> participants, Date schedule, int duration){
        return true;
    }
}
