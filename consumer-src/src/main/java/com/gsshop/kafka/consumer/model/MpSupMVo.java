package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpSupMVo {
	private BigDecimal supCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	private String modrId;
	private String supNm;
	private String supGbnCd;
	private String bzRegNo;
	private String reprNm;
	private String asignrEmailAddr;
	private String asignrCelphnNo;
	private String asignrTelno1;
	private String asignrTelno2;
	private String asignrFaxNo;
	private String asignrNm;
	private String contYn;
	private String repPrdHndlYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date txnEndDt;
	
	private String condtlPrchPmsnYn;
	private String dirTakoutYn;
	private String b2bSupCd;
	private String mimTypCd;
	private String mimPrcRetUrlNm;
	private String noBkbDpoPsblYn;
	private BigDecimal accmSupShrRt;
	private String ecOrdCnlPsblYn;
	private String multiQtyOrdPsblYn;
	private String dirdlvEntrstDlvYn;
	private String dirdlvEntrstPickYn;
	private String prdOboxCd;
	private String simplTaxrYn;
	private String apntDlvsPickTypCd;
	private String cvsRtpYn;
	private String savpntPayYn;
	private String prefrChanlCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date contDt;
	
	private String bzTypCd;
	private String bzGbnCd;
	private String corpNo;
	private String bzconNm;
	private String bztypNm;
	private String tnsYn;
	private String crditEvalTgtYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date crditEvalExpirDt;
	private String scmUseYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date scmUseYnItmRecntModDtm;
	
	private String scmUseYnItmRecntModrId;
	private String asCentExistYn;
	private String workStrTime;
	private String workEndTime;
	private String lunchStrTime;
	private String lunchEndTime;
	private String satWorkYn;
	private String satWorkStrTime;
	private String satWorkEndTime;
	private String unulMatrCntnt;
	private String dlvSchdDmPrdYn;
	private BigDecimal avgAnswrTime;
	private BigDecimal answrObeyRt;
	private String taxInvRcvrNm;
	private BigDecimal apntDlvsPickCost;
	private BigDecimal chrDlvcCd;
	private BigDecimal chrDlvStdAmt;
	private BigDecimal apntDlvsDlvcCd;
	private BigDecimal forgnShopDlvAgncyPrdCd;
	private BigDecimal forgnShopRtpDlvcCd;
	private String aliaCoTnsYn;
	private String vendrCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date lastLoginDt;
	private String supAttndMatrCntnt;
	private String frmlesPrdMailTnsYn;
	private String supSatOffYn;
	private String prchCnfYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date prchCnfDtm;
	
	private String supRegStCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date supRegDt;
	
	private String hompgUrlAddr;
	private String operMdId;
	private BigDecimal pkgmtSupCd;
	private String supKindCd;
	private String etiDeclrTrustYn;
	private String etiAsignrNm;
	private String etiAsignrCelphnNo;
	private String etiAsignrEmailAddr;
	private String payAccntNoUseYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date txnRestatDt;
	
	private String txnEndRsnCd;
	private String txnEndDtlRsnCntnt;
	private String txnEndRetRsnCntnt;
	private String txnEndAftRtpAsProcCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date prchContStrDt;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date prchContEndDt;
	
	private String catvSaleYn;
	private String intrntSaleYn;
	private String dmSaleYn;
	private String forgnSaleYn;
	private String istDlvsUseYn;
	private String ddhdGtpDlvsUseYn;
	private String dirdlvUseYn;
	private String outstkDlyPenltExcptYn;
	private String dirdlvRelsStdHndlAwareYn;
	private String plInsuAdmYn;
	private String plInsuCoNm;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date plInsuAdmStrDt;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date plInsuAdmEndDt;
	
	private String plInsuStockNo;
	private String rtpDeferAmtAgreeYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date rtpDeferAmtAgreeDt;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date crditEvalIssueDt;
	
	private String crditEvalOrgCd;
	private String crditEvalStdGrdCdVal;
	private String crditEvalRsltGrdCdVal;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date crditGrdShtCnsltDt;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date crditEvalExempCnsltDt;
	
	private String crditEvalExempRsnCntnt;
	private String svcExlntSupYn;
	private String svcExlntSupRflctYy;
	private String svcExlntSupRflctHalfyyCd;
	private String gtpDdhdManulShipYn;
	private String gtpDdhdOboxImplmYn;
	private String dirdlvPoCntAdjstPsblYn;
	private String thplUseYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date gtpDlvs2StrDt;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date gtpDlvs2EndDt;
	
	private String celphnPoPsblYn;
	private String ecDtctDlvYn;
	private String apntDlvsNoadmtRsnCd;
	private String apntDlvsNoadmtDtlRsnCntnt;
	private String apntDlvsAsignrNm;
	private String apntDlvsAsignrTelno;
	private String cvsRtpImplmNoadmtRsnCd;
	private String cvsRtpNoadmtDtlRsnCntnt;
	private String dirdlvEntrstAsPickDlvYn;
	private String baseDtctCd;
	private String dlvCsAsignrNm;
	private String dlvCsAsignrTelno;
	private String dlvCsAsignrCelphnNo;
	private String dlvCsAsignrEmailAddr;
	private String dirdlvRelsInfoImprovTgtYn;
	private String offlnSupYn;
	private String repTelno;
	private String repFaxNo;
	private String reprCelphnNo;
	private String reprEmailAddr;
	private String mcPcCpnCrePsblSupYn;
	private String supCnfYn;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date supCnfRegDtm;
	
	private String supCnfRegrId;
	private BigDecimal ansimNoClrDdcnt;
	private String corpNoEcp;
	private String forgnDirprhYn;
	private String prdRelsCntryVal;
	private String smsRcvTime;
	private String smsRcvNo;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date certDtm;
}
