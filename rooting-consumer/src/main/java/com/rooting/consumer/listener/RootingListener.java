package com.rooting.consumer.listener;

import com.google.gson.Gson;
import com.rooting.consumer.repository.vo.ShopMVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RootingListener {

    @Autowired
    Gson gson;

    @Autowired
    Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = "shopM", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonSample(String shopMJson){

        logger.info(" >>> consumer input: " + shopMJson);
        ShopMVo shopMVo = gson.fromJson(shopMJson, ShopMVo.class);
        //service로 넘어가기
    }

//    @KafkaListener(topics = "shopM", containerFactory = "kafkaContainerFactory")
//    public void getJsonShopM(String shopMJson){
//
//    }
    @KafkaListener(topics="empM", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonEmpM(String empMJson){}

    @KafkaListener(topics="memM", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMemM(String memM){}

    @KafkaListener(topics="teamM", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonTeamM(String teamM){}

    @KafkaListener(topics="empLocM", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonEmpLoc(String empLoc){}
}