package com.rooting.consumer.repository.vo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@ToString
@Table(name = "emp_loc")
public class EmpLocVo implements Serializable {

    //JPA save 사용할때는 GeneratedValue 를 무조건 사용해야함!
    @Id
    @Column(updatable=false)
    private BigDecimal empCd;

    private BigDecimal locLat;
    private BigDecimal locLng;
    private String regDt;
    private String regId;
}
