package com.gsshop.kafka.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpPrdMVo;
import com.gsshop.kafka.consumer.repository.PrdPrdMJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdPrdM;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class KafkaPrdPrdMService {

	@Autowired
    private PrdPrdMJpaRepository prdPrdMJpaRepository;

    
    public void setPrdPrdMService(MpPrdMVo mpPrdMVo) {
        
        PrdPrdM prdPrdM;
        PrdPrdM selPrdPrdM = prdPrdMJpaRepository.findByPrdCd(mpPrdMVo.getPrdCd());
        
        if ( !ObjectUtils.isEmpty(selPrdPrdM) ) {
        	prdPrdM = ObjUtil.createObject(selPrdPrdM, PrdPrdM.class);
        	ObjUtil.copyObject(mpPrdMVo, prdPrdM);
        } else {
	    	prdPrdM = ObjUtil.createObject(mpPrdMVo, PrdPrdM.class);
	    }
        
        prdPrdMCheckRequired(prdPrdM); //Vo에 미포함된 칼럼이면서 필수입력대상 칼럼 설정
	    prdPrdMJpaRepository.save(prdPrdM);
    }
    
    private void prdPrdMCheckRequired(PrdPrdM checkPrdPrdM) { 
    	
    	
    	//TODO: Default값이 안정해져있는 컬럼들 어떻게 처리할지 논의 필요. (native 쿼리 사용? join 을 해야하는 부분인가?)
    	
//    	QA_GRD_CD (default 없음)
//    	SALE_PSBL_APRV_YN (default 없음)
//    	SHTPRD_REG_DTM (default 없음)
//    	EC_APRV_ST_CD (default 없음)

    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getRepPrdYn())) checkPrdPrdM.setRepPrdYn( "N" );
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getSeparOrdNoadmtYn())) checkPrdPrdM.setSeparOrdNoadmtYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getComprPrcMrkYn())) checkPrdPrdM.setComprPrcMrkYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getZrwonSaleYn())) checkPrdPrdM.setZrwonSaleYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getBaseAccmLimitYn())) checkPrdPrdM.setBaseAccmLimitYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getSelAccmApplyYn())) checkPrdPrdM.setSelAccmApplyYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getImmAccmDcLimitYn())) checkPrdPrdM.setImmAccmDcLimitYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getCpnApplyTypCd())) checkPrdPrdM.setCpnApplyTypCd("00");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getCpnDcAmtExposYn())) checkPrdPrdM.setCpnDcAmtExposYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getGsnpntNoGivYn())) checkPrdPrdM.setGsnpntNoGivYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getAliaSpclsalLimitYn())) checkPrdPrdM.setAliaSpclsalLimitYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getCardUseLimitYn())) checkPrdPrdM.setCardUseLimitYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getOrdMnfcYn())) checkPrdPrdM.setOrdMnfcYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getRsrvSalePrdYn())) checkPrdPrdM.setRsrvSalePrdYn("N");

    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getRsrvOrdPsblYn())) checkPrdPrdM.setRsrvOrdPsblYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getSmlTypPrdYn())) checkPrdPrdM.setSmlTypPrdYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getImbcAliaYn())) checkPrdPrdM.setImbcAliaYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getDittoYn())) checkPrdPrdM.setDittoYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getDittoBundlDlvLimitYn())) checkPrdPrdM.setDittoBundlDlvLimitYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getOpenAftRtpNoadmtYn())) checkPrdPrdM.setOpenAftRtpNoadmtYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getTaxInvIssueYn())) checkPrdPrdM.setTaxInvIssueYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getSpcltaxYn())) checkPrdPrdM.setSpcltaxYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getOnetmGivGftYn())) checkPrdPrdM.setOnetmGivGftYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getCvsDlvsRtpYn())) checkPrdPrdM.setCvsDlvsRtpYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getCentAddPkgYn())) checkPrdPrdM.setCentAddPkgYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getApntDlvsImplmYn())) checkPrdPrdM.setApntDlvsImplmYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getExchRtpChrYn())) checkPrdPrdM.setExchRtpChrYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getAttrTypExposCd())) checkPrdPrdM.setAttrTypExposCd("L");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getGnuinYn())) checkPrdPrdM.setGnuinYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getFlatprcPrdYn())) checkPrdPrdM.setFlatprcPrdYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getDmShtprdAlamYn())) checkPrdPrdM.setDmShtprdAlamYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getPrdRespnsTgtYn())) checkPrdPrdM.setPrdRespnsTgtYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getGshsGftcertYn())) checkPrdPrdM.setGshsGftcertYn("N");
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getDlvSchdDtGuideLimitYn())) checkPrdPrdM.setDlvSchdDtGuideLimitYn("N");
    	
     	if ( ObjectUtils.isEmpty(checkPrdPrdM.getFlgdPrcExposYn() ) ) checkPrdPrdM.setFlgdPrcExposYn( "N" );
        
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getUseYn())) checkPrdPrdM.setUseYn( "Y" );
    
    
    }
    
    
    
    
}
