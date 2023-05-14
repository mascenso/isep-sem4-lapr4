package eapli.base.repositories;

import eapli.base.domain.Course;
import eapli.base.domain.Exam;
import eapli.base.domain.ExamTitle;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends DomainRepository<ExamTitle, Exam> {

    List<Exam> findByCourse(Course course);

    Optional<Exam> findByTitle(String title);

}