package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpDescdHtmlDVo;
import com.gsshop.kafka.consumer.repository.PrdDescdHtmlDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdDescdHtmlD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdDescdHtmlDService {
	@Autowired
    private PrdDescdHtmlDJpaRepository prdDescdHtmlDJpaRepository;
    
	public void setPrdDescdHtmlDService(MpDescdHtmlDVo mpDescdHtmlDVo) {
	
    	PrdDescdHtmlD prdDescdHtmlD;
    	PrdDescdHtmlD selPrdDescdHtmlD = prdDescdHtmlDJpaRepository.findByPrdCdAndChanlCdAndRegGbnCd(mpDescdHtmlDVo.getPrdCd(), 
    			mpDescdHtmlDVo.getChanlCd(), mpDescdHtmlDVo.getRegGbnCd());
    	
    	if(!ObjectUtils.isEmpty(selPrdDescdHtmlD)) {
    		prdDescdHtmlD = ObjUtil.createObject(selPrdDescdHtmlD, PrdDescdHtmlD.class);
    		ObjUtil.copyObject(mpDescdHtmlDVo,prdDescdHtmlD);
    	}
    	else {
    		prdDescdHtmlD = ObjUtil.createObject(mpDescdHtmlDVo, PrdDescdHtmlD.class);
    	}
    	prdDescdHtmlDCheckRequired(prdDescdHtmlD);
    	prdDescdHtmlDJpaRepository.save(prdDescdHtmlD);
    	
    }

	private void prdDescdHtmlDCheckRequired(PrdDescdHtmlD checkPrdDescdHtmlD) {
    	if(ObjectUtils.isEmpty(checkPrdDescdHtmlD.getWritePrevntYn())) {
    		checkPrdDescdHtmlD.setWritePrevntYn("N");
    	}
    	if(ObjectUtils.isEmpty(checkPrdDescdHtmlD.getEcExposYn())) {
    		checkPrdDescdHtmlD.setEcExposYn("Y");
    	}
    }
    
}
