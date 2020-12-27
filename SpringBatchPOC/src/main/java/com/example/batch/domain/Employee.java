package com.example.batch.domain;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




public class Employee {

    private String EmpID;

    private String FirstName;


    private String LastName;


    private String Department;

    private String City;

    private String Designation;

    private String EmpbirthDate;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    private String EmpSalary;


    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        EmpID = empID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getEmpbirthDate() {
        return EmpbirthDate;
    }

    public void setEmpbirthDate(String empbirthDate) {
        EmpbirthDate = empbirthDate;
    }

    public String getEmpSalary() {
        return EmpSalary;
    }

    public void setEmpSalary(String empSalary) {
        EmpSalary = empSalary;
    }
}
