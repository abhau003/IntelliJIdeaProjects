package com.example.batch.configuration;
import com.example.batch.configuration.ItemCountListener;
import com.example.batch.Listener.StepListener;
import com.example.batch.domain.Employee;
import com.example.batch.domain.EmployeeResponse;
import com.example.batch.repository.EmployeeRowMapper;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.batch.configuration.BatchDataSourceConfig;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.support.incrementer.HsqlSequenceMaxValueIncrementer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@EnableBatchProcessing
@Configuration
//@EnableAutoConfiguration
public class BatchConfig {
    @Autowired
    DataSource dataSource;

     @Value("${sql}")
    private String selsql;

     @Value("${InsSql}")
     private String inssql;

     @Value("${csize}")
     private Integer chunk;

     @Value("${throt}")
     private Integer tsize;

    @Autowired
    @Qualifier("EmployeeDetailsDataSource")
    DataSource dataSource1;


    @Autowired
    @Qualifier("EmployeeResponseDataSource")
    DataSource dataSource2;

    Employee employee = new Employee();

    StepListener stepListener=new StepListener();


    @Bean(name="task")
    public TaskExecutor taskExecutor(){
        return new SimpleAsyncTaskExecutor("employee_batch");
    }

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ItemReader itemReader, ItemProcessor itemProcessor, ItemWriter itemWriter,TaskExecutor taskExecutor)
    {
       /* Step step=stepBuilderFactory.get("step1").chunk(chunk).reader(itemReader).
                processor(itemProcessor).writer(itemWriter).listener(listener()).taskExecutor(taskExecutor).throttleLimit(tsize).build();*/
        Step step=stepBuilderFactory.get("step1").chunk(chunk).reader(itemReader).
                processor(itemProcessor).writer(itemWriter).faultTolerant().retryLimit(3).listener(listener()).taskExecutor(taskExecutor).throttleLimit(tsize).build();



        return jobBuilderFactory.get("EmployeeProcessor").incrementer(new RunIdIncrementer()).start(step).build();
    }

    @Bean
    public JdbcCursorItemReader reader()
    {
        JdbcCursorItemReader jdbcCursorItemReader=new JdbcCursorItemReader();
        jdbcCursorItemReader.setDataSource(dataSource1);
        //System.out.println(selsql);
        jdbcCursorItemReader.setSql(selsql);
        jdbcCursorItemReader.setVerifyCursorPosition(false);
        jdbcCursorItemReader.setRowMapper(new EmployeeRowMapper());
        return jdbcCursorItemReader;
    }

   @Bean
    public JdbcBatchItemWriter<EmployeeResponse> writer() {
        JdbcBatchItemWriter<EmployeeResponse> jdbcBatchItemWriter = new JdbcBatchItemWriter();
        jdbcBatchItemWriter.setDataSource(dataSource2);
        jdbcBatchItemWriter.setSql(inssql);
       //jdbcBatchItemWriter.setSql("Insert into employee_response(EMID,FNAME,LNAME,EMPDESIG,EMPBDATE,SALARY,EMCITY)values(:Emid,:FName,:LName,:EmpDesig,:EmpBDate,:Salary,:EmCity)");
        jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return  jdbcBatchItemWriter;
    }


    @Bean
    public ItemCountListener listener() {
        return new ItemCountListener();
    }



}
