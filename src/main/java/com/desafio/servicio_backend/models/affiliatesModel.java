package com.desafio.servicio_backend.models;

import jakarta.persistence.*;


@Entity
@Table(name = "affiliates")
public class affiliatesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id",unique = true, nullable = false)
    private Long id;
    
    @Column(name= "name",nullable = false)
    private String name;
    @Column(name= "age",nullable = false)
    private Long age;
    @Column(name= "mail",nullable = false)
    private String mail;
    
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
    public Long getAge() {
        return age;
    }
    public void setAge(Long age) {
        this.age = age;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}


