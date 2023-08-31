package com.farras.lsb.ch2.API;

import com.farras.lsb.ch2.entities.AddressEntitiy;
import com.farras.lsb.ch2.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIAddress {

    @Autowired
    AddressService addressService;

    @GetMapping(value = "/address", consumes = {"*/*"})
    public List<AddressEntitiy> getAlls (){
        return addressService.getAllAddress();
    }

    @GetMapping("/addressByAlamat")
    public List<AddressEntitiy> getByName(@RequestBody AddressEntitiy addressEntitiy){
        return addressService.getAllAddressCostume(addressEntitiy);
    }

    @PostMapping(value = "/add/address")
    public AddressEntitiy addAddress(@RequestBody AddressEntitiy addressEntitiy){
        return addressService.saveAddress(addressEntitiy);
    }
}
