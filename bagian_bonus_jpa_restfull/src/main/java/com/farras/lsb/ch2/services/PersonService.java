package com.farras.lsb.ch2.services;

import com.farras.lsb.ch2.entities.AddressEntitiy;
import com.farras.lsb.ch2.entities.PersonEntitiy;
import com.farras.lsb.ch2.repository.AddressRepository;
import com.farras.lsb.ch2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;


    public List<PersonEntitiy> getAllPersons(){
        return personRepository.findAll();
    }

    public PersonEntitiy savePerson(PersonEntitiy personEntitiy){
        return personRepository.save(personEntitiy);
    }

    public Optional<PersonEntitiy> getPersonById(Long id){
        return personRepository.findById(id);
    }

    public List<PersonEntitiy> getPersonWithAdress(String alamat){
        List<PersonEntitiy> temp = new ArrayList<>();
        List<AddressEntitiy> alamatnya = addressRepository.findByAlamatContainsIgnoreCase(alamat);
        System.out.println(alamatnya.size());
        for (AddressEntitiy data : alamatnya){
            if (personRepository.findByAlamatId(data.getId()) != null )  temp.add(personRepository.findByAlamatId(data.getId()));
        }
        return temp;
    }

}
