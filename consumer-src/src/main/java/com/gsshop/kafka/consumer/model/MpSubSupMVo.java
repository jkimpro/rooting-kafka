package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpSubSupMVo {
	private String subSupCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	private String modrId;
	private String subSupNm;
	private BigDecimal upperSupCd;
	private String entId;
	private String updId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date lastLoginDtm;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date lastPasswdChgDtm;
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date txnEndDt;
	
	private String asignrNm;
	private String subSupAddr;
	private String telno;
	private String celphnNo;
	private String faxNo;
	private String emailAddr;
	private String useYn;
	private String passwdEcp;
	private String aliaCoTnsYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date lockDtm;
	private String dutyNm;
	private String dpatBrandVal;
	private String dpatFlrhigtVal;
	private BigDecimal passwdFailCnt;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date passwdLastFailDtm;
	private String smsRcvTime;
	private String smsRcvNo;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date certDtm;
	private String relsCnlNtcSmsYn;
	private String relsCnlNtcCelphnNo;
	private BigDecimal celphnCertFailCnt;
}