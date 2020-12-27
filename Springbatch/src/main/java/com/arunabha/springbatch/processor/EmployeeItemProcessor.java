package com.arunabha.springbatch.processor;

import com.arunabha.springbatch.model.Employee;
import com.arunabha.springbatch.model.Person;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Person> {
    @Override
    public Person process(Employee employee) throws Exception {

        final String firstName = employee.getFirst_name().toUpperCase();
        final String lastName = employee.getLast_name().toUpperCase();

        final Person transformedPerson = new Person(employee.getId(),firstName, lastName,employee.getEmail(),employee.getAge());

        return transformedPerson;
    }
}
