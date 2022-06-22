package com.example.Hasscript.controller;

import com.example.Hasscript.model.Department;
import com.example.Hasscript.model.Hospital;
import com.example.Hasscript.repository.DepartmentRepository;
import com.example.Hasscript.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;

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
}
