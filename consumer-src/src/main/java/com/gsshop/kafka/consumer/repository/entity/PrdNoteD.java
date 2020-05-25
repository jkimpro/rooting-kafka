package com.gsshop.kafka.consumer.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "PRD_NOTE_D")
@ToString
@IdClass(PrdNoteD.class)
public class PrdNoteD  implements Serializable {
	
	@Id
	@Column(name = "PRD_CD", length=22) //PK
	@NotNull
	private BigDecimal prdCd; // 상품코드 (PRD_CD)

	@Id
	@Column(name = "NOTE_TYP_CD", length = 3, updatable = false)//PK
	@NotNull
	private String noteTypCd; // 비고유형코드(NOTE_TYP_CD)

	@Id
	@Column(name = "NOTE_SEQ", length = 22)//PK
	@NotNull
	private BigDecimal noteSeq; // 비고순번 (NOTE_SEQ)

	@Column(name = "REG_DTM", length = 7)
	@NotNull
	private Date regDtm; // 등록일시(REG_DTM)

	@Column(name = "REGR_ID", length = 10)
	@NotNull
	private String regrId; // 등록자ID(REGR_ID)

	@Column(name = "MOD_DTM", length = 7)
	@NotNull
	private Date modDtm; // 수정일시(MOD_DTM)

	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId; // 수정자ID(MODR_ID)

	@Column(name = "NOTE_CNTNT_1", length = 4000)
	private String noteCntnt1; // 비고내용1(NOTE_CNTNT1)

	@Column(name = "NOTE_CNTNT_2", length = 4000)
	private String noteCntnt2; // 비고내용2(NOTE_CNTNT2)

	@Column(name = "NOTE_CNTNT_3", length = 4000)
	private String noteCntnt3; // 비고내용3(NOTE_CNTNT3)

	@Column(name = "NOTE_CNTNT_4", length = 4000)
	private String noteCntnt4; // 비고내용4(NOTE_CNTNT4)

	@Column(name = "NOTE_CNTNT_5", length = 4000)
	private String noteCntnt5; // 비고내용5(NOTE_CNTNT5)

	@Column(name = "NOTE_CNTNT_6", length = 4000)
	private String noteCntnt6; // 비고내용6(NOTE_CNTNT6)

	@Column(name = "NOTE_CNTNT_7", length = 4000)
	private String noteCntnt7; // 비고내용7(NOTE_CNTNT7)

	@Column(name = "NOTE_CNTNT_8", length = 4000)
	private String noteCntnt8; // 비고내용8(NOTE_CNTNT8)

	@Column(name = "NOTE_CNTNT_9", length = 4000)
	private String noteCntnt9; // 비고내용9(NOTE_CNTNT9)
	
	@Column(name = "NOTE_CNTNT_10", length = 4000)
	private String noteCntnt10; // 비고내용10(NOTE_CNTNT10)
}
