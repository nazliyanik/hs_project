package com.example.Hasscript.repository;
import com.example.Hasscript.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdentityNumber(long identityNumber);
    List<User> findByDepartmentId(Long departmentId);

}
