package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpPreOrdngLVo {
	private BigDecimal attrPrdCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date entDtm;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String attrPrdRepCd;
	private BigDecimal prdCd;
	private String prdTypCd;
	private BigDecimal ordPsblQty;
	private String procYn;
	private String procMsgCntnt;
}
