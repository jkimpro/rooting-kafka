package com.gsshop.kafka.consumer.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.gsshop.kafka.consumer.repository.prkey.PrdUdaDPK;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "PRD_UDA_D")
@IdClass(PrdUdaDPK.class)
public class PrdUdaD {
	
	@Id
	@Column(name = "uda_no")
	private BigDecimal udaNo;       // UDA번호(uda_no)

	@Id
	@Column(name = "prd_cd")
	private BigDecimal prdCd;       // 상품코드(prd_cd)

	@Id
	@Column(name = "valid_end_dtm")
	private Date validEndDtm; // 유효종료일시(valid_end_dtm)

	@Id
	@Column(name = "valid_str_dtm")
	private Date validStrDtm; // 유효시작일시(valid_str_dtm)
	
	@Column(name = "uda_gbn_cd")
	private String udaGbnCd;    // uda구분코드(uda_gbn_cd)

	@Column(name = "reg_dtm")
	private Date regDtm;      // 등록일시(reg_dtm)

	@Column(name = "regr_id")
	private String regrId;      // 등록자ID(regr_id)

	@Column(name = "mod_dtm")
	private Date modDtm;      // 수정일시(mod_dtm)

	@Column(name = "modr_id")
	private String modrId;      // 수정자ID(modr_id)

	@Column(name = "uda_val")
	private String udaVal;      // uda값(uda_val)

	@Column(name = "use_yn")
	private String useYn;       // 사용여부(use_yn)

	@Column(name = "uda_val_1")
	private String udaVal1;     // uda값1(uda_val_1)
	
}
