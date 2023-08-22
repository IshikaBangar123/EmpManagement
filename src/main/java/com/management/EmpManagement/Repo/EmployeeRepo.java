package com.management.EmpManagement.Repo;

import com.management.EmpManagement.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
}
