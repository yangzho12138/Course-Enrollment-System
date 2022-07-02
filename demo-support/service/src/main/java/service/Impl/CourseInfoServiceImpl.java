package service.Impl;

import api.CourseInfoService;
import dao.mapper.CourseInfoMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Course;

import java.util.List;
import java.util.Map;

@Service
public class CourseInfoServiceImpl implements CourseInfoService {
    @Autowired
    CourseInfoMapper courseInfoMapper;

    public List<Course> findCourse(Map<String, Object> params){
        return courseInfoMapper.findCourse(params);
    }
}
