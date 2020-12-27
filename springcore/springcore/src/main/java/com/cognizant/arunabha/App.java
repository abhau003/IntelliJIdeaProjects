package com.cognizant.arunabha;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("beans.xml File Loaded");
        Airtel airtel = context.getBean("airtel",Airtel.class);
        airtel.activateService();
        Airtel airtel1 = context.getBean("airtel1",Airtel.class);
        airtel1.activateService();
    }


}

