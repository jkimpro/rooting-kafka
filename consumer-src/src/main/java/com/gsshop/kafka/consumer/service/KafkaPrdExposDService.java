package com.gsshop.kafka.consumer.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.gsshop.kafka.consumer.model.MpExposDVo;
import com.gsshop.kafka.consumer.repository.PrdExposDJpaRepository;
import com.gsshop.kafka.consumer.repository.entity.PrdPrdM;
import com.gsshop.kafka.util.DateUtil;
import com.gsshop.kafka.util.ObjUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaPrdExposDService {

	//TODO 이 클래스 check required 전면 수정 필요
	
    @Autowired
    private PrdExposDJpaRepository prdExposDJpaRepository;
    
	public void setPrdExposDService(MpExposDVo mpExposDVo){
    	//매핑은 PRD_PRD_M 과 같이 함
    	PrdPrdM prdExposD;
    	PrdPrdM selPrdExposD = prdExposDJpaRepository.findByPrdCd(mpExposDVo.getPrdCd());
    	
    	if(!ObjectUtils.isEmpty(selPrdExposD)) {
    		prdExposD = ObjUtil.createObject(selPrdExposD, PrdPrdM.class);
    		ObjUtil.copyObject(mpExposDVo,prdExposD);
    	}
    	else {
    		prdExposD = ObjUtil.createObject(mpExposDVo, PrdPrdM.class);
    	}
    	prdPrdMCheckRequired(prdExposD);
    	prdExposDJpaRepository.save(prdExposD);    	
    }
	
	private void prdPrdMCheckRequired(PrdPrdM checkPrdPrdM) { 

		//TODO 관련 값들 업데이트 확인하기.
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getUseYn() ) ) checkPrdPrdM.setUseYn( "Y" );
		
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getItemCd())) checkPrdPrdM.setItemCd(new BigDecimal(0));
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getBrandCd())) checkPrdPrdM.setBrandCd(new BigDecimal(0));
    	
    	if ( ObjectUtils.isEmpty(checkPrdPrdM.getCopyPrdYn())) checkPrdPrdM.setCopyPrdYn("N");
    	
    	//if ( ObjectUtils.isEmpty(checkPrdPrdM.getSaleStrDtm())) checkPrdPrdM.setSaleStrDtm();; //		SALE_STR_DTM (default없음)

    	if(ObjectUtils.isEmpty(checkPrdPrdM.getSaleEndDtm())) checkPrdPrdM.setSaleEndDtm(DateUtil.getMaxDate());
    	
    	
//		PRD_CLS_CD (default없음)
//		PRD_TYP_CD (default없음)

    	if(ObjectUtils.isEmpty(checkPrdPrdM.getPrdGbnCd())) checkPrdPrdM.setPrdGbnCd("00");
    	
//		PRCH_TYP_CD (default없음)
//		ORD_PRD_TYP_CD (default없음)
//		FRMLES_PRD_TYP_CD (default없음)
//		GFT_TYP_CD (default없음)
//		TAX_TYP_CD (default없음)
//		EXPOS_ST_CD (default없음)
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getRepPrdYn())) checkPrdPrdM.setRepPrdYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getSeparOrdNoadmtYn())) checkPrdPrdM.setSeparOrdNoadmtYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getPrdAprvStCd())) checkPrdPrdM.setPrdAprvStCd("00");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getTempoutYn())) checkPrdPrdM.setTempoutYn("N");
    	
    	if (ObjectUtils.isEmpty(checkPrdPrdM.getFlgdPrcExposYn())) checkPrdPrdM.setFlgdPrcExposYn( "N" );
    	
    	if (ObjectUtils.isEmpty(checkPrdPrdM.getComprPrcMrkYn())) checkPrdPrdM.setComprPrcMrkYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getZrwonSaleYn())) checkPrdPrdM.setZrwonSaleYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getBaseAccmLimitYn())) checkPrdPrdM.setBaseAccmLimitYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getSelAccmApplyYn())) checkPrdPrdM.setSelAccmApplyYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getImmAccmDcLimitYn())) checkPrdPrdM.setImmAccmDcLimitYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getCpnApplyTypCd())) checkPrdPrdM.setCpnApplyTypCd("00");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getCpnDcAmtExposYn())) checkPrdPrdM.setCpnDcAmtExposYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getGsnpntNoGivYn())) checkPrdPrdM.setGsnpntNoGivYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getAliaSpclsalLimitYn())) checkPrdPrdM.setAliaSpclsalLimitYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getCardUseLimitYn())) checkPrdPrdM.setCardUseLimitYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getOrdMnfcYn())) checkPrdPrdM.setOrdMnfcCntnt("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getRsrvSalePrdYn())) checkPrdPrdM.setRsrvSalePrdYn("N");
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getRsrvOrdPsblYn())) checkPrdPrdM.setRsrvOrdPsblYn("N");    	
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getSmlTypPrdYn())) checkPrdPrdM.setSmlTypPrdYn("N");    	
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getOnairSalePsblYn())) checkPrdPrdM.setOnairSalePsblYn("N");    	
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getImbcAliaYn())) checkPrdPrdM.setImbcAliaYn("N");    	
    	
    	if(ObjectUtils.isEmpty(checkPrdPrdM.getAdultCertYn())) checkPrdPrdM.setAdultCertYn("N");    	
  
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getDittoYn())) checkPrdPrdM.setDittoYn("N");    	

      	if(ObjectUtils.isEmpty(checkPrdPrdM.getDittoBundlDlvLimitYn())) checkPrdPrdM.setDittoBundlDlvLimitYn("N");    	

      	if(ObjectUtils.isEmpty(checkPrdPrdM.getOpenAftRtpNoadmtYn())) checkPrdPrdM.setOpenAftRtpNoadmtYn("N");    	

      	if(ObjectUtils.isEmpty(checkPrdPrdM.getTaxInvIssueYn())) checkPrdPrdM.setTaxInvIssueYn("N");    	
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getSpcltaxYn())) checkPrdPrdM.setSpcltaxYn("N");    	
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getOnetmGivGftYn())) checkPrdPrdM.setOnetmGivGftYn("N");    	
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getImgCnfYn())) checkPrdPrdM.setImgCnfYn("N");    	
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getAutoOrdPsblYn())) checkPrdPrdM.setAutoOrdPsblYn("N");    	
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getAutoOrdClsCd())) checkPrdPrdM.setAutoOrdClsCd("X");    	
      	
//		SUP_CD (default없음)
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getCvsDlvsRtpYn())) checkPrdPrdM.setCvsDlvsRtpYn("N");    	
      	
//		DLVS_CO_CD (default없음)

      	if(ObjectUtils.isEmpty(checkPrdPrdM.getCentAddPkgYn())) checkPrdPrdM.setCentAddPkgYn("N");    	
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getChrDlvYn())) checkPrdPrdM.setChrDlvYn("N");    	
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getChrDlvAddYn())) checkPrdPrdM.setChrDlvAddYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getApntDlvsImplmYn())) checkPrdPrdM.setApntDlvsImplmYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getExchRtpChrYn())) checkPrdPrdM.setExchRtpChrYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getAttrTypExposCd())) checkPrdPrdM.setAttrTypExposCd("L");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getSaleEndYn())) checkPrdPrdM.setSaleEndYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getGnuinYn())) checkPrdPrdM.setGnuinYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getFlatprcPrdYn())) checkPrdPrdM.setFlatprcPrdYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getDmShtprdAlamYn())) checkPrdPrdM.setDmShtprdAlamYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getPrdRespnsTgtYn())) checkPrdPrdM.setPrdRespnsTgtYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getGshsGftcertYn())) checkPrdPrdM.setGshsGftcertYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getBroadPrdYn())) checkPrdPrdM.setBroadPrdYn("N");
      	
      //	if(ObjectUtils.isEmpty(checkPrdPrdM.getRegChanlGrpCd())) checkPrdPrdM.setRegChanlGrpCd() //		REG_CHANL_GRP_CD (default없음)

      	if(ObjectUtils.isEmpty(checkPrdPrdM.getStyleDirEntYn())) checkPrdPrdM.setStyleDirEntYn("N");
      	
      	if(ObjectUtils.isEmpty(checkPrdPrdM.getDlvSchdDtGuideLimitYn())) checkPrdPrdM.setDlvSchdDtGuideLimitYn("N");
      	
    }
}
