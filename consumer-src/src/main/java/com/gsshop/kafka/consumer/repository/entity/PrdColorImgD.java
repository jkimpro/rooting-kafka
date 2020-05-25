package com.gsshop.kafka.consumer.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.gsshop.kafka.consumer.repository.prkey.PrdColorImgDPK;

import lombok.Data;

@Data
@Entity
@Table(name = "PRD_COLOR_IMG_D")
@IdClass(PrdColorImgDPK.class)
public class PrdColorImgD {
	
	@Column(name = "PRD_CD")
	@NotNull
	@Id
	private BigDecimal prdCd; // 상품코드(PRD_CD)

	@Column(name = "COLOR_NM", length = 200)
	@NotNull
	@Id
	private String colorNm; // 색상명(COLOR_NM)

	@Column(name = "REG_DTM", updatable = false)
	@NotNull
	private Date regDtm; // 등록일시(REG_DTM)

	@Column(name = "REGR_ID", length = 10, updatable = false)
	@NotNull
	private String regrId; // 등록자ID(REGR_ID)

	@Column(name = "MOD_DTM")
	@NotNull
	private Date modDtm; // 수정일시(MOD_DTM)

	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId; // 수정자ID(MODR_ID)

	@Column(name = "COLOR_VAL", length = 50)
	@NotNull
	private String colorVal; // 색상값(COLOR_VAL)

	@Column(name = "IMG_FILE_NM", length = 200)
	private String imgFileNm; // 이미지파일명(IMG_FILE_NM)
}
