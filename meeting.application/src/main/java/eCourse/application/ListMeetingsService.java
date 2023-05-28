package eCourse.application;

import eCourse.domain.Course;
import eCourse.domain.Meeting;
import eCourse.domain.MeetingStatus;
import eCourse.domain.ParticipantsOfMeeting;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.commons.collections4.IteratorUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Meeting> ListMeetingThatUserCreated(SystemUser user) {
        List <Meeting> listMeetingUser = new ArrayList<>();
        List <Meeting> allMeetings = (List<Meeting>) PersistenceContext.repositories().meetings().findAll();

        for (int i = 0; i < allMeetings.size(); i++) {

            if(allMeetings.get(i).meetingCreator().identity().toString().equalsIgnoreCase( user.identity().toString()) &&
            allMeetings.get(i).meetingStatus() == MeetingStatus.SCHEDULE){
                listMeetingUser.add(allMeetings.get(i));
            }
        }
        return listMeetingUser;
    }

    public Iterable<Meeting> getMeetingsByUser(Optional<SystemUser> user) {
        Iterable<Meeting> meetingIterable = PersistenceContext.repositories().meetings().findByUsername(user.get().identity());
        List<Meeting> meetingListByUser = IteratorUtils.toList(meetingIterable.iterator());

        return  meetingListByUser;
    }
}
