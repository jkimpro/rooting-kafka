package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpChanlDVo;
import com.gsshop.kafka.consumer.repository.PrdChanlDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdChanlD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaPrdChanlDService {
	@Autowired
    private PrdChanlDJpaRepository prdChanlDJpaRepository;
	
	public void setPrdChanlDService(MpChanlDVo mpChanlDVo) {
    	
		PrdChanlD prdChanlD;
		PrdChanlD selPrdChanlD = prdChanlDJpaRepository.findByPrdCdAndChanlCd(mpChanlDVo.getPrdCd(),mpChanlDVo.getChanlCd());
				
    	if(!ObjectUtils.isEmpty(selPrdChanlD)) {
    		prdChanlD = ObjUtil.createObject(selPrdChanlD, PrdChanlD.class);
    		ObjUtil.copyObject(mpChanlDVo,prdChanlD);
    	}
    	else {
    		prdChanlD = ObjUtil.createObject(mpChanlDVo, PrdChanlD.class);
    	}
    	
    	prdChanlDCheckRequired(prdChanlD);
    	prdChanlDJpaRepository.save(prdChanlD);
    }
	
	private void prdChanlDCheckRequired(PrdChanlD checkPrdChanlD) {
		if(ObjectUtils.isEmpty(checkPrdChanlD.getQaInspYn())) {
			checkPrdChanlD.setQaInspYn("N");
    	}
	}
}
