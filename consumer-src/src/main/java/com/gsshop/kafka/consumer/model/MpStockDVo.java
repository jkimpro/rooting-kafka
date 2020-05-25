package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpStockDVo {
	private String attrPrdRepCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String attrPrdRepNm;
	private BigDecimal prdCd;
	private BigDecimal stockQty;
	private BigDecimal safeStockQty;
	private BigDecimal asumQty;
	private String sapTnsCd;
	private String tempoutYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date tempoutDtm;
	private Integer thedayFstStockQty;
}
