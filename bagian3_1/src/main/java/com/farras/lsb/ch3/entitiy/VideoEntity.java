package com.farras.lsb.ch3.entitiy;

import jakarta.persistence.*;

@Entity
@Table(name="video")
public class VideoEntity {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private String description;

        public VideoEntity(){}

    public VideoEntity(String name, String description){
        this.id = null;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
