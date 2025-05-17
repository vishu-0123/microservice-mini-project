package com.epam.demo.department_service.service;

import com.epam.demo.department_service.client.EmployeeClient;
import com.epam.demo.department_service.dto.EmployeeDto;
import com.epam.demo.department_service.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    private static final Map<String, Department> departments = new HashMap<>();

    static {
        departments.put("IT-001", new Department("IT", "IT-001", "Information Technology Department"));
        departments.put("HR-002", new Department("HR", "HR-002", "Human Resources Department"));
        departments.put("FIN-001", new Department("Finance", "FIN-001", "Finance and Accounts Department"));
        departments.put("MKT-001", new Department("Marketing", "MKT-001", "Marketing and Sales Department"));
        departments.put("OPS-001", new Department("Operations", "OPS-001", "Operations and Logistics Department"));
    }

    @Autowired
    private EmployeeClient employeeClient;

    public List<EmployeeDto> getEmployeesInDepartment(String deptCode){
        return employeeClient.getEmployeeByDeptCode(deptCode);
    }

    public Department getDepartmentByDeptCode(String deptCode){
        if(departments.containsKey(deptCode)){
            return departments.get(deptCode);
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Department with code " + deptCode + "is not found 😒"
            );
        }
    }

}
