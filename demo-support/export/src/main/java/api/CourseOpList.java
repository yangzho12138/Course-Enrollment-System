package api;

import java.util.Map;
import java.util.concurrent.Future;

public interface CourseOpList {
    // student: enroll a course based on the course_id
    String enrollCourse(Map<String, Object> params);

    // student: drop an enrolled course based on course_id
    String dropCourse(Map<String, Object> params);
}
