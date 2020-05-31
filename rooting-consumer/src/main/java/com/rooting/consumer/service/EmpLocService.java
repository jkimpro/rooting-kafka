package com.rooting.consumer.service;

import com.rooting.consumer.repository.EmpLocJpaRepository;
import com.rooting.consumer.repository.vo.EmpLocVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

@Service
public class EmpLocService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EmpLocJpaRepository empLocJpaRepository;

    public void setLocation(EmpLocVo input){
        try{
            EmpLocVo nowEmpLoc = empLocJpaRepository.findByEmpCd(input.getEmpCd());
        }
        catch(Exception e) {
            //실행하기
            //새로이 저장하는 로직 필요함.
        }
    }


}

