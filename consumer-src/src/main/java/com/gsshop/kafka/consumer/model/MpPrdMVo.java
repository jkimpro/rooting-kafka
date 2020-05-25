package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpPrdMVo {
	private BigDecimal prdCd;

	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;

	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String useYn;
	private BigDecimal itemCd;
	private BigDecimal brandCd;
	private BigDecimal copySrcPrdCd;
	private String copyPrdYn;
	private String prdNm;
	private String autoOrdPrdNm;

	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date saleStrDtm;

	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date saleEndDtm;
	
	private String mnfcCoNm;
	private String orgpNm;
	private String modelNo;
	private String operMdId;
	private String prdClsCd;
	private String prdTypCd;
	private String prdGbnCd;
	private String prchTypCd;
	private String ordPrdTypCd;
	private String frmlesPrdTypCd;
	private String gftTypCd;
	private String taxTypCd;
	private String exposStCd;
	private String prdAprvStCd;
	private String tempoutYn;
	private String rfnTypCd;
	private BigDecimal ordLimitQty;
	private String adultCertYn;
	private String supModNoadmtYn;
	private String imgCnfYn;
	private String preOrdTypCd;
	private String autoOrdPsblYn;
	private String autoOrdClsCd;
	private BigDecimal supCd;
	private String subSupCd;
	private String supPrdCd;
	private String mnfcCoBzNo;
	private String mnfcCoGbnCd;
	private String prdInfoMngrId;
	private String dlvPickMthodCd;
	private String prdRetpAddrCd;
	private String prdRelspAddrCd;
	private String dlvsCoCd;
	private String chrDlvYn;
	private BigDecimal chrDlvcCd;
	private String chrDlvAddYn;
	private String saleEndYn;
	private String saleEndPrsnId;
	private String saleEndRsnCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date exposSchdDt;
	
	private String onairSalePsblYn;
	private String broadPrdYn;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date fstBroadDtm;
	
	private String prdRegGbnCd;
	private BigDecimal arsMaxQty;
	private String ifYn;
	private String regChanlGrpCd;
	private String styleDirEntYn;

	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date itemMappnDtm;
	
	private String orgpCd;
	private String attrTypNm1;
	private String attrTypNm2;
	private String attrTypNm3;
	private String attrTypNm4;
	private BigDecimal attrTypSeq1;
	private BigDecimal attrTypSeq2;
	private BigDecimal attrTypSeq3;
	private BigDecimal attrTypSeq4;
	private String istTypCd;
	private BigDecimal repPrdCd;
	private String prdEngNm;
	private String repPrdYn;
	private String bundlPrdGbnCd;
	private String separOrdNoadmtYn;
	private String qaGrdCd;
	private String qaPrgStCd;
	private String salePsblAprvYn;

	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date tempoutChgDtm;

	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date shtprdRegDtm;
	
	private String ecAprvStCd;

	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date lastAprvCnfDtm;
	
	private String prdCnsdrStCd;
	private String prdAttrPrcGbnCd;
	private String prdAttrDtlGbnCd;
}
