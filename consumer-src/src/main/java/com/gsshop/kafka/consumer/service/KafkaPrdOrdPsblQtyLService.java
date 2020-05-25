package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpOrdPsblQtyLVo;
import com.gsshop.kafka.consumer.repository.PrdOrdPsblQtyLJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdOrdPsblQtyL;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaPrdOrdPsblQtyLService {

	@Autowired
    private PrdOrdPsblQtyLJpaRepository prdOrdPsblQtyLJpaRepository;
    
	public void setPrdOrdPsblQtyLService(MpOrdPsblQtyLVo mpOrdPsblQtyLVo) {
    	PrdOrdPsblQtyL prdOrdPsblQtyL;
    	PrdOrdPsblQtyL selPrdOrdPsblQtyL = prdOrdPsblQtyLJpaRepository.findByLogSeq(mpOrdPsblQtyLVo.getLogSeq());
    	
    	if(!ObjectUtils.isEmpty(selPrdOrdPsblQtyL)) {
    		prdOrdPsblQtyL = ObjUtil.createObject(selPrdOrdPsblQtyL, PrdOrdPsblQtyL.class);
    		ObjUtil.copyObject(mpOrdPsblQtyLVo,prdOrdPsblQtyL);
    	}
    	else {
    		prdOrdPsblQtyL = ObjUtil.createObject(mpOrdPsblQtyLVo, PrdOrdPsblQtyL.class);
    	}
   
    	prdOrdPsblQtyLCheckRequired(prdOrdPsblQtyL);
    	prdOrdPsblQtyLJpaRepository.save(prdOrdPsblQtyL);
    	
    }
	private void prdOrdPsblQtyLCheckRequired(PrdOrdPsblQtyL checkPrdOrdPsblQtyL) {
    	//디폴트 없음
    }
     
}
