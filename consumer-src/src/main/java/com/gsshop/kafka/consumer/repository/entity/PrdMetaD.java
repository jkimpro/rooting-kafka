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

import com.gsshop.kafka.consumer.repository.prkey.PrdMetaDPK;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@IdClass(PrdMetaDPK.class)
@Table(name = "PRD_META_D")
public class PrdMetaD  implements Serializable {

	@Id	
	@Column(name = "PRD_CD") //PK
	@NotNull
	private BigDecimal prdCd; // 상품코드(PRD_CD)

	@Id
	@Column(name = "PRD_META_TYP_CD", length=2) //PK
	@NotNull
	private String prdMetaTypCd; // 상품메타유형코드(PRD_META_TYP_CD)
	
	@Column(name = "REG_DTM", length = 7)
	@NotNull
	private Date regDtm;		//등록일(REG_DTM)
	
	@Column(name = "REGR_ID", length = 10)
	@NotNull
	private String regId;		//등록자ID(REGR_ID)
	
	@Column(name = "MOD_DTM", length = 7)
	@NotNull
	private Date modDtm;		//수정일시(MOD_DTM)
	
	@Column(name = "MODR_ID", length = 10)
	@NotNull
	private String modrId;		//수정자ID(MODR_ID)

	@Column(name = "ATTR_CHAR_VAL_1", length = 100)
	//@NotNull
	private String attrCharVal1;		//속성문자값1(ATTR_CHAR_VAL_1)

	@Column(name = "ATTR_CHAR_VAL_2", length = 100)
	//@NotNull
	private String attrCharVal2;		//속성문자값2(ATTR_CHAR_VAL_1)

	@Column(name = "ATTR_CHAR_VAL_3", length = 100)
	//@NotNull
	private String attrCharVal3;		//속성문자값3(ATTR_CHAR_VAL_3)

	@Column(name = "ATTR_CHAR_VAL_4", length = 300)
	//@NotNull
	private String attrCharVal4;		//속성문자값4(ATTR_CHAR_VAL_4)

	@Column(name = "ATTR_CHAR_VAL_5", length = 100)
	//@NotNull
	private String attrCharVal5;		//속성문자값5(ATTR_CHAR_VAL_5)

	@Column(name = "ATTR_CHAR_VAL_6", length = 100)
	//@NotNull
	private String attrCharVal6;		//속성문자값6(ATTR_CHAR_VAL_6)

	@Column(name = "ATTR_CHAR_VAL_7", length = 100)
	//@NotNull
	private String attrCharVal7;		//속성문자값7(ATTR_CHAR_VAL_7)

	@Column(name = "ATTR_CHAR_VAL_8", length = 100)
	//@NotNull
	private String attrCharVal8;		//속성문자값8(ATTR_CHAR_VAL_8)

	@Column(name = "ATTR_CHAR_VAL_9", length = 100)
	//@NotNull
	private String attrCharVal9;		//속성문자값9(ATTR_CHAR_VAL_9)

	@Column(name = "ATTR_CHAR_VAL_10", length = 100)
	//@NotNull
	private String attrCharVal10;		//속성문자값10(ATTR_CHAR_VAL_10)

	@Column(name = "ATTR_CHAR_VAL_11", length = 100)
	//@NotNull
	private String attrCharVal11;		//속성문자값11(ATTR_CHAR_VAL_11)

	@Column(name = "ATTR_CHAR_VAL_12", length = 100)
	//@NotNull
	private String attrCharVal12;		//속성문자값12(ATTR_CHAR_VAL_12)

	@Column(name = "ATTR_CHAR_VAL_13", length = 100)
	//@NotNull
	private String attrCharVal13;		//속성문자값13(ATTR_CHAR_VAL_13)

	@Column(name = "ATTR_CHAR_VAL_14", length = 100)
	//@NotNull
	private String attrCharVal14;		//속성문자값14(ATTR_CHAR_VAL_14)

	@Column(name = "ATTR_CHAR_VAL_15", length = 100)
	//@NotNull
	private String attrCharVal15;		//속성문자값15(ATTR_CHAR_VAL_15)

	@Column(name = "ATTR_NUM_VAL_1", length = 22)
	//@NotNull
	private BigDecimal attrNumVal1;		//속성숫자값1(ATTR_NUM_VAL_1)

	@Column(name = "ATTR_NUM_VAL_2", length = 22)
	//@NotNull
	private BigDecimal attrNumVal2;		//속성숫자값2(ATTR_NUM_VAL_2)

	@Column(name = "ATTR_NUM_VAL_3", length = 22)
	//@NotNull
	private BigDecimal attrNumVal3;		//속성숫자값1(ATTR_NUM_VAL_3)

	@Column(name = "ATTR_NUM_VAL_4", length = 22)
	//@NotNull
	private BigDecimal attrNumVal4;		//속성숫자값1(ATTR_NUM_VAL_4)

	@Column(name = "ATTR_NUM_VAL_5", length = 22)
	//@NotNull
	private BigDecimal attrNumVal5;		//속성숫자값1(ATTR_NUM_VAL_5)

	
}
