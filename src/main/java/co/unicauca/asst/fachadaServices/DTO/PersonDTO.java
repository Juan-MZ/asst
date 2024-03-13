package co.unicauca.asst.fachadaServices.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
    private String cedula;
    private String completedName;
    private String gender;
    private String civilStatus;
    private String studyLevel;
    private String occupation;
    private List<EvaluationDTO> Evaluations;

    PersonDTO() {
        this.Evaluations = new ArrayList<>();
    }
}
