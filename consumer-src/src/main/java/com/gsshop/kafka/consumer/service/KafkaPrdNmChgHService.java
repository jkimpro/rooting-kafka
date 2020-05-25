package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpNmChgHVo;
import com.gsshop.kafka.consumer.repository.PrdNmChgHJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdNmChgH;
import com.gsshop.kafka.util.DateUtil;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdNmChgHService {
	@Autowired
    private PrdNmChgHJpaRepository prdNmChgHJpaRepository;
   
	public void setPrdNmChgHService(MpNmChgHVo mpNmChgHVo) {
    	PrdNmChgH prdNmChgH; 
    	PrdNmChgH selPrdNmChgH = prdNmChgHJpaRepository.findByPrdCdAndChanlCdAndValidEndDtmAndValidStrDtm(mpNmChgHVo.getPrdCd(), mpNmChgHVo.getChanlCd(), mpNmChgHVo.getValidEndDtm(), mpNmChgHVo.getValidStrDtm());
    	
    	if(!ObjectUtils.isEmpty(selPrdNmChgH)) {
    		prdNmChgH = ObjUtil.createObject(selPrdNmChgH, PrdNmChgH.class);
    		ObjUtil.copyObject(mpNmChgHVo,prdNmChgH);
    	}
    	else {
    		prdNmChgH = ObjUtil.createObject(mpNmChgHVo, PrdNmChgH.class);
    	}
    	prdNmChgHCheckRequired(prdNmChgH);
    	prdNmChgHJpaRepository.save(prdNmChgH);
    }
	
	private void prdNmChgHCheckRequired(PrdNmChgH checkPrdNmChgH) {
    	if(ObjectUtils.isEmpty(checkPrdNmChgH.getValidEndDtm())) {
    		checkPrdNmChgH.setValidEndDtm(DateUtil.getMaxDate());
    	}
    }
}
