package com.gsshop.kafka.consumer.repository.prkey;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
@Embeddable
public class PrdNmChgHPK implements Serializable{
	@Column(name = "PRD_CD") //PK
	@NotNull
	private BigDecimal prdCd; // (prd_cd)

	@Column(name = "CHANL_CD", length = 2) //PK
	@NotNull
	private String chanlCd; // 채널코드(chanl_cd)

	@Column(name = "VALID_END_DTM") //PK
	@NotNull
	private Date validEndDtm; // 유효종료일시(valid_end_dtm)

	@Column(name = "VALID_STR_DTM") //PK
	@NotNull
	private Date validStrDtm; // 유효시작일시(valid_str_dtm)

}
