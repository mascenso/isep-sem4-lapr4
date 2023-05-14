package eapli.base.domain;

import java.util.HashMap;
import java.util.Map;

public enum GradeType {
    NONE(1),
    ON_SUBMISSION(2),
    AFTER_CLOSING(3);


    private final int id;
    private static final Map<Integer, GradeType> GRADE_TYPE_MAP = new HashMap<>();

    static {
        for (GradeType gradeType : GradeType.values()) {
            GRADE_TYPE_MAP.put(gradeType.getId(), gradeType);
        }
    }

    GradeType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    protected static GradeType getGradeTypeById(int id) {
        return GRADE_TYPE_MAP.get(id);
    }

    protected static Map<Integer, GradeType> getGradeTypeMap() {
        return GRADE_TYPE_MAP;
    }

    public static Map<Integer, GradeType> getListOfGradeTypes(){
        return getGradeTypeMap();
    }

    public static GradeType getGradeType(int id){
        return getGradeTypeById(id);
    }
}
