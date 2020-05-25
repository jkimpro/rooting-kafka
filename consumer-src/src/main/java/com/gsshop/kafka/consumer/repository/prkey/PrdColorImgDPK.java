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
public class PrdColorImgDPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PRD_CD")
	private BigDecimal prdCd; // 상품코드(PRD_CD)
	
	@Column(name = "COLOR_NM", length = 200)
	private String colorNm; // 색상명(COLOR_NM)

}
