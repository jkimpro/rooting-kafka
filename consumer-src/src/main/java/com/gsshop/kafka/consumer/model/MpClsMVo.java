package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpClsMVo {
	private String prdClsCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String prdClsNm;
	private String upperPrdClsCd;
	private BigDecimal clsLvlNo;
	private String useYn;
	private String noteCntnt;
	private BigDecimal vipDlvStdAmt;
	private String clothYn;
	private String unulMatrCntnt1;
	private String unulMatrCntnt2;
	private String exchNoadmtRsnCntnt;
	private String exchUnulMatrCntnt;
	private BigDecimal immAccmDcRt;
	private String spcltaxYn;
	private String cvsRtpYn;
	private String safeCertTgtYn;
	private String readExcluYn;
	private String taxInvIssueYn;
	private String giftPkgYn;
	private String rfnTypCd;
	private String qualGuarntTermCntnt;
	private String asProcStdCntnt;
	private BigDecimal asPartDlvStdProcDdcnt;
	private BigDecimal asExchtogStdProcDdcnt;
	private BigDecimal asSimplExchStdProcDdcnt;
	private BigDecimal asReparStdProcDdcnt;
	private BigDecimal asVisitStdProcDdcnt;
	private BigDecimal asSimplPickStdProcDdcnt;
	private String rtpCnlPsblCntnt;
	private String rtpProcStdCntnt;
	private String attndMatrCntnt;
	private String cnsdrTgtYn;
	private String adultCertYn;
	private String cnsdrDeepTgtYn;
	private String prdSpecTgtYn;
	private String celphnTgtYn;
	private String bookTgtYn;
	private String weihtMandYn;
	private String smsPrdRegPsblYn;
	private String addDlvcYn;
	private String bundlDlvYn;
	private String minusMargnYn;
	private String qaInfoFileNm1;
	private String qaInfoFileNm2;
	private BigDecimal shopNo;
	private String bookMdId;
	private String srchExposYn;
	private String govPublsPrdGrpCd;
	private String frmlesPrdTypCd;
	private String prdDtlSizeYn;
	private String nutrnIngrdYn;
	private String travlSchdYn;
	private String validTermMngYn;
	private String tofStdCd;
	private String hsCd;
	private String forgnDlvPsblYn;
	private String prdClsEngNm;
}
