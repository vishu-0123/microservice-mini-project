package com.epam.organization_service.service;

import com.epam.organization_service.client.EmployeeClientOfOrg;
import com.epam.organization_service.dto.EmployeeDtoOfOrg;
import com.epam.organization_service.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrganizationService {

    @Autowired
    private EmployeeClientOfOrg employeeClientOfOrg;

    public static final Map<String, Organization> ORGANIZATION_MAP = new HashMap<>();

    static {
        ORGANIZATION_MAP.put("ORG-001", new Organization("ORG-001", "EPAM Systems", "Global provider of digital platform engineering and software development services."));
        ORGANIZATION_MAP.put("ORG-002", new Organization("ORG-002", "Infosys", "Multinational corporation providing business consulting, information technology and outsourcing services."));
        ORGANIZATION_MAP.put("ORG-003", new Organization("ORG-003", "TCS", "Leading global IT services, consulting, and business solutions organization."));
        ORGANIZATION_MAP.put("ORG-004", new Organization("ORG-004", "Google", "Technology company that specializes in Internet-related services and products."));
    }

    public Organization getOrgByOrgCode(String orgCode){
        System.out.println("Inside the service");
        if (ORGANIZATION_MAP.containsKey(orgCode)){
            System.out.println("Inside if of orgService");
            return ORGANIZATION_MAP.get(orgCode);
        }
        else {
            System.out.println("Inside else of orgService");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Organization with code" + orgCode + "not found"
            );
        }
    }

    public List<EmployeeDtoOfOrg> getEmpByOrg(String orgCode){
        return employeeClientOfOrg.getEmployeeByOrgCode(orgCode);
    }


}
