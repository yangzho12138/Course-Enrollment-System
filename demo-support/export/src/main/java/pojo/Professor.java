package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Professor implements Serializable {
    @NotNull(message = "professor id is not null")
    private String professorId;
    private String firstName;
    private String lastName;
    private String deptName;
    private String phone;
    private String room;
    private List<Teach> teachList;
}
