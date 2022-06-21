package com.example.Hasscript.model;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "cityName")
    private String  cityName;
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

