package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpMetaDVo {
	private BigDecimal prdCd;
	private String prdMetaTypCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String attrCharVal1;
	private String attrCharVal2;
	private String attrCharVal3;
	private String attrCharVal4;
	private String attrCharVal5;
	private String attrCharVal6;
	private String attrCharVal7;
	private String attrCharVal8;
	private String attrCharVal9;
	private String attrCharVal10;
	private String attrCharVal11;
	private String attrCharVal12;
	private String attrCharVal13;
	private String attrCharVal14;
	private String attrCharVal15;
	private BigDecimal attrNumVal1;
	private BigDecimal attrNumVal2;
	private BigDecimal attrNumVal3;
	private BigDecimal attrNumVal4;
	private BigDecimal attrNumVal5;
}