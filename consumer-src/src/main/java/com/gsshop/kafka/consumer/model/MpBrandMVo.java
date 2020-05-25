package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpBrandMVo {
	private BigDecimal brandCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String brandNm;
	private String brandMrkGbnCd;
	private String brandHanglNm;
	private String brandEngNm;
	private BigDecimal brandLvlNo;
	private BigDecimal upperBrandCd;
	private String brandStCd;
	private String prdSpecCd;
	private BigDecimal prdSpecSeq;
	private String primBrandYn;
	private String forgnBrandYn;
	private String noteCntnt;
	private String mimgFileNm;
	private String limgFileNm;
	private String timgFileNm;
	private String simgFileNm;
	private String himgFileNm;
}