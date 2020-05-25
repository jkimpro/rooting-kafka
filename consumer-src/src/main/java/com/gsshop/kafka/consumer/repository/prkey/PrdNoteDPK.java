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
public class PrdNoteDPK implements Serializable  {
	
	@Column(name = "PRD_CD", length=22) //PK
	@NotNull
	private BigDecimal prdCd; // 상품코드 (PRD_CD)

	@Column(name = "NOTE_TYP_CD", length = 3, updatable = false)//PK
	@NotNull
	private String noteTypCd; // 비고유형코드(NOTE_TYP_CD)

	@Column(name = "NOTE_SEQ", length = 22)//PK
	@NotNull
	private BigDecimal noteSeq; // 비고순번 (NOTE_SEQ)

}
