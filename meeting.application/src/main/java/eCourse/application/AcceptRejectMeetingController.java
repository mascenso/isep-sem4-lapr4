package eCourse.application;
import eCourse.domain.ParticipantsOfMeeting;
import eCourse.domain.ParticipantsStatus;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.MeetingRequestRepository;
import eapli.framework.validations.Preconditions;

public class AcceptRejectMeetingController {
    private ParticipantMeetingService participantMeetingService = new ParticipantMeetingService();
    private final MeetingRequestRepository meetingRequestRepository = PersistenceContext.repositories().meetingResquests();

    public ParticipantsOfMeeting acceptMeetingRequest(final ParticipantsOfMeeting participantsOfMeeting, final ParticipantsStatus newStatus){

        Preconditions.nonNull(participantsOfMeeting);
        participantsOfMeeting.accept();
        return meetingRequestRepository.save(participantsOfMeeting);
    }

    public ParticipantsOfMeeting rejectMeetingRequest(final ParticipantsOfMeeting participantsOfMeeting, final ParticipantsStatus newStatus){

        Preconditions.nonNull(participantsOfMeeting);
        participantsOfMeeting.reject();
        return meetingRequestRepository.save(participantsOfMeeting);
    }

    public Iterable<ParticipantsOfMeeting> listMeetingsByUser(){
        return participantMeetingService.getMeetingsByUser();
    }

}
