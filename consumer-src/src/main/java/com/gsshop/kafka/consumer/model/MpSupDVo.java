package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpSupDVo {
	private BigDecimal supCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String supByEcInfoRoomCntnt;
	private String note1Cntnt;
	private String note2Cntnt;
	private String supCmmCntnt;
	private String relsCnlNtcSmsYn;
	private String relsCnlNtcCelphnNo;
	private String dirdlvChgCtrlYn;
	private String dirdlvChgCtrlCntnt;
	private String dlvcCalcExcptYn;
	private String autoPickExcptYn;
}