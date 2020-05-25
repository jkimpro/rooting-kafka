package com.gsshop.kafka.consumer.repository.prkey;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
@Embeddable
public class PrdExplnDPK   implements Serializable{
	@Column(name = "PRD_CD") //PK
	@NotNull
	private BigDecimal prdCd; // (prd_cd)

	@Column(name = "CHANL_CD", length = 2) //PK
	@NotNull
	private String chanlCd; // 채널코드(chanl_cd)

	@Column(name = "GOV_PUBLS_PRD_GRP_CD", length = 2) //PK
	@NotNull
	private String govPublsPrdGrpCd; // 정부고시상품군코드(GOV_PUBLS_PRD_GRP_CD)

	@Column(name = "PRD_EXPLN_ITM_CD", length = 5) //PK
	@NotNull
	private String prdExplnItmCd; // 상품설명항목코드(PRD_EXPLN_ITM_CD)
	
}
