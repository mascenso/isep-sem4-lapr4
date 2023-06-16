package eCourse.persistence.impl.jpa;

import eCourse.Application;
import eCourse.domain.Meeting;
import eCourse.domain.ParticipantsOfMeeting;
import eCourse.repositories.MeetingRequestRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;

public class JpaMeetingRequestRepository extends JpaAutoTxRepository<ParticipantsOfMeeting, Username, Username>  implements MeetingRequestRepository {
    public JpaMeetingRequestRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "username");

    }

    @Override
    public Iterable<ParticipantsOfMeeting> pendingMeetingRequests() {
        return null;
    }

    @Override
    public Iterable<ParticipantsOfMeeting> findByUsername(Username name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return match("e.participant.username=:name", params);
    }

    @Override
    public Iterable<ParticipantsOfMeeting> findByMeeting(Meeting meeting) {
        final Map<String, Object> params = new HashMap<>();
        params.put("meeting", meeting);
        return match("e.meeting = :meeting", params);
    }
}
