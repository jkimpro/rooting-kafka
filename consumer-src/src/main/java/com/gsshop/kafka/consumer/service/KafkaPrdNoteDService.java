package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpNoteDVo;
import com.gsshop.kafka.consumer.repository.PrdNoteDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdNoteD;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdNoteDService {

	@Autowired
    private PrdNoteDJpaRepository prdNoteDJpaRepository;
    
	public void setPrdNoteDService(MpNoteDVo mpNoteDVo) {
    	PrdNoteD prdNoteD;
    	PrdNoteD selPrdNoteD = prdNoteDJpaRepository.findByPrdCdAndNoteTypCdAndNoteSeq(mpNoteDVo.getPrdCd(), mpNoteDVo.getNoteTypCd(), mpNoteDVo.getNoteSeq());
    	
    	if(!ObjectUtils.isEmpty(selPrdNoteD)) {
    		prdNoteD = ObjUtil.createObject(selPrdNoteD, PrdNoteD.class);
    		ObjUtil.copyObject(mpNoteDVo,prdNoteD);
    	}
    	else {
    		prdNoteD = ObjUtil.createObject(mpNoteDVo, PrdNoteD.class);
    	}
   
    	prdNoteDCheckRequired(prdNoteD);
    	prdNoteDJpaRepository.save(prdNoteD);
    	
	}
	private void prdNoteDCheckRequired(PrdNoteD checkPrdNoteD) {
		//디폴트 없음
	}
}
