package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class MpAttrPrcHVo {
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date validEndDtm;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date validStrDtm;
	
	private BigDecimal supGivRtamt;
	private BigDecimal attrPrdCd;
	private BigDecimal prchPrc;
	private BigDecimal prdCd;
	private BigDecimal salePrc;
	private String attrPrdApplyGbnCd;
	private String attrPrdApplyVal;
	private String modrId;
	private String noteCntnt;
	private String regrId;
	private String supGivRtamtCd;
	
}