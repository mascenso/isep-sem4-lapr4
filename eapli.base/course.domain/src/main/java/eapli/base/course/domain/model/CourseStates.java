package eapli.base.course.domain.model;

public final class CourseStates {

    private static final String OPEN = "Open";
    private static final String CLOSE = "Close";
    private static final String ENROLL = "Enroll";
    private static final String PROGRESS = "Progress";

    public static String[] stateValues (){
        return new String[]{OPEN,CLOSE,ENROLL,PROGRESS};
    }
}
