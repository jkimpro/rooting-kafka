package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpMetaDVo;
import com.gsshop.kafka.consumer.repository.PrdMetaDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdMetaD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdMetaDService {

	@Autowired
    private PrdMetaDJpaRepository prdMetaDJpaRepository;
    
	public void setPrdMetaDService(MpMetaDVo mpMetaDVo) {
    	PrdMetaD prdMetaD;
    	PrdMetaD selPrdMetaD = prdMetaDJpaRepository.findByPrdCdAndPrdMetaTypCd(mpMetaDVo.getPrdCd(), mpMetaDVo.getPrdMetaTypCd());
    	
    	if(!ObjectUtils.isEmpty(selPrdMetaD)) {
    		prdMetaD = ObjUtil.createObject(selPrdMetaD, PrdMetaD.class);
    		ObjUtil.copyObject(mpMetaDVo,prdMetaD);
    	}
    	else {
    		prdMetaD = ObjUtil.createObject(mpMetaDVo, PrdMetaD.class);
    	}
    	
    	//prdMetaDCheckRequired(prdMetaD);
    	prdMetaDJpaRepository.save(prdMetaD);
    }
	private void prdMetaDCheckRequired(PrdMetaD chekcPrdMetaD) {
    	//디폴트 없음
    }
}
