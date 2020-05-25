package com.gsshop.kafka.consumer.repository.prkey;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Embeddable
public class PrdPrcHPK implements Serializable{

	@Column(name = "PRD_CD") //PK
	@NotNull
	private BigDecimal prdCd;         // (prd_cd)
	
	@Column(name = "PRD_ATTR_GBN_CD") //PK
	@NotNull
	private String prdAttrGbnCd;   // 상품속성구분코드(PRD_ATTR_GBN_CD)
	
	@Column(name = "VALID_END_DTM") //PK
	@NotNull
	private Date validEndDtm;   // 유효종료일시(valid_end_dtm)
	
	@Column(name = "VALID_STR_DTM") //PK
	@NotNull
	private Date validStrDtm;   // 유효시작일시(valid_str_dtm)
	
}
