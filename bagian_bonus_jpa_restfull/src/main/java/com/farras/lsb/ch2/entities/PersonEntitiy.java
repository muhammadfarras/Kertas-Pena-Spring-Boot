package com.farras.lsb.ch2.entities;


import jakarta.persistence.*;
import org.apache.juli.logging.Log;

import java.time.LocalDate;

@Entity
@Table(name = "Person")
public class PersonEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(name = "tanggalLahir")
    private LocalDate dateBorn;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "address_id")
    private AddressEntitiy alamat;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public AddressEntitiy getAlamat() {
        return alamat;
    }

    protected PersonEntitiy(){}

}
