package com.management.EmpManagement.Repo;

import com.management.EmpManagement.Entity.PartialWorkFromHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartialWFHRepository extends JpaRepository<PartialWorkFromHome,Long> {
}
