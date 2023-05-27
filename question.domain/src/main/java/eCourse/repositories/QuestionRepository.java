package eCourse.repositories;

import eCourse.domain.Question;
import eCourse.domain.QuestionType;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends DomainRepository<Long, Question> {

    Optional<Question> findByQuestionType(QuestionType questionType);
}