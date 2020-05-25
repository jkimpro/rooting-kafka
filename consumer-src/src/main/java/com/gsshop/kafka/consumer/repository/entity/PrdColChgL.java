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
@Table(name = "PRD_COL_CHG_L")
public class PrdColChgL {
	@Column(name = "LOG_SEQ")
	@NotNull
	@Id
	private BigDecimal logSeq; // 로그 순번
	
	@Column(name = "REG_DTM", updatable = false)
	@NotNull
	private Date regDtm; // 등록일시(REG_DTM)

	@Column(name = "REGR_ID", length = 10, updatable = false)
	@NotNull
	private String regrId; // 등록자ID(REGR_ID)

	@Column(name = "MOD_DTM",length = 7)
	@NotNull
	private Date modDtm; // 수정일시(MOD_DTM)

	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId; // 수정자ID(MODR_ID)

	@Column(name = "REGR_IP", length = 32)
	private String regrIp; // 등록자IP(REGR_IP)
	
	@Column(name = "PRD_CD")
	@NotNull
	private BigDecimal prdCd; // 상품코드(PRD_CD)
	
	@Column(name = "CHG_COL_NM", length=100)
	private String chgColNm; // 변경컬럼명(CHG_COL_NM)
	
	@Column(name = "CHG_BEF_VAL", length=2000)
	private String chgBefVal; // 변경전값(CHG_COL_NM)
	
	@Column(name = "CHG_AFT_VAL", length=2000)
	private String chgAftVal; // 변경후값(CHG_AFT_VAL)
	
	
}
