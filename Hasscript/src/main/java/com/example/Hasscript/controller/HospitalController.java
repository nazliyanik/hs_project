package com.example.Hasscript.controller;

import com.example.Hasscript.model.Department;
import com.example.Hasscript.model.Hospital;
import com.example.Hasscript.model.User;
import com.example.Hasscript.repository.DepartmentRepository;
import com.example.Hasscript.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;
    DepartmentRepository departmentRepository;


    @PostMapping("/hospital/create")
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospital) {
        try {
            Hospital _hospital = hospitalRepository
                    .save(new Hospital(hospital.getHospitalName(), hospital.getEmail(), hospital.getPhoneNumber()));
            return new ResponseEntity<>(_hospital, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/hospital/getAllHospitals")
    public ResponseEntity<List<Hospital>> getAllUsers(@RequestParam(required = false) String title) {

        List<Hospital> hospitals = new ArrayList<Hospital>();
        hospitals = hospitalRepository.findAll();
        return new ResponseEntity<>(hospitals, HttpStatus.OK);
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<Set<Department>> getByHospitalId(@PathVariable("id") long id) {
        Hospital hospitalData = hospitalRepository.findById(id);

        return new ResponseEntity<>(hospitalData.getDepartmentList(), HttpStatus.OK);
    }

    @GetMapping("/cityHospital/{id}")
    public ResponseEntity<List<Hospital>> getCitiesHospital(@PathVariable("id") long id) {
        List<Hospital> hospitalData = hospitalRepository.findAll();
        List<Hospital> choosenHospital = hospitalData.stream().filter(data -> data.getCity().getId() == id).collect(Collectors.toList());

        return new ResponseEntity<>(choosenHospital, HttpStatus.OK);
    }
}
