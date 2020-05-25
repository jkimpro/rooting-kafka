package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpPrcHVo {
	
	private BigDecimal prdCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date validEndDtm;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date validStrDtm;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	private String modrId;
	private BigDecimal salePrc;
	private BigDecimal prchPrc;
	private String supGivRtamtCd;
	private BigDecimal supGivRtamt;
	private BigDecimal supProprdUprc;
	private BigDecimal instlCost;
	private BigDecimal proprdWthtax;
	private String vipDlvYn;
	private BigDecimal vipDlvStdPrc;
	private BigDecimal onsitePrdPrc;
	private BigDecimal onsiteDcPrc;
	private BigDecimal detrmWeihtVal;
	private BigDecimal onsiteChrCost;
	private String whsCd;
	private String otherSysTnsYn;
	private String noteCntnt;
}