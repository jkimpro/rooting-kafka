package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpNoteDVo {
	private BigDecimal prdCd;
	private String noteTypCd;
	private BigDecimal noteSeq;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	private String modrId;
	private String noteCntnt1;
	private String noteCntnt2;
	private String noteCntnt3;
	private String noteCntnt4;
	private String noteCntnt5;
	private String noteCntnt6;
	private String noteCntnt7;
	private String noteCntnt8;
	private String noteCntnt9;
	private String noteCntnt10;
}
