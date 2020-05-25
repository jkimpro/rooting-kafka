package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpCntntDVo;
import com.gsshop.kafka.consumer.repository.PrdCntntDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdCntntD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdCntntDService {

	@Autowired
	private PrdCntntDJpaRepository prdCntntDJpaRepository;

	public void setPrdCntntDService(MpCntntDVo mpCntntDVo) {
    	
		PrdCntntD prdCntntD;
		PrdCntntD selPrdCntntD = prdCntntDJpaRepository.findByCntntNo(mpCntntDVo.getCntntNo());
		
		if(!ObjectUtils.isEmpty(selPrdCntntD)) {
			prdCntntD = ObjUtil.createObject(selPrdCntntD, PrdCntntD.class);
    		ObjUtil.copyObject(mpCntntDVo,prdCntntD);
    	}
    	else {
    		prdCntntD = ObjUtil.createObject(mpCntntDVo, PrdCntntD.class);
    	}

		prdCntntDCheckRequired(prdCntntD);
    	prdCntntDJpaRepository.save(prdCntntD);
		
	}
	private void prdCntntDCheckRequired(PrdCntntD checkPrdCntntD) {
		//PRD_ATTR_GBN_CD
		if(ObjectUtils.isEmpty(checkPrdCntntD.getPrdAttrGbnCd())) {
			checkPrdCntntD.setPrdAttrGbnCd("P");
    	}
	}
}
