package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpExposDVo {
	private BigDecimal prdCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	private String modrId;
	private String qaGrdCd;
	private String qaPrgStCd;
	private String salePsblAprvYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date tempoutChgDtm;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date shtprdRegDtm;
	
	private String ecAprvStCd;
	private Date lastAprvCnfDtm;
	private String prdCnsdrStCd;
	private String taskTeamAprvRsltCntnt;
	private BigDecimal orgprdPkgCnt;
	private String prdBaseCmposCntnt;
	private BigDecimal addCmposPkgCnt;
	private String prdAddCmposCntnt;
	private String addCmposOrgpNm;
	private String addCmposMnfcCoNm;
	private BigDecimal gftPkgCnt;
	private String prdGftCmposCntnt;
	private String gftCmposOrgpNm;
	private String gftCmposMnfcCoNm;
	private String prdEtcCmposCntnt;
	private String prdInfoCmposCntnt;
	private String rtpAttndMatrCntnt;
	private String dlvAttndMatrCntnt;
	private String chrDlvCondCntnt;
	private String mdDlvMatrCntnt;
	private String tmDescCntnt;
	private String ordAttndCntnt;
	private String srchKeywdNm1;
	private String srchKeywdNm2;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date clsChkCertDtm;
	private String clsChkAftAprvCd;
	private String clsChkStCd;
	private String clsChkNoteCntnt;
	private String clsChkrEmpnoId;
	private String cmposInfoExposYn;
	private String saleEndRsnCntnt;
	private String clsChkNoPassRsnCntnt;
	private String supCnfYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date supCnfDtm;
	private String addModelNo;
}
