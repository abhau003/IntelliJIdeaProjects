package com.arunabha.springbatch.config;


import com.arunabha.springbatch.model.Employee;
import com.arunabha.springbatch.model.Person;
import com.arunabha.springbatch.processor.EmployeeItemProcessor;
import com.arunabha.springbatch.repository.EmployeeRowMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.function.Function;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    @Qualifier("BatchDataSource")
    DataSource dataSource;

    @Autowired
    @Qualifier("EmployeeDetailsDataSource")
    DataSource dataSource1;

    @Autowired
    @Qualifier("PersonResponseDataSource")
    DataSource dataSource2;

    @Bean
    public JdbcCursorItemReader<Employee> reader(){
        JdbcCursorItemReader<Employee> cursorItemReader = new JdbcCursorItemReader<>();
        cursorItemReader.setDataSource(dataSource1);
        cursorItemReader.setSql("SELECT employee_id,first_name,last_name,email,age FROM Employee");
        cursorItemReader.setRowMapper(new EmployeeRowMapper());
        return cursorItemReader;
    }


    @Bean
    public EmployeeItemProcessor processor(){
        return new EmployeeItemProcessor();
    }

   /* @Bean
    public FlatFileItemWriter<Employee> writer(){
        FlatFileItemWriter<Employee> writer = new FlatFileItemWriter<Employee>();
        writer.setResource(new ClassPathResource("employee.csv"));

        DelimitedLineAggregator<Employee> lineAggregator = new DelimitedLineAggregator<Employee>();
        lineAggregator.setDelimiter(",");

        BeanWrapperFieldExtractor<Employee>  fieldExtractor = new BeanWrapperFieldExtractor<Employee>();
        fieldExtractor.setNames(new String[]{"id","first_name","last_name","email","age"});
        lineAggregator.setFieldExtractor(fieldExtractor);

        writer.setLineAggregator(lineAggregator);
        return writer;
    }*/

    @Bean
    public JdbcBatchItemWriter<Person> writer() {
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
        writer.setSql("INSERT INTO person (person_id,first_name, last_name,email, age) VALUES (:id,:first_name, :last_name,:email,:age)");
        writer.setDataSource(dataSource2);
        return writer;
    }

    @Bean
    public Step step1(){
       return stepBuilderFactory.get("step1").<Employee, Person>chunk(100).reader(reader()).processor(processor()).writer(writer()).build();
        }

    @Bean
    public Job exportEmployeeJob(){
        return jobBuilderFactory.get("exportEmployeeJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
    }
}
