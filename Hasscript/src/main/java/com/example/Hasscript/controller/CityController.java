package com.example.Hasscript.controller;

import com.example.Hasscript.model.City;
import com.example.Hasscript.model.Department;
import com.example.Hasscript.repository.CityRepository;
import com.example.Hasscript.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping("city/getAll")
    public ResponseEntity<List<City>> getAllCities() {
        try {
            List<City> cities = cityRepository.findAll();
            if (cities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/city/create")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        try {
            City _city = cityRepository
                    .save(new City(city.getCityName()));
            return new ResponseEntity<>(_city, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
