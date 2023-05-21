package eCourse.repositories;

import eCourse.domain.Question;
import eCourse.domain.QuestionType;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends DomainRepository<Long, Question> {

    List<Question> findByQuestionType(QuestionType questionType);
}