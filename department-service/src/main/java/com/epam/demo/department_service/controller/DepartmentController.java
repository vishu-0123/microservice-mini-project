package com.epam.demo.department_service.controller;


import com.epam.demo.department_service.dto.EmployeeDto;
import com.epam.demo.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/{deptCode}")
    public List<EmployeeDto> getEmployeeByDeptCode(@PathVariable String deptCode){
        return departmentService.getEmployeesInDepartment(deptCode);
    }
}
