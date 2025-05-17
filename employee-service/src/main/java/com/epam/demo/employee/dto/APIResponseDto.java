package com.epam.demo.employee.dto;

import com.epam.demo.employee.entity.Employee;

public class APIResponseDto {

    private Employee employee;
    private DepartmentDto departmentDto;
    private OrganizationDto organizationDto;

    public APIResponseDto(Employee employee, DepartmentDto departmentDto,OrganizationDto organizationDto) {
        this.employee = employee;
        this.departmentDto = departmentDto;
        this.organizationDto=organizationDto;
    }

    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }

    public void setOrganizationDto(OrganizationDto organizationDto) {
        this.organizationDto = organizationDto;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }
}
