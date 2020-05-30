package com.rooting.consumer.repository.vo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
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
    @Column(name = "EMP_CD")
    private BigDecimal empCd;

    private String regDt;
    private String regId;
    private String empNm;
    private BigDecimal teamCd;
    private String onWorkYn;
    private String insideYn;
    private String masterRtYn;
}
