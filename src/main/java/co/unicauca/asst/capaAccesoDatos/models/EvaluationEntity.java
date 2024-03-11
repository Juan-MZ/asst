package co.unicauca.asst.capaAccesoDatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EvaluationEntity {
    private String evaluationSec;
    private String city;
    private String gender;
    private Date date;
    private String evaluationType;
    private String civilStatus;
    private String studyLevel;
    private String occupation;
    private List<String> questions;
    private PersonEntity person;

    public EvaluationEntity(){

    }
}
