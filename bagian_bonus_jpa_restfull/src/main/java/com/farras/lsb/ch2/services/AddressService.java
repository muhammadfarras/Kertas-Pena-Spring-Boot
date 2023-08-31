package com.farras.lsb.ch2.services;

import com.farras.lsb.ch2.entities.AddressEntitiy;
import com.farras.lsb.ch2.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<AddressEntitiy> getAllAddress(){
        return addressRepository.findAll();
    }

    public AddressEntitiy saveAddress(AddressEntitiy addressEntitiy){
        addressRepository.save(addressEntitiy);
        return addressEntitiy;
    }

    public List<AddressEntitiy> getAllAddressCostume(AddressEntitiy addressEntitiy){
        if (StringUtils.hasText(addressEntitiy.getAlamat())) {
            return addressRepository.findByAlamatContainsIgnoreCase(addressEntitiy.getAlamat());
        }

        // Jika kosong kembalikan empty list
        return Collections.emptyList();
    }
}
