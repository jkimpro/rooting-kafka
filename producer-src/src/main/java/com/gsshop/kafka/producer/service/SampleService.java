package com.gsshop.kafka.producer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.google.gson.Gson;
import com.gsshop.kafka.producer.repository.MpPrdMRepository;
import com.gsshop.kafka.producer.repository.jpa.MpPrdM;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
    private MpPrdMRepository mpPrdMRepository;
    
    /*여러건 전송예제*/
    
    public List<String> sampleSelectionKeyPrdPrdM(List<BigDecimal> prdCdList){
    	List <String> sendResultList = new ArrayList<String>();
    	
    	List <MpPrdM> mpPrdMList = new ArrayList<MpPrdM>();
    	for(BigDecimal tmpPrdCd: prdCdList) {
    		MpPrdM mpPrdM = mpPrdMRepository.findByPrdCd(tmpPrdCd);
    		if(!ObjectUtils.isEmpty(mpPrdM)) {
    			mpPrdMList.add(mpPrdM);
    		}
    	}
    	
    	String mainTopic = "everest-mpPrdM";
    
    	
    	
    	return sendResultList;
    }
    
    
    public List<String> sampleSelectionPrdPrdM(List <BigDecimal> prdCdList) {
    	
    	List <String> sendResultList = new ArrayList<String>();
    	List <MpPrdM> mpPrdMList = new ArrayList<MpPrdM>();
    	for(BigDecimal tmpPrdCd: prdCdList) {
    		MpPrdM mpPrdM = mpPrdMRepository.findByPrdCd(tmpPrdCd);
    		if(!ObjectUtils.isEmpty(mpPrdM)) {
    			mpPrdMList.add(mpPrdM);
    		}
    	}
    	
    	String topic = "test-partition";
    	
    	for(MpPrdM tmpMpPrdM: mpPrdMList) {
    		Gson sendData  = new Gson();
        	String sendStr = sendData.toJson(tmpMpPrdM);
        	StringBuilder resultValue = new StringBuilder();
        	    		
        	ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, sendStr);
        	future.addCallback(new ListenableFutureCallback<SendResult<String, String>>(){
        		
        		@Override
        		public void onSuccess(SendResult<String, String> result) {
        		 
                    log.info("Sent offset = ["+ result.getRecordMetadata().offset()+ "]");
                    log.info("Sent partition = ["+ result.getRecordMetadata().partition()+ "]");
                    log.info("Sent offset = ["+ result.getRecordMetadata().topic()+ "]");
                    
        			resultValue.append(result.getProducerRecord().value());
        		}
        		@Override
        		public void onFailure(Throwable ex){
        			throw new RuntimeException(ex);
        		}
        	});
        	sendResultList.add(resultValue.toString());
    	}	
    	return sendResultList;
    }
    
    
    /**
     * 단건(1 row) 전송 예제
     * @param prdCd - prd_prd_m 의 ID (PK) 
     * @return
     */
    public String samplePrdPrdM(BigDecimal prdCd) {
        MpPrdM mpPrdM = mpPrdMRepository.findByPrdCd(prdCd);
        String topic = "everest-mpPrdM";
        
        //String topic = "test-partition";
        StringBuilder resultValue = new StringBuilder();
        
        /*
         * 카프카로 DTO 전송 후 결과를 받아 처리하는 로직 샘플. 
         */
        Gson sendData = new Gson();
        String sendStr = sendData.toJson(mpPrdM);
        log.debug("send str : {}", sendStr);
        System.out.println("print ln send str : " + sendStr);
        
        ListenableFuture<SendResult<String, String>> future =  kafkaTemplate.send(topic, sendStr);
        
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            //성공시 
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent offset    =[" + result.getRecordMetadata().offset() + "]");
                log.info("Sent partition =[" + result.getRecordMetadata().partition() + "]");
                log.info("Sent topic     =[" + result.getRecordMetadata().topic() + "]");
                
                //전송한 JSON 데이터.
                resultValue.append(result.getProducerRecord().value());
            }

            //실패시
            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message due to : " + ex.getMessage());
                //Exception을 던지거나...
                //별도의 오류 보정 처리등...
                throw new RuntimeException(ex);
            }
        });
        
        //전송한 JSON 데이터.
        return resultValue.toString();
    }
    
    public String samplePrdPrdMPartition() {
        List<BigDecimal> prdCdList = new ArrayList<>();
        prdCdList.add(new BigDecimal("10972782"));
        prdCdList.add(new BigDecimal("32668400"));
        prdCdList.add(new BigDecimal("14422832"));
        prdCdList.add(new BigDecimal("10972782"));
        
        //String topic = "test-partition";
        String topic = "everest-mpPrdM";
        
        StringBuilder resultValue = new StringBuilder();
        
        /*
         * 카프카로 DTO 전송 후 결과를 받아 처리하는 로직 샘플. 
         */
        Gson sendData = new Gson();
        
        log.info("prdCdList size =[{}]", prdCdList.size());
        for(int i = 1; i <= prdCdList.size(); i++) {
            MpPrdM mpPrdM = mpPrdMRepository.findByPrdCd(prdCdList.get(i-1));
            String sendStr = sendData.toJson(mpPrdM);
            log.debug("[{}] send str : {}", i, sendStr);
            
            int partition = i % 2;
            String key = mpPrdM.getPrdCd() + String.valueOf(i%2);
            ListenableFuture<SendResult<String, String>> future =  kafkaTemplate.send(topic, partition, key, sendStr);
            log.info("set partition = [{}], key = [{}]", partition, key);
            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
    
                //성공시 
                @Override
                public void onSuccess(SendResult<String, String> result) {
                    log.info("Sent offset    =[" + result.getRecordMetadata().offset() + "]");
                    log.info("Sent partition =[" + result.getRecordMetadata().partition() + "]");
                    log.info("Sent topic     =[" + result.getRecordMetadata().topic() + "]");
                    
                    //전송한 JSON 데이터.
                    resultValue.append(result.getProducerRecord().value() + "\n\n\n");
                }
    
                //실패시
                @Override
                public void onFailure(Throwable ex) {
                    log.info("Unable to send message due to : " + ex.getMessage());
                    //Exception을 던지거나...
                    //별도의 오류 보정 처리등...
                    throw new RuntimeException(ex);
                }
            });
        }
        //전송한 JSON 데이터.
        return resultValue.toString();
    }
}
