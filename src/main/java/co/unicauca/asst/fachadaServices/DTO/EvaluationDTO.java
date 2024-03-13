package co.unicauca.asst.fachadaServices.DTO;

import java.util.Date;
import java.util.List;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class EvaluationDTO {
    private Integer evaluationSec;
    private String city;
    private String gender;
    private Date date;
    private String evaluationType;
    private String civilStatus;
    private String studyLevel;
    private String occupation;
    private List<String> questions;

    EvaluationDTO() {

    }
}
