package co.unicauca.asst.capaAccesoDatos.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import co.unicauca.asst.capaAccesoDatos.models.EvaluationEntity;

@Repository
public class EvaluationRepository {
    private ArrayList<EvaluationEntity> EvaluationList;

    public EvaluationRepository() {
        this.EvaluationList = new ArrayList<EvaluationEntity>();
    }

    public List<EvaluationEntity> findAll() {
        System.out.println("Invocando a listar Evaluaciones");
        return this.EvaluationList;
    }

    public EvaluationEntity findById(Integer evaluationSec) {
        System.out.println("Invocando a consultar una Evaluacion");
        EvaluationEntity objEvaluation = null;

        for (EvaluationEntity Evaluation : EvaluationList) {
            if (Evaluation.getEvaluationSec() == evaluationSec) {
                objEvaluation = Evaluation;
                break;
            }
        }

        return objEvaluation;
    }

    public EvaluationEntity save(EvaluationEntity Evaluation) {
        System.out.println("Invocando a guardar Evaluacion");
        EvaluationEntity objEvaluation = null;
        if (this.EvaluationList.add(Evaluation)) {
            objEvaluation = Evaluation;
        }

        return objEvaluation;
    }

    public EvaluationEntity update(Integer evaluationSec, EvaluationEntity Evaluation) {
        System.out.println("Invocando a actualizar Evaluacion");
        EvaluationEntity objEvaluation = null;

        for (int i = 0; i < this.EvaluationList.size(); i++) {
            if (Objects.equals(this.EvaluationList.get(i).getEvaluationSec(), evaluationSec)) {
                this.EvaluationList.set(i, Evaluation);
                objEvaluation = Evaluation;
                break;
            }
        }

        return objEvaluation;
    }

    public boolean delete(Integer evaluationSec) {
        System.out.println("Invocando a eliminar Evaluacion");
        boolean bandera = false;

        for (int i = 0; i < this.EvaluationList.size(); i++) {
            if (Objects.equals(this.EvaluationList.get(i).getEvaluationSec(), evaluationSec)) {
                this.EvaluationList.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }
}
