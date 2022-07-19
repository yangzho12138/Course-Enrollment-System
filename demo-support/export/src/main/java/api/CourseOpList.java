package api;

import java.util.Map;
import java.util.concurrent.Future;

public interface CourseOpList {
    // student: enroll a lecture based on the course_id
    String enrollLecture(Map<String, Object> params);

    // student: enroll a lecture based on the course_id
    String enrollDiscussion(Map<String, Object> params);

    // student: drop an enrolled course based on course_id
    String dropCourse(Map<String, Object> params);
}
