package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpPrdDVo;
import com.gsshop.kafka.consumer.repository.PrdPrdDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdPrdD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdPrdDService {
	
	@Autowired
    private PrdPrdDJpaRepository prdPrdDJpaRepository;
    
	public void setPrdPrdDService(MpPrdDVo mpPrdDVo) {
    	PrdPrdD prdPrdD;
    	PrdPrdD selPrdPrdD = prdPrdDJpaRepository.findByPrdCd(mpPrdDVo.getPrdCd());
    	if ( !ObjectUtils.isEmpty(selPrdPrdD) ) {
    		prdPrdD = ObjUtil.createObject(selPrdPrdD, PrdPrdD.class);
        	ObjUtil.copyObject(mpPrdDVo, prdPrdD);
        } else {
        	prdPrdD = ObjUtil.createObject(mpPrdDVo, PrdPrdD.class);
	    }
        prdPrdDCheckRequired(prdPrdD);
	    prdPrdDJpaRepository.save(prdPrdD);
    }
	private void prdPrdDCheckRequired(PrdPrdD checkPrdPrdD) {
    
//		CLS_CHK_ST_CD (Default 없음)
//		PRD_REG_FSHYN (Default ‘N’)
//		QUAL_GUARNT_DOC_EXIST_YN (Default ‘N’) => 문제는 prddb에 컬럼이 있기는 한데 여기는 디폴트가 없음 (smtc native로 한번 조회하고, 없을 경우에는 디폴트?)
//		CMPOS_INFO_EXPOS_YN (Default 없음)

		if(ObjectUtils.isEmpty(checkPrdPrdD.getPrdRegFshYn())) {checkPrdPrdD.setPrdRegFshYn("N");}
    	if(ObjectUtils.isEmpty(checkPrdPrdD.getQualGuarntDocExistYn())) {checkPrdPrdD.setQualGuarntDocExistYn("N");}
    }
}
