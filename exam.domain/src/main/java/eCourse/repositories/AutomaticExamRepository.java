package eCourse.repositories;

import eCourse.domain.*;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomaticExamRepository extends DomainRepository<ExamTitle, AutomaticExame> {

    List<Exam> findByCourse(Course course);

    List<Exam> findByTeacher(Teacher teacher);

    Exam findByTitle(String title);

    Exam findById(Long examId);

    //Exam findByTitle(ExamTitle title);

}