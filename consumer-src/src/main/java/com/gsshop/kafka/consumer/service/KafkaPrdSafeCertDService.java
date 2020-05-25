package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpSafeCertDVo;
import com.gsshop.kafka.consumer.repository.PrdSafeCertDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdSafeCertD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdSafeCertDService {
	@Autowired
    private PrdSafeCertDJpaRepository prdSafeCertDJpaRepository;
    
	 public void setPrdSafeCertDService(MpSafeCertDVo mpSafeCertDVo) {
    	PrdSafeCertD prdSafeCertD;
    	
    	PrdSafeCertD selPrdSafeCertD = prdSafeCertDJpaRepository.findByPrdCd(mpSafeCertDVo.getPrdCd());
    	
    	if ( !ObjectUtils.isEmpty(selPrdSafeCertD) ) {
    		prdSafeCertD = ObjUtil.createObject(selPrdSafeCertD, PrdSafeCertD.class);
        	ObjUtil.copyObject(mpSafeCertDVo, prdSafeCertD);

        	//MP_SAFE_CERT_D에 같은기능이지만 다른 컬럼명인 Case가 존재함
        	selPrdSafeCertD.setCertExpirDt(mpSafeCertDVo.getSafeExpirDt());
        	selPrdSafeCertD.setCertLastChkDt(mpSafeCertDVo.getSafeLastChkDt());
        
    	} else {
        	prdSafeCertD = ObjUtil.createObject(mpSafeCertDVo, PrdSafeCertD.class);
        	
        	//MP_SAFE_CERT_D에 같은기능이지만 다른 컬럼명인 Case가 존재함
        	selPrdSafeCertD.setCertExpirDt(mpSafeCertDVo.getSafeExpirDt());
        	selPrdSafeCertD.setCertLastChkDt(mpSafeCertDVo.getSafeLastChkDt());	
        }
    	
    	
    	prdSafeCertDCheckRequired(prdSafeCertD);
    	prdSafeCertDJpaRepository.save(prdSafeCertD);
	 }
	 
	 private void prdSafeCertDCheckRequired(PrdSafeCertD checkPrdSafeCertD) {
     	if(ObjectUtils.isEmpty(checkPrdSafeCertD.getSafeCertGbnCd())) {checkPrdSafeCertD.setSafeCertGbnCd("0");}
    	if(ObjectUtils.isEmpty(checkPrdSafeCertD.getSafeCertOrgCd())) {checkPrdSafeCertD.setSafeCertOrgCd("0");}
    }
}
