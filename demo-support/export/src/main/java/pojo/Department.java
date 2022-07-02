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
public class Department implements Serializable {
    @NotNull(message = "depart name can not be null")
    private String deptName;
    private String deptAddr;
    private String deptPhone;

}
