package com.gsshop.kafka.consumer.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;

@Data
@Entity
@Table(name = "PRD_PRD_D")
public class PrdPrdD {


	//****************************************************************************
	@Id	
	@Column(name = "PRD_CD", length = 22) //PK
	@NotNull
	private BigDecimal prdCd; // 상품코드(PRD_CD)
	
	@Column(name = "REG_DTM", length = 7)
	@NotNull
	private Date regDtm;		//등록일(REG_DTM)
	
	@Column(name = "REGR_ID", length = 10)
	@NotNull
	private String regId;		//등록자ID(REGR_ID)
	
	@Column(name = "MOD_DTM", length = 7)
	@NotNull
	private Date modDtm;		//수정일시(MOD_DTM)
	
	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId;		//수정자ID(MODR_ID)

	//****************************************************************************
	
	
	@Column(name = "ORGPRD_PKG_CNT", length = 22)
	private BigDecimal orgprdPkgCnt;				//본품 포장 개수 (ORGPRD_PKG_CNT)
	
	@Column(name = "PRD_BASE_CMPOS_CNTNT", length = 500)
	private String prdBaseCmposCntnt;				//상품기본구성내용(PRD_BASE_CMPOS_CNTNT)
	
	@Column(name = "ADD_CMPOS_PKG_CNT", length = 22)
	private BigDecimal addCmposPkgCnt;				//추가구성포장개수(ADD_CMPOS_PKG_CNT)
	
	@Column(name = "PRD_ADD_CMPOS_CNTNT", length =500)
	private String prdAddCmposCntnt;				//상품추가구성내용(PRD_ADD_CMPOS_CNTNT)
	
	@Column(name = "ADD_CMPOS_ORGP_NM", length = 1333)
	private String addCmposOrgpNm;					//추가구성원산지명(ADD_CMPOS_ORGP_NM)

	@Column(name = "ADD_CMPOS_MNFC_CO_NM", length = 200)
	private String addCmposMnfcCoNm;				//추가구성제조사명(ADD_CMPOS_MNFC_CO_NM)

	@Column(name = "GFT_PKG_CNT", length = 22)
	private BigDecimal gftPkgCnt;					//사은품포장개수(GFT_PKG_CNT)
	
	@Column(name = "PRD_GFT_CMPOS_CNTNT", length = 500)
	private String prdGftCmposCntnt;				//상품사은품구성내용 (PRD_GFT_CMPOS_CNTNT)
	
	@Column(name = "GFT_CMPOS_ORGP_NM", length = 1333)
	private String gftCmposOrgpNm;					//사은품구성원산지명 (GFT_CMPOS_ORGP_NM)
	
	@Column(name = "GFT_CMPOS_MNFC_CO_NM", length = 200)
	private String gftCmposMnfcCoNm;				//사은품구성제조사명 (GFT_CMPOS_MNFC_CO_NM)
	
	@Column(name = "PRD_ETC_CMPOS_CNTNT", length = 500)
	private String prdEtcCmposCntnt;				//상품기타구성내용 (PRD_ETC_CMPOS_CNTNT)
	
	@Column(name = "PRD_INFO_CMPOS_CNTNT", length = 500)
	private String prdInfoCmposCntnt;				//상품정보구성내용 (PRD_INFO_CMPOS_CNTNT)
	
	@Column(name = "RTP_ATTND_MATR_CNTNT", length = 500)
	private String rtpAttndMatrCntnt;				//반품주의사항내용 (RTP_ATTND_MATR_CNTNT)

	@Column(name = "DLV_ATTND_MATR_CNTNT", length = 500)
	private String dlvAttndMatrCntnt;				//배송주의사항내용 (DLV_ATTND_MATR_CNTNT)

	@Column(name = "PRD_RE_IST_CNTNT", length = 500)
	private String prdReIstCntnt;					//상품재입고내용 (PRD_RE_IST_CNTNT)

	@Column(name = "CHR_DLV_COND_CNTNT", length = 500)
	private String chrDlvCondCntnt;					//유료배송조건내용 (CHR_DLV_COND_CNTNT)

	@Column(name = "MD_DLV_MATR_CNTNT", length = 1333)
	private String mdDlvMatrCntnt;					//MD전달사항내용 (MD_DLV_MATR_CNTNT)

	@Column(name = "TM_DESC_CNTNT", length = 1333)
	private String tmDescCntnt;						//상담원기술내용 (TM_DESC_CNTNT)

	@Column(name = "ORD_ATTND_CNTNT", length = 1333)
	private String ordAttndCntnt;					//주문주의내용 (ORD_ATTND_CNTNT)

	@Column(name = "SRCH_KEYWD_NM1", length = 500)
	private String srchKeywdNm1;					//검색키워드명1 (SRCH_KEYWD_NM1)

	@Column(name = "SRCH_KEYWD_NM2", length = 500)
	private String srchKeywdNm2;					//검색키워드명2 (SRCH_KEYWD_NM2)

	@Column(name = "SRCH_KEYWD_NM3", length = 500)
	private String srchKeywdNm3;					//검색키워드명3 (SRCH_KEYWD_NM3)

	@Column(name = "CLS_CHK_CERT_DTM", length = 7)
	private Date clsChkCertDtm;						//분류검증인증일시 (CLS_CHK_CERT_DTM)

	@Column(name = "CLS_CHK_AFT_APRV_CD", length = 1)
	private String clsChkAftAprvCd;					//분류검증후결재코드 (CLS_CHK_AFT_APRV_CD)

	@Column(name = "CLS_CHK_ST_CD", length = 2)
	@NotNull
	private String clsChkStCd;						//분류검증상태코드 (CLS_CHK_ST_CD)

	@Column(name = "CLS_CHK_NOTE_CNTNT", length = 200)
	private String clsChkNoteCntnt;					//분류검증비고내용 (CLS_CHK_NOTE_CNTNT)
	
	@Column(name = "PRD_REG_FSH_YN", length = 1)
	@NotNull
	private String prdRegFshYn;						//상품등록완료여부 (PRD_REG_FSH_YN)
	
	@Column(name = "CLS_CHKR_EMPNO_ID", length = 10)
	//@NotNull
	private String clsChkrEmpnoId;					//분류검증자사번ID (CLS_CHKR_EMPNO_ID)
	
	@Column(name = "QUAL_GUARNT_DOC_EXIST_YN", length = 1)
	@NotNull
	private String qualGuarntDocExistYn;			//품질보증서존재여부 (QUAL_GUARNT_DOC_EXIST_YN)
	
	@Column(name = "QUAL_GUARNT_TERM_CNTNT", length = 100)
	//@NotNull
	private String qualGuarntTermCntnt;				//품질보증기간내용 (QUAL_GUARNT_TERM_CNTNT)
	
	
	@Column(name = "CMPOS_INFO_EXPOS_YN", length = 1)
	@NotNull
	private String cmposInfoExposYn;				//구성정보노출여부 (CMPOS_INFO_EXPOS_YN)
	
	@Column(name = "SALE_END_RSN_CNTNT", length = 200)
	//@NotNull
	private String saleEndRsnCntnt;					//판매종료사유내용 (SALE_END_RSN_CNTNT)
	
	@Column(name = "FST_PRC", length = 22)
	//@NotNull
	private BigDecimal fstPrc;						//FIRST PRICE (FST_PRC)
	
	@Column(name = "NO_INT_APPLY_GBN_CD", length = 1)
	//@NotNull
	private String noIntApplyGbnCd;					//무이자적용구분코드 (NO_INT_APPLY_GBN_CD)
	
	@Column(name = "CLS_CHK_NO_PASS_RSN_CNTNT", length = 1000)
	//@NotNull
	private String clsChkNoPassRsnCntnt;			//분류검증불합격사유내용 (CLS_CHK_NO_PASS_RSN_CNTNT)
	
	@Column(name = "STOCK_IN_SALE_YN", length = 1)
	//@NotNull
	private String stockInSaleYn;					//재고내판매여부 (STOCK_IN_SALE_YN)
	
	@Column(name = "SUP_CNF_YN", length = 1)
	//@NotNull
	private String supCnfYn;						//협력사확인여부 (SUP_CNF_YN)
	
	@Column(name = "SUP_CNF_DTM", length = 7)
	//@NotNull
	private Date supCnfDtm;							//협력사확인일시 (SUP_CNF_DTM)
	
	@Column(name = "QUICK_DLV_NOADMT_YN", length = 1)
	//@NotNull
	private String quickDlvNoadmtYn;				//빠른배송불가여부 (QUICK_DLV_NOADMT_YN)
	
	@Column(name = "ILND_DLV_PSBL_YN", length = 1)
	//@NotNull
	private String ilndDlvPsblYn;					//도서지방배송가능여부 (ILND_DLV_PSBL_YN)
	
	@Column(name = "JEJU_DLV_PSBL_YN", length = 1)
	//@NotNull
	private String jejuDlvPsblYn;					//제주도배송가능여부 (JEJU_DLV_PSBL_YN)
	
	@Column(name = "DD3_IN_DLV_NOADMT_REGON_YN", length = 1)
	//@NotNull
	private String dd3InDlvNoadmtRegonYn;			//3일내배송불가지역여부 (DD3_IN_DLV_NOADMT_REGON_YN)
	
	@Column(name = "ILND_CHR_DLV_YN", length = 1)
	//@NotNull
	private String ilndChrDlvYn;					//도서지방유료배송여부 (ILND_CHR_DLV_YN)
	
	@Column(name = "ILND_CHR_DLVC_CD", length = 22)
	//@NotNull
	private BigDecimal ilndChrDlvcCd;				//도서지방유료배송비코드 (ILND_CHR_DLVC_CD)
	
	@Column(name = "ILND_EXCH_RTP_CHR_YN", length = 1)
	//@NotNull
	private String ilndExchRtpChrYn;				//도서지방교환반품유료여부 (ILND_EXCH_RTP_CHR_YN)
	
	@Column(name = "ILND_RTP_DLVC_CD", length = 22)
	//@NotNull
	private BigDecimal ilndRtpDlvcCd;				//도서지방반품배송비코드 (ILND_RTP_DLVC_CD)
	
	@Column(name = "ILND_RTP_ONEWY_RNDTRP_CD", length = 10)
	//@NotNull
	private String ilndRtpOnewyRndtrpCd;			//도서지방반품 편도왕복코드 (ILND_RTP_ONEWY_RNDTRP_CD)
	
	@Column(name = "ILND_EXCH_ONEWY_RNDTRP_CD", length = 10)
	//@NotNull
	private String ilndExchOnewyRndtrpCd;			//도서지방교환 편도왕복코드 (ILND_EXCH_ONEWY_RNDTRP_CD)
	
	@Column(name = "JEJU_CHR_DLV_YN", length = 1)
	//@NotNull
	private String jejuChrDlvYn;					//제주도유료배송여부 (JEJU_CHR_DLV_YN)
	
	@Column(name = "JEJU_CHR_DLVC_CD", length = 22)
	//@NotNull
	private BigDecimal jejuChrDlvcCd;				//제주도유료배송비코드 (JEJU_CHR_DLVC_CD)
	
	@Column(name = "JEJU_EXCH_RTP_CHR_YN", length = 1)
	//@NotNull
	private String jejuExchRtpChrYn;				//제주도교환반품유료여부 (JEJU_EXCH_RTP_CHR_YN)
	
	@Column(name = "JEJU_RTP_DLVC_CD", length = 22)
	//@NotNull
	private BigDecimal jejuRtpDlvcCd;					//제주도반품배송비코드 (JEJU_RTP_DLVC_CD)
	
	@Column(name = "JEJU_RTP_ONEWY_RNDTRP_CD", length = 10)
	//@NotNull
	private String jejuRtpOnewyRndtrpCd;			//제주도반품편도왕복코드 (JEJU_RTP_ONEWY_RNDTRP_CD)
	
	@Column(name = "JEJU_EXCH_ONEWY_RNDTRP_CD", length = 10)
	//@NotNull
	private String jejuExchOnewyRndtrpCd;		//제주도교환편도왕복코드 (JEJU_EXCH_ONEWY_RNDTRP_CD)
	
	@Column(name = "CPN_DC_GUIDE_RT", length = 22)
	//@NotNull
	private BigDecimal cpnDcGuideRt;			//쿠폰할인가이드율 (CPN_DC_GUIDE_RT)
	
	@Column(name = "SUP_PRD_DTL_VAL", length = 100)
	//@NotNull
	private String supPrdDtlVal;				//협력사상품상세값 (SUP_PRD_DTL_VAL)
	
	@Column(name = "ADD_MODEL_NO", length = 1000)
	//@NotNull
	private String addModelNo;				//추가모델번호 (ADD_MODEL_NO)
	
	@Column(name = "APNT_DT_DLV_YN", length = 1)
	//@NotNull
	private String apntDtDlvYn;				//지정일자배송여부 (APNT_DT_DLV_YN)
	
	@Column(name = "APNT_DT_DLV_TYP", length = 1)
	//@NotNull
	private String apntDtDlvTyp;			//지정일자배송유형 (APNT_DT_DLV_TYP)
	
	@Column(name = "GSCHOICE_YN", length = 1)
	//@NotNull
	private String gschoiceYn;			//GS초이스여부 (GSCHOICE_YN)
	
	@Column(name = "DAWN_CHR_DLV_YN", length = 1)
	//@NotNull
	private String dawnChrDlvYn;			//새벽유료배송여부 (DAWN_CHR_DLV_YN)
	
	
	@Column(name = "DAWN_CHR_DLVC_CD", length = 22)
	//@NotNull
	private BigDecimal dawnChrDlvcCd;			//새벽유료배송비코드 (DAWN_CHR_DLVC_CD)
	
	@Column(name = "DAWN_EXCH_RTP_CHR_YN", length = 1)
	//@NotNull
	private String dawnExchRtpChrYn;			//새벽교환반품유료여부 (DAWN_EXCH_RTP_CHR_YN)
	
	@Column(name = "DAWN_RTP_DLVC_CD", length = 22)
	//@NotNull
	private BigDecimal dawnRtpDlvcCd;			//새벽반품배송비코드 (DAWN_RTP_DLVC_CD)
	
	
	@Column(name = "DAWN_RTP_ONEWY_RNDTRP_CD", length = 10)
	//@NotNull
	private String dawnRtpOnewyRndtrpCd;		//새벽반품편도왕복코드 (DAWN_RTP_ONEWY_RNDTRP_CD)
	
	@Column(name = "DAWN_EXCH_ONEWY_RNDTRP_CD", length = 10)
	//@NotNull
	private String dawnExchOnewyRndtrpCd;		//새벽교환편도왕복코드 (DAWN_EXCH_ONEWY_RNDTRP_CD)
	
}
