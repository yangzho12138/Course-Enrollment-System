package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Schedule implements Serializable {
    private Integer scheduleId;
    private String startTime;
    private String endTime;
    private String weekday;
}
