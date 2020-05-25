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

import com.gsshop.kafka.consumer.repository.prkey.PrdExplnDPK;

import lombok.Data;
import lombok.ToString;


@ToString
@Data
@Entity
@Table(name = "PRD_EXPLN_D")
@IdClass(PrdExplnDPK.class)
public class PrdExplnD  implements Serializable{
	@Column(name = "PRD_CD") //PK
	@NotNull
	@Id
	private BigDecimal prdCd; // (prd_cd)

	@Column(name = "CHANL_CD", length = 2) //PK
	@NotNull
	@Id
	private String chanlCd; // 채널코드(chanl_cd)

	@Column(name = "GOV_PUBLS_PRD_GRP_CD", length = 2) //PK
	@NotNull
	@Id
	private String govPublsPrdGrpCd; // 정부고시상품군코드(GOV_PUBLS_PRD_GRP_CD)

	@Column(name = "PRD_EXPLN_ITM_CD", length = 5) //PK
	@NotNull
	@Id
	private String prdExplnItmCd; // 상품설명항목코드(PRD_EXPLN_ITM_CD)
	
	@Column(name = "REG_DTM", updatable = false)
	@NotNull
	private Date regDtm; // 등록일시
	
	@Column(name = "REGR_ID", length = 10, updatable = false)
	@NotNull
	private String regrId; // 등록자ID
	
	@Column(name = "MOD_DTM")
	@NotNull
	private Date modDtm; // 수정일시
	
	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId; // 수정자ID
	
	@Column(name = "PRD_EXPLN_ITM_NM", length = 300)
	@NotNull
	private String prdExplnItmNm; // 상품설명항목명
	
	@Column(name = "PRD_EXPLN_GBN_CD", length = 1)
	@NotNull
	private String prdExplnGbnCd; // 상품설명구분코드
	
	@Column(name = "PRD_EXPLN_CNTNT", length = 4000)
	@NotNull
	private String prdExplnCntnt; // 상품설명내용
	
	@Column(name = "EXPOS_SEQ", length = 15)	
	private BigDecimal exposSeq; // 노출순서
	
	@Column(name = "EXPOS_YN", length = 1)		//default y
	@NotNull
	private String exposYn; // 노출여부
	
	@Column(name = "CNSDR_ST_CD", length = 2)	
	private String cnsdrStCd; // 심의상태코드
	
	@Column(name = "CNSDR_PRSN_ID", length = 10)	
	private String cnsdrPrsnId; // 심의자ID
	
	@Column(name = "CNSDR_DT")	
	private Date cnsdrDt; // 심의일자
	
	@Column(name = "ERR_YN", length = 1)	
	private String errYn; // 오류여부
}
