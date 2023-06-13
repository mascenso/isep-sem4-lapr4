import eCourse.domain.*;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExamTest {

    private ExamTitle examTitle1;
    private ExamTitle examTitle2;
    private Exam exam1;
    private Exam exam2;
    private Exam exam3;
    private Course course1;
    private Course course2;
    private Date openDate1;
    private Date closeDate1;
    private Date openDate2;
    private Date closeDate2;
    private File examFile1;
    private File examFile2;

    @BeforeEach
    public void setUp() throws ParseException {
        examTitle1 = ExamTitle.valueOf("LPROG Exam");
        examTitle2 = ExamTitle.valueOf("EAPLI Exam");
        course1 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("LPROG")).edition(CourseEdition.valueOf("2022/2023")).build();
        course2 = new CourseBuilder().descriptioned(Description.valueOf("Course for developers"))
                .named(Designation.valueOf("EAPLI")).edition(CourseEdition.valueOf("2022/2023")).build();
        openDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("05/06/2023");
        closeDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2023");
        openDate2 = new SimpleDateFormat("dd/MM/yyyy").parse("20/07/2023");
        closeDate2 = new SimpleDateFormat("dd/MM/yyyy").parse("25/07/2023");
        examFile1 = new File("lprog_exam.pdf");
        examFile2 = new File("eapli_exam.pdf");

        exam1 = new ExamBuilder().theCourse(course1).theExamTitle(examTitle1).theOpenDate(openDate1)
                .theCloseDate(closeDate1).theFile(examFile1).build();
        exam2 = new ExamBuilder().theCourse(course2).theExamTitle(examTitle2).theOpenDate(openDate2)
                .theCloseDate(closeDate2).theFile(examFile2).build();
        exam3 = new ExamBuilder().theCourse(course1).theExamTitle(examTitle1).theOpenDate(openDate1)
                .theCloseDate(closeDate1).theFile(examFile1).build();


    }


    @Test
    public void testIfExamTitleIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            ExamTitle nullTitle = null;
            new ExamBuilder().theCourse(course1).theExamTitle(nullTitle).theOpenDate(openDate1)
                    .theCloseDate(closeDate1).theFile(examFile1).build();
        });
    }

    @Test
    public void testIfExamCourseIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Course nullCourse = null;
            new ExamBuilder().theCourse(nullCourse).theExamTitle(examTitle1).theOpenDate(openDate1)
                    .theCloseDate(closeDate1).theFile(examFile1).build();
        });
    }

    @Test
    public void testIfExamOpenDateIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Date nullOpenDate = null;
            new ExamBuilder().theCourse(course1).theExamTitle(examTitle1).theOpenDate(nullOpenDate)
                    .theCloseDate(closeDate1).theFile(examFile1).build();
        });
    }

    @Test
    public void testIfExamCloseDateIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            Date nullCloseDate = null;
            new ExamBuilder().theCourse(course1).theExamTitle(examTitle1).theOpenDate(openDate1)
                    .theCloseDate(nullCloseDate).theFile(examFile1).build();
        });
    }

    @Test
    public void testIfExamFileIsRequired() {
        assertThrows(IllegalStateException.class, () -> {
            File nullFile = null;
            new ExamBuilder().theCourse(course1).theExamTitle(examTitle1).theOpenDate(openDate1)
                    .theCloseDate(closeDate1).theFile(nullFile).build();
        });
    }
    @Test
    public void testIfAllParametersAreFilled() {
        assertDoesNotThrow(() -> {
            Exam exam = new ExamBuilder().theCourse(course1).theExamTitle(examTitle1).theOpenDate(openDate1)
                    .theCloseDate(closeDate1).theFile(examFile1).build();

            assertEquals(course1, exam.getExamCourse());
            assertEquals(examTitle1, exam.getExamTitle());
            assertEquals(openDate1, exam.getExamOpenDate());
            assertEquals(closeDate1, exam.getExamCloseDate());
            assertEquals(examFile1, exam.getExamFile());
        });
    }


    @Test
    public void testIfExamTitleIsCorrect() {
        assertEquals(examTitle1, exam1.getExamTitle());
        assertEquals(examTitle2, exam2.getExamTitle());
        assertNotEquals(examTitle2, exam1.getExamTitle());
    }

    @Test
    public void testIfExamCourseIsCorrect() {
        assertEquals(course1, exam1.getExamCourse());
        assertEquals(course2, exam2.getExamCourse());
        assertNotEquals(course1, exam2.getExamCourse());
    }

    @Test
    public void testIfExamOpenDateIsCorrect() {
        assertEquals(openDate1, exam1.getExamOpenDate());
        assertEquals(openDate2, exam2.getExamOpenDate());
        assertNotEquals(openDate1, exam2.getExamOpenDate());
    }

    @Test
    public void testIfExamCloseDateIsCorrect() {
        assertEquals(closeDate1, exam1.getExamCloseDate());
        assertEquals(closeDate2, exam2.getExamCloseDate());
        assertNotEquals(closeDate1, exam2.getExamCloseDate());
    }

    @Test
    public void testIfExamFileIsCorrect() {
        assertEquals(examFile1, exam1.getExamFile());
        assertEquals(examFile2, exam2.getExamFile());
        assertNotEquals(examFile1, exam2.getExamFile());
    }

    @Test
    public void testCreateExams() {

        Exam exam = new ExamBuilder().theCourse(course1).theExamTitle(examTitle1).theOpenDate(openDate1)
                .theCloseDate(closeDate1).theFile(examFile1).build();

        assertEquals(course1, exam.getExamCourse());
        assertEquals(examTitle1, exam.getExamTitle());
        assertEquals(openDate1, exam.getExamOpenDate());
        assertEquals(closeDate1, exam.getExamCloseDate());
    }

    @Test
    public void testUpdateExams() {
        Exam exam = new ExamBuilder().theCourse(course1).theExamTitle(examTitle1).theOpenDate(openDate1)
                .theCloseDate(closeDate1).theFile(examFile1).build();

        Date newOpenDate = new Date();
        Date newCloseDate = new Date();
        File newExamFile = new File("updated_lprog_exam.pdf");

        exam.updateExam(newOpenDate, newCloseDate, newExamFile);

        assertEquals(newOpenDate, exam.getExamOpenDate());
        assertEquals(newCloseDate, exam.getExamCloseDate());
        assertEquals(newExamFile, exam.getExamFile());
    }

    @Test
    public void testEqualsExams() {

        assertTrue(exam1.sameAs(exam3));
    }

    @Test
    public void testNotEqualsExams() {

        assertFalse(exam1.sameAs(exam2));
    }

}
