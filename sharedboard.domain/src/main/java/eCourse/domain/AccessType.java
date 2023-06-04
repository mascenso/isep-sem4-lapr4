package eCourse.domain;

import java.util.HashMap;
import java.util.Map;

public enum AccessType {

    READ(1),
    WRITE(2);

    private final int id;
    private static final Map<Integer, AccessType> ACCESS_TYPE_MAP = new HashMap<>();

    static {
        for (AccessType  access : AccessType.values()) {
            ACCESS_TYPE_MAP.put(access.getId(), access);
        }
    }

    protected static Map<Integer, AccessType> getAccessTypeMap() {
        return ACCESS_TYPE_MAP;
    }

    public static Map<Integer, AccessType> getListOfAccessTypes(){
        return getAccessTypeMap();
    }
    AccessType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
