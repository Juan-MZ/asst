package co.unicauca.asst.capaAccesoDatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonEntity {
    private String cedula;
    private String completedName;
    private String gender;
    private String civilStatus;
    private String studyLevel;
    private String occupation;
    private List<EvaluationEntity> Evaluations;

    public PersonEntity() {
        this.Evaluations = new ArrayList<>();
    }
}
