package com.cognizant.arunabha;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private List<String> phones;

    public int getId() {
        return id;
    }

    public void show(){
        System.out.println("Showing Employee Class");
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}


