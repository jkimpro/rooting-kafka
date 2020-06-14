package com.rooting.producer.vo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@ToString
@Table(name = "EMP_M")
public class EmpMVo {

    @Id
    private BigDecimal empCd;

    private String regDt;
    private String regId;
    private String empNm;
    private BigDecimal teamCd;

    private String onWorkYn;
    private String insideYn;
    private String masterRtYn;

}
