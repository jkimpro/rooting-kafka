package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpUdaDVo;
import com.gsshop.kafka.consumer.repository.PrdUdaDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdUdaD;
import com.gsshop.kafka.util.DateUtil;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdUdaDService {

	@Autowired
    private PrdUdaDJpaRepository prdUdaDJpaRepository;

	public void setPrdUdaDService(MpUdaDVo mpUdaDVo) {
	
		PrdUdaD prdUdaD;
		PrdUdaD selPrdUdaD = prdUdaDJpaRepository.findByUdaNoAndPrdCdAndValidEndDtmAndValidStrDtm(mpUdaDVo.getUdaNo(), 
				mpUdaDVo.getPrdCd(), mpUdaDVo.getValidEndDtm(), mpUdaDVo.getValidStrDtm());
				
		if(!ObjectUtils.isEmpty(selPrdUdaD)) {
			prdUdaD = ObjUtil.createObject(selPrdUdaD, PrdUdaD.class);
    		ObjUtil.copyObject(mpUdaDVo,prdUdaD);
    	}
    	else {
    		prdUdaD = ObjUtil.createObject(mpUdaDVo, PrdUdaD.class);
    	}

		prdUdaDCheckRequired(prdUdaD);
		prdUdaDJpaRepository.save(prdUdaD);
		
	}
	
	private void prdUdaDCheckRequired(PrdUdaD checkPrdUdaD) {
		if(ObjectUtils.isEmpty(checkPrdUdaD.getValidEndDtm())) {
			checkPrdUdaD.setValidEndDtm(DateUtil.getMaxDate());
    	}
		if(ObjectUtils.isEmpty(checkPrdUdaD.getUdaVal())) {
			checkPrdUdaD.setUdaVal("*");
		}
		
	}
}
