package com.example.batch.controller;

import com.example.batch.Listener.StepListener;
import com.example.batch.configuration.ItemCountListener;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/batch")
@Configuration
//@EnableAutoConfiguration
public class BatchController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;
    //ItemCountListener itemCountListener=new ItemCountListener();

    //StepListener stepListener=new StepListener();

    @GetMapping
    public BatchStatus batch() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        Map<String, JobParameter>jobParameterMap=new HashMap<>();
        JobParameter jobParameter=new JobParameter(System.currentTimeMillis());
        jobParameterMap.put("Time",jobParameter);
        JobParameters jobParameters=new JobParameters(jobParameterMap);
        JobExecution  jobExecution=jobLauncher.run(job,jobParameters);
        return jobExecution.getStatus();

    }


}
