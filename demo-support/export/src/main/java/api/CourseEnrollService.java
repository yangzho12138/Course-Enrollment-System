package api;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public interface CourseEnrollService {
    // student: add a course to the operation list
    String addCourse(Map<String, Object> params);

    // student: submit the operations of courses in the operation list to enroll or drop
    List<String> submitCourses(Map<String, Object> params);

    // show the course info in the operation list
    List<Map<String, Object>> infoInOpList(Map<String, Object> params);
}
