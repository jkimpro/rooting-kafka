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

import com.gsshop.kafka.consumer.repository.prkey.PrdPrcHPK;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "PRD_PRC_H")
@IdClass(PrdPrcHPK.class)
public class PrdPrcH implements Serializable {

	@Id
	@Column(name = "PRD_CD") //PK
	@NotNull
	private BigDecimal prdCd;         // (prd_cd)
	
	@Id
	@Column(name = "PRD_ATTR_GBN_CD") //PK
	@NotNull
	private String prdAttrGbnCd;   // 상품속성구분코드(PRD_ATTR_GBN_CD)
	
	@Id
	@Column(name = "VALID_END_DTM") //PK
	@NotNull
	private Date validEndDtm;   // 유효종료일시(valid_end_dtm)
	
	@Id
	@Column(name = "VALID_STR_DTM") //PK
	@NotNull
	private Date validStrDtm;   // 유효시작일시(valid_str_dtm)
	
	@Column(name = "REG_DTM")
	@NotNull
	private Date regDtm; 		//등록일시(REG_DTM)

	@Column(name = "REGR_ID", length = 10)
	@NotNull
	private String regrId; 		//등록자ID(REGR_ID)

	@Column(name = "MOD_DTM")
	@NotNull
	private Date modDtm; 		//수정일시(MOD_DTM)

	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId;		 // 수정자ID(MODR_ID)

	@Column(name = "SALE_PRC", length = 22)
	@NotNull
	private BigDecimal salePrc;       //판매가격 (SALE_PRC)
	
	@Column(name = "PRCH_PRC", length = 22)
	private BigDecimal prchPrc;       //매입가격 (PRCH_PRC)
	
	@Column(name = "SUP_GIV_RTAMT_CD", length=2)
	private String supGivRtamtCd; 		//협력사지급율/액 코드(SUP_GIV_RTAMT_CD)
	
	@Column(name = "SUP_GIV_RTAMT", length=22)
	private BigDecimal supGivRtamt;   		//협력사지급율/액(SUP_GIV_RTAMT)
	
	@Column(name = "SUP_PROPRD_UPRC", length=22)
	private BigDecimal supProprdUprc;   		//협력사경품단가(SUP_PROPRD_UPRC)
	
	@Column(name = "INSTL_COST", length=22)
	private BigDecimal instlCost;     // 설치비용(INSTL_COST)

	@Column(name = "PROPRD_WTHTAX", length=22)
	private BigDecimal proprdWthtax;  //경품원천세 (PROPRD_WTHTAX)
	
	@Column(name = "VIP_DLV_YN", length=1)
	private String vipDlvYn;      	// vip배송여부(VIP_DLV_YN)

	@Column(name = "VIP_DLV_STD_PRC", length=22)
	private BigDecimal vipDlvStdPrc;  //vip배송기준가격(VIP_DLV_STD_PRC)

	@Column(name = "ONSITE_PRD_PRC", length=22)
	private BigDecimal onsitePrdPrc;  // 현지상품가격(ONSITE_PRD_PRC)
	
	@Column(name = "ONSITE_DC_PRC", length=22)
	private BigDecimal onsiteDcPrc;  // 현지할인가격(ONSITE_DC_PRC)
	
	@Column(name = "DETRM_WEIHT_VAL", length=22)
	private BigDecimal detrmWeihtVal; 	// 결정무게값(DETRM_WEIHT_VAL)
	
	@Column(name = "ONSITE_CHR_COST", length=22)
	private BigDecimal onsiteChrCost; 	// 현지운임비용(ONSITE_CHR_COST)
	
	@Column(name = "WHS_CD", length=2)
	private String whsCd;         // 창고코드(WHS_CD)
	
	@Column(name = "OTHER_SYS_TNS_YN", length=1)
	private String otherSysTnsYn; // 타시스템전송여부(OTHER_SYS_TNS_YN)
	
	@Column(name = "NOTE_CNTNT", length=500)
	private String noteCntnt;     // 비고내용(NOTE_CNTNT)
	
}
