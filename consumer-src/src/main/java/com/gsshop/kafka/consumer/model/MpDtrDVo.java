package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MpDtrDVo {
	private BigDecimal prdCd;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String bundlPrdGbnCd;
	private String instlDlvPrdYn;
	private String smlTypPrdYn;
	private String cvsDlvsRtpYn;
	private String oboxCd;
	private String centAddPkgYn;
	private String dlvDtGuideCd;
	private String istTypCd;
	private String dlvCrditNo;
	private String pickCrditNo;
	private String apntDlvsImplmYn;
	private String apntDlvDlvsCoCd;
	private String apntPickDlvsCoCd;
	private String exchRtpChrYn;
	private BigDecimal rtpDlvcCd;
	private String rtpOnewyRndtrpCd;
	private String exchOnewyRndtrpCd;
	private String bundlDlvCd;
	private String dlvSchdDtGuideLimitYn;
	private String ilndDlvPsblYn;
	private String jejuDlvPsblYn;
	private String dd3InDlvNoadmtRegonYn;
	private String ilndChrDlvYn;
	private BigDecimal ilndChrDlvcCd;
	private String ilndExchRtpChrYn;
	private BigDecimal ilndRtpDlvcCd;
	private String ilndRtpOnewyRndtrpCd;
	private String ilndExchOnewyRndtrpCd;
	private String jejuChrDlvYn;
	private BigDecimal jejuChrDlvcCd;
	private String jejuExchRtpChrYn;
	private BigDecimal jejuRtpDlvcCd;
	private String jejuRtpOnewyRndtrpCd;
	private String jejuExchOnewyRndtrpCd;
	private String apntDtDlvYn;
	private String apntDtDlvTyp;
	private String gschoiceYn;
	private String pkgmtYn;
	private String pkgmtTypCd;
	private String prdChrGrpCd;
	private String oboxPsblYn;
	private BigDecimal oboxPsblQty;
	private String gftOboxPsblYn;
	private BigDecimal widVal;
	private BigDecimal vertVal;
	private BigDecimal hightVal;
	private String lenUnitCd;
	private BigDecimal weihtVal;
	private String weihtUnitCd;
	private String volUnitCd;
	private String rtpcDlvcSameYn;
	private String prdValidTermCd;
	private String wrtdnYn;
	private String pkgmtWthExposYn;
	private String prdChrGrpCdCnfYn;
	private BigDecimal volVal;
	private String fprdTypCd;
	private String gtpDirdlvProcStrDt;
	private String gtpDirdlvProcEndDt;
	private String lowuprcExcluDlvsYn;
	private String dlvSchdDtExtndYn;
	private String dirdlvMngAgncyYn;
	private BigDecimal bundlDlvPsblQty;
	private String gtpDdhdChgYn;
	private BigDecimal fprdUprc;
}
