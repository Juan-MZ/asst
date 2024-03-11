package co.unicauca.asst.capaAccesoDatos.repositories;

import co.unicauca.asst.capaAccesoDatos.models.PersonEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonRepository {

    private ArrayList<PersonEntity> PeopleList;

    public PersonRepository() {
        this.PeopleList = new ArrayList<PersonEntity>();
        cargarPersonas();
    }

    public List<PersonEntity> findAll() {
        System.out.println("Invocando a listar personas");
        return this.PeopleList;
    }

    public PersonEntity findById(String cedula) {
        System.out.println("Invocando a consultar una persona");
        PersonEntity objPerson = null;

        for (PersonEntity people : PeopleList) {
            if (Objects.equals(people.getCedula(), cedula)) {
                objPerson = people;
                break;
            }
        }

        return objPerson;
    }

    public PersonEntity save(PersonEntity person) {
        System.out.println("Invocando a guardar persona");
        PersonEntity objPerson = null;
        if (this.PeopleList.add(person)) {
            objPerson = person;
        }

        return objPerson;
    }

    public PersonEntity update(String cedula, PersonEntity person) {
        System.out.println("Invocando a actualizar persona");
        PersonEntity objPerson = null;

        for (int i = 0; i < this.PeopleList.size(); i++) {
            if (Objects.equals(this.PeopleList.get(i).getCedula(), cedula)) {
                this.PeopleList.set(i, person);
                objPerson = person;
                break;
            }
        }

        return objPerson;
    }

    public boolean delete(String cedula) {
        System.out.println("Invocando a eliminar persona");
        boolean bandera = false;

        for (int i = 0; i < this.PeopleList.size(); i++) {
            if (Objects.equals(this.PeopleList.get(i).getCedula(), cedula)) {
                this.PeopleList.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    private void cargarPersonas() {
        // Sample data (replace with your actual data source)
        String[] cedulas = {"12345678", "87654321", "90123456", "65432109"};
        String[] completedNames = {"Juan Perez", "Catalina Lopez", "Sandra Sanchez", "Andres Garcia"};
        String[] genders = {"M", "F", "F", "M"};
        String[] civilStatuses = {"Soltero", "Casada", "Soltera", "Casado"};
        String[] studyLevels = {"Primaria", "Secundaria", "Universitario", "Secundaria"};
        String[] occupations = {"Doctor", "Ingeniera", "Docente", "Abogado"};

        // Loop to create and add PersonEntity objects
        for (int i = 0; i < cedulas.length; i++) {
            PersonEntity persona = new PersonEntity();
            persona.setCedula(cedulas[i]);
            persona.setCompletedName(completedNames[i]);
            persona.setGender(genders[i]);
            persona.setCivilStatus(civilStatuses[i]);
            persona.setStudyLevel(studyLevels[i]);
            persona.setOccupation(occupations[i]);
            this.PeopleList.add(persona);
        }
    }

}
