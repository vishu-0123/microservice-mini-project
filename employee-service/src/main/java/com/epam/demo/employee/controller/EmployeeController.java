package com.epam.demo.employee.controller;

import com.epam.demo.employee.dto.APIResponseDto;
import com.epam.demo.employee.entity.Employee;
import com.epam.demo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public APIResponseDto getEmployeeDetails(@PathVariable int id){
        System.out.println("Inside emp controller "+ id);
        return employeeService.empWithDeptInfo(id);
    }

    @GetMapping("/employees/department/{deptCode}")
    public List<Employee> getEmployeesByDepartmentCode(@PathVariable String deptCode){
    return employeeService.getEmployeesByDepartmentCode(deptCode);
    }

    @GetMapping("/org/{orgCode}")
    public List<Employee> getEmpByOrgCode(@PathVariable String orgCode){
        return employeeService.getEmployeeByorgCode(orgCode);
    }
}
