package com.farras.lsb.ch2.repository;

import com.farras.lsb.ch2.entities.AddressEntitiy;
import com.farras.lsb.ch2.entities.PersonEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntitiy,Long> {

    PersonEntitiy findByAlamatId(Long id);
}
