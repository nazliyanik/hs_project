package com.example.Hasscript.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "city")
public class City{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "cityName")
    private String  cityName;
    @OneToMany (mappedBy = "city")
    private Set<Hospital> hospital;

    public City(){};
    public City(String cityName){
        this.cityName = cityName;
    }

    public String getCityName(){
        return cityName;
    }
    public void setCityName(String cityName){
        this.cityName = cityName;
    }
}

