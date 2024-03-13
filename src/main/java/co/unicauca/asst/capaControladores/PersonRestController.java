package co.unicauca.asst.capaControladores;

import co.unicauca.asst.fachadaServices.DTO.PersonDTO;
import co.unicauca.asst.fachadaServices.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/people")
    public List<PersonDTO> index() {
        return personService.findAll();
    }

    @GetMapping("/people/{cedula}")
    public PersonDTO show(@PathVariable String cedula) {
        PersonDTO objPerson = null;
        objPerson = personService.findByCedula(cedula);
        return objPerson;
    }

    @PostMapping("/people/create")
    public PersonDTO create(@RequestBody PersonDTO person) {
        PersonDTO objPerson = null;
        objPerson = personService.save(person);
        return objPerson;
    }

    @PutMapping("/people/update/{cedula}")
    public PersonDTO update(@RequestBody PersonDTO cliente, @PathVariable String cedula) {
        PersonDTO objPerson = null;
        PersonDTO personActual = personService.findByCedula(cedula);
        if (personActual != null) {
            objPerson = personService.update(cedula, cliente);
        }
        return objPerson;
    }

    @DeleteMapping("/people/delete")
    public Boolean delete(@RequestParam String cedula) {
        Boolean bandera = false;
        PersonDTO personActual = personService.findByCedula(cedula);
        if (personActual != null) {
            bandera = personService.delete(cedula);
        }
        return bandera;

    }
}
