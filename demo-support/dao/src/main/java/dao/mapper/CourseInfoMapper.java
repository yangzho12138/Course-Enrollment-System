package dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import pojo.Course;
import pojo.Oplist;


import java.util.List;
import java.util.Map;

@Mapper
public interface CourseInfoMapper {
    List<Course> findCourse(Map<String, Object> params);

    List<Oplist> getOpList(Map<String, Object> params);
    Course getOpListCourse(Map<String, Object> params);
}
