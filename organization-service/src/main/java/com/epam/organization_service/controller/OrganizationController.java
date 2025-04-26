package com.epam.organization_service.controller;

import com.epam.organization_service.dto.EmployeeDtoOfOrg;
import com.epam.organization_service.entity.Organization;
import com.epam.organization_service.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/{orgCode}")
    public List<EmployeeDtoOfOrg> getAllEmpForAOrgCode(@PathVariable String orgCode){
        System.out.println("Vishal");
        return organizationService.getEmpByOrg(orgCode);
    }

    @GetMapping("/specific/{orgCode}")
    public Organization getEmp(@PathVariable String orgCode){
        System.out.println(" 1 inside controller"+ orgCode);
        return organizationService.getOrgByOrgCode(orgCode);
    }

}
