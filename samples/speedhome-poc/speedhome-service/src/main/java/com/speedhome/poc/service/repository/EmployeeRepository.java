package com.speedhome.poc.service.repository;

import com.speedhome.poc.service.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Override
    List<EmployeeEntity> findAll();

    boolean existsById(long id);

    boolean existsByEmailId(String emailId);

    EmployeeEntity findByEmailId(String emailId);
}
