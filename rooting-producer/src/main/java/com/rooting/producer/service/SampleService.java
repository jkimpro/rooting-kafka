package com.rooting.producer.service;

import com.google.gson.Gson;
import com.rooting.producer.repository.EmpMJpaRepository;
import com.rooting.producer.vo.EmpMVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SampleService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate <String, String> kafkaTemplate;

    @Autowired
    private EmpMJpaRepository empMJpaRepository;


    public List<String> sampleSelectionKeyEmpM(List<BigDecimal> list){
        List<String> sendResultList = new ArrayList<String>();

        List <EmpMVo> empMList = new ArrayList<EmpMVo>();
        for(BigDecimal empCd: list){
            //찾아오기
        }

        return sendResultList;
    }

    /*
    * empCd 다건 전송 리스트
    * @param : empCdList (empCd 코드의 집합)
    * @return : 결과 전송 리스트
    *
    * */
    public List<String> sampleSelectionEmpM(List<BigDecimal>empCdList){
        List <String> sendResultList = new ArrayList<String>();
        List <EmpMVo> empMList = new ArrayList<EmpMVo>();

        for(BigDecimal tmpEmpCd: empCdList){
            EmpMVo empMVo = empMJpaRepository.findByEmpCd(tmpEmpCd);
            if(!ObjectUtils.isEmpty(empMVo)){
                empMList.add(empMVo);
            }
        }

        String topic = "test-partition";

        for(EmpMVo empMVo: empMList){
            Gson sendData = new Gson();
            String sendStr = sendData.toJson(empMVo);
            StringBuilder resultValue = new StringBuilder();

            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic,sendStr);
            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                   @Override
                   public void onFailure(Throwable ex) {
                       logger.info("send failure : " + sendStr);
                   }

                   @Override
                   public void onSuccess(SendResult<String, String> result) {
                       logger.info("Sent offset = [" +  result.getRecordMetadata().offset()+"]");
                       logger.info("Sent partition = [" +  result.getRecordMetadata().partition()+"]");
                       logger.info("Sent topic = [" +  result.getRecordMetadata().topic()+"]");
                       resultValue.append(result.getProducerRecord().value());
                   }

                });
            sendResultList.add(resultValue.toString());
        }
        return sendResultList;
    }

    /*
    * @param : empCd
    * @return : 전송 결과
    *
    * notes: 단건으로 전송함
    * */
    public String sampleEmpM(BigDecimal empCd){

        EmpMVo empMVo = empMJpaRepository.findByEmpCd(empCd);
        String topic = "test-partition";

        Gson sendData = new Gson();
        String sendStr = sendData.toJson(empMVo);
        StringBuilder resultValue = new StringBuilder();
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, sendStr);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("send failure : " + sendStr);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("Sent offset = [" +  result.getRecordMetadata().offset()+"]");
                logger.info("Sent partition = [" +  result.getRecordMetadata().partition()+"]");
                logger.info("Sent topic = [" +  result.getRecordMetadata().topic()+"]");
                resultValue.append(result.getProducerRecord().value());
            }
        });
        return resultValue.toString();
    }


}
