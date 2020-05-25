package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpColorImgDVo;
import com.gsshop.kafka.consumer.repository.PrdColorImgDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdColorImgD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdColorImgDService {

	@Autowired
    private PrdColorImgDJpaRepository prdColorImgDJpaRepository;
	
	public void setPrdColorImgDService(MpColorImgDVo mpColorImgDVo) {
    
		PrdColorImgD prdColorImgD;
		PrdColorImgD selPrdColorImgD = prdColorImgDJpaRepository.findByPrdCdAndColorNm(mpColorImgDVo.getPrdCd(), mpColorImgDVo.getColorNm());
		
		log.debug("PrdColorImgDService got inside");
		log.debug("mp Val Check regDtm: " + mpColorImgDVo.getRegDtm());
		log.debug("mp Val Check modDtm: " + mpColorImgDVo.getModDtm());
		
		if(!ObjectUtils.isEmpty(selPrdColorImgD)) {
			prdColorImgD = ObjUtil.createObject(selPrdColorImgD, PrdColorImgD.class);
    		ObjUtil.copyObject(mpColorImgDVo,prdColorImgD);
    	}
    	else {
    		prdColorImgD = ObjUtil.createObject(mpColorImgDVo, PrdColorImgD.class);
    	}
		
		
		prdColorImgDCheckRequired(prdColorImgD);
    	prdColorImgDJpaRepository.save(prdColorImgD);
	}
	private void prdColorImgDCheckRequired(PrdColorImgD checkPrdColorImgD) {
		//기존과 같음
	}
	
}
