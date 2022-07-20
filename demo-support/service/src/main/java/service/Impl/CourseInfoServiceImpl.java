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

@Service
public class CourseInfoServiceImpl implements CourseInfoService {
    @Autowired
    CourseInfoMapper courseInfoMapper;

    public List<Course> findCourse(Map<String, Object> params){
        return courseInfoMapper.findCourse(params);
    }

    // stuId
    public List<Map<String, Object>> infoInOpList(Map<String, Object> params){
        List<Map<String, Object>> infoList = new LinkedList<>();
        List<Oplist> oplists = courseInfoMapper.getOpList(params);
        for(Oplist oplist: oplists){
            HashMap<String, Object> map = new HashMap<>();
            String courseId = oplist.getCourseId();
            map.put("courseId",courseId);
            Course c = courseInfoMapper.getOpListCourse(map);
            map.put("courseName",c.getCourseName());
            map.put("courseType",c.getCourseType());
            map.put("credit",c.getCredit());
            map.put("courseNum",c.getCourseNum());
            map.put("status",oplist.getStatus());
            infoList.add(map);
        }
        return infoList;
    }
}
