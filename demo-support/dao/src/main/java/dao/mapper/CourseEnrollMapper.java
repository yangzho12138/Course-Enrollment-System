package dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import pojo.Course;
import pojo.Override;
import pojo.Student;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseEnrollMapper {
    // enroll in a course
    int enrollCourse(Map<String, Object> params);
    Student checkIdentification(String stuId);
    Integer checkOverride(String courseId, String stuId);
    Course checkSeatsAndLevel(String courseId);
    List<Course> hasPrerequisite(String courseId);
    Integer checkPrerequisite(String courseId, String stuId);

    // drop a course
    int dropCourse(Map<String, Object> params);

    // add a course
    int addCourse(Map<String, Object> params);
}
