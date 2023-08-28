package com.management.EmpManagement.Repo;

import com.management.EmpManagement.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByEmpCode(String empCode);
}
