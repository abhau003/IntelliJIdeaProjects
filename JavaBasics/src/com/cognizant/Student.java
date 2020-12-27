package com.cognizant;

public class Student {
    int id;
    String name;
    int age;
    long phone;

    public Student(int id,String name,int age, long phone){
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public void profiledetails(){
        System.out.println("Id" +" " +id);
        System.out.println("Name" +" " +name);
        System.out.println("Age" +" " +age);
        System.out.println("Phone" +" " +phone);
    }
}
