package com.farras.lsb.ch2.API;


import com.farras.lsb.ch2.entities.AddressEntitiy;
import com.farras.lsb.ch2.entities.PersonEntitiy;
import com.farras.lsb.ch2.services.PersonService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class APIPerson {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<PersonEntitiy> getAll(){
        return personService.getAllPersons();
    }

    @PostMapping("/add/person")
    public PersonEntitiy savePerson(@RequestBody PersonEntitiy personEntitiy, HttpServletResponse response){
        try {
            return personService.savePerson(personEntitiy);
        }
        catch (Exception|Error ex){
            String message = ex.getCause().getCause().getLocalizedMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message,ex);
        }
    }

    @GetMapping ("/persons/{id}")
    public Optional <PersonEntitiy> getPersonById(@PathVariable("id") long id){
        return personService.getPersonById(id);
    }

    @PostMapping("/person/alamat")
    public List<PersonEntitiy> getPersonByAlamat(@RequestBody AddressEntitiy addressEntitiy){
        return personService.getPersonWithAdress(addressEntitiy.getAlamat());
    }

}
