package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpPreOrdngLVo;
import com.gsshop.kafka.consumer.repository.PrdPreOrdngLJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdPreOrdngL;
import com.gsshop.kafka.util.DateUtil;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdPreOrdngLService {

	@Autowired
    private PrdPreOrdngLJpaRepository prdPreOrdngLJpaRepository;
    
	 public void setPrdPreOrdngLService(MpPreOrdngLVo mpPreOrdngLVo) {
    	PrdPreOrdngL prdPreOrdngL;
    	PrdPreOrdngL selPrdPreOrdngL = prdPreOrdngLJpaRepository.findByAttrPrdCdAndEntDtm(mpPreOrdngLVo.getAttrPrdCd(), mpPreOrdngLVo.getEntDtm());
    	
    	if(!ObjectUtils.isEmpty(selPrdPreOrdngL)) {
    		prdPreOrdngL = ObjUtil.createObject(selPrdPreOrdngL, PrdPreOrdngL.class);
    		ObjUtil.copyObject(mpPreOrdngLVo,prdPreOrdngL);
    	}
    	else {
    		prdPreOrdngL = ObjUtil.createObject(mpPreOrdngLVo, PrdPreOrdngL.class);
    	}
    
    	prdPreOrdngLCheckRequired(prdPreOrdngL);
    	prdPreOrdngLJpaRepository.save(prdPreOrdngL);
    }
	    
	private void prdPreOrdngLCheckRequired(PrdPreOrdngL checkPrdPreOrdngL) {
      	if(ObjectUtils.isEmpty(checkPrdPreOrdngL.getEntDtm())) {checkPrdPreOrdngL.setEntDtm(DateUtil.getDate("now"));}
    }
    
    
}
