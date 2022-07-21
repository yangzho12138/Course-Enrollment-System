package dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import pojo.Course;
import pojo.Student;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseEnrollMapper {
    // enroll in a course
    int enrollCourse(Map<String, Object> params);
    // change status in Oplist after enrollment (stuId, courseId)
    int changeStatus(String status, String stuId, String courseId);
    // delete dropped courses in operation list
    int deleteDroppedCourse();

    // stuId
    Student checkIdentification(Map<String, Object> params);

    // courseId
    String checkType(Map<String, Object> params);

    // courseId, stuId
    Integer checkOverride(Map<String, Object> params);

    // courseId
    String checkAttribute(Map<String, Object> params);
    // stuId
    List<String> checkMajor(Map<String, Object> params);

    // stuId
    List<String> courseEnrolled(Map<String, Object> params);
    // courseId
    List<Integer> courseSchedule(Map<String, Object> params);

    // courseId
    Integer checkCredit(Map<String, Object> params);

    // courseId
    Course checkSeatsAndLevel(Map<String, Object> params);

    // courseId
    List<Course> hasPrerequisite(Map<String, Object> params);
    // courseId, stuId
    Integer checkPrerequisite(String courseId, String stuId);

    // courseId
    String findCourseNum(Map<String, Object> params);
    List<String> lectureEnrolled(String courseNum);

    // add a course to the operation list
    int addCourse(Map<String, Object> params);

    // drop a course from the operation list
    int dropCourse(Map<String, Object> params);



}
