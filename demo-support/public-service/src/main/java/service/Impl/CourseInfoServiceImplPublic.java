package service.Impl;

import api.CourseInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Course;
import utils.RedisUtil;

import java.util.List;
import java.util.Map;

@Service(group = "public-courses")
public class CourseInfoServiceImplPublic implements CourseInfoService {
    @Autowired
    RedisUtil redisUtil;

    // Using Redis to cache the course info
    public List<Course> findCourse(Map<String, Object> params) {
        return null;
    }

}
