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
public class PrdPreOrdngLPK implements Serializable{
	@Column(name = "ATTR_PRD_CD", length = 22) //PK
	@NotNull
	private BigDecimal attrPrdCd; 		// 속성상품코드(ATTR_PRD_CD)
	
	@Column(name = "ENT_DTM", length = 7)		//PK
	@NotNull
	private Date entDtm;		//입력일(ENT_DTM)
	
}
