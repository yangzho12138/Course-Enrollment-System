package service.Impl;

import api.CourseEnrollService;
import api.CourseOpList;
import dao.mapper.CourseEnrollMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pojo.Oplist;

import java.util.*;

/*
author : Yang Zhou
Date: 2022-6-26
Description:
*/

@Service
@Slf4j
public class CourseEnrollServiceImpl implements CourseEnrollService {
    @Autowired
    CourseEnrollMapper courseEnrollMapper;
    @Autowired
    CourseOpList courseOpList;

    public String addCourse(Map<String, Object> params){
        int res = courseEnrollMapper.addCourse(params);
        if(res != 1)
            return "Error: add course" + params.get("courseId") + " to the list failed";
        return "Add course "+  params.get("courseId") +"succeed";
    }

    @Transactional
    public List<String> submitCourses(Map<String, Object> params){
        List<Oplist> oplists = (List<Oplist>) params.get("OpCourses");

        List<Oplist> dropList = new LinkedList<>(); // faster than ArrayList in add
        List<Oplist> enrollList = new LinkedList<>();
        for(Oplist op : oplists){
            if(op.getStatus().equals("enroll")){
                enrollList.add(op);
            }else if(op.getStatus().equals("drop")){
                dropList.add(op);
            }
        }
        List<String> res = new ArrayList<>();

        // 1. drop courses
        for(Oplist op: dropList){
            Map<String,Object> p = new HashMap<>();
            p.put("stuId",op.getStuId());
            p.put("courseId",op.getCourseId());
            String info = courseOpList.dropCourse(p);
            res.add(info);
        }
        // 2. enroll courses
        for(Oplist op : enrollList){
            Map<String,Object> p = new HashMap<>();
            p.put("stuId",op.getStuId());
            p.put("courseId",op.getCourseId());
            String info = courseOpList.enrollCourse(p);
            res.add(info);
        }

        return res;
    }


}
