package eCourse.repositories;

import eCourse.domain.Meeting;
import eCourse.domain.ParticipantsOfMeeting;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

public interface MeetingRequestRepository extends DomainRepository<Username, ParticipantsOfMeeting> {
    Iterable<ParticipantsOfMeeting> pendingMeetingRequests();

    Iterable<ParticipantsOfMeeting> findByUsername(final Username name);

    Iterable<ParticipantsOfMeeting> findByMeeting(final Meeting meeting);
}
