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
public class Prerequisite implements Serializable {
    @NotNull(message = "course id can not be null")
    private String courseId;
    @NotNull(message = "prerequisite id can not be null")
    private String prerequisiteId;
    private String prerequisiteName;
}
