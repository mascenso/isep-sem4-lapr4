import eCourse.domain.*;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class QuestionTest {

    private QuestionType questionType1;
    private QuestionType questionType2;
    private Course course1;
    private Course course2;
    private Question question1;
    private Question question2;
    private File file1;
    private File file2;
    private String description1;
    private String description2;

    @BeforeEach
    public void setUp() {
        questionType1 = QuestionType.MULTIPLE_CHOICE;
        questionType2 = QuestionType.SHORT_ANSWER;
        course1 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("LPROG")).edition(CourseEdition.valueOf("2022/2023"))
                .state(CourseState.valueOf("Open")).build();
        course2 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("EAPLI")).edition(CourseEdition.valueOf("2022/2023"))
                .state(CourseState.valueOf("Open")).build();
        file1 = new File("question1.pdf");
        file2 = new File("question2.pdf");
        description1 = "testing1";
        description2 = "testing2";

        question1 = new QuestionBuilder().theQuestionType(questionType1).theFile(file1).theCourse(course1)
                .theDescription(description1).build();
        question2 = new QuestionBuilder().theQuestionType(questionType2).theFile(file2).theCourse(course2)
                .theDescription(description2).build();
    }


    @Test
    public void testIfQuestionTypeIsCorrect(){
        assertEquals(questionType1, question1.getQuestionType());
        assertEquals(questionType2, question2.getQuestionType());
        assertNotEquals(questionType1, question2.getQuestionType());
    }

    @Test
    public void testIfFileIsCorrect(){
        assertEquals(file1, question1.getFile());
        assertEquals(file2, question2.getFile());
        assertNotEquals(file1, question2.getFile());
    }

    @Test
    public void testIfCourseIsCorrect(){
        assertEquals(course1, question1.getQuestionCourse());
        assertEquals(course2, question2.getQuestionCourse());
        assertNotEquals(course1, question2.getQuestionCourse());
    }
    @Test
    public void testIfDescriptionIsCorrect(){
        assertEquals(description1, question1.getQuestionDescription());
        assertEquals(description2, question2.getQuestionDescription());
        assertNotEquals(description1, question2.getQuestionDescription());
    }

    @Test
    public void testCreateQuestion() {

        Question question = new QuestionBuilder().theQuestionType(questionType1).theFile(file1).theCourse(course1)
                .theDescription(description1).build();

        assertEquals(questionType1, question.getQuestionType());
        assertEquals(course1, question.getQuestionCourse());
        assertEquals(file1, question.getFile());
        assertEquals(description1, question.getQuestionDescription());
    }

    @Test
    public void testUpdateQuestion() {
        Question question = new QuestionBuilder().theQuestionType(questionType1).theFile(file1).theCourse(course1)
                .theDescription(description1).build();

        File newFile = new File("updated_question.pdf");
        QuestionType newQuestionType = QuestionType.TRUE_FALSE;
        Course newCourse = course1;

        question.updateQuestion(newFile, newQuestionType, newCourse);

        assertEquals(newFile, question.getFile());
        assertEquals(newQuestionType, question.getQuestionType());
        assertEquals(newCourse, question.getQuestionCourse());
    }

    @Test
    public void testEqualsQuestions() {
        Question question1 = new QuestionBuilder().theQuestionType(questionType1).theFile(file1).theCourse(course1)
                .theDescription(description1).build();
        Question question2 = new QuestionBuilder().theQuestionType(questionType1).theFile(file1).theCourse(course1)
                .theDescription(description1).build();

        assertTrue(question1.sameAs(question2));
    }

    @Test
    public void testNotEqualsQuestions() {
        Question question1 = new QuestionBuilder().theQuestionType(questionType1).theFile(file1).theCourse(course1)
                .theDescription(description1).build();
        Question question2 = new QuestionBuilder().theQuestionType(questionType2)
                .theFile(file2).theCourse(course2)
                .theDescription(description1).build();

        assertFalse(question1.sameAs(question2));
    }

}
