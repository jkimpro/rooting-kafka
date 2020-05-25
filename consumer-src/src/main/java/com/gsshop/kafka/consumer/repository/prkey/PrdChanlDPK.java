package com.gsshop.kafka.consumer.repository.prkey;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PrdChanlDPK implements Serializable {
	
	private static final long serialVersionUID = 7712658838002953419L;
	
	@Column(name = "PRD_CD") //PK
	private BigDecimal prdCd; // 상품코드(PRD_CD)
	
	@Column(name = "CHANL_CD") //PK
	private String chanlCd; // 채널코드(CHANL_CD)

}
