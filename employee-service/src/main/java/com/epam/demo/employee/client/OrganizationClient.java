package com.epam.demo.employee.client;

import com.epam.demo.employee.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationClient {

    @GetMapping("/org/specific/{orgCode}")
    OrganizationDto getEmpByOrgCode(@PathVariable String orgCode);
}
