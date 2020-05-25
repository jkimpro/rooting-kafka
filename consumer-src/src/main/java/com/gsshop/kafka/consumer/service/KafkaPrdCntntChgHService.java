package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpCntntChgHVo;
import com.gsshop.kafka.consumer.repository.PrdCntntChgHJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdCntntChgH;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdCntntChgHService {

	@Autowired
    private PrdCntntChgHJpaRepository prdCntntChgHJpaRepository;
    
	public void setPrdCntntChgHService(MpCntntChgHVo mpCntntChgHVo) {
		PrdCntntChgH prdCntntChgH;
		PrdCntntChgH selPrdCntntChgH = prdCntntChgHJpaRepository.findByChgHistSeq(mpCntntChgHVo.getChgHistSeq());
	
		if(!ObjectUtils.isEmpty(selPrdCntntChgH)) {
			prdCntntChgH = ObjUtil.createObject(selPrdCntntChgH, PrdCntntChgH.class);
    		ObjUtil.copyObject(mpCntntChgHVo,prdCntntChgH);
    	}
    	else {
    		prdCntntChgH = ObjUtil.createObject(mpCntntChgHVo, PrdCntntChgH.class);
    	}
    
		prdCntntChgHCheckRequired(prdCntntChgH);
		prdCntntChgHJpaRepository.save(prdCntntChgH);
    	
	}
	private void prdCntntChgHCheckRequired(PrdCntntChgH checkPrdCntntChgH) {
		 //어차피 컬럼 일치여서 Default확인여부 불필요.
	}
}
