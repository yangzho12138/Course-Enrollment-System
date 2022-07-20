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
public class Oplist implements Serializable {
    private String stuId;
    private String courseId;
    private String status;
    private String operation; // operation transmitted from the front end, no corresponding field in db
}
