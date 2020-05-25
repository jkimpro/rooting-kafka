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

import com.gsshop.kafka.consumer.repository.prkey.PrdDescdHtmlDPK;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@IdClass(PrdDescdHtmlDPK.class)
@Table(name = "PRD_DESCD_HTML_D")
public class PrdDescdHtmlD implements Serializable{
	
	@Column(name = "PRD_CD") //PK
	@NotNull
	@Id
	private BigDecimal prdCd; // (PRD_CD)

	@Column(name = "CHANL_CD", length = 2) //PK
	@NotNull
	@Id
	private String chanlCd; // 채널코드(CHANL_CD)

	@Column(name = "REG_GBN_CD", length = 1) //PK
	@NotNull
	@Id
	private String regGbnCd; // 등록구분코드(REG_GBN_CD)
	
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

	@Column(name = "DESCD_EXPLN_CNTNT",length = 4000)
	private String descdExplnCntnt; // 기술서설명내용(DESCD_EXPLN_CNTNT)

	@Column(name = "RCMD_SNTNC_CNTNT", length = 4000)
	private String rcmdSntncCntnt; // 추천문구내용(RCMD_SNTNC_CNTNT)

	@Column(name = "WRITE_PREVNT_YN", length = 1)
	@NotNull
	private String writePrevntYn; // 쓰기방지여부(WRITE_PREVNT_YN)

//	@Column(name = "WRITE_PREVNT_CNF_DT")
	private Date writePrevntCnfDt; // 쓰기방지확인일자(WRITE_PREVNT_CNF_DT)

	@Column(name = "EC_EXPOS_YN", length = 1)
	@NotNull
	private String ecExposYn; // EC노출여부(EC_EXPOS_YN)

	@Column(name = "IMG_EXPLN_CNTNT", length = 1333)
	private String imgExplnCntnt; // 이미지설명내용(IMG_EXPLN_CNTNT)
}
