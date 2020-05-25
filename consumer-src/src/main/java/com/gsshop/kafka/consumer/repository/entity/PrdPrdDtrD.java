package com.gsshop.kafka.consumer.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
@Entity
@Table(name = "PRD_PRD_DTR_D")
public class PrdPrdDtrD {

	@Id
	@NotNull
	@Column(name = "PRD_CD") //PK
	private BigDecimal prdCd; // 상품코드(prd_cd)

	@Column(name = "REG_DTM")
	@NotNull
	private Date regDtm; // 등록일시(reg_dtm)

	@Column(name = "REGR_ID")
	@NotNull
	private String regrId; // 등록자ID(regr_id)

	@Column(name = "MOD_DTM")
	@NotNull
	private Date modDtm; // 수정일시(mod_dtm)

	@Column(name = "MODR_ID")
	@NotNull
	private String modrId; // 수정자ID(modr_id)

	@Column(name = "PKGMT_YN")
	@NotNull
	private String pkgmtYn; // 포장재여부(pkgmt_yn)

	@Column(name = "PKGMT_TYP_CD")
	private String pkgmtTypCd; // `(pkgmt_typ_cd)

	@Column(name = "PRD_CHR_GRP_CD")
	private String prdChrGrpCd; // 상품운임그룹코드(prd_chr_grp_cd)

	@Column(name = "OBOX_PSBL_YN")
	private String oboxPsblYn; // 합포장가능여부(obox_psbl_yn)

	@Column(name = "OBOX_PSBL_QTY")
	private BigDecimal oboxPsblQty; // 합포장가능수량(obox_psbl_qty)

	@Column(name = "GFT_OBOX_PSBL_YN")
	@NotNull
	private String gftOboxPsblYn; // 사은품합포장가능여부(gft_obox_psbl_yn)
	
	//TODO exchrgGnrlChgYn prddb에서는 삭제되었는데 어떻게 처리할지 고민
	@Column(name = "EXCHRG_GENRL_CHG_YN")
	@NotNull
	private String exchrgGnrlChgYn; //전담일반전환여부(EXCHRG_GENRL_CHG_YN)
	
	@Column(name = "WID_VAL")
	private BigDecimal widVal; // 가로값(wid_val)

	@Column(name = "VERT_VAL")
	private BigDecimal vertVal; // 세로값(vert_val)

	@Column(name = "HIGHT_VAL")
	private BigDecimal hightVal; // 높이값(hight_val)

	@Column(name = "LEN_UNIT_CD")
	private String lenUnitCd; // 길이단위코드(len_unit_cd)

	@Column(name = "WEIHT_VAL")
	private BigDecimal weihtVal; // 무게값(weiht_val)
	
	@Column(name = "WEIHT_UNIT_CD")
	private String weihtUnitCd; // 무게단위코드(weiht_unit_cd)

	@Column(name = "VOL_UNIT_CD")
	private String volUnitCd; // 부피단위코드(vol_unit_cd)

	@Column(name = "RTPC_DLVC_SAME_YN")
	private String rtpcDlvcSameYn; // 반품비배송비동일여부(rtpc_dlvc_same_yn)

	@Column(name = "PRD_VALID_TERM_CD")
	private String prdValidTermCd; // 상품유효기간코드(prd_valid_term_cd)

	
	@Column(name = "WRTDN_YN")
	@NotNull
	private String wrtdnYn; // 평가감여부(wrtdn_yn)

	@Column(name = "PKGMT_WTH_EXPOS_YN")
	private String pkgmtWthExposYn; // 포장재위드넷노출여부(pkgmt_wth_expos_yn)

	@Column(name = "PRD_CHR_GRP_CD_CNF_YN")
	@NotNull
	private String prdChrGrpCdCnfYn; // 상품운임그룹코드확정여부(prd_chr_grp_cd_cnf_yn)

	@Column(name = "VOL_VAL")
	private BigDecimal volVal; // 부피값(vol_val)

	@Column(name = "FPRD_TYP_CD")
	private String fprdTypCd; // 양품화유형코드(fprd_typ_cd)

	@Column(name = "GTP_DIRDLV_PROC_STR_DT")
	private String gtpDirdlvProcStrDt; // 집하직송처리시작일자(gtp_dirdlv_proc_str_dt)

	@Column(name = "GTP_DIRDLV_PROC_END_DT")
	private String gtpDirdlvProcEndDt; // 집하직송처리종료일자(gtp_dirdlv_proc_end_dt)
	
	////-------prddb에 없는 부분--------------------------------------------------------
	
	@Column(name = "EXPRT_PRD_YN")
	private String exprtPrdYn; // 수출상품여부(EXPRT_PRD_YN)
	
	@Column(name = "EXPRT_PRD_ONSITE_SALE_PRC")
	private BigDecimal exprtPrdOnsiteSalePrc; // 수출상품현지판매가격(EXPRT_PRD_ONSITE_SALE_PRC)
	
	@Column(name = "EXPRT_PRD_ONSITE_PRCH_PRC")
	private BigDecimal exprtPrdOnsitePrchPrc; // 수출상품현지매입가격(EXPRT_PRD_ONSITE_PRCH_PRC)
	
	@Column(name = "EXCHRT_VAL")
	private BigDecimal exchrtVal; // 환율값(EXCHRT_VAL)
	
	@Column(name = "EXPRT_CNSLT_NO")
	private String EXPRT_CNSLT_NO; // 수출품의번호(EXPRT_CNSLT_NO)
	
	///------------------------------------------------------------------------------
	@Column(name = "LOWUPRC_EXCLU_DLVS_YN")
	private String lowuprcExcluDlvsYn; // 저단가전용택배여부(lowuprc_exclu_dlvs_yn)

	@Column(name = "DLV_SCHD_DT_EXTND_YN")
	private String dlvSchdDtExtndYn; // 배송예정일자연장여부(dlv_schd_dt_extnd_yn)

	@Column(name = "DIRDLV_MNG_AGNCY_YN")
	private String dirdlvMngAgncyYn; // 직송관리대행여부(dirdlv_mng_agncy_yn)

	@Column(name = "BUNDL_DLV_PSBL_QTY")
	private BigDecimal bundlDlvPsblQty; // 묶음배송가능수량(bundl_dlv_psbl_qty)

	////-------prddb에 없는 부분--------------------------------------------------------
	
	@Column(name = "EXPRT_WON_CONT_YN")
	private String exprtWonContYn; // 수출한화계약여부(EXPRT_WON_CONT_YN)
	
	@Column(name = "EXPRT_ENG_PRD_NM")
	private String exprtEngPrdNm; // 수출영문상품명(EXPRT_ENG_PRD_NM)

	///------------------------------------------------------------------------------
	
	@Column(name = "GTP_DDHD_CHG_YN")
	private String gtpDdhdChgYn; // 집하직택배변경여부(gtp_ddhd_chg_yn)

	@Column(name = "FPRD_UPRC")
	private String fprdUprc; // 양품화단가(fprd_uprc)
	
	
	
//-----------------------------------------------------------------------------------------------	
	
	
	
//	
//	@Column(name = "BUNDL_PRD_GBN_CD")
//	private String bundlPrdGbnCd; // 묶음상품구분코드(bundl_prd_gbn_cd)
//
//	@Column(name = "INSTL_DLV_PRD_YN")
//	private String instlDlvPrdYn; // 설치배송상품여부(instl_dlv_prd_yn)
//
//	@Column(name = "SML_TYP_PRD_YN")
//	private String smlTypPrdYn; // 소형상품여부(sml_typ_prd_yn)
//
//	@Column(name = "CVS_DLVS_RTP_YN")
//	private String cvsDlvsRtpYn; // 편의점택배반품여부(cvs_dlvs_rtp_yn)
//
//	@Column(name = "OBOX_CD")
//	private String oboxCd; // 합포장코드(obox_cd)
//
//	@Column(name = "CENT_ADD_PKG_YN")
//	private String centAddPkgYn; // 센터추가포장여부(cent_add_pkg_yn)
//
//	@Column(name = "DLV_DT_GUIDE_CD")
//	private String dlvDtGuideCd; // 배송일자안내코드(dlv_dt_guide_cd)
//
//	@Column(name = "IST_TYP_CD")
//	private String istTypCd; // 입고유형코드(ist_typ_cd)
//
//	@Column(name = "DLV_CRDIT_NO")
//	private String dlvCrditNo; // 배송신용번호(dlv_crdit_no)
//
//	@Column(name = "PICK_CRDIT_NO")
//	private String pickCrditNo; // 수거신용번호(pick_crdit_no)
//
//	@Column(name = "APNT_DLVS_IMPLM_YN")
//	private String apntDlvsImplmYn; // 지정택배시행여부(apnt_dlvs_implm_yn)
//
//	@Column(name = "APNT_DLV_DLVS_CO_CD")
//	private String apntDlvDlvsCoCd; // 지정배송택배사코드(apnt_dlv_dlvs_co_cd)
//
//	@Column(name = "APNT_PICK_DLVS_CO_CD")
//	private String apntPickDlvsCoCd; // 지정수거택배사코드(apnt_pick_dlvs_co_cd)
//
//	@Column(name = "EXCH_RTP_CHR_YN")
//	private String exchRtpChrYn; // 교환반품유료여부(exch_rtp_chr_yn)
//
//	@Column(name = "RTP_DLVC_CD")
//	private String rtpDlvcCd; // 반품배송비코드(rtp_dlvc_cd)
//
//	@Column(name = "RTP_ONEWY_RNDTRP_CD")
//	private String rtpOnewyRndtrpCd; // 반품편도왕복코드(rtp_onewy_rndtrp_cd)
//
//	@Column(name = "EXCH_ONEWY_RNDTRP_CD")
//	private String exchOnewyRndtrpCd; // 교환편도왕복코드(exch_onewy_rndtrp_cd)
//
//	@Column(name = "BUNDL_DLV_CD")
//	private String bundlDlvCd; // 묶음배송코드(bundl_dlv_cd)
//
//	@Column(name = "DLV_SCHD_DT_GUIDE_LIMIT_YN")
//	private String dlvSchdDtGuideLimitYn; // 배송예정일안내제한여부(dlv_schd_dt_guide_limit_yn)
//
//	@Column(name = "ILND_DLV_PSBL_YN")
//	private String ilndDlvPsblYn; // 도서지방배송가능여부(ilnd_dlv_psbl_yn)
//
//	@Column(name = "JEJU_DLV_PSBL_YN")
//	private String jejuDlvPsblYn; // 제주도배송가능여부(jeju_dlv_psbl_yn)
//
//	@Column(name = "DD3_IN_DLV_NOADMT_REGON_YN")
//	private String dd3InDlvNoadmtRegonYn; // 3일내배송불가지역여부(dd3_in_dlv_noadmt_regon_yn)
//
//	@Column(name = "ILND_CHR_DLV_YN")
//	private String ilndChrDlvYn; // 도서지방유료배송여부(ilnd_chr_dlv_yn)
//
//	@Column(name = "ILND_CHR_DLVC_CD")
//	private String ilndChrDlvcCd; // 도서지방유료배송비코드(ilnd_chr_dlvc_cd)
//
//	@Column(name = "ILND_EXCH_RTP_CHR_YN")
//	private String ilndExchRtpChrYn; // 도서지방교환반품유료여부(ilnd_exch_rtp_chr_yn)
//
//	@Column(name = "ILND_RTP_DLVC_CD")
//	private String ilndRtpDlvcCd; // 도서지방반품배송비코드(ilnd_rtp_dlvc_cd)
//
//	@Column(name = "ILND_RTP_ONEWY_RNDTRP_CD")
//	private String ilndRtpOnewyRndtrpCd; // 도서지방반품 편도왕복코드(ilnd_rtp_onewy_rndtrp_cd)
//
//	@Column(name = "ILND_EXCH_ONEWY_RNDTRP_CD")
//	private String ilndExchOnewyRndtrpCd; // 도서지방교환 편도왕복코드(ilnd_exch_onewy_rndtrp_cd)
//
//	@Column(name = "JEJU_CHR_DLV_YN")
//	private String jejuChrDlvYn; // 제주도유료배송여부(jeju_chr_dlv_yn)
//
//	@Column(name = "JEJU_CHR_DLVC_CD")
//	private String jejuChrDlvcCd; // 제주유료배송비코드(jeju_chr_dlvc_cd)
//
//	@Column(name = "JEJU_EXCH_RTP_CHR_YN")
//	private String jejuExchRtpChrYn; // 제주교환반품유료여부(jeju_exch_rtp_chr_yn)
//
//	@Column(name = "JEJU_RTP_DLVC_CD")
//	private String jejuRtpDlvcCd; // 제주반품배송비코드(jeju_rtp_dlvc_cd)
//
//	@Column(name = "JEJU_RTP_ONEWY_RNDTRP_CD")
//	private String jejuRtpOnewyRndtrpCd; // 제주도반품편도왕복코드(jeju_rtp_onewy_rndtrp_cd)
//
//	@Column(name = "JEJU_EXCH_ONEWY_RNDTRP_CD")
//	private String jejuExchOnewyRndtrpCd; // 제주도교환편도왕복코드(jeju_exch_onewy_rndtrp_cd)
//
//	@Column(name = "APNT_DT_DLV_YN")
//	private String apntDtDlvYn; // 지정일자배송여부(apnt_dt_dlv_yn)
//
//	@Column(name = "APNT_DT_DLV_TYP")
//	private String apntDtDlvTyp; // 지정일자배송유형(apnt_dt_dlv_typ)
//
//	@Column(name = "GSCHOICE_YN")
//	private String gschoiceYn; // gs초이스여부(gschoice_yn)
//	
	
}
