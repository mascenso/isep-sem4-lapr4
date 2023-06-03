package eCourse.domain;


public final class BaseCourseStates {
    public static final CourseState OPEN = CourseState.valueOf("Open"); // event open (->state open) +  event close (-> state closed)
    public static final CourseState CLOSE = CourseState.valueOf("Close"); // event create (-> state close)
    public static final CourseState ENROLL = CourseState.valueOf("Enroll"); // event open enrollments (-> state enroll)
    public static final CourseState PROGRESS = CourseState.valueOf("Progress"); //  event close enrollments (-> state in progress)

    public static CourseState[] allCourseStates() {
        return new CourseState[]{OPEN, CLOSE, ENROLL, PROGRESS};
    }
}
