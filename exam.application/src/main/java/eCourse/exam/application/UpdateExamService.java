package eCourse.exam.application;

import eCourse.domain.Course;
import eCourse.domain.Exam;
import eCourse.domain.ExamTitle;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.ExamRepository;
import eapli.framework.application.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ApplicationService
public class UpdateExamService {

    @Autowired
    private ExamRepository examRepository;
    public Iterable<Exam> allExams() {
        return PersistenceContext.repositories().exams().findAll();
    }


    public List<Exam> getExamByCourse(Course course) {
        List<Exam> examListByCourse = new ArrayList<>();
        for (Exam exm : allExams()) {
            if (exm.getExamCourse().equals(course)) {
                examListByCourse.add(exm);
            }
        }
        return examListByCourse;
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id);
    }
    public Exam getExamByTitle(ExamTitle title){
        Exam foundExam = null;

        for (Exam exm : allExams()) {
            if (exm.getExamTitle().toString().equals(title.toString())){
                foundExam=exm;
            }
        }
        return foundExam;
    }


}
