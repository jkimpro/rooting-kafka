package com.gsshop.kafka.producer.repository.jpa;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MP_PRD_M")
public class MpPrdM {
    
    @Id
    @Column(name = "prd_cd")
    @NotNull
    private BigDecimal prdCd;            // 상품코드(prd_cd)
    
    @Column(name = "reg_dtm", updatable = false)
    @NotNull
    private Date       regDtm;           // 등록일시(reg_dtm)
    
    @Column(name = "regr_id", length = 10, updatable = false)
    @NotNull
    private String     regrId;           // 등록자ID(regr_id)
    
    @Column(name = "mod_dtm")
    @NotNull
    private Date       modDtm;           // 수정일시(mod_dtm)
    
    @Column(name = "modr_id", length = 10)
    @NotNull
    private String     modrId;           // 수정자ID(modr_id)
    
    @Column(name = "use_yn", length = 1)
    @NotNull
    private String     useYn;            // 사용여부(use_yn)
    
    @Column(name = "item_cd")
    private BigDecimal itemCd;           // 아이템코드(item_cd)
    
    @Column(name = "brand_cd")
    private BigDecimal brandCd;          // 브랜드코드(brand_cd)
    
    @Column(name = "copy_src_prd_cd")
    private BigDecimal copySrcPrdCd;     // 복사소스상품코드(copy_src_prd_cd)
    
    @Column(name = "copy_prd_yn", length = 1)
    @NotNull
    private String     copyPrdYn;        // 복사상품여부(copy_prd_yn)
    
    @Column(name = "prd_nm", length = 45)
    @NotNull
    private String     prdNm;            // 상품명(prd_nm)
    
    @Column(name = "auto_ord_prd_nm", length = 53)
    private String     autoOrdPrdNm;     // 자동주문상품명(auto_ord_prd_nm)
    
    @Column(name = "sale_str_dtm")
    @NotNull
    private Date       saleStrDtm;       // 판매시작일시(sale_str_dtm)
    
    @Column(name = "sale_end_dtm")
    @NotNull
    private Date       saleEndDtm;       // 판매종료일시(sale_end_dtm)
    
    @Column(name = "mnfc_co_nm", length = 200)
    private String     mnfcCoNm;         // 제조사명(mnfc_co_nm)
    
    @Column(name = "orgp_nm", length = 3000)
    private String     orgpNm;           // 원산지명(orgp_nm)
    
    @Column(name = "model_no", length = 60)
    private String     modelNo;          // 모델번호(model_no)
    
    @Column(name = "oper_md_id", length = 5)
    private String     operMdId;         // 운영mdID(oper_md_id)
    
    @Column(name = "prd_cls_cd", length = 20)
    @NotNull
    private String     prdClsCd;         // 상품분류코드(prd_cls_cd)
    
    @Column(name = "prd_typ_cd", length = 1)
    @NotNull
    private String     prdTypCd;         // 상품유형코드(prd_typ_cd)
    
    @Column(name = "prd_gbn_cd", length = 4)
    @NotNull
    private String     prdGbnCd;         // 상품구분코드(prd_gbn_cd)
    
    @Column(name = "prch_typ_cd", length = 2)
    @NotNull
    private String     prchTypCd;        // 매입유형코드(prch_typ_cd)
    
    @Column(name = "ord_prd_typ_cd", length = 2)
    @NotNull
    private String     ordPrdTypCd;      // 주문상품유형코드(ord_prd_typ_cd)
    
    @Column(name = "frmles_prd_typ_cd", length = 1)
    @NotNull
    private String     frmlesPrdTypCd;   // 무형상품유형코드(frmles_prd_typ_cd)
    
    @Column(name = "gft_typ_cd", length = 2)
    @NotNull
    private String     gftTypCd;         // 사은품유형코드(gft_typ_cd)
    
    @Column(name = "tax_typ_cd", length = 2)
    @NotNull
    private String     taxTypCd;         // 세금유형코드(tax_typ_cd)
    
    @Column(name = "expos_st_cd", length = 1)
    @NotNull
    private String     exposStCd;        // 노출상태코드(expos_st_cd)
    
    @Column(name = "prd_aprv_st_cd", length = 2)
    @NotNull
    private String     prdAprvStCd;      // 상품결재상태코드(prd_aprv_st_cd)
    
    @Column(name = "tempout_yn", length = 1)
    @NotNull
    private String     tempoutYn;        // 일시품절여부(tempout_yn)
    
    @Column(name = "rfn_typ_cd", length = 2)
    private String     rfnTypCd;         // 환불유형코드(rfn_typ_cd)
    
    @Column(name = "ord_limit_qty")
    private BigDecimal ordLimitQty;      // 주문제한수량(ord_limit_qty)
    
    @Column(name = "adult_cert_yn", length = 1)
    @NotNull
    private String     adultCertYn;      // 성인인증여부(adult_cert_yn)
    
    @Column(name = "sup_mod_noadmt_yn", length = 1)
    private String     supModNoadmtYn;   // 협력사수정불가여부(sup_mod_noadmt_yn)
    
    @Column(name = "img_cnf_yn", length = 1)
    @NotNull
    private String     imgCnfYn;         // 이미지확인여부(img_cnf_yn)
    
    @Column(name = "pre_ord_typ_cd", length = 1)
    private String     preOrdTypCd;      // 미리주문유형코드(pre_ord_typ_cd)
    
    @Column(name = "auto_ord_psbl_yn", length = 1)
    @NotNull
    private String     autoOrdPsblYn;    // 자동주문가능여부(auto_ord_psbl_yn)
    
    @Column(name = "auto_ord_cls_cd", length = 2)
    @NotNull
    private String     autoOrdClsCd;     // 자동주문분류코드(auto_ord_cls_cd)
    
    @Column(name = "sup_cd")
    private BigDecimal supCd;            // (sup_cd)
    
    @Column(name = "sub_sup_cd", length = 15)
    private String     subSupCd;         // 하위협력사코드(sub_sup_cd)
    
    @Column(name = "sup_prd_cd", length = 30)
    private String     supPrdCd;         // 협력사상품코드(sup_prd_cd)
    
    @Column(name = "mnfc_co_bz_no", length = 13)
    private String     mnfcCoBzNo;       // 제조사사업자번호(mnfc_co_bz_no)
    
    @Column(name = "mnfc_co_gbn_cd", length = 2)
    private String     mnfcCoGbnCd;      // 제조사구분코드(mnfc_co_gbn_cd)
    
    @Column(name = "prd_info_mngr_id", length = 10)
    private String     prdInfoMngrId;    // 상품정보관리자ID(prd_info_mngr_id)
    
    @Column(name = "dlv_pick_mthod_cd", length = 4)
    private String     dlvPickMthodCd;   // 배송수거방법코드(dlv_pick_mthod_cd)
    
    @Column(name = "prd_retp_addr_cd", length = 4)
    private String     prdRetpAddrCd;    // 상품반송지주소코드(prd_retp_addr_cd)
    
    @Column(name = "prd_relsp_addr_cd", length = 4)
    private String     prdRelspAddrCd;   // 상품출고지주소코드(prd_relsp_addr_cd)
    
    @Column(name = "dlvs_co_cd", length = 2)
    private String     dlvsCoCd;         // 택배사코드(dlvs_co_cd)
    
    @Column(name = "chr_dlv_yn", length = 1)
    @NotNull
    private String     chrDlvYn;         // 유료배송여부(chr_dlv_yn)
    
    @Column(name = "chr_dlvc_cd")
    private BigDecimal chrDlvcCd;        // 유료배송비코드(chr_dlvc_cd)
    
    @Column(name = "chr_dlv_add_yn", length = 1)
    @NotNull
    private String     chrDlvAddYn;      // 유료배송추가여부(chr_dlv_add_yn)
    
    @Column(name = "sale_end_yn", length = 1)
    private String     saleEndYn;        // 판매종료여부(sale_end_yn)
    
    @Column(name = "sale_end_prsn_id", length = 10)
    private String     saleEndPrsnId;    // 판매종료자ID(sale_end_prsn_id)
    
    @Column(name = "sale_end_rsn_cd", length = 4)
    private String     saleEndRsnCd;     // 판매종료사유코드(sale_end_rsn_cd)
    
    @Column(name = "expos_schd_dt")
    private Date       exposSchdDt;      // 노출예정일자(expos_schd_dt)
    
    @Column(name = "onair_sale_psbl_yn", length = 1)
    @NotNull
    private String     onairSalePsblYn;  // 방송중판매가능여부(onair_sale_psbl_yn)
    
    @Column(name = "broad_prd_yn", length = 1)
    private String     broadPrdYn;       // 방송상품여부(broad_prd_yn)
    
    @Column(name = "fst_broad_dtm")
    private Date       fstBroadDtm;      // 최초방송일시(fst_broad_dtm)
    
    @Column(name = "prd_reg_gbn_cd", length = 1)
    private String     prdRegGbnCd;      // 상품등록구분코드(prd_reg_gbn_cd)
    
    @Column(name = "ars_max_qty")
    private BigDecimal arsMaxQty;        // 자동주문최대수량(ars_max_qty)
    
    @Column(name = "if_yn", length = 1)
    private String     ifYn;             // 인터페이스여부(if_yn)
    
    @Column(name = "reg_chanl_grp_cd", length = 2)
    private String     regChanlGrpCd;    // 등록채널그룹코드(reg_chanl_grp_cd)
    
    @Column(name = "style_dir_ent_yn", length = 1)
    private String     styleDirEntYn;    // 스타일직접입력여부(style_dir_ent_yn)
    
    @Column(name = "item_mappn_dtm")
    private Date       itemMappnDtm;     // 아이템매핑일시(item_mappn_dtm)
    
    @Column(name = "orgp_cd", length = 10)
    private String     orgpCd;           // 원산지코드(orgp_cd)
    
    @Column(name = "attr_typ_nm1", length = 50)
    private String     attrTypNm1;       // 속성유형명1(attr_typ_nm1)
    
    @Column(name = "attr_typ_nm2", length = 50)
    private String     attrTypNm2;       // 속성유형명2(attr_typ_nm2)
    
    @Column(name = "attr_typ_nm3", length = 50)
    private String     attrTypNm3;       // 속성유형명3(attr_typ_nm3)
    
    @Column(name = "attr_typ_nm4", length = 50)
    private String     attrTypNm4;       // 속성유형명4(attr_typ_nm4)
    
    @Column(name = "attr_typ_seq_1")
    private BigDecimal attrTypSeq1;      // 속성유형순서1(attr_typ_seq_1)
    
    @Column(name = "attr_typ_seq_2")
    private BigDecimal attrTypSeq2;      // 속성유형순서2(attr_typ_seq_2)
    
    @Column(name = "attr_typ_seq_3")
    private BigDecimal attrTypSeq3;      // 속성유형순서3(attr_typ_seq_3)
    
    @Column(name = "attr_typ_seq_4")
    private BigDecimal attrTypSeq4;      // 속성유형순서4(attr_typ_seq_4)
    
//    @Column(name = "ist_typ_cd")
//    private String     istTypCd;         // (ist_typ_cd)
    
//    @Column(name = "rep_prd_cd")
//    private String     repPrdCd;         // (rep_prd_cd)
//    
//    @Column(name = "prd_eng_nm")
//    private String     prdEngNm;         // (prd_eng_nm)
//    
//    @Column(name = "rep_prd_yn")
//    @NotNull
//    private String     repPrdYn;         // (rep_prd_yn)
//    
//    @Column(name = "bundl_prd_gbn_cd")
//    private String     bundlPrdGbnCd;    // (bundl_prd_gbn_cd)
    
//    @Column(name = "separ_ord_noadmt_yn")
//    @NotNull
//    private String     separOrdNoadmtYn; // (separ_ord_noadmt_yn)
//    
//    @Column(name = "qa_grd_cd")
//    @NotNull
//    private String     qaGrdCd;          // (qa_grd_cd)
//    
//    @Column(name = "qa_prg_st_cd")
//    private String     qaPrgStCd;        // (qa_prg_st_cd)
    
//    @Column(name = "sale_psbl_aprv_yn")
//    @NotNull
//    private String     salePsblAprvYn;   // (sale_psbl_aprv_yn)
    
//    @Column(name = "tempout_chg_dtm")
//    private Date       tempoutChgDtm;    // (tempout_chg_dtm)
    
//    @Column(name = "shtprd_reg_dtm")
//    private String     shtprdRegDtm;     // (shtprd_reg_dtm)
    
//    @Column(name = "ec_aprv_st_cd")
//    @NotNull
//    private String     ecAprvStCd;       // (ec_aprv_st_cd)
    
//    @Column(name = "last_aprv_cnf_dtm")
//    private String     lastAprvCnfDtm;   // (last_aprv_cnf_dtm)
    
//    @Column(name = "prd_cnsdr_st_cd")
//    private String     prdCnsdrStCd;     // (prd_cnsdr_st_cd)

    public MpPrdM() {
        super();
        this.prdCd = new BigDecimal(1);
        this.regDtm = new Date();
        this.regrId = "regid_temp";
        this.useYn = "Y";
        this.itemCd = new BigDecimal(2);
        this.brandCd = new BigDecimal(3);
        this.copySrcPrdCd = new BigDecimal(4);
        this.copyPrdYn = "N";
        this.prdNm = "prdNm";
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
