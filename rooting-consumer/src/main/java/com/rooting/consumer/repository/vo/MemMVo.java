package com.rooting.consumer.repository.vo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@ToString
@Table(name = "MEM_M")
public class MemMVo {
    @Id
    private BigDecimal memCd;

    private String id;
    private String password;
    private String empYn;
    private Integer empCd;
}

//    CREATE TABLE MEM_M(
//        MEM_CD INT(11) PRIMARY KEY,
//    ID VARCHAR(11) NOT NULL,
//    PASSWORD VARCHAR(11) NOT NULL,
//    EMP_YN VARCHAR(11) DEFAULT 'N',
//        EMP_CD INT(11)
//        );