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
@Table(name = "PRD_STOCK_D")
public class PrdStockD{
	@Id	
	@Column(name = "ATTR_PRD_REP_CD", length = 50) //PK
	@NotNull
	private String attrPrdRepCd; 		// 속성상품대표코드(ATTR_PRD_REP_CD)
	
	@Column(name = "REG_DTM", length = 7)
	@NotNull
	private Date regDtm;		//등록일(REG_DTM)
	
	@Column(name = "REGR_ID", length = 10)
	@NotNull
	private String regId;		//등록자ID(REGR_ID)
	
	@Column(name = "MOD_DTM", length = 7)
	@NotNull
	private Date modDtm;		//수정일시(MOD_DTM)
	
	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId;		//수정자ID(MODR_ID)

	@Column(name = "ATTR_PRD_REP_NM", length = 300)
	private String attrPrdRepNm;		//속성상품대표명(ATTR_PRD_REP_NM)

	@Column(name = "PRD_CD", length = 22)
	@NotNull
	private BigDecimal prdCd; 			// 상품코드(PRD_CD)
	
	@Column(name = "STOCK_QTY", length = 22)
	private BigDecimal stockQty;		//재고수량(STOCK_QTY)
	
	@Column(name = "SAFE_STOCK_QTY", length = 22)
	private BigDecimal safeStockQty;		//안전재고수량(SAFE_STOCK_QTY)

	@Column(name = "ASUM_QTY", length = 22)
	private BigDecimal asumQty;		//누적수량(ASUM_QTY)
	
	@Column(name = "SAP_TNS_CD", length = 1)
	private String sapTnsCd;				//SAP전송코드(SAP_TNS_CD)
	
	@Column(name = "TEMPOUT_YN", length = 1)
	private String tempoutYn;				//일시품절여부(TEMPOUT_YN)
	
	@Column(name = "TEMPOUT_DTM", length = 1)
	private Date tempoutDtm;				//일시품절일시(TEMPOUT_DTM)
	
	@Column(name = "THEDAY_FST_STOCK_QTY", length = 1)
	private String thedayFstStockQty;				//당일최초재고수량(THEDAY_FST_STOCK_QTY)
	
}
