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

import com.gsshop.kafka.consumer.repository.prkey.PrdDescdGenrlDPK;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@IdClass(PrdDescdGenrlDPK.class)
@Table(name = "PRD_DESCD_GENRL_D")
public class PrdDescdGenrlD implements Serializable{
	
	@Column(name = "PRD_CD") //PK
	@NotNull
	@Id
	private BigDecimal prdCd; // 상품코드(PRD_CD)

	@Column(name = "CHANL_CD", length = 2) //PK
	@NotNull
	@Id
	private String chanlCd; // 채널코드(CHANL_CD) 
	
	@Column(name = "DESCD_ITM_SEQ") //PK
	@NotNull
	@Id
	private BigDecimal descdItmSeq; // 기술서항목순번(DESCD_ITM_SEQ)

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

	@Column(name = "DESCD_ITM_NM", length = 300)
	@NotNull
	private String descdItmNm; // 기술서항목명(DESCD_ITM_NM)

	@Column(name = "DESCD_EXPLN_CNTNT", length = 4000)
	private String descdExplnCntnt; // 기술서설명내용(DESCD_EXPLN_CNTNT)

	
	
	@Column(name = "DESCD_ITM_CD", length = 5)
	private String descdItmCd; // 기술서항목코드(DESCD_ITM_CD)

	@Column(name = "SORT_SEQ")
	private BigDecimal sortSeq; // 정렬순서(SORT_SEQ)

	@Column(name = "ITM_HIDDN_YN", length = 1)
	@NotNull
	private String itmHiddnYn; // 항목숨김여부(ITM_HIDDN_YN)

	@Column(name = "WRAP_YN", length = 1)
	@NotNull
	private String wrapYn; // 줄바꿈여부(WRAP_YN)

	@Column(name = "LINE_INSERT_YN", length = 1)
	@NotNull
	private String lineInsertYn; // 줄삽입여부(LINE_INSERT_YN)

	@Column(name = "FLCKR_YN", length = 1)
	@NotNull
	private String flckrYn; // 점멸여부(FLCKR_YN)

	@Column(name = "LTR_COLOR_NM", length = 50)
	private String ltrColorNm; // 글자색상명(LTR_COLOR_NM)

	@Column(name = "INTRNT_EXPOS_YN", length = 1)
	@NotNull
	private String intrntExposYn; // 인터넷노출여부(INTRNT_EXPOS_YN)

	@Column(name = "EAI_LINK_YN", length = 1)
	@NotNull
	private String eaiLinkYn; // EAI연동여부(EAI_LINK_YN)

	@Column(name = "GENRL_DESCD_ID", length = 45)
	@NotNull
	private String genrlDescdId; // 일반기술서ID(GENRL_DESCD_ID)

	@Column(name = "CNSDR_ST_CD", length = 2)
	private String cnsdrStCd; // 심의상태코드(CNSDR_ST_CD)

	@Column(name = "CNSDR_PRSN_ID", length = 10)
	private String cnsdrPrsnId; // 심의자ID(CNSDR_PRSN_ID)

	@Column(name = "CNSDR_DT")
	private Date cnsdrDt; // 심의일자(CNSDR_DT)
}
