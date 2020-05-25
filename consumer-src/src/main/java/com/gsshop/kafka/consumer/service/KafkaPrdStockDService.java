package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpStockDVo;
import com.gsshop.kafka.consumer.repository.PrdStockDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdStockD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaPrdStockDService {

	@Autowired
    private PrdStockDJpaRepository prdStockDJpaRepository;
    
    public void setPrdStockDService(MpStockDVo mpStockDVo) {
    	PrdStockD prdStockD;
    	PrdStockD selPrdStockD = prdStockDJpaRepository.findByAttrPrdRepCd(mpStockDVo.getAttrPrdRepCd());
    	
    	if(!ObjectUtils.isEmpty(selPrdStockD)) {
    		prdStockD = ObjUtil.createObject(selPrdStockD, PrdStockD.class);
    		ObjUtil.copyObject(mpStockDVo,prdStockD);
    	}
    	else {
    		prdStockD = ObjUtil.createObject(mpStockDVo, PrdStockD.class);
    	}
    	//prdStockDCheckRequired(prdStockD);
    	prdStockDJpaRepository.save(prdStockD);
    }
   
	private void prdStockDCheckRequired(PrdStockD checkPrdStockD) {
	    
    }
    
}
