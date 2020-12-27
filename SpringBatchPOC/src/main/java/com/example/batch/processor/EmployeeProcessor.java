package com.example.batch.processor;

import com.example.batch.domain.Employee;
import com.example.batch.domain.EmployeeResponse;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

enum City{

    kol("Kolkata"),chn("Chennai");

    private String action;

    public String getAction()
    {
        return this.action;
    }

    private City(String action){
        this.action = action;
    }


}




@Component
public class EmployeeProcessor implements ItemProcessor<Employee, EmployeeResponse> {


    @Override
    public EmployeeResponse process(Employee employee) throws Exception {

        EmployeeResponse employeeResponse=new EmployeeResponse();
        String cDate = employee.getEmpbirthDate();
        DateFormat fromFormat = new SimpleDateFormat("MMddyyyy");
        Date curDate = fromFormat.parse(cDate);
        DateFormat toFormat = new SimpleDateFormat("MM-dd-yyyy");
        String toDate = toFormat.format(curDate);

        employeeResponse.setEmid(employee.getEmpID());
        employeeResponse.setFName(employee.getFirstName());
        employeeResponse.setLName(employee.getLastName());
        employeeResponse.setEmpDesig(employee.getDesignation());
        employeeResponse.setEmpBDate(toDate);
        employeeResponse.setSalary(Integer.parseInt(employee.getEmpSalary()));
        employeeResponse.setEmCity(City.valueOf(employee.getCity().toLowerCase()).getAction().toString());
        return employeeResponse;

    }



}
