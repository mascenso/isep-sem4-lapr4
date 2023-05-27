package eCourse.course.application;

import eCourse.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class BulkCsvValidateResult {
    ArrayList<Student> validStudentsList = new ArrayList<>();
    ArrayList<String> invalidStudentsList = new ArrayList<>();

    public void addValidStudent (Student valid){
        this.validStudentsList.add(valid);

    }

    public void addInvalidStudentRow (String invalid){
        this.invalidStudentsList.add(invalid);
    }

    public List<Student> validStudents(){
        return  validStudentsList;
    }
    public List<String> invalidStudents(){
        return  invalidStudentsList;
    }
}