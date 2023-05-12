package eapli.base.repositories;

import eapli.base.domain.Question;
import eapli.base.domain.QuestionType;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Designation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends DomainRepository<Designation, Question> {

    List<Question> findByQuestionType(QuestionType questionType);
}