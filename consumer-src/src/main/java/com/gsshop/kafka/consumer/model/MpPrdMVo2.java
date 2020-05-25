package com.gsshop.kafka.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MpPrdMVo2  {
	
	private String name;
    private BigDecimal price;
    
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private Date regdate;
    private BigDecimal prdCd;
    private String prdNm;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public BigDecimal getPrdCd() {
		return prdCd;
	}

	public void setPrdCd(BigDecimal prdCd) {
		this.prdCd = prdCd;
	}

	public String getPrdNm() {
		return prdNm;
	}

	public void setPrdNm(String prdNm) {
		this.prdNm = prdNm;
	}
    
    public MpPrdMVo2() {}

	public MpPrdMVo2 ( String name, BigDecimal price, Date regdate, BigDecimal prdCd, String prdNm) {
    	this.name = name;
    	this.price = price;
    	this.regdate = regdate;
    	this.prdCd = prdCd;
    	this.prdNm = prdNm;
    }
    

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MpPrdM{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append(", regdate='").append(regdate).append('\'');
        sb.append(", prdCd='").append(prdCd).append('\'');
        sb.append(", prdNm='").append(prdNm).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
