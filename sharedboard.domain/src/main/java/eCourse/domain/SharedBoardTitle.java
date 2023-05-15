package eCourse.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

public class SharedBoardTitle implements ValueObject, Comparable<SharedBoardTitle> {
    private static final long serialVersionUID = 1L;

    private String title;

    public SharedBoardTitle(final String title){
        if (StringPredicates.isNullOrEmpty(title)){
            throw new IllegalArgumentException("Board Title should neither be null nor empty ");
        }
        this.title = title;
    }

    protected SharedBoardTitle(){
        // for ORM
    }

    public static SharedBoardTitle valueOf(final String title){
        return new SharedBoardTitle(title);
    }

    @Override
    public boolean equals(final Object o){
        if (this == o) {
            return true;
        }
        if (!(o instanceof SharedBoardTitle)){
            return false;
        }

        final SharedBoardTitle that = (SharedBoardTitle) o;
        return this.title.equals(that.title);
    }

    @Override
    public int hashCode(){
        return this.title.hashCode();
    }

    @Override
    public String toString(){
        return this.title;
    }

    @Override
    public int compareTo(SharedBoardTitle arg0) {
        return title.compareTo(arg0.title);
    }

}
