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

import com.gsshop.kafka.consumer.repository.prkey.PrdMontrnExcptDPK;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "PRD_MONTRN_EXCPT_D")
@IdClass(PrdMontrnExcptDPK.class)
public class PrdMontrnExcptD  implements Serializable {
	
	@Id	
	@Column(name = "CONCT_NO") //PK
	@NotNull
	private BigDecimal conctNo; // 연결번호(CONCT_NO)

	@Id	
	@Column(name = "MONTRN_EXCPT_TGT_GBN_CD") //PK
	@NotNull
	private String montrnExcptTgtGbnCd; // 모니터링예외대상구분코드(MONTRN_EXCPT_TGT_GBN_CD)

	@Id	
	@Column(name = "VALID_STR_DTM") //PK
	@NotNull
	private Date validStrDtm; // 유효시작일시(VALID_STR_DTM)
	
	@Id	
	@Column(name = "VALID_END_DTM") //PK
	@NotNull
	private Date validEndDtm; // 유효종료일시(VALID_END_DTM)
	
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
	

	@Column(name = "MONTRN_EXCPT_APRV_REQ_CNTNT", length = 1000)
//	@NotNull
	private String montrnExcptAprvReqCntnt; // 모니터링예외승인요청내용(MONTRN_EXCPT_APRV_REQ_CNTNT)
	
	@Column(name = "MONTRN_GBN_CD", length = 2)  //PK
	@NotNull
	private String montrnGbnCd; // 모니터링구분코드(MONTRN_GBN_CD)
	
	@Column(name = "END_RSN_CNTNT", length = 1000)
//	@NotNull
	private String endRsnCntnt; // 종료사유내용(END_RSN_CNTNT)
	
	@Column(name = "KEYWD_CNTNT", length = 1000)
//	@NotNull
	private String keywdCntnt; // 키워드내용(KEYWD_CNTNT)
	
	
}
