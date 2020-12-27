package com.cognizant.arunabha;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args){
        System.out.println("A");
        ApplicationContext cx = new ClassPathXmlApplicationContext("listconfig.xml");
        System.out.println("B");
        Movie movie = (Movie) cx.getBean("movie");
        System.out.println("Movie Name: " + movie.getName());
        System.out.println("Movie Genre: " +movie.getGenre());
    }
}
