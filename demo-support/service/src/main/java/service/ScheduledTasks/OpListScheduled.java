package service.ScheduledTasks;

import dao.mapper.CourseEnrollMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


@Service
public class OpListScheduled {
    @Autowired
    CourseEnrollMapper courseEnrollMapper;

    // delete the courses (status = dropped) from the operation list
    @Scheduled(cron = "0 0 0/12 * *") // execute in 0:00 and 12:00
    public void deleteDroppedCourse(){
        courseEnrollMapper.deleteDroppedCourse();
    }
}
