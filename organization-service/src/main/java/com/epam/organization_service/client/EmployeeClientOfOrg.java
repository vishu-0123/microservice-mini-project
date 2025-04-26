package com.epam.organization_service.client;

import com.epam.organization_service.dto.EmployeeDtoOfOrg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeClientOfOrg {

    @GetMapping("/employee/org/{orgCode}")
    List<EmployeeDtoOfOrg> getEmployeeByOrgCode(@PathVariable("orgCode")String orgCode);
}
