package service.ScheduledTasks;

import dao.mapper.CourseEnrollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
