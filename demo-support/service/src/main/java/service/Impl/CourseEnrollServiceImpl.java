package service.Impl;

import api.CourseEnrollService;
import dao.mapper.CourseEnrollMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Course;
import pojo.Student;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/*
author : Yang Zhou
Date: 2022-6-26
Description:
*/

@Service
public class CourseEnrollServiceImpl implements CourseEnrollService {
    @Autowired
    CourseEnrollMapper courseEnrollMapper;

    public String enrollCourse(Map<String, Object> params){
        // check student status
        Student s = courseEnrollMapper.checkIdentification((String) params.get("stuId"));
        if(s.getStatus().equals("registered") == false)
            return "Your student status is not illegal to register a course";
        // check override
        Integer override = courseEnrollMapper.checkOverride((String) params.get("courseId"),(String) params.get("stuId"));
        if(override != null && override == 1){ // check whether the value of override is null first, or it will report the NullPointer exception
            int res = courseEnrollMapper.enrollCourse(params);
            if(res != 1)
                return "Enrollment failed";
            return "Enrollment succeed";
        }
        // check the time conflict with enrolled courses

        // check the total credit limits

        // check the dependencies: 

        // check available seats
        Course c = courseEnrollMapper.checkSeatsAndLevel((String) params.get("courseId"));
        int available_seat = c.getCapacity();
        if(available_seat<=0)
            return "The is no seats available for the course: " + params.get("courseId");
        // check identification
        int level = Character.getNumericValue(c.getCourseNum().split(" ")[1].charAt(0));
        if(s.getIdentification() - s.getEnrollmentYear() + Calendar.getInstance().get(Calendar.YEAR) < level)
            return "You have no authority to choose the high-level course: " + params.get("courseId");
        // check prerequisites courses
        List<Course> prerequisites = courseEnrollMapper.hasPrerequisite((String) params.get("courseId"));
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
            return "Error: drop course" + params.get("courseId") + "failed";
        return "Drop course" +  params.get("courseId") + "succeed";
    }

    public String addCourse(Map<String, Object> params){
        List<Course> courseList = (List<Course>)params.get("courses");
        for(Course c: courseList){

        }
    }

    public String submitCourse(Map<String, Object> params){

    }


}
