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

import com.gsshop.kafka.consumer.repository.prkey.PrdSpecDPK;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "PRD_SPEC_D")
@IdClass(PrdSpecDPK.class)
public class PrdSpecD implements Serializable{

	//****************************************************************************
	@Id	
	@Column(name = "PRD_CD", length = 22) //PK
	@NotNull
	private BigDecimal prdCd; 		// 상품코드(PRD_CD)
	
	@Id	
	@Column(name = "PRD_SPEC_CD", length = 5) //PK
	@NotNull
	private String prdSpecCd; 		// 상품사양코드(PRD_SPEC_CD)
	
	@Id	
	@Column(name = "PRD_SPEC_SEQ", length = 5) //PK
	@NotNull
	private BigDecimal prdSpecSeq; 	// 상품사양순번(PRD_SPEC_SEQ)
	
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

	@Column(name = "PRD_SPEC_ST_CD", length = 1)
	@NotNull
	private String prdSpecStCd;		//상품사양상태코드(PRD_SPEC_ST_CD)

	@Column(name = "REP_YN", length = 1)
	@NotNull
	private String repYn;		//대표여부(REP_YN)

	//****************************************************************************

}
