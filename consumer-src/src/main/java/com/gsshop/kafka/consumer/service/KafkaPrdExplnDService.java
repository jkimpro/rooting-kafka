package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpExplnDVo;
import com.gsshop.kafka.consumer.repository.PrdExplnDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdExplnD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdExplnDService {

	@Autowired
    private PrdExplnDJpaRepository prdExplnDJpaRepository;
    
	public void setPrdExplnDService(MpExplnDVo mpExplnDVo) {
    	PrdExplnD prdExplnD;
    	PrdExplnD selPrdExplnD = prdExplnDJpaRepository.findByPrdCdAndChanlCdAndGovPublsPrdGrpCdAndPrdExplnItmCd(mpExplnDVo.getPrdCd(),mpExplnDVo.getChanlCd(),mpExplnDVo.getGovPublsPrdGrpCd()
    			,mpExplnDVo.getPrdExplnItmCd());
    	if(!ObjectUtils.isEmpty(selPrdExplnD)) {
    		prdExplnD = ObjUtil.createObject(selPrdExplnD, PrdExplnD.class);
    		ObjUtil.copyObject(mpExplnDVo,prdExplnD);
    	}
    	else {
    		prdExplnD = ObjUtil.createObject(mpExplnDVo, PrdExplnD.class);
    	}
    	prdExplnDCheckRequired(prdExplnD);
    	prdExplnDJpaRepository.save(prdExplnD);
    	
    }
	private void prdExplnDCheckRequired(PrdExplnD checkPrdExplnD) {
    	if(ObjectUtils.isEmpty(checkPrdExplnD.getExposYn())) {
    		checkPrdExplnD.setExposYn("Y");
    	}
    }
}
