package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpAttrPrdMVo {
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date saleEndDtm;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date saleStrDtm;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date shtprdRegDtm;
	
	private BigDecimal arsAttrSeq1;
	private BigDecimal arsAttrSeq2;
	private BigDecimal arsAttrSeq3;
	private BigDecimal arsAttrSeq4;
	private BigDecimal attrPkgCnt;
	private BigDecimal attrPrdCd;
	private BigDecimal cntntNo;
	private BigDecimal ecAttrPrdCd;
	private BigDecimal exposSeq;
	private BigDecimal prdCd;
	private String addCmposGbnCd;
	private String arsAttrVal1;
	private String arsAttrVal2;
	private String arsAttrVal3;
	private String arsAttrVal4;
	private String attrCmposCntnt;
	private String attrPrdAprvStCd;
	private String attrPrdNm;
	private String attrPrdRepCd;
	private String attrRegGbnCd;
	private String attrVal1;
	private String attrVal2;
	private String attrVal3;
	private String attrVal4;
	private String attrValCd1;
	private String attrValCd2;
	private String attrValCd3;
	private String attrValCd4;
	private String catvSaleLimitYn;
	private String exposDfaltValYn;
	private String mnfcCoNm;
	private String modelNo;
	private String modrId;
	private String orgpNm;
	private String prcCmposYn;
	private String regrId;
	private String saleEndPrsnId;
	private String saleEndRsnCd;
	private String saleEndRsnCntnt;
	private String salePsblAprvYn;
	private String sapTnsYn;
	private String supAttrPrdCd;
	private String useYn;
	private String attrPrdUdaCd;
}