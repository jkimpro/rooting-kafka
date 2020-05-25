package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpDescdGenrlDVo {
	private BigDecimal prdCd;
	private String chanlCd;
	private BigDecimal descdItmSeq;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String descdItmNm;
	private String descdExplnCntnt;
	private String descdItmCd;
	private BigDecimal sortSeq;
	private String itmHiddnYn;
	private String wrapYn;
	private String lineInsertYn;
	private String flckrYn;
	private String ltrColorNm;
	private String intrntExposYn;
	private String eaiLinkYn;
	private String genrlDescdId;
	private String cnsdrStCd;
	private String cnsdrPrsnId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date cnsdrDt;
}
