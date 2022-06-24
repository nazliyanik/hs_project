package com.example.Hasscript.repository;

import com.example.Hasscript.model.Department;
import com.example.Hasscript.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    Hospital findById(long departmentId);


}
