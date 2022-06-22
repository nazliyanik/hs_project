package com.example.Hasscript.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name="identityNumber")
    private Long identityNumber;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="bloodType")
    private String bloodType;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;


    public User() {
    }
    public User(Long identityNumber,String name, String surname,String email,String password,String phoneNumber, String bloodType) {
        this.identityNumber=identityNumber;
        this.name = name;
        this.surname = surname;
        this.email=email;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.bloodType= bloodType;
    }

    public Long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(Long identityNumber) {
        this.identityNumber = identityNumber;
    }
    public String getName(){
        return  name;
    }
    public void setName(String Name){
        this.name=name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
