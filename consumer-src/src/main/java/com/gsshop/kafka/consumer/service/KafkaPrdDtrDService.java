package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpDtrDVo;
import com.gsshop.kafka.consumer.repository.PrdDtrDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdPrdDtrD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaPrdDtrDService {
	@Autowired
    private PrdDtrDJpaRepository prdDtrDJpaRepository;
    
	public void setPrdDtrDService(MpDtrDVo mpDtrDVo) {
    	//TODO: 컬럼 추가 삭제 다름 (로직 매우 복잡하여 수정 요망)
    	
		PrdPrdDtrD prdDtrD;
		PrdPrdDtrD selprdDtrD = prdDtrDJpaRepository.findByPrdCd(mpDtrDVo.getPrdCd());
				
    	if(!ObjectUtils.isEmpty(selprdDtrD)) {
    		prdDtrD = ObjUtil.createObject(selprdDtrD, PrdPrdDtrD.class);
    		ObjUtil.copyObject(mpDtrDVo,prdDtrD);
    	}
    	else {
    		prdDtrD = ObjUtil.createObject(mpDtrDVo, PrdPrdDtrD.class);
    	}
    	
    	prdDtrDCheckRequired(prdDtrD);
    	prdDtrDJpaRepository.save(prdDtrD);
    }
	 
	private void prdDtrDCheckRequired(PrdPrdDtrD checkPrdDtrD) {
		
		
	}
    
}
