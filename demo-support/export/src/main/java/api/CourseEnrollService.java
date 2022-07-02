package api;

import java.util.Map;

public interface CourseEnrollService {
    // student: enroll a course based on the course_id
    String enrollCourse(Map<String, Object> params);

    // student: drop an enrolled course based on course_id
    String dropCourse(Map<String, Object> params);

    // student: add a course to the operation list
    String addCourse(Map<String, Object> params);

    // student: submit the operations of courses in the operation list to enroll or drop
    String submitCourse(Map<String, Object> params);
}
