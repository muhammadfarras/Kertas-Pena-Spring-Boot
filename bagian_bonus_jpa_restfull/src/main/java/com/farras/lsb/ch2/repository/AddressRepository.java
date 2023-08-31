package com.farras.lsb.ch2.repository;

import com.farras.lsb.ch2.entities.AddressEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntitiy , Long> {

    List<AddressEntitiy> findByAlamatContainsIgnoreCase(String alamat);
}
