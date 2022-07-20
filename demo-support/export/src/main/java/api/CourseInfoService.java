package api;

import pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseInfoService {
    // search a course through course_name or course_id
    List<Course> findCourse(Map<String, Object> params);

    // show the course info in the operation list
    List<Map<String, Object>> infoInOpList(Map<String, Object> params);

}
