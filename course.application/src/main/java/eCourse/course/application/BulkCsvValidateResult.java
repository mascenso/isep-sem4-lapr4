package eCourse.course.application;

import eCourse.domain.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BulkCsvValidateResult {
    Set<Student> validStudentsList = new HashSet<>();
    ArrayList<String> invalidStudentsList = new ArrayList<>();

    public void addValidStudent (Student valid){
        this.validStudentsList.add(valid);

    }

    public void addInvalidStudentRow (String invalid){
        this.invalidStudentsList.add(invalid);
    }

    public Set<Student> validStudents(){
        return validStudentsList;
    }
    public List<String> invalidStudents(){
        return  invalidStudentsList;
    }
}