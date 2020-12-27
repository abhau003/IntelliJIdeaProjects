package com.example.batch.configuration;

import com.example.batch.domain.Employee;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableJpaRepositories
public class BatchDataSourceConfig {

    @Value("${msqldriver}")
    private String bdrvr;

    @Value("${batchjdbcuri}")
    private String bjdburl;

    @Value("${batchconnid}")
    private String batchuid;

    @Value("${batchconnpwd}")
    private String batchpwd;


    @Bean(name="BatchDataSource")
    @Primary
    public DataSource BatchDataSource() throws SQLException {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(bdrvr);
        dataSourceBuilder.url(bjdburl);
        dataSourceBuilder.username(batchuid);
        dataSourceBuilder.password(batchpwd);
        return dataSourceBuilder.build();
    }


}
