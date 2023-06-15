# US1010 - As Teacher, I want to schedule a class

## 1. Requirements Engineering


### 1.1. User Story Description

A teacher schedule a class (always a recurring class, happens every week). System must check if the Teacher is available for the class period.

### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**
* Teachers are responsible for scheduling classes for their courses. 
* A class is always a recurring weekly event.
* A class must have a unique title, a date and a duration. 
* It should be impossible to schedule classes that are coincident with other classes of the same course. 
* The system should also warn if one of the participants in the class (either a teacher or a student) has other classes at the same time. [...]


**From the client clarifications:**

> **Question**
> 
> Bom dia!
> Nestas duas US, pretende que seja mostrada a lista de Class/ExtraClass que já estão agendadas para que o professor saiba onde pode agendar?

>  **Answer**
> 
> Boa tarde.
> Em termos de requisitos é importante que o sistema garanta as regras que estão descritas em 5.1.2 relativo a aulas e aulas extra. Em termos de user interface para cada um desses casos de uso não existem requisitos específicos.
> Nesse aspeto de "user experience" devem seguir boas práticas. Mas isso já faz parte do desenho da solução. "O cliente não percebe muito disso :-)"
>

> **Question**
>
> Good afternoon, I've a question regarding the shedule of a class. A teacher can only schedule classes to a given course that he/her is in?
 
>  **Answer**
> 
> Bom dia.
> Por favor siga o processo que indiquei em https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=22571#p28540 antes de colocar a questão.

> **Question:**
>
> Good afternoon, I've a question regarding the shedule of a class and of an extra class.
> Is it possible (or there should be a warning) to schedule a class and/or an extra class when a student and/or teacher, that will be part of it, have a meeting at the same time that the class will happen? 

> **Answer:**
>
> Bom dia.
> Por favor siga o processo que indiquei em https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=22571#p28540 antes de colocar a questão.

> **Question:** 

> Dear Client,
> The teacher that schedules the class is the one that will give it, or can one teacher schedule a class that will be assigned to another teacher?
> Best regards,

> **Answer:** 
>
>Bom dia.
>Por favor siga o processo que indiquei em https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=22571#p28540 antes de colocar a questão.

### 1.3. Acceptance Criteria

* **FRC09:** Schedule of Class A teacher schedule a class (always a recurring class, happens every week). System must check if the Teacher is available for the class period

The user needs to be logged in the application as a teacher.


### 1.4. Found out Dependencies

* There is a dependency to "US1001 - As Manager, I want to be able to register, disable/enable, and list users of the system (Teachers and Students, as well as Managers)
* There is a dependency to "US01002 - As Manager, I want to create courses
* There is a dependency to "US1005 - As Manager, I want to set the teachers of a course

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* Title
    * Start Date
    * End Date
    * Start Time
    * Duration
    * Frequency


**Output Data:**

* Recurring Lesson

### Analysis

* User Interface - This class is named CreateRecurringLessonUI where it will allow the teacher to create a recurring lesson.
* Controller     - This class is named RecurringLessonController where will be responsible for managing UI requests and performing the necessary actions to create the recurring lesson.
* Repository     - This class is named RecurringLessonRepository where it will store the data about the Recurring Lessons
* Service        - ScheduleLessonService that propagates the recurring lesson with a certain frequency and validates that the teacher doesnt have a lesson in that date/time

*Below is the use case diagram to show the interactions between the manager and the system when open and close courses*

![Use Case Diagram](US1010-UCD.svg "US1010 Use Case Diagram")

### 1.6. System Sequence Diagram (SSD)

![US06_SSD](US1010-SSD.svg)

### 1.7 Other Relevant Remarks


## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**


| Interaction ID | Question: Which class is responsible for... | Answer                    | Justification (with patterns)                                                                                                                        |
|:---------------|:--------------------------------------------|:--------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------|
| Step 1         | ... interacting with the actor?             | CreateRecurringLessonUI   | UI pattern: CreateRecurringLessonUI is responsible for interacting with the actor                     |
|                | ... coordinating the US?                    | RecurringLessonController | Controller pattern: RecurringLessonController is responsible for coordinating the use case and invoking necessary classes.                           |
| Step 2         | .. return list of courses                   | RecurringLessonRepository | Repository pattern: RecurringLessonRepository is responsible for saving the recurring lesson in the database.                                        |
| Step 3         | .. propagates the lesson and validates      | ScheduleLessonService     | Service: ScheduleRecurringLesson is responsible propagating the lesson for a certain frequency and validates the teacher availability for the lesson |


### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * RecurringLesson

Other software classes (i.e. Pure Fabrication) identified: 

 * CreateRecurringLessonController
 * ScheduleLessonService
 * RecurringLessonRepository

## 3.2. Sequence Diagram (SD)

![US06_SD](US1010-SD.svg)


## 3.3. Class Diagram (CD)

![US06_CD](US1010-CD.svg)

# 4. Tests

## ReccurringLessonTest

    public class RecurringLessonTest {

    private RecurringLesson lesson1;
    private RecurringLesson lesson2;
    private RecurringLesson lesson3;
    private Designation title1;
    private Designation title2;
    private Role TEACHER;
    private Set<Role> roles1 = new HashSet<>();
    private SystemUser teacher;
    private Teacher teacher1;
    private Teacher teacher2;
    private Course course1;
    private Course course2;
    private Calendar startDate1;
    private Calendar startDate2;
    private Calendar endDate1;
    private Calendar endDate2;
    private LocalTime startTime1;
    private LocalTime startTime2;
    private int duration1;
    private int duration2;
    private int frequency1;
    private int frequency2;
    private LocalDate occurrences1;
    private LocalDate occurrences2;

    @BeforeEach
    public void setUp() throws ParseException {
        title1 = Designation.valueOf("EAPLI-2NA");
        title2 = Designation.valueOf("EAPLI-2NB");
        TEACHER = Role.valueOf("TEACHER");
        roles1.add(TEACHER);
        SystemUser teacher = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder()).with("Mig", "teste", "Miguel", "Seixas", "miguel@isep.pt").withRoles(roles1).build();
        teacher1 = new TeacherBuilder().withAcronym("MMA").withSystemUser(teacher).build();
        teacher2 = new TeacherBuilder().withAcronym("MSE").withSystemUser(teacher).build();
        course1 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("ESOFT")).edition(CourseEdition.valueOf("2022/2023")).teacherCoordinator(teacher).build();
        course2 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("EAPLI")).edition(CourseEdition.valueOf("2022/2023")).teacherCoordinator(teacher).build();
        startDate1 = Calendar.getInstance();
        startDate2 = Calendar.getInstance();
        endDate1 = Calendar.getInstance();
        endDate2 = Calendar.getInstance();
        startTime1 = LocalTime.parse("10:00");
        startTime2 = LocalTime.parse("11:00");
        duration1 = 50;
        duration2 = 60;
        frequency1 = 2;
        frequency2 = 3;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        occurrences1 = LocalDate.parse("01/05/2023", formatter);
        occurrences2 = LocalDate.parse("02/05/2023", formatter);


        lesson1 = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        lesson2 = new RecurringLessonBuilder().titled(title2).responsible(teacher2).teachedAt(course2).starting(startDate2).ending(endDate2)
                .startingAt(startTime2).lasts(duration2).ocurringAt(frequency2).happensAt(occurrences2).build();
        lesson3 = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();

    }

    @Test
    public void testIfRecurringLessonTitleIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Teacher nullTeacher = null;
            new RecurringLessonBuilder().titled(title1).responsible(nullTeacher).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).build();
        });
    }

    @Test
    public void testIfRecurringLessonResponsibleIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Designation nullTitle = null;
            new RecurringLessonBuilder().titled(nullTitle).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).build();
        });
    }

    @Test
    public void testIfRecurringLessonCourseIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Course nullCourse = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(nullCourse).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        });
    }

    @Test
    public void testIfRecurringLessonStartDateIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Calendar nullStartDate = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(nullStartDate).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        });
    }

    @Test
    public void testIfRecurringLessonEndDateIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Calendar nullEndDate = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(nullEndDate)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        });
    }

    @Test
    public void testIfRecurringLessonStartTimeIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            LocalTime nullStartTime = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(nullStartTime).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();
        });
    }

    @Test
    public void testIfRecurringLessonOccurrencesIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            LocalDate nullOccurrence = null;
            new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(nullOccurrence).build();
        });
    }

    @Test
    public void testIfAllParametersAreFilled() {
        assertDoesNotThrow(() -> {
            RecurringLesson recurringLesson = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                    .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();

            assertEquals(title1, recurringLesson.title());
            assertEquals(course1, recurringLesson.recurringLessonCourse());
            assertEquals(teacher1, recurringLesson.responsibleTeacher());
            assertEquals(startDate1, recurringLesson.startDate());
            assertEquals(endDate1, recurringLesson.endDate());
            assertEquals(startTime1, recurringLesson.startTime());
            assertEquals(duration1, recurringLesson.duration());
            assertEquals(frequency1, recurringLesson.frequency());
            assertEquals(occurrences1, recurringLesson.occurrences());
        });
    }

    @Test
    public void testIfRecurringLessonTitleIsCorrect() {
        assertEquals(title1, lesson1.title());
        assertEquals(title2, lesson2.title());
        assertNotEquals(title2, lesson1.title());
    }

    @Test
    public void testIfRecurringLessonCourseIsCorrect() {
        assertEquals(course1, lesson1.recurringLessonCourse());
        assertEquals(course2, lesson2.recurringLessonCourse());
        assertNotEquals(course2, lesson1.recurringLessonCourse());
    }

    @Test
    public void testIfRecurringLessonTeacherIsCorrect() {
        assertEquals(teacher1, lesson1.responsibleTeacher());
        assertEquals(teacher2, lesson2.responsibleTeacher());
        assertNotEquals(teacher2, lesson1.responsibleTeacher());
    }

    @Test
    public void testIfRecurringLessonStartDateIsCorrect() {
        assertEquals(startDate1, lesson1.startDate());
        assertEquals(startDate2, lesson2.startDate());
    }

    @Test
    public void testIfRecurringLessonEndDateIsCorrect() {
        assertEquals(endDate1, lesson1.endDate());
        assertEquals(endDate2, lesson2.endDate());
    }

    @Test
    public void testIfRecurringLessonStartTimeIsCorrect() {
        assertEquals(startTime1, lesson1.startTime());
        assertEquals(startTime2, lesson2.startTime());
        assertNotEquals(startTime2, lesson1.startTime());
    }

    @Test
    public void testIfRecurringLessonDurationIsCorrect() {
        assertEquals(duration1, lesson1.duration());
        assertEquals(duration2, lesson2.duration());
        assertNotEquals(duration2, lesson1.duration());
    }

    @Test
    public void testIfRecurringLessonFrequencyIsCorrect() {
        assertEquals(frequency1, lesson1.frequency());
        assertEquals(frequency2, lesson2.frequency());
        assertNotEquals(frequency2, lesson1.frequency());
    }

    @Test
    public void testIfRecurringLessonOccurrencesIsCorrect() {
        assertEquals(occurrences1, lesson1.occurrences());
        assertEquals(occurrences2, lesson2.occurrences());
        assertNotEquals(occurrences2, lesson1.occurrences());
    }

    @Test
    public void testCreateRecurringLesson() {
        RecurringLesson recurringLesson = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();

        assertEquals(title1, recurringLesson.title());
        assertEquals(course1, recurringLesson.recurringLessonCourse());
        assertEquals(teacher1, recurringLesson.responsibleTeacher());
        assertEquals(startDate1, recurringLesson.startDate());
        assertEquals(endDate1, recurringLesson.endDate());
        assertEquals(startTime1, recurringLesson.startTime());
        assertEquals(duration1, recurringLesson.duration());
        assertEquals(frequency1, recurringLesson.frequency());
        assertEquals(occurrences1, recurringLesson.occurrences());
    }

    @Test
    public void testUpdateRecurringLesson() {
        RecurringLesson recurringLesson = new RecurringLessonBuilder().titled(title1).responsible(teacher1).teachedAt(course1).starting(startDate1).ending(endDate1)
                .startingAt(startTime1).lasts(duration1).ocurringAt(frequency1).happensAt(occurrences1).build();


        Calendar newStartDate = Calendar.getInstance();
        Calendar newEndDate = Calendar.getInstance();
        int newDuration = 45;

        recurringLesson.updateScheduleOfLesson(newStartDate, newEndDate, newDuration);

        assertEquals(newStartDate, recurringLesson.startDate());
        assertEquals(newEndDate, recurringLesson.endDate());
        assertEquals(newDuration, recurringLesson.duration());
    }

    @Test
    public void testEqualsRecurringLessons() {

        assertTrue(lesson1.sameAs(lesson3));
    }

    @Test
    public void testNotEqualsRecurringLessons() {

        assertFalse(lesson1.sameAs(lesson2));
    }


    }

# 5. Construction (Implementation)

## Class RecurringLesson

    @XmlRootElement
    @Entity
    public class RecurringLesson implements AggregateRoot<Designation>, Representationable {
    /**
    * The primary key of lesson is the unique title
    */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecurringLesson;


    @XmlElement
    @JsonProperty
    private Designation title;

    @ManyToOne
    private Teacher recurringLessonTeacher;

    @ManyToOne
    private Course recurringLessonCourse;

    @OneToMany(mappedBy = "recurringLesson", cascade = CascadeType.ALL)
    private List<ParticipantsOfRecurringLesson> participants;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar startDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar endDate;

    //@Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private int frequency;

    private LocalDate occurrences;

    /*
    @ElementCollection
    @CollectionTable(name = "occurrence", joinColumns = @JoinColumn(name = "recurring_lesson_id"))
    @Column(name = "occurrence_datetime", nullable = false)
    private List<LocalDateTime> occurrences;
     */
    protected RecurringLesson(Teacher recurringLessonTeacher, Course recurringLessonCourse, Designation title, Calendar startDate, Calendar endDate, LocalTime startTime, int duration, int frequency, LocalDate occurrences) {
        Preconditions.noneNull(title, startDate, endDate, startTime, duration, frequency);
        this.recurringLessonTeacher = recurringLessonTeacher;
        this.recurringLessonCourse = recurringLessonCourse;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.duration = duration;
        this.frequency = frequency;
        this.occurrences = occurrences;
    }

    protected RecurringLesson() {
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof RecurringLesson)) {
            return false;
        }

        final RecurringLesson that = (RecurringLesson) other;
        if (this == that) {
            return true;
        }
        return recurringLessonTeacher.equals(that.recurringLessonTeacher) && recurringLessonCourse.equals(that.recurringLessonCourse) && identity().equals(that.identity()) && startDate.equals(that.startDate) && endDate.equals(that.endDate) &&
        startTime == that.startTime && duration == that.duration && frequency == that.frequency;
    }

    @Override
    public <R> R buildRepresentation(final RepresentationBuilder<R> builder) {
        return null;
    }

    public Teacher responsibleTeacher() { return this.recurringLessonTeacher; }

    public Course recurringLessonCourse() { return this.recurringLessonCourse; }

    @Override
    public Designation identity() { return this.title; }

    public Designation title() { return this.title;}

    public Calendar startDate() { return this.startDate;}

    public Calendar endDate() { return this.endDate;}

    public LocalTime startTime() { return this.startTime;}

    public int duration() { return this.duration;}

    public int frequency() { return this.frequency;}

    public LocalDate occurrences() { return this.occurrences;}

    public RecurringLesson updateScheduleOfLesson(Calendar startDate, Calendar endDate, int duration){
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        return this;
    }
}


# 6. Integration and Demo 
/-

# 7. Observations
/-





