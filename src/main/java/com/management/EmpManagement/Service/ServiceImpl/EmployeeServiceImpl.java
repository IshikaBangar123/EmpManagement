package com.management.EmpManagement.Service.ServiceImpl;

import com.management.EmpManagement.Dto.EmployeeDto;
import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Repo.EmployeeRepo;
import com.management.EmpManagement.Service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo empRepo;
    @Override
    public EmployeeEntity saveEmp(EmployeeDto dto) {
        EmployeeEntity emp = new EmployeeEntity();
        BeanUtils.copyProperties(dto, emp);
        return empRepo.save(emp);
    }

    @Override
    public EmployeeEntity getByEmpId(Long id) {
        return empRepo.findById(id).get();
    }

    @Override
    public List<EmployeeEntity> getAllEmp() {
        return empRepo.findAll();
    }

    @Override
    public EmployeeEntity updateEmp(Long id, EmployeeDto dto) {
        EmployeeEntity emp = empRepo.findById(id).get();
        BeanUtils.copyProperties(dto, emp);
        return emp;
    }

    @Override
    public void deleteEmp(Long id) {
      empRepo.deleteById(id);
    }
}
