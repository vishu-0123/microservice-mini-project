package com.epam.demo.department_service.service;

import com.epam.demo.department_service.client.EmployeeClient;
import com.epam.demo.department_service.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private EmployeeClient employeeClient;

    public List<EmployeeDto> getEmployeesInDepartment(String deptCode){
        return employeeClient.getEmployeeByDeptCode(deptCode);
    }

}
