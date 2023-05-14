package eapli.base.domain;

import java.util.HashMap;
import java.util.Map;

public enum FeedbackType {
    NONE(1),
    ON_SUBMISSION(2),
    AFTER_CLOSING(3);


    private final int id;
    private static final Map<Integer, FeedbackType> FEEDBACK_TYPE_MAP = new HashMap<>();

    static {
        for (FeedbackType feedbackType : FeedbackType.values()) {
            FEEDBACK_TYPE_MAP.put(feedbackType.getId(), feedbackType);
        }
    }

    FeedbackType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    protected static FeedbackType getFeedbackTypeById(int id) {
        return FEEDBACK_TYPE_MAP.get(id);
    }

    protected static Map<Integer, FeedbackType> getFeedbackTypeMap() {
        return FEEDBACK_TYPE_MAP;
    }

    public static Map<Integer, FeedbackType> getListOfFeedbackTypes(){
        return getFeedbackTypeMap();
    }

    public static FeedbackType getFeedbackType(int id){
        return getFeedbackTypeById(id);
    }

}
