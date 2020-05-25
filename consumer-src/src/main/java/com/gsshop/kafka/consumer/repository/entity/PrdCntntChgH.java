package com.gsshop.kafka.consumer.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "PRD_CNTNT_CHG_H")
public class PrdCntntChgH {
	
	@Column(name = "CHG_HIST_SEQ")
	@NotNull
	@Id
	private BigDecimal chgHistSeq; // 변경이력순번(CHG_HIST_SEQ)

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

	@Column(name = "OLD_PRD_CD")
	@NotNull
	private BigDecimal oldPrdCd; // 구상품코드(OLD_PRD_CD)

	@Column(name = "NEW_PRD_CD")
	@NotNull
	private BigDecimal newPrdCd; // 새상품코드(NEW_PRD_CD)

	@Column(name = "CHG_GBN_CD", length = 1)
	@NotNull
	private String chgGbnCd; // 변경구분코드(CHG_GBN_CD)

	@Column(name = "USE_YN", length = 1)
	private String useYn; // 사용여부(USE_YN)

}
