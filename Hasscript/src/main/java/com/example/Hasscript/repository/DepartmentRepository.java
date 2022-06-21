package com.example.Hasscript.repository;

import com.example.Hasscript.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Department,Long> {
}
