package com.example.batch.repository;

import com.example.batch.domain.Employee;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee=new Employee();
        if(!resultSet.isAfterLast()) {
            employee.setEmpID(resultSet.getString("EMPID"));
            employee.setFirstName(resultSet.getString("FIRSTNAME"));
            employee.setLastName(resultSet.getString("LASTNAME"));
            employee.setDesignation(resultSet.getString("DESIGNATION"));
            employee.setEmpbirthDate(resultSet.getString("EMPBIRTHDATE"));
            employee.setEmpSalary(resultSet.getString("EMPSALARY"));
            employee.setCity(resultSet.getString("EMPCITY"));
        }

        return employee;
    }
}
