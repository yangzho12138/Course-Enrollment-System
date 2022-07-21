package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment implements Serializable {
    @NotNull(message = "student id can not be null")
    private String stuId;
    @NotNull(message = "course id can not be null")
    private String courseId;
    @Min(value = 0, message = "grade can not be lower than 0")
    @Max(value = 100, message = "grade can not be higher than 100")
    private Integer grade;
}
