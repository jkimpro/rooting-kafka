package com.gsshop.kafka.consumer.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "PRD_SHOP_EXPOS_D")
public class PrdShopExposD {

	//****************************************************************************
	@Id	
	@Column(name = "PRD_CD", length = 22) //PK
	@NotNull
	private BigDecimal prdCd; // 상품코드(PRD_CD)
	
	@Column(name = "REG_DTM", length = 7)
	private Date regDtm;		//등록일(REG_DTM)
	
	@Column(name = "REGR_ID", length = 10)
	private String regId;		//등록자ID(REGR_ID)
	
	@Column(name = "MOD_DTM", length = 7)
	private Date modDtm;		//수정일시(MOD_DTM)
	
	@Column(name = "MODR_ID", length = 10)
	private String modrId;		//수정자ID(MODR_ID)

	//****************************************************************************
	@Column(name = "OPTML_CPN_NO", length = 15)
	private String optmlCpnNo;		//최적쿠폰번호(OPTML_CPN_NO)

	@Column(name = "OPTML_CPN_DC_AMT", length = 22)
	private BigDecimal optmlCpnDcAmt;	//최적쿠폰할인금액(OPTML_CPN_DC_AMT)

	@Column(name = "CPN_DC_CNTNT", length = 100)
	private String cpnDcCntnt;		//쿠폰할인내용(CPN_DC_CNTNT)

	@Column(name = "PRC_REDUCT_BEF_LOW_PRC", length = 22)
	private BigDecimal prcReductBefLowPrc;	//가격인하전최저가격(PRC_REDUCT_BEF_LOW_PRC)

	@Column(name = "PRC_REDUCT_DTM", length = 7)
	private Date prcReductDtm;	//가격인하일시(PRC_REDUCT_DTM)
	
	@Column(name = "PRC_DC_DTM", length = 7)
	private Date prcDcDtm;	//가격할인일시(PRC_DC_DTM)
	
	@Column(name = "FLGD_PRC", length =22)
	private BigDecimal flgdPrc;	//기분좋은가격(FLGD_PRC)
	
	@Column(name = "FLGD_PRC_DC_RT", length =22)
	private BigDecimal flgdPrcDcRt;	//기분좋은가격할인율(FLGD_PRC_DC_RT)
	
	@Column(name = "PRE_OPTML_CPN_NO", length =15)
	private String preOptmlCpnNo;	//이전최적쿠폰번호(PRE_OPTML_CPN_NO)
	
	@Column(name = "FLGD_PRC_MARGN_RT", length =22)
	private BigDecimal flgdPrcMargnRt;	//기분좋은가격마진율(FLGD_PRC_MARGN_RT)
	
}
