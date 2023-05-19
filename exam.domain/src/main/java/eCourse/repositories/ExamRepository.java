package eCourse.repositories;

import eCourse.domain.Exam;
import eCourse.domain.ExamTitle;
import eCourse.domain.Course;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends DomainRepository<ExamTitle, Exam> {

    List<Exam> findByCourse(Course course);

    Exam findByTitle(String title);

    Exam findById(Long examId);

    //Exam findByTitle(ExamTitle title);

}