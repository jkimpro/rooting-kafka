package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpSupAddrDVo {
	private String supAddrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private BigDecimal supCd;
	private String supAddrCd;
	private String cntcTypCd;
	private String useYn;
	private String asignrNm;
	private String telno;
	private String celphnNo;
	private String faxNo;
	private String addrGbnNm;
	private String zipcd;
	private String baseAddr;
	private String dtlAddr;
	private String baseRetpYn;
	private String baseRelspYn;
	private String baseAddrYn;
	private String taxInvAddrYn;
	private String tranZipcd;
	private String whlAddr;
	private String extnsTelno;
	private String intrntMailAddr;
	private String asignrId;
	private String dutyNm;
	private String deptNm;
	private String noteCntnt;
	private String asCentYn;
	private String asCentTelno;
	private String asCentNm;
	private String asDpoAccntNo;
	private BigDecimal asCentUseCnt;
	private String asCentUseYn;
	private String sapAsignOldByYn;
	private String cnfYn;
	private String delYn;
	private String asAddrExposYn;
	private String gtpSaleofcNm;
	private String gtpSaleofcAsignrNm;
	private String gtpSaleofcAsignrTelno;
	private String gtpDdhdRelspYn;
	private String baseGtpDdhdRelspYn;
	private String dtofRetpYn;
	private String baseDtofRetpYn;
	private String dirdlvRelspYn;
	private String dirdlvRetpYn;
	private String roadNmAddrUseYn;
	private String roadNmBaseAddr;
	private String roadNmDtlAddr;
	private String dlvsCoCd;
	private String pickCrditNo;
	private BigDecimal dlvcAmt;
	private BigDecimal rtpcAmt;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date dirdlvMngAddrModDtm;
}
