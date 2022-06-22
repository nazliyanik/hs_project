package com.example.Hasscript.repository;

import com.example.Hasscript.model.City;
import com.example.Hasscript.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
