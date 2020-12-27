package com.example.batch.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class EmployeeResponse {

    private String Emid;
    private String FName;
    private String LName;
    private String EmpDesig;
    private String EmpBDate;
    private Integer Salary;
    private String EmCity;

    public String getEmid() {
        return Emid;
    }

    public void setEmid(String emid) {
        Emid = emid;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getEmpDesig() {
        return EmpDesig;
    }

    public void setEmpDesig(String empDesig) {
        EmpDesig = empDesig;
    }

    public String getEmpBDate() {
        return EmpBDate;
    }

    public void setEmpBDate(String empBDate) {
        EmpBDate = empBDate;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public String getEmCity() {
        return EmCity;
    }

    public void setEmCity(String emCity) {
        EmCity = emCity;
    }
}
