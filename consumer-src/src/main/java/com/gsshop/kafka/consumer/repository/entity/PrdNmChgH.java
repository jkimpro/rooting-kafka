package com.gsshop.kafka.consumer.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.gsshop.kafka.consumer.repository.prkey.PrdNmChgHPK;

import lombok.Data;
import lombok.ToString;


@Data
@Entity
@ToString
@Table(name = "PRD_NM_CHG_H")
@IdClass(PrdNmChgHPK.class)
public class PrdNmChgH  implements Serializable{

	@Id
	@Column(name = "PRD_CD") //PK
	@NotNull
	private BigDecimal prdCd; // (prd_cd)

	@Id
	@Column(name = "CHANL_CD", length = 2) //PK
	@NotNull
	private String chanlCd; // 채널코드(chanl_cd)

	@Id
	@Column(name = "VALID_END_DTM") //PK
	@NotNull
	private Date validEndDtm; // 유효종료일시(valid_end_dtm)

	@Id
	@Column(name = "VALID_STR_DTM") //PK
	@NotNull
	private Date validStrDtm; // 유효시작일시(valid_str_dtm)

	@Column(name = "REG_DTM")
	@NotNull
	private Date regDtm; // 등록일시(reg_dtm)

	@Column(name = "REGR_ID", length = 10)
	@NotNull
	private String regrId; // 등록자ID(regr_id)

	@Column(name = "MOD_DTM")
	@NotNull
	private Date modDtm; // 수정일시(mod_dtm)

	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId; // 수정자ID(modr_id)

	@Column(name = "EXPOS_PRD_NM", length = 240)
	private String exposPrdNm; // 노출상품명(expos_prd_nm)

	@Column(name = "EXPOS_PMO_NM", length = 240)
	private String exposPmoNm; // 노출프로모션명(expos_pmo_nm)

	@Column(name = "EXPOS_PR_SNTNC_NM", length = 240)
	private String exposPrSntncNm; // 노출홍보문구명(expos_pr_sntnc_nm)
}
