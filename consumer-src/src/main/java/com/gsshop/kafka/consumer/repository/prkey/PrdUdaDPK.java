package com.gsshop.kafka.consumer.repository.prkey;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Embeddable
public class PrdUdaDPK implements Serializable  {

	private static final long serialVersionUID = -6955667427244500058L;

	@Column(name = "uda_no")
	@NotNull
	private BigDecimal udaNo;       // UDA번호(uda_no)

	@Column(name = "prd_cd")
	@NotNull
	private BigDecimal prdCd;       // 상품코드(prd_cd)

	@Column(name = "valid_end_dtm")
	@NotNull
	private Date validEndDtm; // 유효종료일시(valid_end_dtm)

	@Column(name = "valid_str_dtm")
	@NotNull
	private Date validStrDtm; // 유효시작일시(valid_str_dtm)
}
