package com.management.EmpManagement.Service;

import com.management.EmpManagement.Dto.EmployeeDto;
import com.management.EmpManagement.Dto.EmployeeDto;
import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Util.CommonResponse;

import javax.persistence.Table;
import java.text.ParseException;
import java.util.List;

public interface EmployeeService {

    CommonResponse saveEmp(EmployeeDto dto) throws ParseException;

    EmployeeEntity getByEmpId(Long id);

    List<EmployeeEntity> getAllEmp();

    EmployeeEntity updateEmp(Long id, EmployeeDto dto);

    void deleteEmp(Long id);
}
