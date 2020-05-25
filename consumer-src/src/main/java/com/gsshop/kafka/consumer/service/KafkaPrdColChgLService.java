package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpColChgLVo;
import com.gsshop.kafka.consumer.repository.PrdColChgLJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdColChgL;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdColChgLService {
	
	@Autowired
    private PrdColChgLJpaRepository prdColChgLJpaRepository;
    
	public void setPrdColChgLService(MpColChgLVo mpColChgLVo) {
		PrdColChgL prdColChgL;
		PrdColChgL selPrdColChgL = prdColChgLJpaRepository.findByLogSeq(mpColChgLVo.getLogSeq());
		
		if(!ObjectUtils.isEmpty(selPrdColChgL)) {
			prdColChgL = ObjUtil.createObject(selPrdColChgL, PrdColChgL.class);
    		ObjUtil.copyObject(mpColChgLVo,prdColChgL);
    	}
    	else {
    		prdColChgL = ObjUtil.createObject(mpColChgLVo, PrdColChgL.class);
    	}
		
		prdColChgLCheckRequired(prdColChgL);
		prdColChgLJpaRepository.save(prdColChgL);
	}
	
	private void prdColChgLCheckRequired(PrdColChgL checkPrdColChgL) {
		
	}
	
}
