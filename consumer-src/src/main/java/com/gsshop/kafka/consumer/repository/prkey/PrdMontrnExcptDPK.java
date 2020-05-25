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
public class PrdMontrnExcptDPK  implements Serializable {

	private static final long serialVersionUID = -7114302882397733395L;
	
	@Column(name = "CONCT_NO") //PK
	@NotNull
	private BigDecimal conctNo; // 연결번호(CONCT_NO)

	@Column(name = "MONTRN_EXCPT_TGT_GBN_CD") //PK
	@NotNull
	private String montrnExcptTgtGbnCd; // 모니터링예외대상구분코드(MONTRN_EXCPT_TGT_GBN_CD)

	@Column(name = "VALID_STR_DTM") //PK
	@NotNull
	private Date validStrDtm; // 유효시작일시(VALID_STR_DTM)
	
	@Column(name = "VALID_END_DTM") //PK
	@NotNull
	private Date validEndDtm; // 유효종료일시(VALID_END_DTM)

}
