package com.rooting.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RootingListener {

    @KafkaListener(topics = "shopM", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonSample(String shopMJson){

    }

//    @KafkaListener(topics = "shopM", containerFactory = "kafkaContainerFactory")
//    public void getJsonShopM(String shopMJson){
//
//    }
//
//    @KafkaListener
//    public void getJsonEmpM(String empMJson){}
//
//    @KafkaListener
//    public void getJsonMemM(String memM){}
//
//    @KafkaListener
//    public void getJsonTeamM(String teamM){}
//
//    @KafkaListener
//    public void getJsonEmpLoc(String empLoc){}
}