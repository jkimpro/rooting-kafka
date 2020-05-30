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
@Table(name = "SHOP_M")
public class ShopMVo {
    @Id
    private BigDecimal shopCd;

    private String regDt;
    private String regId;
    private String modDt;
    private String modId;
    private String shopNm;
    private String shopPtCd;
    private BigDecimal prdBuy;
    private BigDecimal authEmpCd;
}