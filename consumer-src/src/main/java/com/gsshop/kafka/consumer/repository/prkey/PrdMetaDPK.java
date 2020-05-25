package com.gsshop.kafka.consumer.repository.prkey;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Embeddable
public class PrdMetaDPK implements Serializable {
	
	@Column(name = "PRD_CD") //PK
	@NotNull
	private BigDecimal prdCd; // 상품코드(PRD_CD)

	@Column(name = "PRD_META_TYP_CD", length=2) //PK
	@NotNull
	private String prdMetaTypCd; // 상품메타유형코드(PRD_META_TYP_CD)
	
}
