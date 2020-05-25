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

import com.gsshop.kafka.consumer.repository.prkey.PrdPreOrdngLPK;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "PRD_PRE_ORDNG_L")
@IdClass(PrdPreOrdngLPK.class)
public class PrdPreOrdngL implements Serializable{

	@Id	
	@Column(name = "ATTR_PRD_CD", length = 22) //PK
	@NotNull
	private BigDecimal attrPrdCd; 		// 속성상품코드(ATTR_PRD_CD)
	
	@Id	
	@Column(name = "ENT_DTM", length = 7)		//PK
	@NotNull
	private Date entDtm;		//입력일(ENT_DTM)
	
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


	@Column(name = "ATTR_PRD_REP_CD", length = 50)
	@NotNull
	private String attrPrdRepCd; 		// 속성상품대표코드(ATTR_PRD_REP_CD)
	
	@Column(name = "PRD_CD", length = 22)
	@NotNull
	private BigDecimal prdCd; 		// 상품코드(PRD_CD)
	
	@Column(name = "PRD_TYP_CD", length = 1)
	@NotNull
	private String prdTypCd; 		// 상품유형코드(PRD_TYP_CD)
	
	@Column(name = "ORD_PSBL_QTY", length = 22)
	@NotNull
	private BigDecimal ordPsblQty; 		// 주문가능수량(ORD_PSBL_QTY)
	
	@Column(name = "PROC_YN", length = 1)
	@NotNull
	private String procYn; 		// 처리여부(PROC_YN)
	
	@Column(name = "PROC_MSG_CNTNT", length = 100)
	@NotNull
	private String procMsgCntnt; 		// 처리메세지내용(PROC_MSG_CNTNT)
	
	
}
