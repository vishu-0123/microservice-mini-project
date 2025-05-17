package com.epam.demo.employee.entity;

public class Employee {

    private int empId;
    private String empName;
    private String departmentCode;
    private String orgCode;

    public Employee(String empName, int empId, String departmentCode,String orgCode) {
        this.empName = empName;
        this.empId = empId;
        this.departmentCode = departmentCode;
        this.orgCode=orgCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
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
