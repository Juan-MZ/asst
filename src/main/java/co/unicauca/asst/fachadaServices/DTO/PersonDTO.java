package co.unicauca.asst.fachadaServices.DTO;

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

    PersonDTO(){

    }
}
