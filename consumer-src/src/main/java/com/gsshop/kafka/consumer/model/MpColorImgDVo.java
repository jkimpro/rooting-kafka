package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class MpColorImgDVo {
	private BigDecimal prdCd;
	private String colorNm;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDtm;
	private String regrId;
	
	@JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modDtm;
	
	private String modrId;
	private String colorVal;
	private String imgFileNm;
}

