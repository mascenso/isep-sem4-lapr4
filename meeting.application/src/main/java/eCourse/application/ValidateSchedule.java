package eCourse.application;

import eCourse.domain.Meeting;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidateSchedule {

    ListMeetingsService service = new ListMeetingsService();
    /**
     * For now this returns true only but in the future it will be to validate that no participant
     * has class or another meeting at the same time as the meeting
     * @param participants
     * @param schedule
     * @return
     */
    public boolean validateScheduleForAllParticipants(List<SystemUser> participants, Date schedule, int duration){
        List<Meeting> meetingsOfUsers = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            meetingsOfUsers = service.getMeetingsOfUser(participants.get(i));
        }

        for (int i = 0; i < meetingsOfUsers.size(); i++) {


            if (meetingsOfUsers.get(0).dateOfMeeting().getTime()==schedule.getTime()){

                return false;
            }
        }
        return true;
    }
}
