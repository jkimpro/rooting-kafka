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
@Table(name = "PRD_SAFE_CERT_D")
public class PrdSafeCertD {

	@Id	
	@Column(name = "PRD_CD", length = 22) //PK
	@NotNull
	private BigDecimal prdCd; // 상품코드(PRD_CD)
	
	@Column(name = "REG_DTM", length = 7)
	//@NotNull
	private Date regDtm;		//등록일(REG_DTM)
	
	@Column(name = "REGR_ID", length = 10)
	//@NotNull
	private String regId;		//등록자ID(REGR_ID)
	
	@Column(name = "MOD_DTM", length = 7)
	//@NotNull
	private Date modDtm;		//수정일시(MOD_DTM)
	
	@Column(name = "MODR_ID", length = 10)
	//@NotNull
	private String modrId;		//수정자ID(MODR_ID)
	
	@Column(name = "SAFE_CERT_NO", length = 30)
	//@NotNull
	private String safeCertNo;           //안전인증번호
	
	@Column(name = "SAFE_CERT_GBN_CD", length = 1)
	@NotNull
	private String safeCertGbnCd;        //안전인증구분코드
	
	@Column(name = "SAFE_CERT_ORG_CD", length = 30)
	//@NotNull
	private String safeCertOrgCd;     	//안전인증기관코드
	
	@Column(name = "SAFE_CERT_DT", length = 30)
	//@NotNull
	private Date safeCertDt;     		//안전인증날짜
	
	@Column(name = "SAFE_CERT_MODEL_NM", length = 100)
	private String safeCertModelNm;     //안전인증모델명

	@Column(name = "SAFE_CERT_FILE_NM", length = 200)
	private String safeCertFileNm;     //안전인증 이미지파일명
	
	@Column(name="CERT_EXPIR_DT")
	private Date certExpirDt;			//안전인증 만료 날짜
	
	@Column(name = "CERT_LAST_CHK_DT")
	private Date certLastChkDt;			//안전인증 마지막 확인날짜
	
	@Column(name="CERT_INSP_NTC_DT")
	private Date certInspNtcDt;			
	
	@Column(name="CERT_UPD_REQ_DT")
	private Date certUpdReqDt;
	
	@Column(name="CERT_LAST_CNF_DT")
	private Date certLastCnfDt;
	
}
