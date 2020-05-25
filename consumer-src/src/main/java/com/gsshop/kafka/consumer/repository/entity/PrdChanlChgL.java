package com.gsshop.kafka.consumer.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.gsshop.kafka.consumer.repository.prkey.PrdChanlChgLPK;

import lombok.Data;

@Data
@Entity
@Table(name = "PRD_CHANL_CHG_L")
@IdClass(PrdChanlChgLPK.class)
public class PrdChanlChgL {
	
	@Column(name = "PRD_CD")
	@NotNull
	@Id
	private BigDecimal prdCd; // 상품코드(PRD_CD)

	@Column(name = "CHANL_CD", length = 2)
	@NotNull
	@Id
	private String chanlCd; // 채널코드(CHANL_CD)

	@Column(name = "LOG_REG_DTM")
	@NotNull
	@Id
	private Date logRegDtm; // 로그등록일시(LOG_REG_DTM)
	
	@Column(name = "REG_DTM", updatable = false)
	@NotNull
	private Date regDtm; // 등록일시(REG_DTM)

	@Column(name = "REGR_ID", length = 10, updatable = false)
	@NotNull
	private String regrId; // 등록자ID(REGR_ID)

	@Column(name = "MOD_DTM")
	@NotNull
	private Date modDtm; // 수정일시(MOD_DTM)

	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId; // 수정자ID(MODR_ID)

	@Column(name = "CHANL_MD_ID", length = 5)
	@NotNull
	private String chanlMdId; // 채널MDID(CHANL_MD_ID)

	@Column(name = "SALE_PSBL_YN", length = 1)
	@NotNull
	private String salePsblYn; // 판매가능여부(SALE_PSBL_YN)

	@Column(name = "QA_INSP_YN", length = 1)
	@NotNull
	private String qaInspYn; // QA검사여부(QA_INSP_YN)

	@Column(name = "STD_RELS_DDCNT")
	private BigDecimal stdRelsDdcnt; // 표준출고일수(STD_RELS_DDCNT)

	@Column(name = "REP_MD_USER_ID", length = 10)
	private String repMdUserId; // 대표MD사용자ID(REP_MD_USER_ID)

	@Column(name = "SUB_REP_MD_USER_ID", length = 10)
	private String subRepMdUserId; // 하위대표MD사용자ID(SUB_REP_MD_USER_ID)
}
