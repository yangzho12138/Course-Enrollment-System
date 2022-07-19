package service.Impl;


import api.CourseOpList;
import dao.mapper.CourseEnrollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Course;
import pojo.Student;

import java.util.*;

@Service
public class CourseOpListImpl implements CourseOpList {
    @Autowired
    CourseEnrollMapper courseEnrollMapper;


    // parameters: stuId, courseId
    public String enrollCourse(Map<String, Object> params){
        // check student status

        Student s = courseEnrollMapper.checkIdentification(params);
        if(s.getStatus().equals("registered") == false)
            return "Your student status is not illegal to register a course";

        // check the dependencies:
        String type = courseEnrollMapper.checkType(params);
        if(type.equals("discussion")){
            return " ";
        }
        // check override
        Integer override = courseEnrollMapper.checkOverride(params);
        if(override != null && override == 1){ // check whether the value of override is null first, or it will report the NullPointer exception
            int res = courseEnrollMapper.enrollCourse(params);
            if(res != 1)
                return "Enrollment failed";
            return "Enrollment succeed";
        }

        // check the time conflict with enrolled courses
        List<String> courseEnrolled = courseEnrollMapper.courseEnrolled(params);
        List<Integer> schedules = courseEnrollMapper.courseSchedule(params);
        for(Integer schedule: schedules){
            for(String courseEnrolledId: courseEnrolled){
                Map<String, Object> map = new HashMap<>();
                map.put("courseId",courseEnrolledId);
                List<Integer> enrolledSchedules = courseEnrollMapper.courseSchedule(map);
                for(Integer enrolledSchedule: enrolledSchedules){
                    if(enrolledSchedule == schedule)
                        return "Time conflicts!: "+ courseEnrolledId + " and " + params.get("courseId");
                }
            }
        }

        // check the total credit limits
        int credit = courseEnrollMapper.checkCredit(params);
        for(String courseEnrolledId: courseEnrolled){
            Map<String, Object> map = new HashMap<>();
            map.put("courseId",courseEnrolledId);
            credit += courseEnrollMapper.checkCredit(map);
            if(credit > 20)
                return "excess the credit limitation, please contact the registration office";
        }

        // check available seats
        Map<String, Object> param = new HashMap<>();
        param.put("courseId",params.get("courseId"));
        Course c = courseEnrollMapper.checkSeatsAndLevel(param);
        int available_seat = c.getCapacity();
        if(available_seat<=0)
            return "The is no seats available for the course: " + params.get("courseId");
        // check identification (course-level)
        int level = Character.getNumericValue(c.getCourseNum().split(" ")[1].charAt(0));
        if(s.getIdentification() - s.getEnrollmentYear() + Calendar.getInstance().get(Calendar.YEAR) < level)
            return "You have no authority to choose the high-level course: " + params.get("courseId");
        // check prerequisites courses
        List<Course> prerequisites = courseEnrollMapper.hasPrerequisite(params);
        if(prerequisites.size()!=0){
            for(Course course : prerequisites){
                Integer check_prerequisite = courseEnrollMapper.checkPrerequisite(course.getCourseId(),(String) params.get("stuId"));
                // not finish or pass the course
                if(check_prerequisite == null || check_prerequisite<60)
                    return "You have not meet the course: " + params.get("courseId") +" prerequisite course requirement, please finish the course: "+course.getCourseName() + "first";
            }
        }
        // SQL Trigger —— capacity decrease
        int res = courseEnrollMapper.enrollCourse(params);
        if(res != 1)
            return "Error: enroll in course: " + params.get("courseId") +" failed";
        return "Enroll in course: " + params.get("courseId") +" succeed";
    }



    public String dropCourse(Map<String, Object> params){
        // SQL Trigger —— capacity increase
        int res = courseEnrollMapper.dropCourse(params);
        if(res != 1)
            return "Error: drop course " + params.get("courseId") + " from the list failed";
        return "Drop course" +  params.get("courseId") + "succeed";
    }
}
