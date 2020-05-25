package com.gsshop.kafka.consumer.repository.prkey;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PrdChanlChgLPK  implements Serializable {

	@Column(name = "PRD_CD")
	@NotNull	
	private BigDecimal prdCd; // 상품코드(PRD_CD)
	
	@Column(name = "CHANL_CD", length = 2)
	@NotNull
	private String chanlCd; // 채널코드(CHANL_CD)
	
	@Column(name = "LOG_REG_DTM")
	@NotNull
	private String logRegDtm; // 로그등록일시(LOG_REG_DTM)
}
