package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpExplnDVo {
	private BigDecimal prdCd;
	private String chanlCd;
	private String govPublsPrdGrpCd;
	private String prdExplnItmCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String prdExplnItmNm;
	private String prdExplnGbnCd;
	private String prdExplnCntnt;
	private BigDecimal exposSeq;
	private String exposYn;
	private String cnsdrStCd;
	private String cnsdrPrsnId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date cnsdrDt;
	private String errYn;
}
