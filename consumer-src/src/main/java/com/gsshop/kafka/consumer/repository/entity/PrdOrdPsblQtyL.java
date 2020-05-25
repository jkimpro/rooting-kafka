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
@Table(name = "PRD_ORD_PSBL_QTY_L")
public class PrdOrdPsblQtyL {

	@Id
	@Column(name = "LOG_SEQ", length=22) //PK
	@NotNull
	private BigDecimal logSeq; 		//로그순번(LOG_SEQ)
	
	
	@Column(name = "REG_DTM")
	@NotNull
	private Date regDtm; 		//등록일시(REG_DTM)

	@Column(name = "REGR_ID", length = 10)
	@NotNull
	private String regrId; 		//등록자ID(REGR_ID)

	@Column(name = "MOD_DTM")
	@NotNull
	private Date modDtm; 		//수정일시(MOD_DTM)

	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId;		 // 수정자ID(MODR_ID)

	@Column(name = "ATTR_PRD_REP_CD", length=50)
	@NotNull
	private String attrPrdRepCd; //속성상품대표코드 (ATTR_PRD_REP_CD)

	@Column(name = "CHANL_GRP_CD", length=2)
	@NotNull
	private String chanlGrpCd; //채널그룹코드 (CHANL_GRP_CD)

	@Column(name = "ORD_PSBL_QTY", length = 22)
	@NotNull
	private BigDecimal ordPsblQty; 	// 주문가능수량(ORD_PSBL_QTY)
}
