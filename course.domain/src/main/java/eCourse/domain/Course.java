package eCourse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course implements AggregateRoot<Designation> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCourse;

    @Embedded
    private Designation name;

    @Embedded
    private Description description;

    @Embedded
    private CourseEdition edition;

    @Embedded
    private CourseState state;

    @ManyToOne
    private SystemUser teacherCoordinator;

    /**
     * Teachers in a course.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private final Set<TeachersInCourse> teachers = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Course_Student",
            joinColumns = {@JoinColumn(name = "IDCOURSE")},
            inverseJoinColumns = {@JoinColumn(name = "NUMBER")}
    )
    Set<Student> students = new HashSet<>();

    protected Course (final Designation name, final Description description, final CourseEdition edition, SystemUser teacherCordinator){
        Preconditions.noneNull(name,description,edition);

        this.name = name;
        this.edition = edition;
        this.state= new CourseState("Close");
        this.description = description;
        this.teacherCoordinator = teacherCordinator;
    }

    protected Course(){
        //for ORM only
    }

    public Designation designation (){return name;}

    public Description description (){return description;}

    public CourseState state (){return state;}

    public CourseEdition edition (){return edition;}

    public String cordinator (){return teacherCoordinator.name().toString();}

    /*public CourseState updateState(CourseState newState) {
        if (!this.state.equals(newState)) {
            this.state = newState;
        }
        return newState;
    }*/

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Course)) {
            return false;
        }

        final Course otherCourse = (Course) other;

        return name.equals(otherCourse.name)
                && description.equals(otherCourse.description)
                && edition.equals(otherCourse.edition)
                && state.equals(otherCourse.state);
    }

    @Override
    public Designation identity() {
        return name;
    }


    public CourseState getCourseState() {
        return state;
    }

    public void open() {
        state = new CourseState("Open");
    }

    public void progress() {
        state = new CourseState("Progress");
    }

    public void enroll() {
        state = new CourseState("Enroll");
    }

    public void close() {
        state = new CourseState("Close");
    }
    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    public boolean addStudent(Student student) {
        return this.students.add(student);
    }

    public boolean addAllStudent(List<Student> students) {
        return this.students.addAll(students);
    }

    /**
     *
     * @param teacher
     * @return
     */
    public boolean addTeacher(Teacher teacher) {
        return this.teachers.add(new TeachersInCourse(teacher));
    }

    public Set<TeachersInCourse> teachers() {
        return teachers;
    }

    public void addTeachers(Set<Teacher> teachersOfCourse) {
        for (Teacher teacher : teachersOfCourse) {
            this.teachers.add(new TeachersInCourse(teacher));
        }
    }
}
