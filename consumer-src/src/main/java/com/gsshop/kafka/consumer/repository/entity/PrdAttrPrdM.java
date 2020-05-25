package com.gsshop.kafka.consumer.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;


@Data
@Entity
@ToString
@Table(name = "PRD_ATTR_PRD_M")
public class PrdAttrPrdM {
	
	@Id
	@Column(name = "ATTR_PRD_CD")
	@NotNull
	private BigDecimal attrPrdCd;       // (ATTR_PRD_CD)

	@Column(name = "REG_DTM", updatable=false)
	@NotNull
	private Date regDtm;          // 등록일시(REG_DTM)

	@Column(name = "REGR_ID", length = 10, updatable=false)
	@NotNull
	private String regrId;          // 등록자ID(REGR_ID)

	@Column(name = "MOD_DTM")
	@NotNull
	private Date modDtm;          // 수정일시(MOD_DTM)

	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId;          // 수정자ID(MODR_ID)
	
	@Column(name = "EC_ATTR_PRD_CD")
	@NotNull
	private BigDecimal ecAttrPrdCd;     // (EC_ATTR_PRD_CD)

	@Column(name = "PRD_CD")
	@NotNull
	private BigDecimal prdCd;           // (PRD_CD)

	@Column(name = "ATTR_PRD_REP_CD", length = 50)
	@NotNull
	private String attrPrdRepCd;    // 속성상품대표코드(ATTR_PRD_REP_CD)

	@Column(name = "USE_YN", length = 1)								//'Y'
	@NotNull
	private String useYn;           // 사용여부(use_yn)

	@Column(name = "EXPOS_DFALT_VAL_YN", length = 1)					//'N'
	@NotNull
	private String exposDfaltValYn; // 노출디폴트값여부(expos_dfalt_val_yn)

	@Column(name = "ATTR_VAL_1", length = 80)
	@NotNull
	private String attrVal1;        // 속성값1(ATTR_VAL_1)

	@Column(name = "ATTR_VAL_2", length = 80)
	@NotNull
	private String attrVal2;        // 속성값2(ATTR_VAL_2)

	@Column(name = "ATTR_VAL_3", length = 80)
	@NotNull
	private String attrVal3;        // 속성값3(ATTR_VAL_3)

	@Column(name = "ATTR_VAL_4", length = 80)
	@NotNull
	private String attrVal4;        // 속성값4(ATTR_VAL_4)

	@Column(name = "ATTR_VAL_CD_1", length = 10)
	@NotNull
	private String attrValCd1;      // 속성값코드1(ATTR_VAL_CD_1)

	@Column(name = "ATTR_VAL_CD_2", length = 10)
	@NotNull
	private String attrValCd2;      // 속성값코드2(ATTR_VAL_CD_2)

	@Column(name = "ATTR_VAL_CD_3", length = 10)
	@NotNull
	private String attrValCd3;      // 속성값코드3(ATTR_VAL_CD_3)

	@Column(name = "ATTR_VAL_CD_4", length = 10)
	@NotNull
	private String attrValCd4;      // 속성값코드4(ATTR_VAL_CD_4)

//	@Column(name = "ATTR_PRD_NM", length = 320)===================PRDDB에만 있는 컬럼
//	private String attrPrdNm;       // 속성명(attr_prd_nm)

	@Column(name = "ATTR_WHL_VAL", length = 320)								//이거 디폴트값 존재하지 않음 but not null임에도 불구하고, prdDb 테이블에는 없음. 어케처리해야할지..
	@NotNull
	private String attrWhlVal;      // 속성전체값(ATTR_WHL_VAL)
	
	@Column(name = "SALE_STR_DTM")
	@NotNull
	private Date saleStrDtm;      // 판매시작일시(SALE_STR_DTM)

	@Column(name = "SALE_END_DTM")												//MAXDate임
	@NotNull
	private Date saleEndDtm;      // 판매종료일시(SALE_END_DTM)	

	@Column(name = "SALE_END_PRSN_ID", length = 10)
	private String saleEndPrsnId;   // 판매종료자ID(SALE_END_PRSN_ID)

	@Column(name = "SALE_END_RSN_CD", length = 4)
	private String saleEndRsnCd;    // 판매종료사유코드(SALE_END_PSN_CD)

	@Column(name = "SALE_END_RSN_CNTNT", length = 200)
	private String saleEndRsnCntnt; // 판매종료사유내용(SALE_END_RSN_CNTNT)

	@Column(name = "SHTPRD_REG_DTM")
	private Date shtprdRegDtm;    // 결품등록일시(SHTPRD_REG_DTM)

	@Column(name = "ADD_CMPOS_GBN_CD", length = 1)
	private String addCmposGbnCd;   // 추가구성구분코드(ADD_CMPOS_GBN_CD)

	@Column(name = "ATTR_PKG_CNT")
	private BigDecimal attrPkgCnt;      // 속성포장갯수(ATTR_PKG_CNT)

	@Column(name = "ATTR_CMPOS_CNTNT", length = 500)
	private String attrCmposCntnt;  // 속성구성내용(ATTR_CMPOS_CNTNT)

	@Column(name = "ORGP_NM", length = 3000)
	private String orgpNm;          // 원산지명(ORGP_NM)

	@Column(name = "MNFC_CO_NM", length = 200)
	private String mnfcCoNm;        // 제조사명(MNFC_CO_NM)

	@Column(name = "PRC_CMPOS_YN", length = 1)
	private String prcCmposYn;      // 가격구성여부(PRC_CMPOS_YN)	

	@Column(name = "ARS_ATTR_SEQ_1", length = 15)
	private BigDecimal arsAttrSeq1;     // 자동주문속성순서1(ARS_ATTR_SEQ_1)

	@Column(name = "ARS_ATTR_SEQ_2", length = 15)
	private BigDecimal arsAttrSeq2;     // 자동주문속성순서2(ARS_ATTR_SEQ_2)

	@Column(name = "ARS_ATTR_SEQ_3", length = 15)
	private BigDecimal arsAttrSeq3;     // 자동주문속성순서3(ARS_ATTR_SEQ_3)

	@Column(name = "ARS_ATTR_SEQ_4", length = 15)
	private BigDecimal arsAttrSeq4;     // 자동주문속성순서4(ARS_ATTR_SEQ_4)

	@Column(name = "SAP_TNS_YN", length = 1)
	private String sapTnsYn;        // sap전송여부(SAP_TNS_YN)

	@Column(name = "SALE_PSBL_APRV_YN", length = 1)									//'Y'
	@NotNull
	private String salePsblAprvYn;  // 판매가능결재여부(SALE_PSBL_APRV_YN)

	@Column(name = "ATTR_PRD_APRV_ST_CD", length = 2)								// '00'
	@NotNull
	private String attrPrdAprvStCd; // 속성상품결재상태코드(ATTR_PRD_APRV_ST_CD)

	@Column(name = "ATTR_REG_GBN_CD", length = 1)
	private String attrRegGbnCd;    // 속성등록구분코드(ATTR_REG_GBN_CD)

	@Column(name = "MODEL_NO", length = 60)
	private String modelNo;         // 모델번호(MODEL_NO)

	@Column(name = "EXPOS_SEQ")
	private BigDecimal exposSeq;        // (EXPOS_SEQ)

	@Column(name = "CNTNT_NO")
	private BigDecimal cntntNo;         // (CNTNT_NO)

	@Column(name = "ARS_ATTR_VAL_1", length = 80)
	private String arsAttrVal1;     // 자동주문속성값1(ARS_ATTR_VAL_1)

	@Column(name = "ARS_ATTR_VAL_2", length = 80)
	private String arsAttrVal2;     // 자동주문속성값2(ARS_ATTR_VAL_2)

	@Column(name = "ARS_ATTR_VAL_3", length = 80)
	private String arsAttrVal3;     // 자동주문속성값3(ARS_ATTR_VAL_3)

	@Column(name = "ARS_ATTR_VAL_4", length = 80)
	private String arsAttrVal4;     // 자동주문속성값4(ARS_ATTR_VAL_4)

	@Column(name = "CATV_SALE_LIMIT_YN", length = 1)
	private String catvSaleLimitYn; // 케이블tv판매제한여부(CATV_SALE_LIMIT_YN)

	@Column(name = "SUP_ATTR_PRD_CD", length = 50)
	private String supAttrPrdCd;    // 협력사속성상품코드(SUP_ATTR_PRD_CD)
	

}
