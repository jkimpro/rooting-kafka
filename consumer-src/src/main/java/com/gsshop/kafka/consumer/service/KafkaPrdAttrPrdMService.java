package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpAttrPrdMVo;
import com.gsshop.kafka.consumer.repository.PrdAttrPrdMJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdAttrPrdM;
import com.gsshop.kafka.util.DateUtil;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaPrdAttrPrdMService {

	@Autowired
	PrdAttrPrdMJpaRepository prdAttrPrdMJpaRepository;
	
	public void setPrdAttrPrdMService(MpAttrPrdMVo mpAttrPrdMVo) {
		PrdAttrPrdM prdAttrPrdM;
		PrdAttrPrdM selPrdAttrPrdM = prdAttrPrdMJpaRepository.findByAttrPrdCd(mpAttrPrdMVo.getAttrPrdCd());
		
		if(!ObjectUtils.isEmpty(selPrdAttrPrdM)) {
			prdAttrPrdM = ObjUtil.createObject(selPrdAttrPrdM, PrdAttrPrdM.class);
			ObjUtil.copyObject(mpAttrPrdMVo,prdAttrPrdM);
		}
		else {
			prdAttrPrdM = ObjUtil.createObject(mpAttrPrdMVo, PrdAttrPrdM.class);
		}
		prdAttrPrdMCheckRequired(prdAttrPrdM);
		prdAttrPrdMJpaRepository.save(prdAttrPrdM);
	}
	
	private void prdAttrPrdMCheckRequired(PrdAttrPrdM checkPrdAttrPrdM) {
		
		
		if(ObjectUtils.isEmpty(checkPrdAttrPrdM.getAttrWhlVal())) {
		
		}
		
		if(ObjectUtils.isEmpty(checkPrdAttrPrdM.getSaleEndDtm())) {
			checkPrdAttrPrdM.setSaleEndDtm(DateUtil.getMaxDate());
		}
		if(ObjectUtils.isEmpty(checkPrdAttrPrdM.getSalePsblAprvYn())) {
			checkPrdAttrPrdM.setSalePsblAprvYn("Y");
		}
		if(ObjectUtils.isEmpty(checkPrdAttrPrdM.getAttrPrdAprvStCd())) {
			checkPrdAttrPrdM.setAttrPrdAprvStCd("00");
		}

	}
}
