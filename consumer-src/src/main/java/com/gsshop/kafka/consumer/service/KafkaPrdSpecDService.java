package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpSpecDVo;
import com.gsshop.kafka.consumer.repository.PrdSpecDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdSpecD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaPrdSpecDService {

	@Autowired
    private PrdSpecDJpaRepository prdSpecDJpaRepository;
    
	public void setPrdSpecDService(MpSpecDVo mpSpecDVo) {
    	PrdSpecD prdSpecD;
    	PrdSpecD selPrdSpecD = prdSpecDJpaRepository.findByPrdCdAndPrdSpecCdAndPrdSpecSeq(mpSpecDVo.getPrdCd(), mpSpecDVo.getPrdSpecCd(), mpSpecDVo.getPrdSpecSeq()); 
    	
    	if ( !ObjectUtils.isEmpty(selPrdSpecD) ) {
    		prdSpecD = ObjUtil.createObject(selPrdSpecD, PrdSpecD.class);
        	ObjUtil.copyObject(mpSpecDVo, prdSpecD);
        } else {
        	prdSpecD = ObjUtil.createObject(mpSpecDVo, PrdSpecD.class);
	    }
    	
    	prdSpecDCheckRequired(prdSpecD);
    	prdSpecDJpaRepository.save(prdSpecD);
    }
	private void prdSpecDCheckRequired(PrdSpecD checkPrdSpecD) {
    	if(ObjectUtils.isEmpty(checkPrdSpecD.getRepYn())) {checkPrdSpecD.setRepYn("Y");}
    }
    
}
