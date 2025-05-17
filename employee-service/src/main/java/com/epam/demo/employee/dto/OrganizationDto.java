package com.epam.demo.employee.dto;

public class OrganizationDto {
    private String organizationCode;
    private String organizationName;
    private String organizationDescription;

    public OrganizationDto(String organizationCode, String organizationName, String organizationDescription) {
        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }
}
