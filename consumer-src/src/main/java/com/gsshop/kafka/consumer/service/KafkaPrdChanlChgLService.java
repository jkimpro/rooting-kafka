package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpChanlChgLVo;
import com.gsshop.kafka.consumer.repository.PrdChanlChgLJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdChanlChgL;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdChanlChgLService {
	
	@Autowired
	private PrdChanlChgLJpaRepository prdChanlChgLJpaRepository;
	
	public void setPrdChanlChgLService(MpChanlChgLVo mpChanlChgLVo) {
		
		PrdChanlChgL prdChanlChgL;
		PrdChanlChgL selPrdChanlChgL = prdChanlChgLJpaRepository.findByPrdCdAndChanlCdAndLogRegDtm(mpChanlChgLVo.getPrdCd(),
				mpChanlChgLVo.getChanlCd(), mpChanlChgLVo.getLogRegDtm());
				
				
				
    	if(!ObjectUtils.isEmpty(selPrdChanlChgL)) {
    		prdChanlChgL = ObjUtil.createObject(selPrdChanlChgL, PrdChanlChgL.class);
    		ObjUtil.copyObject(mpChanlChgLVo,prdChanlChgL);
    	}
    	else {
    		prdChanlChgL = ObjUtil.createObject(mpChanlChgLVo, PrdChanlChgL.class);
    	}
    	
    	prdChanlChgLCheckRequired(prdChanlChgL);
    	prdChanlChgLJpaRepository.save(prdChanlChgL);
	
	}

	private void prdChanlChgLCheckRequired(PrdChanlChgL checkPrdChanlChgL) {
		//나머지는 공통임
		if(ObjectUtils.isEmpty(checkPrdChanlChgL.getQaInspYn())){
			checkPrdChanlChgL.setQaInspYn("N");
		}
	}	
}
