package demo.controller;

import api.CourseInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.Course;
import utils.CommonResult;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("public/courses/info")
public class PublicCourseInfoController {
    @Reference(group = "public-courses")
    private CourseInfoService courseInfoService;

    // find a course through courseId or courseName
    @RequestMapping(value = "/findCourse", method = RequestMethod.POST)
    public CommonResult findCourse(@RequestBody Map<String,Object> params){
        List<Course> courses = courseInfoService.findCourse(params);
        //System.out.println(courses.size());
        if(courses == null || courses.size()==0)
            return new CommonResult(0,"No related course found, please check the info",null);
        for(Course c:courses)
            System.out.println(c);
        return new CommonResult(1,"Course found!",courses);
    }
}
