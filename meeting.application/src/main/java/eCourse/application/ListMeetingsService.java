package eCourse.application;

import eCourse.domain.Course;
import eCourse.domain.Meeting;
import eCourse.domain.ParticipantsOfMeeting;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class ListMeetingsService {

    public Iterable<Meeting> allMeetings(){

        return PersistenceContext.repositories().meetings().findAll();
    }

    public List<Meeting> getMeetingsOfUser(SystemUser user) {
        List<Meeting> allMeetings = (List<Meeting>) PersistenceContext.repositories().meetings().findAll();
        List<Meeting> meetingsOfUser = new ArrayList<>();

        for (Meeting meeting: allMeetings) {
            if(findUserOnMeetings(meeting.participants(),user)){
                meetingsOfUser.add(meeting);
            }
        }
        return meetingsOfUser;
    }

    private boolean findUserOnMeetings(List<ParticipantsOfMeeting> participants, SystemUser user) {
        for (int i = 0; i < participants.size(); i++) {

            if(participants.get(i).identity().equals(user.identity())){
                return true;
            }
        }
        return false;
    }

}
