package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpCntntDVo {
	private BigDecimal cntntNo;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private BigDecimal prdCd;
	private BigDecimal attrPrdCd;
	private String prdAttrGbnCd;
	private String useYn;
	private String cntntTypCd;
	private String cntntGbnCd;
	private String cntntFileNm;
	private String cntntExtnsNm;
	private BigDecimal fileSize;
	private String cntntUrlNm;
	private String cntntExplnCntnt;
	private String cntntSupNm;
	private String ecExposYn;
	private String brdExposYn;
	private String catvExposYn;
	private String cntntRegGbnCd;
	private String ecOrSiebelYn;
	private String imgExplnCntnt;
}