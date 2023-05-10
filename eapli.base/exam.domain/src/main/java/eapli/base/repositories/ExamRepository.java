package eapli.base.repositories;

import eapli.base.domain.Course;
import eapli.base.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findByCourse(Course course);

    Optional<Exam> findByTitle(String title);

}