package com.epam.demo.employee.dto;

import com.epam.demo.employee.entity.Employee;

public class APIResponseDto {

    private Employee employee;
    private DepartmentDto departmentDto;

    public APIResponseDto(Employee employee, DepartmentDto departmentDto) {
        this.employee = employee;
        this.departmentDto = departmentDto;
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
