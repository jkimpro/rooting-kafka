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
public class PrdDescdHtmlDPK implements Serializable {
	
	@Column(name = "PRD_CD") //PK
	@NotNull
	private BigDecimal prdCd; // (PRD_CD)

	@Column(name = "CHANL_CD", length = 2) //PK
	@NotNull
	private String chanlCd; // 채널코드(CHANL_CD)

	@Column(name = "REG_GBN_CD", length = 1) //PK
	@NotNull
	private String regGbnCd; // 등록구분코드(REG_GBN_CD)
	
}
