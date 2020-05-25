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
public class PrdSpecDPK implements Serializable{

	@Column(name = "PRD_CD", length = 22) //PK
	@NotNull
	private BigDecimal prdCd; 		// 상품코드(PRD_CD)
	
	@Column(name = "PRD_SPEC_CD", length = 5) //PK
	@NotNull
	private String prdSpecCd; 		// 상품사양코드(PRD_SPEC_CD)
	
	@Column(name = "PRD_SPEC_SEQ", length = 5) //PK
	@NotNull
	private BigDecimal prdSpecSeq; 	// 상품사양순번(PRD_SPEC_SEQ)
	
}
