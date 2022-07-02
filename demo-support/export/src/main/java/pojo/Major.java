package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Major implements Serializable {
    @NotNull(message = "student id can not be null")
    private String stuId;
    @NotNull(message = "department name can not be null")
    private String deptName;
    private String major;
}
