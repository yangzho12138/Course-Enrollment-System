package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private String stuId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String stuPhone;
    private Integer enrollmentYear;
    private Integer identification;
    private String status;
    private List<Enrollment> enrollmentList;
}
