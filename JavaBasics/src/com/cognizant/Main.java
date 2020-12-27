package com.cognizant;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("This is my First Java Project");
        Student student1 = new Student(1,"Arunabha Bhaumik",28,8961060625L);
        Student student2 = new Student(2,"Souvik Majumder",30,9051267719L);
        Student student3 = new Student(3,"Anjan Santra",33,8961060614L);
        student1.profiledetails();
        student2.profiledetails();
        student3.profiledetails();
    }
}
