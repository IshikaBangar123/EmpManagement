package com.management.EmpManagement.Service;

import com.management.EmpManagement.Dto.EmployeeDto;
import com.management.EmpManagement.Entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity saveEmp(EmployeeDto dto);

    EmployeeEntity getByEmpId(Long id);

    List<EmployeeEntity> getAllEmp();

    EmployeeEntity updateEmp(Long id, EmployeeDto dto);

    void deleteEmp(Long id);
}
