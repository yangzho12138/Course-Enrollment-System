package demo.controller;

import api.CourseEnrollService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import utils.CommonResult;

import java.util.Map;

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

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public CommonResult addCourse(Map<String, Object> params){
        courseEnrollService.addCourse(params);
        return new CommonResult();
    }


}
