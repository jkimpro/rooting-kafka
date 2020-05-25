package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpPrcHVo;
import com.gsshop.kafka.consumer.repository.PrdPrcHJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdPrcH;
import com.gsshop.kafka.util.DateUtil;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdPrcHService {

	@Autowired
    private PrdPrcHJpaRepository prdPrcHJpaRepository;
	
	
	public void setPrdPrcHService(MpPrcHVo mpPrcHVo) {
		PrdPrcH prdPrcH;
    	PrdPrcH selPrdPrcH = new PrdPrcH();

    	//PRD_PRC_H 에서는 무조건 PRD_ATTR_GBN_CD 가 "P"가 됨.
    	selPrdPrcH = prdPrcHJpaRepository.findByPrdCdAndPrdAttrGbnCdAndValidEndDtmAndValidStrDtm(mpPrcHVo.getPrdCd(),"P", mpPrcHVo.getValidEndDtm(), mpPrcHVo.getValidStrDtm());
    	
    	if(!ObjectUtils.isEmpty(selPrdPrcH)) {
    		prdPrcH = ObjUtil.createObject(selPrdPrcH, PrdPrcH.class);
    		ObjUtil.copyObject(mpPrcHVo,prdPrcH);
    	}
    	else {
    		prdPrcH = ObjUtil.createObject(mpPrcHVo, PrdPrcH.class);
    	}
    	
    	prdPrcHCheckRequired(prdPrcH);
    	prdPrcHJpaRepository.save(prdPrcH);
    }
	
	private void prdPrcHCheckRequired(PrdPrcH checkPrdPrcH) {

		//SALE_PRC (Default ‘없음) -> native로 조회해야 할 필요 있음 (PRDDB에서도 not null 이기 때문에 별다른 문제는 없을듯)
		if(ObjectUtils.isEmpty(checkPrdPrcH.getPrdAttrGbnCd())){
			checkPrdPrcH.setPrdAttrGbnCd("P");
		}
		
    	if(ObjectUtils.isEmpty(checkPrdPrcH.getValidEndDtm())) {
    		checkPrdPrcH.setValidEndDtm(DateUtil.getMaxDate());
    	}
    }
    
}
