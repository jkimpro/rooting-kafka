package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpPrdDVo {
	private BigDecimal prdCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	private String modrId;
	private String prdEngNm;
	private String prchTypAprvCd;
	
	private BigDecimal gftcertFacePrc;
	private String flgdPrcExposYn;
	private String dcMrkGbnCd;
	private String prcComprTnsCd;
	private String comprPrcMrkYn;
	private String zrwonSaleYn;
	private String baseAccmLimitYn;
	private String selAccmApplyYn;
	private BigDecimal selAccRt;
	private String immAccmDcLimitYn;
	private BigDecimal immAccmDcRt;
	private BigDecimal cpnMaxDcAmt;
	private String cpnApplyTypCd;
	private String cpnDcAmtExposYn;
	private String gsnpntNoGivYn;
	private String aliaSpclsalLimitYn;
	private String cardUseLimitYn;
	private String ordMnfcYn;
	private BigDecimal ordMnfcTermDdcnt;
	private String rsrvSalePrdYn;
	private String rsrvOrdPsblYn;
	private String openAftRtpNoadmtYn;
	private String taxInvIssueYn;
	private String spcltaxYn;
	private String arfnTimeCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date fstExposDt;
	private String barcdNo;
	private String insuCoCd;
	private String gshsGftcertYn;
	private BigDecimal forgnPrdNormPrc;
	private String ordMnfcTypCd;
	private String ordMnfcCntnt;
	private String forgnDlvPsblYn;
	private BigDecimal forgnDlvWeihtVal;
	private String prcMrkTypVal;
	private String qualGuarntDocExistYn;
	private String qualGuarntTermCntnt;
	private String noIntApplyGbnCd;
	private String quickDlvNoadmtYn;
	private String exprtPrdYn;
	private BigDecimal exprtPrdOnsiteSalePrc;
	private BigDecimal exprtPrdOnsitePrchPrc;
	private BigDecimal exchrtVal;
	private String exprtCnsltNo;
	private String exprtWonContYn;
	private String exprtEngPrdNm;
	private String stockInSaleYn;
}