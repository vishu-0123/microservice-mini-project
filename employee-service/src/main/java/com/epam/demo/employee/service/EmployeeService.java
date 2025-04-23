package com.epam.demo.employee.service;

import com.epam.demo.employee.client.DepartmentClient;
import com.epam.demo.employee.dto.APIResponseDto;
import com.epam.demo.employee.dto.DepartmentDto;
import com.epam.demo.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

        private static final Map<Integer , Employee> employeeMap = new HashMap<>();

        static {
            employeeMap.put(659977,new Employee("Vishal",659977,"IT-001"));
            employeeMap.put(2, new Employee("Aman", 2, "HR-002"));
            employeeMap.put(3, new Employee("Priya", 3, "IT-001"));
        }

        public Employee getEmployeeById(int id){
            if (employeeMap.containsKey(id)) {
                return employeeMap.get(id);
            }

            else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employee with ID " + id + " not found"
                );
            }

        }

        @Autowired
    private DepartmentClient departmentClient;
        public APIResponseDto getEmployeeWithDepartmentCode(int id){
            Employee employee = getEmployeeById(id);

            DepartmentDto department = departmentClient.getDepartmentByCode(employee.getDepartmentCode());
            return new APIResponseDto(employee,department);
        }

        public APIResponseDto empWithDeptInfo(int id){
            Employee employee = getEmployeeById(id);
            DepartmentDto departmentDto=departmentClient.getDeptInfo(employee.getDepartmentCode());
            return new APIResponseDto(employee,departmentDto);
        }

    public List<Employee> getEmployeesByDepartmentCode(String deptCode) {
        return employeeMap.values().stream()
                .filter(emp -> emp.getDepartmentCode().equalsIgnoreCase(deptCode))
                .toList();
    }


}
