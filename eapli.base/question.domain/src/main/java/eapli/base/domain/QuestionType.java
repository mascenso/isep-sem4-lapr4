package eapli.base.domain;


import java.util.HashMap;
import java.util.Map;

public enum QuestionType {

    MATCHING(1),
    MULTIPLE_CHOICE(2),
    SHORT_ANSWER(3),
    NUMERICAL(4),
    SELECT_MISSING_WORDS(5),
    TRUE_FALSE(6);

    private final int id;
    private static final Map<Integer, QuestionType> QUESTION_TYPE_MAP = new HashMap<>();

    static {
        for (QuestionType questionType : QuestionType.values()) {
            QUESTION_TYPE_MAP.put(questionType.getId(), questionType);
        }
    }

    QuestionType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    protected static QuestionType getQuestionTypeById(int id) {
        return QUESTION_TYPE_MAP.get(id);
    }

    protected static Map<Integer, QuestionType> getQuestionTypeMap() {
        return QUESTION_TYPE_MAP;
    }

    public static Map<Integer, QuestionType> getListOfQuestionTypes(){
        return getQuestionTypeMap();
    }

    public static QuestionType getQuestionType(int id){
        return getQuestionTypeById(id);
    }


}
