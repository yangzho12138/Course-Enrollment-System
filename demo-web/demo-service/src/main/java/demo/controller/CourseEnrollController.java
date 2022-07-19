package demo.controller;

import api.CourseEnrollService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import utils.CommonResult;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/*
author: Yang Zhou
Date: 2022-6-26
Description: Controllers for students' operation
 */

@RestController
@RequestMapping("/courses/enrollment")
public class CourseEnrollController {
    @Reference
    private CourseEnrollService courseEnrollService;

    // student: add a course to the operation list
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public CommonResult addCourse(Map<String, Object> params){
        String info = courseEnrollService.addCourse(params);
        return new CommonResult(1,"added",info);
    }

    // student: submit the operations of courses in the operation list to enroll or drop
    @RequestMapping(value = "/submitCourses", method = RequestMethod.POST)
    public CommonResult submitCourses(Map<String, Object> params){
        List<String> info = courseEnrollService.submitCourses(params);
        return new CommonResult(1,"submitted",info);
    }
}
