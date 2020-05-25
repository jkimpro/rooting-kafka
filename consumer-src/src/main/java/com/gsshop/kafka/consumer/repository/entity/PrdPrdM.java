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
@Table(name = "PRD_PRD_M")
public class PrdPrdM {

	@Id	
	@Column(name = "PRD_CD")
//	@NotNull
	private BigDecimal prdCd; // 상품코드(PRD_CD)
	
	//****************************************************************************

	@Column(name = "REG_DTM")
	@NotNull
	private Date regDtm; // 등록일시(REG_DTM)
	
	@Column(name = "REGR_ID", length = 10)
	@NotNull
	private String regrId; // 등록자ID(REGR_ID)
	
	@Column(name = "MOD_DTM")
	@NotNull
	private Date modDtm; // 수정일시(MOD_DTM)
	
	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId; // 수정자ID(MODR_ID)
	
	//****************************************************************************

	@Column(name = "USE_YN", length = 1)
	@NotNull
	@ColumnDefault("Y")
	private String useYn; // 사용여부(USE_YN)
	
	@Column(name = "ITEM_CD")
	@NotNull
	@ColumnDefault("0")
	private BigDecimal itemCd; // 아이템코드(ITEM_CD)
	
	@Column(name = "BRAND_CD")
	@NotNull
	@ColumnDefault("0")
	private BigDecimal brandCd; // 브랜드코드(BRAND_CD)
	
	@Column(name = "COPY_SRC_PRD_CD")
	private BigDecimal copySrcPrdCd; // 복사소스상품코드(COPY_SRC_PRD_CD)
	
	@Column(name = "COPY_PRD_YN", length = 1)
	@NotNull
	@ColumnDefault("N")
	private String copyPrdYn; // 복사상품여부(COPY_PRD_YN)
	
	@Column(name = "REP_PRD_CD")
	private BigDecimal repPrdCd; // 대표상품코드(REP_PRD_CD)
	
	@Column(name = "PRD_NM", length = 45)
	private String prdNm; // 상품명(PRD_NM)
	
	@Column(name = "AUTO_ORD_PRD_NM", length = 53)
	private String autoOrdPrdNm; // 자동주문상품명(AUTO_ORD_PRD_NM)
	
	@Column(name = "PRD_ENG_NM", length = 200)
	private String prdEngNm; // 상품영문명(PRD_ENG_NM)
	
	@Column(name = "SALE_STR_DTM")
	@NotNull
	private Date saleStrDtm; // 판매시작일시(SALE_STR_DTM)
	
	@Column(name = "SALE_END_DTM")
	@NotNull
	private Date saleEndDtm; // 판매종료일시(SALE_END_DTM)
	
	@Column(name = "MNFC_CO_NM", length = 200)
	private String mnfcCoNm; // 제조사명(MNFC_CO_NM)
	
	@Column(name = "ORGP_NM", length = 3000)
	private String orgpNm; // 원산지명(ORGP_NM)
	
	@Column(name = "MODEL_NO", length = 60)
	private String modelNo; // 모델번호(MODEL_NO)
	
	@Column(name = "PRD_CLS_CD", length = 20)
	@NotNull
	private String prdClsCd; // 상품분류코드(PRD_CLS_CD)
	
	@Column(name = "PRD_TYP_CD", length = 1)
	@NotNull
	private String prdTypCd; // 상품유형코드(PRD_TYP_CD)
	
	@Column(name = "PRD_GBN_CD", length = 4)
	@NotNull
	@ColumnDefault("00")
	private String prdGbnCd; // 상품구분코드(PRD_GBN_CD)
	
	@Column(name = "PRCH_TYP_CD", length = 2)
	@NotNull
	private String prchTypCd; // 매입유형코드(PRCH_TYP_CD)
	
	@Column(name = "ORD_PRD_TYP_CD", length = 2)
	@NotNull
	private String ordPrdTypCd; // 주문상품유형코드(ORD_PRD_TYP_CD)
	
	@Column(name = "FRMLES_PRD_TYP_CD", length = 1)
	@NotNull
	private String frmlesPrdTypCd; // 무형상품유형코드(FRMLES_PRD_TYP_CD)
	
	@Column(name = "GFT_TYP_CD", length = 2)
	@NotNull
	private String gftTypCd; // 사은품유형코드(GFT_TYP_CD)
	
	@Column(name = "TAX_TYP_CD", length = 2)
	@NotNull
	private String taxTypCd; // 세금유형코드(TAX_TYP_CD)
	
	@Column(name = "EXPOS_ST_CD", length = 1)
	@NotNull
	private String exposStCd; // 노출상태코드(EXPOS_ST_CD)
	
	@Column(name = "REP_PRD_YN", length = 1)
	@NotNull
	@ColumnDefault("N")
	private String repPrdYn; // 대표상품여부(REP_PRD_YN)
	
	@Column(name = "BUNDL_PRD_GBN_CD", length = 2)
	private String bundlPrdGbnCd; // 묶음상품구분코드(BUNDL_PRD_GBN_CD)
	
	@Column(name = "SEPAR_ORD_NOADMT_YN", length = 1)
	@NotNull
	@ColumnDefault("N")
	private String separOrdNoadmtYn; // 단독주문불가여부(SEPAR_ORD_NOADMT_YN)
	
	@Column(name = "QA_GRD_CD", length = 2)
	@NotNull
	private String qaGrdCd; // QA등급코드(QA_GRD_CD)
	
	@Column(name = "QA_PRG_ST_CD", length = 2)
	private String qaPrgStCd; // QA진행상태코드(QA_PRG_ST_CD)
	
	@Column(name = "SALE_PSBL_APRV_YN", length = 1)
	@NotNull
	private String salePsblAprvYn; // 판매가능결재여부(SALE_PSBL_APRV_YN)
	
	@Column(name = "PRD_APRV_ST_CD", length = 2)
	@NotNull
	@ColumnDefault("00")
	private String prdAprvStCd; // 상품결재상태코드(PRD_APRV_ST_CD)
	
	@Column(name = "TEMPOUT_YN", length = 1)
	@NotNull
	@ColumnDefault("N")
	private String tempoutYn; // 일시품절여부(TEMPOUT_YN)
	
	@Column(name = "TEMPOUT_CHG_DTM")
	private Date tempoutChgDtm; // 일시품절변경일시(TEMPOUT_CHG_DTM)
	
	@Column(name = "SHTPRD_REG_DTM")
	private Date shtprdRegDtm; // 결품등록일시(SHTPRD_REG_DTM)
	
	@Column(name = "EC_APRV_ST_CD", length = 2)
	@NotNull
	private String ecAprvStCd; // EC결재상태코드(EC_APRV_ST_CD)
	
	@Column(name = "LAST_APRV_CNF_DTM")
	private Date lastAprvCnfDtm; // 최종결재확인일시(LAST_APRV_CNF_DTM)
	
	@Column(name = "PRD_CNSDR_ST_CD", length = 1)
	private String prdCnsdrStCd; // 상품심의상태코드(PRD_CNSDR_ST_CD)
	
	@Column(name = "TASK_TEAM_APRV_RSLT_CNTNT", length = 1333)
	private String taskTeamAprvRsltCntnt; // 업무팀승인결과내용(TASK_TEAM_APRV_RSLT_CNTNT)
	
	@Column(name = "PRCH_TYP_APRV_CD", length = 1)
	private String prchTypAprvCd; // 매입유형승인코드(PRCH_TYP_APRV_CD)
	
	@Column(name = "ORD_LIMIT_QTY")
	private BigDecimal ordLimitQty; // 주문제한수량(ORD_LIMIT_QTY)
	
	@Column(name = "INSTL_DLV_PRD_YN", length = 1)
	private String instlDlvPrdYn; // 설치배송상품여부(INSTL_DLV_PRD_YN)
	
	@Column(name = "GFTCERT_FACE_PRC")
	private BigDecimal gftcertFacePrc; // 상품권액면가격(GFTCERT_FACE_PRC)
	
	@Column(name = "FLGD_PRC_EXPOS_YN", length = 1)
	@NotNull
	@ColumnDefault("N")
	private String flgdPrcExposYn; // 기분좋은가격노출여부(FLGD_PRC_EXPOS_YN)
	
	@Column(name = "DC_MRK_GBN_CD", length = 2)
	private String dcMrkGbnCd; // 할인표시구분코드(DC_MRK_GBN_CD)
	
	@Column(name = "PRC_COMPR_TNS_CD", length = 2)
	private String prcComprTnsCd; // 가격비교전송코드(PRC_COMPR_TNS_CD)
	
	@Column(name = "COMPR_PRC_MRK_YN", length = 1)
//	@NotNull
	private String comprPrcMrkYn; // 비교가격표시여부(COMPR_PRC_MRK_YN)
	
	@Column(name = "ZRWON_SALE_YN", length = 1)
//	@NotNull
	private String zrwonSaleYn; // 0원판매여부(ZRWON_SALE_YN)
	
	@Column(name = "BASE_ACCM_LIMIT_YN", length = 1)
//	@NotNull
	private String baseAccmLimitYn; // 기본적립금제한여부(BASE_ACCM_LIMIT_YN)
	
	@Column(name = "SEL_ACCM_APPLY_YN", length = 1)
//	@NotNull
	private String selAccmApplyYn; // 선택적립금적용여부(SEL_ACCM_APPLY_YN)
	
	@Column(name = "SEL_ACC_RT")
	private BigDecimal selAccRt; // 선택적립율(SEL_ACC_RT)
	
	@Column(name = "IMM_ACCM_DC_LIMIT_YN", length = 1)
//	@NotNull
	private String immAccmDcLimitYn; // 즉시적립금할인제한여부(IMM_ACCM_DC_LIMIT_YN)
	
	@Column(name = "IMM_ACCM_DC_RT")
	private BigDecimal immAccmDcRt; // 즉시적립금할인율(IMM_ACCM_DC_RT)
	
	@Column(name = "CPN_MAX_DC_AMT")
	private BigDecimal cpnMaxDcAmt; // 쿠폰최대할인금액(CPN_MAX_DC_AMT)
	
	@Column(name = "CPN_APPLY_TYP_CD", length = 2)
//	@NotNull
	private String cpnApplyTypCd; // 쿠폰적용유형코드(CPN_APPLY_TYP_CD)
	
	@Column(name = "CPN_DC_AMT_EXPOS_YN", length = 1)
//	@NotNull
	private String cpnDcAmtExposYn; // 쿠폰할인액노출여부(CPN_DC_AMT_EXPOS_YN)
	
	@Column(name = "GSNPNT_NO_GIV_YN", length = 1)
//	@NotNull
	private String gsnpntNoGivYn; // GS엔포인트미부여여부(GSNPNT_NO_GIV_YN)
	
	@Column(name = "ALIA_SPCLSAL_LIMIT_YN", length = 1)
//	@NotNull
	private String aliaSpclsalLimitYn; // 제휴특판제한여부(ALIA_SPCLSAL_LIMIT_YN)
	
	@Column(name = "CARD_USE_LIMIT_YN", length = 1)
//	@NotNull
	private String cardUseLimitYn; // 카드사용제한여부(CARD_USE_LIMIT_YN)
	
	@Column(name = "ORD_MNFC_YN", length = 1)
//	@NotNull
	private String ordMnfcYn; // 주문제작여부(ORD_MNFC_YN)
	
	@Column(name = "ORD_MNFC_TERM_DDCNT")
	private BigDecimal ordMnfcTermDdcnt; // 주문제작기간일수(ORD_MNFC_TERM_DDCNT)
	
	@Column(name = "RSRV_SALE_PRD_YN", length = 1)
//	@NotNull
	private String rsrvSalePrdYn; // 예약판매상품여부(RSRV_SALE_PRD_YN)
	
	@Column(name = "RSRV_ORD_PSBL_YN", length = 1)
//	@NotNull
	private String rsrvOrdPsblYn; // 예약주문가능여부(RSRV_ORD_PSBL_YN)
	
	@Column(name = "SML_TYP_PRD_YN", length = 1)
//	@NotNull
	private String smlTypPrdYn; // 소형상품여부(SML_TYP_PRD_YN)
	
	@Column(name = "ONAIR_SALE_PSBL_YN", length = 1)
//	@NotNull
	private String onairSalePsblYn; // 방송중판매가능여부(ONAIR_SALE_PSBL_YN)
	
	@Column(name = "IMBC_ALIA_YN", length = 1)
//	@NotNull
	private String imbcAliaYn; // IMBC제휴여부(IMBC_ALIA_YN)
	
	@Column(name = "ADULT_CERT_YN", length = 1)
//	@NotNull
	private String adultCertYn; // 성인인증여부(ADULT_CERT_YN)
	
	@Column(name = "DITTO_YN", length = 1)
//	@NotNull
	private String dittoYn; // DITTO여부(DITTO_YN)
	
	@Column(name = "DITTO_BUNDL_DLV_LIMIT_YN", length = 1)
//	@NotNull
	private String dittoBundlDlvLimitYn; // DITTO일괄배송제한여부(DITTO_BUNDL_DLV_LIMIT_YN)
	
	@Column(name = "OPEN_AFT_RTP_NOADMT_YN", length = 1)
//	@NotNull
	private String openAftRtpNoadmtYn; // 개봉후반품불가여부(OPEN_AFT_RTP_NOADMT_YN)
	
	@Column(name = "SUP_MOD_NOADMT_YN", length = 1)
	private String supModNoadmtYn; // 협력사수정불가여부(SUP_MOD_NOADMT_YN)
	
	@Column(name = "BRAND_SHOP_DISP_YN", length = 1)
	private String brandShopDispYn; // 브랜드매장진열여부(BRAND_SHOP_DISP_YN)
	
	@Column(name = "TAX_INV_ISSUE_YN", length = 1)
//	@NotNull
	private String taxInvIssueYn; // 세금계산서발행여부(TAX_INV_ISSUE_YN)
	
	@Column(name = "SPCLTAX_YN", length = 1)
//	@NotNull
	private String spcltaxYn; // 특소세여부(SPCLTAX_YN)
	
	@Column(name = "ONETM_GIV_GFT_YN", length = 1)
//	@NotNull
	private String onetmGivGftYn; // 일회부여사은품여부(ONETM_GIV_GFT_YN)
	
	@Column(name = "IMG_CNF_YN", length = 1)
//	@NotNull
	private String imgCnfYn; // 이미지확인여부(IMG_CNF_YN)
	
	@Column(name = "PRE_ORD_TYP_CD", length = 1)
	private String preOrdTypCd; // 미리주문유형코드(PRE_ORD_TYP_CD)
	
	@Column(name = "PRE_ORD_BROAD_DT")
	private Date preOrdBroadDt; // 미리주문방송일자(PRE_ORD_BROAD_DT)
	
	@Column(name = "AUTO_ORD_PSBL_YN", length = 1)
//	@NotNull
	private String autoOrdPsblYn; // 자동주문가능여부(AUTO_ORD_PSBL_YN)
	
	@Column(name = "AUTO_ORD_CLS_CD", length = 2)
//	@NotNull
	private String autoOrdClsCd; // 자동주문분류코드(AUTO_ORD_CLS_CD)
	
	@Column(name = "SUP_CD")
//	@NotNull
	private BigDecimal supCd; // 협력사코드(SUP_CD)
	
	@Column(name = "SUB_SUP_CD", length = 15)
	private String subSupCd; // 하위협력사코드(SUB_SUP_CD)
	
	@Column(name = "SUP_PRD_CD", length = 30)
	private String supPrdCd; // 협력사상품코드(SUP_PRD_CD)
	
	@Column(name = "MNFC_CO_BZ_NO", length = 13)
	private String mnfcCoBzNo; // 제조사사업자번호(MNFC_CO_BZ_NO)
	
	@Column(name = "MNFC_CO_GBN_CD", length = 2)
	private String mnfcCoGbnCd; // 제조사구분코드(MNFC_CO_GBN_CD)
	
	@Column(name = "OPER_MD_ID", length = 5)
	private String operMdId; // 운영MDID(OPER_MD_ID)
	
	@Column(name = "PRD_INFO_MNGR_ID", length = 10)
	private String prdInfoMngrId; // 상품정보관리자ID(PRD_INFO_MNGR_ID)
	
	@Column(name = "DLV_PICK_MTHOD_CD", length = 4)
	private String dlvPickMthodCd; // 배송수거방법코드(DLV_PICK_MTHOD_CD)
	
	@Column(name = "PRD_RETP_ADDR_CD", length = 4)
	private String prdRetpAddrCd; // 상품반송지주소코드(PRD_RETP_ADDR_CD)
	
	@Column(name = "PRD_RELSP_ADDR_CD", length = 4)
	private String prdRelspAddrCd; // 상품출고지주소코드(PRD_RELSP_ADDR_CD)
	
	@Column(name = "CVS_DLVS_RTP_YN", length = 1)
//	@NotNull
	private String cvsDlvsRtpYn; // 편의점택배반품여부(CVS_DLVS_RTP_YN)
	
	@Column(name = "DLVS_CO_CD", length = 2)
//	@NotNull
	private String dlvsCoCd; // 택배사코드(DLVS_CO_CD)
	
	@Column(name = "OBOX_CD", length = 1)
	private String oboxCd; // 합포장코드(OBOX_CD)
	
	@Column(name = "CENT_ADD_PKG_YN", length = 1)
//	@NotNull
	private String centAddPkgYn; // 센터추가포장여부(CENT_ADD_PKG_YN)
	
	@Column(name = "DLV_DT_GUIDE_CD", length = 1)
	private String dlvDtGuideCd; // 배송일자안내코드(DLV_DT_GUIDE_CD)
	
	@Column(name = "CHR_DLV_YN", length = 1)
//	@NotNull
	private String chrDlvYn; // 유료배송여부(CHR_DLV_YN)
	
	@Column(name = "CHR_DLVC_CD")
	private BigDecimal chrDlvcCd; // 유료배송비코드(CHR_DLVC_CD)
	
	@Column(name = "IST_TYP_CD", length = 2)
	private String istTypCd; // 입고유형코드(IST_TYP_CD)
	
	@Column(name = "CHR_DLV_ADD_YN", length = 1)
//	@NotNull
	private String chrDlvAddYn; // 유료배송추가여부(CHR_DLV_ADD_YN)
	
	@Column(name = "DLV_CRDIT_NO", length = 20)
	private String dlvCrditNo; // 배송신용번호(DLV_CRDIT_NO)
	
	@Column(name = "PICK_CRDIT_NO", length = 20)
	private String pickCrditNo; // 수거신용번호(PICK_CRDIT_NO)
	
	@Column(name = "APNT_DLVS_IMPLM_YN", length = 1)
//	@NotNull
	private String apntDlvsImplmYn; // 지정택배시행여부(APNT_DLVS_IMPLM_YN)
	
	@Column(name = "APNT_DLV_DLVS_CO_CD", length = 2)
	private String apntDlvDlvsCoCd; // 지정배송택배사코드(APNT_DLV_DLVS_CO_CD)
	
	@Column(name = "APNT_PICK_DLVS_CO_CD", length = 2)
	private String apntPickDlvsCoCd; // 지정수거택배사코드(APNT_PICK_DLVS_CO_CD)
	
	@Column(name = "RFN_TYP_CD", length = 2)
	private String rfnTypCd; // 환불유형코드(RFN_TYP_CD)
	
	@Column(name = "ARFN_TIME_CD", length = 2)
	private String arfnTimeCd; // 후환불시점코드(ARFN_TIME_CD)
	
	@Column(name = "EXCH_RTP_CHR_YN", length = 1)
//	@NotNull
	private String exchRtpChrYn; // 교환반품유료여부(EXCH_RTP_CHR_YN)
	
	@Column(name = "RTP_DLVC_CD")
	private BigDecimal rtpDlvcCd; // 반품배송비코드(RTP_DLVC_CD)
	
	@Column(name = "RTP_ONEWY_RNDTRP_CD", length = 10)
	private String rtpOnewyRndtrpCd; // 반품편도왕복코드(RTP_ONEWY_RNDTRP_CD)
	
	@Column(name = "EXCH_ONEWY_RNDTRP_CD", length = 10)
	private String exchOnewyRndtrpCd; // 교환편도왕복코드(EXCH_ONEWY_RNDTRP_CD)
	
	@Column(name = "ATTR_TYP_NM1", length = 50)
	private String attrTypNm1; // 속성유형명1(ATTR_TYP_NM1)
	
	@Column(name = "ATTR_TYP_NM2", length = 50)
	private String attrTypNm2; // 속성유형명2(ATTR_TYP_NM2)
	
	@Column(name = "ATTR_TYP_NM3", length = 50)
	private String attrTypNm3; // 속성유형명3(ATTR_TYP_NM3)
	
	@Column(name = "ATTR_TYP_NM4", length = 50)
	private String attrTypNm4; // 속성유형명4(ATTR_TYP_NM4)
	
	@Column(name = "ATTR_TYP_SEQ_1")
	private BigDecimal attrTypSeq1; // 속성유형순서1(ATTR_TYP_SEQ_1)
	
	@Column(name = "ATTR_TYP_SEQ_2")
	private BigDecimal attrTypSeq2; // 속성유형순서2(ATTR_TYP_SEQ_2)
	
	@Column(name = "ATTR_TYP_SEQ_3")
	private BigDecimal attrTypSeq3; // 속성유형순서3(ATTR_TYP_SEQ_3)
	
	@Column(name = "ATTR_TYP_SEQ_4")
	private BigDecimal attrTypSeq4; // 속성유형순서4(ATTR_TYP_SEQ_4)
	
	@Column(name = "ATTR_TYP_EXPOS_CD", length = 1)
//	@NotNull
	private String attrTypExposCd; // 속성유형노출코드(ATTR_TYP_EXPOS_CD)
	
	@Column(name = "ATTR_PRD_PRC_YN", length = 1)
	private String attrPrdPrcYn; // 속성상품가격여부(ATTR_PRD_PRC_YN)
	
	@Column(name = "SALE_END_YN", length = 1)
//	@NotNull
	private String saleEndYn; // 판매종료여부(SALE_END_YN)
	
	@Column(name = "SALE_END_PRSN_ID", length = 10)
	private String saleEndPrsnId; // 판매종료자ID(SALE_END_PRSN_ID)
	
	@Column(name = "SALE_END_RSN_CD", length = 4)
	private String saleEndRsnCd; // 판매종료사유코드(SALE_END_RSN_CD)
	
	@Column(name = "FST_EXPOS_DT")
	private Date fstExposDt; // 최초노출일자(FST_EXPOS_DT)
	
	@Column(name = "EXPOS_SCHD_DT")
	private Date exposSchdDt; // 노출예정일자(EXPOS_SCHD_DT)
	
	@Column(name = "SAP_TNS_CD", length = 1)
	private String sapTnsCd; // SAP전송코드(SAP_TNS_CD)
	
	@Column(name = "PRD_REG_GBN_CD", length = 1)
	private String prdRegGbnCd; // 상품등록구분코드(PRD_REG_GBN_CD)
	
	@Column(name = "BARCD_NO", length = 30)
	private String barcdNo; // 바코드번호(BARCD_NO)
	
	@Column(name = "INSU_CO_CD", length = 2)
	private String insuCoCd; // 보험사코드(INSU_CO_CD)
	
	@Column(name = "PRD_BIT_ATTR_CD", length = 20)
	private String prdBitAttrCd; // 상품비트속성코드(PRD_BIT_ATTR_CD)
	
	@Column(name = "GNUIN_YN", length = 1)
//	@NotNull
	private String gnuinYn; // 정품여부(GNUIN_YN)
	
	@Column(name = "FLATPRC_PRD_YN", length = 1)
//	@NotNull
	private String flatprcPrdYn; // 균일가상품여부(FLATPRC_PRD_YN)
	
	@Column(name = "DM_SHTPRD_ALAM_YN", length = 1)
//	@NotNull
	private String dmShtprdAlamYn; // DM결품알람여부(DM_SHTPRD_ALAM_YN)
	
	@Column(name = "PRD_RESPNS_TGT_YN", length = 1)
//	@NotNull
	private String prdRespnsTgtYn; // 상품응대대상여부(PRD_RESPNS_TGT_YN)
	
	@Column(name = "GSHS_GFTCERT_YN", length = 1)
//	@NotNull
	private String gshsGftcertYn; // 당사상품권여부(GSHS_GFTCERT_YN)
	
	@Column(name = "ARS_MAX_QTY")
	private BigDecimal arsMaxQty; // 자동주문최대수량(ARS_MAX_QTY)
	
	@Column(name = "IF_YN", length = 1)
	private String ifYn; // 인터페이스여부(IF_YN)
	
	@Column(name = "BROAD_PRD_YN", length = 1)
//	@NotNull
	private String broadPrdYn; // 방송상품여부(BROAD_PRD_YN)
	
	@Column(name = "BUNDL_DLV_CD", length = 3)
	private String bundlDlvCd; // 묶음배송코드(BUNDL_DLV_CD)
	
	@Column(name = "REG_CHANL_GRP_CD", length = 2)
//	@NotNull
	private String regChanlGrpCd; // 등록채널그룹코드(REG_CHANL_GRP_CD)
	
	@Column(name = "STYLE_DIR_ENT_YN", length = 1)
//	@NotNull
	private String styleDirEntYn; // 스타일직접입력여부(STYLE_DIR_ENT_YN)
	
	@Column(name = "FORGN_PRD_NORM_PRC")
	private BigDecimal forgnPrdNormPrc; // 해외상품정상가격(FORGN_PRD_NORM_PRC)
	
	@Column(name = "FST_BROAD_DTM")
	private Date fstBroadDtm; // 최초방송일시(FST_BROAD_DTM)
	
	@Column(name = "ITEM_MAPPN_DTM")
	private Date itemMappnDtm; // 아이템매핑일시(ITEM_MAPPN_DTM)
	
	@Column(name = "ORD_MNFC_TYP_CD", length = 6)
	private String ordMnfcTypCd; // 주문제작유형코드(ORD_MNFC_TYP_CD)
	
	@Column(name = "ORD_MNFC_CNTNT", length = 500)
	private String ordMnfcCntnt; // 주문제작내용(ORD_MNFC_CNTNT)
	
	@Column(name = "DLV_SCHD_DT_GUIDE_LIMIT_YN", length = 1)
//	@NotNull
	private String dlvSchdDtGuideLimitYn; // 배송예정일안내제한여부(DLV_SCHD_DT_GUIDE_LIMIT_YN)
	
	@Column(name = "DTCT_CD", length = 4)
	private String dtctCd; // 물류센터코드(DTCT_CD)
	
	@Column(name = "ORGP_CD", length = 10)
	private String orgpCd; // 원산지코드(ORGP_CD)
	
	@Column(name = "FORGN_DLV_PSBL_YN", length = 1)
	private String forgnDlvPsblYn; // 해외배송가능여부(FORGN_DLV_PSBL_YN)
	
	@Column(name = "FORGN_DLV_WEIHT_VAL")
	private BigDecimal forgnDlvWeihtVal; // 해외배송무게값(FORGN_DLV_WEIHT_VAL)
	
	@Column(name = "PRC_MRK_TYP_VAL", length = 1)
	private String prcMrkTypVal; // 가격표시유형값(PRC_MRK_TYP_VAL)
	
}
