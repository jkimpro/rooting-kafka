package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpDescdGenrlDVo;
import com.gsshop.kafka.consumer.repository.PrdDescdGenrlDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdDescdGenrlD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdDescdGenrlDService {
	@Autowired
    private PrdDescdGenrlDJpaRepository prdDescdGenrlDJpaRepository;
    
	public void setPrdDescdGenrlDService(MpDescdGenrlDVo mpDescdGenrlDVo) {
    	
    	PrdDescdGenrlD prdDescdGenrlD;
    	PrdDescdGenrlD selPrdDescdGenrlD = prdDescdGenrlDJpaRepository.findByPrdCdAndChanlCdAndDescdItmSeq(mpDescdGenrlDVo.getPrdCd(),
    			mpDescdGenrlDVo.getChanlCd(), mpDescdGenrlDVo.getDescdItmSeq());
    	
    	if(!ObjectUtils.isEmpty(selPrdDescdGenrlD)) {
    		prdDescdGenrlD = ObjUtil.createObject(selPrdDescdGenrlD, PrdDescdGenrlD.class);
    		ObjUtil.copyObject(mpDescdGenrlDVo,prdDescdGenrlD);
    	}
    	else {
    		prdDescdGenrlD = ObjUtil.createObject(mpDescdGenrlDVo, PrdDescdGenrlD.class);
    	}
    	
    	prdDescdGenrlDCheckRequired(prdDescdGenrlD);
    	prdDescdGenrlDJpaRepository.save(prdDescdGenrlD);
	}
	
	private void prdDescdGenrlDCheckRequired(PrdDescdGenrlD checkPrdDescdGenrlD) {
    	if(ObjectUtils.isEmpty(checkPrdDescdGenrlD.getItmHiddnYn())) {
    		checkPrdDescdGenrlD.setItmHiddnYn("N");
    	}
    	if(ObjectUtils.isEmpty(checkPrdDescdGenrlD.getWrapYn())) {
    		checkPrdDescdGenrlD.setWrapYn("N");
    	}
    	if(ObjectUtils.isEmpty(checkPrdDescdGenrlD.getLineInsertYn())) {
    		checkPrdDescdGenrlD.setLineInsertYn("N");
    	}
    	
    	if(ObjectUtils.isEmpty(checkPrdDescdGenrlD.getFlckrYn())) {
    		checkPrdDescdGenrlD.setFlckrYn("N");
    	}
    	if(ObjectUtils.isEmpty(checkPrdDescdGenrlD.getIntrntExposYn())) {
    		checkPrdDescdGenrlD.setIntrntExposYn("N");
    	}
    	if(ObjectUtils.isEmpty(checkPrdDescdGenrlD.getEaiLinkYn())) {
    		checkPrdDescdGenrlD.setEaiLinkYn("N");
    	}
    }
}
