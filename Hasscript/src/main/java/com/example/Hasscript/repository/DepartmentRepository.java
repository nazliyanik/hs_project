package com.example.Hasscript.repository;


import com.example.Hasscript.model.Department;
import com.example.Hasscript.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository <Department,Long> {
    Department findById(long departmentId);
}
