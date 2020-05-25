package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpShopExposDVo {
	private BigDecimal prdCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	private String modrId;
	private String optmlCpnNo;
	private BigDecimal optmlCpnDcAmt;
	private String cpnDcCntnt;
	private BigDecimal prcReductBefLowPrc;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date prcReductDtm;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date prcDcDtm;
	
	private BigDecimal flgdPrc;
	private BigDecimal flgdPrcDcRt;
	private String preOptmlCpnNo;
	private BigDecimal flgdPrcMargnRt;
}
