import eCourse.domain.*;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class MeetingTest {

    private String name1 = "Meeting 1";
    private String name2 = "Meeting 2";
    private String date1 = "20/10/2020 10:10";
    private String date2 = "20/10/2020 10:10";

    private String date3 = "25/10/2020 10:10";
    private int duration1 = 10;
    private int duration2 = 20;
    private int duration3 = 10;

    private String user = "Miguel";
    private List<SystemUser> participants = new ArrayList<>();

    final Set<Role> roles = new HashSet<>();

    private SystemUser systemUser = null;

    Meeting Meeting1 = new MeetingBuilder().duration(duration1).named(Designation.valueOf("Meeting 1")).schedule(new Date(date1)).MeetingCreator(systemUser).participants( participants).build();
    Meeting Meeting2 = new MeetingBuilder().duration(duration2).named(Designation.valueOf("Meeting 2")).schedule(new Date(date2)).MeetingCreator(systemUser).participants( participants).build();
    Meeting Meeting3 = new MeetingBuilder().duration(duration3).named(Designation.valueOf("Meeting 1")).schedule(new Date(date3)).MeetingCreator(systemUser).participants( participants).build();



    @Test
    public void testIfDesignationIsCorrect() {
        assertEquals(name1, Meeting1.designation().toString());
        assertEquals(name2, Meeting2.designation().toString());
    }

    @Test
    public void testIfScheduleIsCorrect() {
        assertEquals(new Date(date1), Meeting1.dateOfMeeting());
        assertEquals(new Date(date2), Meeting2.dateOfMeeting());
        assertEquals(new Date(date3), Meeting3.dateOfMeeting());
    }


    @Test
    public void testIFMeetingIsEqualToAnotherMeeting() {


        assertFalse(Meeting1.sameAs(Meeting2));
        assertFalse(Meeting2.sameAs(Meeting3));
        assertTrue(Meeting1.sameAs(Meeting3));
    }
}