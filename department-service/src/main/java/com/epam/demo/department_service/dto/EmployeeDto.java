package com.epam.demo.department_service.dto;

public class EmployeeDto {

    private int empId;
    private String empName;
    private String departmentCode;

    public EmployeeDto(int empId, String empName, String departmentCode) {
        this.empId = empId;
        this.empName = empName;
        this.departmentCode = departmentCode;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
