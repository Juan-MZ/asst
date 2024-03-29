package co.unicauca.asst.fachadaServices.services;

import co.unicauca.asst.capaAccesoDatos.models.EvaluationEntity;
import co.unicauca.asst.capaAccesoDatos.models.PersonEntity;
import co.unicauca.asst.capaAccesoDatos.repositories.EvaluationRepository;
import co.unicauca.asst.capaAccesoDatos.repositories.PersonRepository;
import co.unicauca.asst.fachadaServices.DTO.EvaluationDTO;
import co.unicauca.asst.fachadaServices.DTO.PersonDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonRepository servicioAccesoBaseDatos;

    @Autowired
    private EvaluationRepository servicioAccesoBaseDatosEvaluation;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PersonDTO> findAll() {

        List<PersonEntity> peopleEntity = this.servicioAccesoBaseDatos.findAll();
        return this.modelMapper.map(peopleEntity, new TypeToken<List<PersonDTO>>() {
        }.getType());
    }

    @Override
    public PersonDTO findByCedula(String cedula) {
        PersonEntity objPersonEntity = this.servicioAccesoBaseDatos.findById(cedula);
        return this.modelMapper.map(objPersonEntity, PersonDTO.class);
    }

    @Override
    public PersonDTO save(PersonDTO person) {
        PersonEntity personEntity = this.modelMapper.map(person, PersonEntity.class);
        PersonEntity objPersonEntity = this.servicioAccesoBaseDatos.save(personEntity);
        for (EvaluationEntity evaluation : objPersonEntity.getEvaluations()) {
            evaluation.setDate(new Date());
            evaluation.setPerson(objPersonEntity);
            this.servicioAccesoBaseDatosEvaluation.save(evaluation);
        }
        return this.modelMapper.map(objPersonEntity, PersonDTO.class);
    }

    @Override
    public PersonDTO update(String cedula, PersonDTO person) {
        PersonEntity personEntity = this.modelMapper.map(person, PersonEntity.class);
        PersonEntity personEntityActualizado = this.servicioAccesoBaseDatos.update(cedula, personEntity);
        return this.modelMapper.map(personEntityActualizado, PersonDTO.class);
    }

    @Override
    public boolean delete(String cedula) {
        PersonEntity objPersonEntity = this.servicioAccesoBaseDatos.findById(cedula);
        for (EvaluationEntity evaluation : objPersonEntity.getEvaluations()) {
            this.servicioAccesoBaseDatosEvaluation.delete(evaluation.getEvaluationSec());
        }
        return this.servicioAccesoBaseDatos.delete(cedula);

    }
}
