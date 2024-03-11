package co.unicauca.asst.fachadaServices.services;

import java.util.List;
import co.unicauca.asst.fachadaServices.DTO.PersonDTO;

public interface IPersonService {
    public List<PersonDTO> findAll();

    public PersonDTO findByCedula(String cedula);

    public PersonDTO save(PersonDTO person);

    public PersonDTO update(String cedula, PersonDTO person);

    public boolean delete(String cedula);
}
