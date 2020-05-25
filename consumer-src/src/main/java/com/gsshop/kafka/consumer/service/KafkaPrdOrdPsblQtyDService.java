package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpOrdPsblQtyDVo;
import com.gsshop.kafka.consumer.repository.PrdOrdPsblQtyDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdOrdPsblQtyD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaPrdOrdPsblQtyDService {
	
	@Autowired
	private PrdOrdPsblQtyDJpaRepository prdOrdPsblQtyDJpaRepository;
	
	public void setPrdOrdPsblQtyDService(MpOrdPsblQtyDVo mpOrdPsblQtyDVo) {
    
		PrdOrdPsblQtyD prdOrdPsblQtyD;
    	PrdOrdPsblQtyD selPrdOrdPsblQtyD = prdOrdPsblQtyDJpaRepository.findByAttrPrdRepCdAndChanlGrpCd(mpOrdPsblQtyDVo.getAttrPrdRepCd(), mpOrdPsblQtyDVo.getChanlGrpCd());
    	
    	if(!ObjectUtils.isEmpty(selPrdOrdPsblQtyD)) {
    		prdOrdPsblQtyD = ObjUtil.createObject(selPrdOrdPsblQtyD, PrdOrdPsblQtyD.class);
    		ObjUtil.copyObject(mpOrdPsblQtyDVo,prdOrdPsblQtyD);
    	}
    	else {
    		prdOrdPsblQtyD = ObjUtil.createObject(mpOrdPsblQtyDVo, PrdOrdPsblQtyD.class);
    	}
   
    	prdOrdPsblQtyDCheckRequired(prdOrdPsblQtyD);
    	prdOrdPsblQtyDJpaRepository.save(prdOrdPsblQtyD);	
  	}
	
	private void prdOrdPsblQtyDCheckRequired(PrdOrdPsblQtyD checkPrdOrdPsblQtyD) {
    	//디폴트 없음
    }
}
