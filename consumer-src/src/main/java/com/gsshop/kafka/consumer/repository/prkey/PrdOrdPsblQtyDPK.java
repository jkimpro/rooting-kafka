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
public class PrdOrdPsblQtyDPK implements Serializable{

	@Column(name = "ATTR_PRD_REP_CD") //PK
	@NotNull
	private String attrPrdRepCd; //속성상품대표코드 (ATTR_PRD_REP_CD)

	@Column(name = "CHANL_GRP_CD") //PK
	@NotNull
	private String chanlGrpCd; //채널그룹코드 (CHANL_GRP_CD)

}
