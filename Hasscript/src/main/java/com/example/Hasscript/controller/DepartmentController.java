package com.example.Hasscript.controller;

import com.example.Hasscript.model.Department;
import com.example.Hasscript.model.User;
import com.example.Hasscript.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DepartmentController{

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("department/getAll")
    public ResponseEntity<List<Department>> getAllDepartments() {
        try {
            List<Department> departments = departmentRepository.findAll();
            if (departments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(departments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/department/create")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        try {
            Department _department = departmentRepository
                    .save(new Department(department.getDepartmentName(), department.getUserList()));
            return new ResponseEntity<>(_department, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
