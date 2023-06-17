package eCourse.domain;
import eapli.framework.domain.model.ValueObject;

public class Position implements ValueObject, Comparable<Position> {

    private Integer rowIndex;
    private Integer columnIndex;

    public Position(Integer rowIndex, Integer columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public Position() {
        // for ORM
    }

    public static Position valueOf(Integer rowIndex, Integer columnIndex) {
        return new Position(rowIndex, columnIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position that = (Position) o;

        if (!rowIndex.equals(that.rowIndex)) return false;
        return columnIndex.equals(that.columnIndex);
    }

    @Override
    public int hashCode() {
        int result = rowIndex.hashCode();
        result = 31 * result + columnIndex.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("{%d,%d}", rowIndex, columnIndex);
    }

    public Integer rowIndex() {
        return rowIndex;
    }

    public Integer columnIndex() {
        return columnIndex;
    }

    @Override
    public int compareTo(Position o) {
        return this.rowIndex.compareTo(o.rowIndex) + this.columnIndex.compareTo(o.columnIndex);
    }
}
