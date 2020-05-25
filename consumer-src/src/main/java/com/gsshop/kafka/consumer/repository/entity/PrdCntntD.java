package com.gsshop.kafka.consumer.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "PRD_CNTNT_D")
public class PrdCntntD {
	@Column(name = "CNTNT_NO")
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal cntntNo; // 컨텐츠번호(CNTNT_NO)
	
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
	
	@Column(name = "PRD_CD")
	@NotNull
	private BigDecimal prdCd; // 상품코드(PRD_CD)
	
	@Column(name = "ATTR_PRD_CD")
	private BigDecimal attrPrdCd; // 속성상품코드(ATTR_PRD_CD)
	
	@Column(name = "PRD_ATTR_GBN_CD", length = 1)
	@NotNull
	private String prdAttrGbnCd; // 상품속성구분코드(PRD_ATTR_GBN_CD)
	
	@Column(name = "USE_YN", length = 1)
	@NotNull
	private String useYn; // 사용여부(USE_YN)
	
	@Column(name = "CNTNT_TYP_CD", length = 12)
	private String cntntTypCd; // 컨텐츠유형코드(CNTNT_TYP_CD)
	
	@Column(name = "CNTNT_GBN_CD", length = 4)
	@NotNull
	private String cntntGbnCd; // 컨텐츠구분코드(CNTNT_GBN_CD)
	
	@Column(name = "CNTNT_FILE_NM", length = 200)
	private String cntntFileNm; // 컨텐츠파일명(CNTNT_FILE_NM)
	
	@Column(name = "CNTNT_EXTNS_NM", length = 50)
	private String cntntExtnsNm; // 컨텐츠확장자명(CNTNT_EXTNS_NM)
	
	@Column(name = "FILE_SIZE")
	@NotNull
	private BigDecimal fileSize; // 파일사이즈(FILE_SIZE)
	
	@Column(name = "CNTNT_URL_NM", length = 1000)
	private String cntntUrlNm; // 컨텐츠URL명(CNTNT_URL_NM)
	
	@Column(name = "CNTNT_EXPLN_CNTNT", length = 500)
	private String cntntExplnCntnt; // 컨텐츠설명내용(CNTNT_EXPLN_CNTNT)
	
	@Column(name = "CNTNT_SUP_NM", length = 100)
	private String cntntSupNm; // 컨텐츠공급자명(CNTNT_SUP_NM)
	
	@Column(name = "EC_EXPOS_YN", length = 1)
	private String ecExposYn; // EC노출여부(EC_EXPOS_YN)
	
	@Column(name = "BRD_EXPOS_YN", length = 1)
	private String brdExposYn; // 방송넷노출여부(BRD_EXPOS_YN)
	
	@Column(name = "CATV_EXPOS_YN", length = 1)
	private String catvExposYn; // 케이블TV노출여부(CATV_EXPOS_YN)
	
	@Column(name = "CNTNT_REG_GBN_CD", length = 2)
	private String cntntRegGbnCd; // 컨텐츠등록구분코드(CNTNT_REG_GBN_CD)
	
	@Column(name = "EC_OR_SIEBEL_YN", length = 1)
	private String ecOrSiebelYn; // EC/시블여부(EC_OR_SIEBEL_YN)
	
	@Column(name = "IMG_EXPLN_CNTNT", length = 1333)
	private String imgExplnCntnt; // 이미지설명내용(IMG_EXPLN_CNTNT)
}
