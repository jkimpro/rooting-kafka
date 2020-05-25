package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpShopExposDVo;
import com.gsshop.kafka.consumer.repository.PrdShopExposDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdShopExposD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdShopExposDService {

	@Autowired
    private PrdShopExposDJpaRepository prdShopExposDJpaRepository;
    
	public void setPrdShopExposDService(MpShopExposDVo mpShopExposDVo) {
    	PrdShopExposD prdShowExposD;
    	PrdShopExposD selPrdShowExposD = prdShopExposDJpaRepository.findByPrdCd(mpShopExposDVo.getPrdCd());
    	
    	if ( !ObjectUtils.isEmpty(selPrdShowExposD) ) {
    		prdShowExposD = ObjUtil.createObject(selPrdShowExposD, PrdShopExposD.class);
        	ObjUtil.copyObject(mpShopExposDVo, prdShowExposD);
        } else {
        	prdShowExposD = ObjUtil.createObject(mpShopExposDVo, PrdShopExposD.class);
	    }
    	
    	//별도의 체크필요한 column 없음
    	prdShopExposDJpaRepository.save(prdShowExposD);
    }
    
}
