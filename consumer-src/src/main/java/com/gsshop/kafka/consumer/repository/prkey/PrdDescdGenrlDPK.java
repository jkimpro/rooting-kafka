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
public class PrdDescdGenrlDPK  implements Serializable{

	private static final long serialVersionUID = -7114302882397733395L;
	
	@Column(name = "PRD_CD") //PK
	@NotNull
	private BigDecimal prdCd; // 상품코드(PRD_CD)

	@Column(name = "CHANL_CD", length = 2) //PK
	@NotNull
	private String chanlCd; // 채널코드(CHANL_CD) 
	
	@Column(name = "DESCD_ITM_SEQ") //PK
	@NotNull
	private BigDecimal descdItmSeq; // 기술서항목순번(DESCD_ITM_SEQ)

}
