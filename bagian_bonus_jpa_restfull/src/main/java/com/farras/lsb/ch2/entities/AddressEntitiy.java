package com.farras.lsb.ch2.entities;

import jakarta.persistence.*;

@Entity
public class AddressEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alamat;

    @OneToOne(mappedBy = "alamat") // mappedBy menggunakan nama dari AddressEntitiy
    private PersonEntitiy personEntitiy;

    protected AddressEntitiy (){}

    public Long getId() {
        return id;
    }

    public String getAlamat() {
        return alamat;
    }
}
