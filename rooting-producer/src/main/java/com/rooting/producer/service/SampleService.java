package com.rooting.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SampleService {
    @Autowired
    KafkaTemplate <String, String> kafkaTemplate;


    public String sample(BigDecimal prdCd){
        return "";
    }
}
