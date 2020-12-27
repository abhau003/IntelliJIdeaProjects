package com.example.batch.Listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepListener implements StepExecutionListener {
    @Override
    public ExitStatus afterStep(StepExecution arg0) {
        int readCount=arg0.getReadCount();
        int writeCount=arg0.getWriteCount();
        int skipCount=arg0.getSkipCount();
        int commitCount=arg0.getCommitCount();

        System.out.println(writeCount);

        return ExitStatus.COMPLETED;

    }

    @Override
    public void beforeStep(StepExecution arg0) {
        int readCount=arg0.getReadCount();
        int writeCount=arg0.getWriteCount();
        int skipCount=arg0.getSkipCount();
        int commitCount=arg0.getCommitCount();

        System.out.println(writeCount);




    }


}
