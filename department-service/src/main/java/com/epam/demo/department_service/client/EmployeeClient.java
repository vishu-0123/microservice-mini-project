package com.epam.demo.department_service.client;

import com.epam.demo.department_service.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="EMPLOYEE-SERVICE")
public interface EmployeeClient {
@GetMapping("/employee/employees/department/{deptCode}")
    List<EmployeeDto> getEmployeeByDeptCode(@PathVariable("deptCode") String deptCode);
}
