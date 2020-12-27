package com.example.batch.configuration;

import com.example.batch.domain.EmployeeResponse;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
//@EnableJpaRepositories
public class EmployeeDetailsDataSourceConfig {

    /*@Value("${oradriver}")
    private String oradrvr;

    @Value("${jdbcuri}")
    private String jdburl;

    @Value("${connid}")
    private String uid;

    @Value("${connpwd}")
    private String pwd;*/


    @Bean(name="EmployeeDetailsDataSource")
    public OracleDataSource EmployeeDetailsDataSource() throws SQLException {
        OracleDataSource oracleDataSource=new OracleDataSource();
        oracleDataSource.setDriverType("oracle.jdbc.OracleDriver");
        oracleDataSource.setURL("jdbc:oracle:thin:@//localhost:1521/ORCL11");
        oracleDataSource.setUser("emp_admin");
        oracleDataSource.setPassword("pass4word");
        return oracleDataSource;

    }

}
