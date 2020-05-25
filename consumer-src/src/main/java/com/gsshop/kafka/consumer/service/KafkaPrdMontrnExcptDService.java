package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpMontrnExcptDVo;
import com.gsshop.kafka.consumer.repository.PrdMontrnExcptDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdMontrnExcptD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdMontrnExcptDService {

	 @Autowired
	 private PrdMontrnExcptDJpaRepository prdMontrnExcptDJpaRepository;
	   
	 public void setPrdMontrnExcptDService(MpMontrnExcptDVo mpMontrnExcptDVo) {
    	PrdMontrnExcptD prdMontrnExcptD;
    	PrdMontrnExcptD selPrdMontrnExcptD = prdMontrnExcptDJpaRepository.findByConctNoAndMontrnExcptTgtGbnCdAndValidStrDtmAndValidEndDtm(mpMontrnExcptDVo.getConctNo(), 
    			mpMontrnExcptDVo.getMontrnExcptTgtGbnCd(),mpMontrnExcptDVo.getValidStrDtm(), mpMontrnExcptDVo.getValidEndDtm());
    	
    	if(!ObjectUtils.isEmpty(selPrdMontrnExcptD)) {
    		prdMontrnExcptD = ObjUtil.createObject(selPrdMontrnExcptD, PrdMontrnExcptD.class);
    		ObjUtil.copyObject(mpMontrnExcptDVo,prdMontrnExcptD);
    	}
    	else {
    		prdMontrnExcptD = ObjUtil.createObject(mpMontrnExcptDVo, PrdMontrnExcptD.class);
    	}
    	prdMontrnExcptDCheckRequired(prdMontrnExcptD);
    	prdMontrnExcptDJpaRepository.save(prdMontrnExcptD);
	 }
	 
	 private void prdMontrnExcptDCheckRequired(PrdMontrnExcptD checkPrdMontrnExcptD) {
	    	//디폴트 없음
	 }
	    
}
