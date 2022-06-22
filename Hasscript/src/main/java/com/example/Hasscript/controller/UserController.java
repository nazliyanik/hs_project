package com.example.Hasscript.controller;

import com.example.Hasscript.model.User;
import com.example.Hasscript.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/getAll")
    public ResponseEntity<List<User>> getUserCreate(@RequestParam(required = false) String title) {

            List<User> users = new ArrayList<User>();
            users = userRepository.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User _user = userRepository
                    .save(new User(user.getIdentityNumber(),user.getName(), user.getSurname(),user.getEmail(),user.getPassword(), user.getPhoneNumber(), user.getBloodType()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/{identityNumber}")
    public ResponseEntity<User> getUserByIdentityNumber(@PathVariable("identityNumber") long identityNumber) {
            User userData = userRepository.findByIdentityNumber(identityNumber);
        if (userData.getIdentityNumber()!=null) {
            return new ResponseEntity<>(userData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/doctor/{departmentNumber}")
    public ResponseEntity<List<User>> getDoctorByDepartmentId(@PathVariable("departmentNumber") long departmentNumber) {
        List<User> userData = userRepository.findByDepartmentId(departmentNumber);
            return new ResponseEntity<>(userData, HttpStatus.OK);
    }


}
