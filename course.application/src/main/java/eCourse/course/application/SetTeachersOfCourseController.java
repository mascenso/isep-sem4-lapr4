package eCourse.course.application;

import eCourse.domain.Teacher;
import eCourse.TeacherService;
import eCourse.domain.Course;
import eCourse.infrastructure.persistence.PersistenceContext;
import eCourse.repositories.CourseRepository;

import java.util.Set;

public class SetTeachersOfCourseController {

    private final ListCoursesService listCoursesService = new ListCoursesService();
    private final TeacherService teacherService = new TeacherService();
    private CourseRepository repo = PersistenceContext.repositories().courses();


    public Iterable<Course> allCourses() {
            return listCoursesService.allCourses();
    }

    public Iterable<Teacher> allTeachers() {
        return teacherService.allTeachers();
    }

    public void addTeachersToCourse(Course theCourse, Set<Teacher> teachersOfCourse) {
        theCourse.addTeachers(teachersOfCourse);
        repo.save(theCourse);
    }
}
