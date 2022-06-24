package com.example.Hasscript.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "hospitalName")
    private String  hospitalName;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany (mappedBy = "hospital")
    private Set<Department> department;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }



    public Hospital() {
    }
    public Hospital(String hospitalName, String email, String phoneNumber) {
        this.hospitalName = hospitalName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getHospitalName(){
        return hospitalName;
    }
    public void setHospitalName(String hospitalName){
        this.hospitalName = hospitalName;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public Set<Department> getDepartmentList(){
        return department;
    }
}
