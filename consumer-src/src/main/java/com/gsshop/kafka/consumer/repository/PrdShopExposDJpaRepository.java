package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdShopExposD;

@Repository
public interface PrdShopExposDJpaRepository extends JpaRepository<PrdShopExposD, BigDecimal> {
    @QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdShopExposDRepository.findByPrdCd")})
    PrdShopExposD findByPrdCd(BigDecimal prdCd);
}