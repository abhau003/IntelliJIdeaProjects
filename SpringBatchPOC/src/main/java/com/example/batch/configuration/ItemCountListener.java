package com.example.batch.configuration;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class ItemCountListener implements ChunkListener {
    private String msg;

    KafkaProducerConfig kafkaProducerConfig=new KafkaProducerConfig();
    Properties props = new Properties();


    ItemCountListener()
    {
        kafkaProducerConfig.setProps(props);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void beforeChunk(ChunkContext context) {

    }

    @Override

    public void afterChunk(ChunkContext context) {

        int count = context.getStepContext().getStepExecution().getWriteCount();
        msg="No of records written:";
        msg=msg+count;
        kafkaProducerConfig.send(msg);
        System.out.println(msg);
    }

    @Override
    public void afterChunkError(ChunkContext context) {
    }

}
