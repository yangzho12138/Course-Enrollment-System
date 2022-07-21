package pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    @NotNull(message = "course id can not be null")
    private String courseId;
    private String courseNum;
    private String courseName;
    private String courseType;
    private String description;
    @Min(value = 0, message = "credit can not be lower than 0")
    private Integer credit;
    @Min(value = 0,message = "capacity can not be lower than 0")
    private Integer capacity;
    private String attribute;
    private List<Taken> takenList ;
    private List<Prerequisite> prerequisiteList;
    private List<Teach> teachList;
    private List<Enrollment> enrollmentList;
}
