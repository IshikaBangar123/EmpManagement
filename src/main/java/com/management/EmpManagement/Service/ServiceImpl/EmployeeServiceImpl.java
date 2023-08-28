package com.management.EmpManagement.Service.serviceImpl;

import com.management.EmpManagement.DTO.EmployeeDto;
import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Enum.Designation;
import com.management.EmpManagement.Exception.BusinessException;
import com.management.EmpManagement.Repo.EmployeeRepo;
import com.management.EmpManagement.Service.EmployeeService;
import com.management.EmpManagement.Util.CommonResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo empRepo;
    @Override
    public CommonResponse saveEmp(EmployeeDto dto){
        try{
        Long count = empRepo.count();
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmpCode("ITS-" + (count == 0 ? "1" : (++count).toString()));
        emp.setDateOfJoining(stringToDateFormat(dto.getDateOfJoining(), "dd-MM-yyyy"));
        emp.setDateOfBirth(stringToDateFormat(dto.getDateOfBirth(), "dd-MM-yyyy"));
        emp.setDesignation(Designation.valueOf(dto.getDesignation()));
        BeanUtils.copyProperties(dto, emp);
        empRepo.save(emp);
        return  new CommonResponse("Save Successfully", HttpStatus.OK.value(), emp.getId());
        }
        catch(Exception e){
          return new CommonResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        }
    }

    @Override
    public EmployeeEntity getByEmpId(Long id) {
        return empRepo.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND.value(),"Employee not found. "));
    }

    @Override
    public List<EmployeeEntity> getAllEmp() {
        return empRepo.findAll();
    }

    @Override
    public EmployeeEntity updateEmp(Long id, EmployeeDto dto) {
        EmployeeEntity emp = empRepo.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND.value(), "Employee not found"));
        BeanUtils.copyProperties(dto, emp);
        return emp;
    }

    @Override
    public void deleteEmp(Long id) {
      empRepo.deleteById(id);
    }

    public static Date stringToDateFormat(String date, String datePattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        return sdf.parse(date);
    }
}
