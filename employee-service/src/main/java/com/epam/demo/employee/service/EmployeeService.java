package com.epam.demo.employee.service;

import com.epam.demo.employee.client.DepartmentClient;
import com.epam.demo.employee.client.OrganizationClient;
import com.epam.demo.employee.dto.APIResponseDto;
import com.epam.demo.employee.dto.DepartmentDto;
import com.epam.demo.employee.dto.OrganizationDto;
import com.epam.demo.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

        private static final Map<Integer , Employee> employeeMap = new HashMap<>();

        static {
            employeeMap.put(659977,new Employee("Vishal",659977,"IT-001","ORG-001"));
            employeeMap.put(2, new Employee("Aman", 2, "HR-002","ORG-002"));
            employeeMap.put(3, new Employee("Priya", 3, "IT-001","ORG-003"));
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
        @Autowired
        private OrganizationClient organizationClient;
//        public APIResponseDto getEmployeeWithDepartmentCode(int id){
//            Employee employee = getEmployeeById(id);
//
//            DepartmentDto department = departmentClient.getDepartmentByCode(employee.getDepartmentCode());
//            return new APIResponseDto(employee,department,orga);
//        }

        public APIResponseDto empWithDeptInfo(int id){
            System.out.println("2 Inside the service");
            Employee employee = getEmployeeById(id);
            System.out.println("3 "+employee.toString());
            DepartmentDto departmentDto=departmentClient.getDeptInfo(employee.getDepartmentCode());
            OrganizationDto organizationDto =organizationClient.getEmpByOrgCode(employee.getOrgCode());
            return new APIResponseDto(employee,departmentDto,organizationDto);
        }

    public List<Employee> getEmployeesByDepartmentCode(String deptCode) {
        return employeeMap.values().stream()
                .filter(emp -> emp.getDepartmentCode().equalsIgnoreCase(deptCode))
                .toList();
    }

    public List<Employee> getEmployeeByorgCode(String orgCode){
            return employeeMap.values().stream()
                    .filter(emp->emp.getOrgCode().equalsIgnoreCase(orgCode))
                    .collect(Collectors.toList());
    }


}
