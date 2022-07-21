package service.Impl;

import api.CourseInfoService;
import dao.mapper.CourseInfoMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Course;
import pojo.Oplist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service(group = "restricted-courses")
public class CourseInfoServiceImpl implements CourseInfoService {
    @Autowired
    CourseInfoMapper courseInfoMapper;
    // courseId or courseName
    public List<Course> findCourse(Map<String, Object> params){
        return courseInfoMapper.findCourse(params);
    }
}
