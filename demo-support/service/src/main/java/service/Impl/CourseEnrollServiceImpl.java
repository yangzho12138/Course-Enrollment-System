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
        log.info(params.toString());
        int res = courseEnrollMapper.addCourse(params);
        if(res != 1)
            return "Error: add course" + params.get("courseId") + " to the list failed";
        return "Add course "+  params.get("courseId") +" succeed";
    }

    @Transactional
    public List<String> submitCourses(Map<String, Object> params){
        List<Map<String, Object>> oplists = (List<Map<String, Object>>)params.get("opCourses");

        List<Map<String, Object>> dropList = new LinkedList<>(); // faster than ArrayList in add
        List<Map<String, Object>> enrollList = new LinkedList<>();
        for(Map<String, Object> op : oplists){
            if(op.get("operation").equals("enroll")){
                enrollList.add(op);
            }else if(op.get("operation").equals("drop")){
                dropList.add(op);
            }
        }
        List<String> res = new ArrayList<>();

        // 1. drop courses
        for(Map<String, Object> op: dropList){
            Map<String,Object> map = new HashMap<>();
            map.put("stuId",params.get("stuId"));
            map.put("courseId",op.get("courseId"));
            String info = courseOpList.dropCourse(map);
            res.add(info);
        }
        // 2. enroll courses
        List<Map<String,Object>> discussions = new LinkedList<>();
        for(Map<String, Object> op : enrollList){
            Map<String,Object> map = new HashMap<>();
            map.put("stuId",params.get("stuId"));
            map.put("courseId",op.get("courseId"));
            String type = courseEnrollMapper.checkType(map);
            if(type.equals("discussion")){
                discussions.add(map);
            }else if(type.equals("lecture")){
                String info = courseOpList.enrollLecture(map);
                res.add(info);
            }
        }

        for(Map<String,Object> discussion : discussions){
            String info = courseOpList.enrollDiscussion(discussion);
            res.add(info);
        }

        return res;
    }


}
