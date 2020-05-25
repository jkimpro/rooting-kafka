package com.gsshop.kafka.producer.repository;

import java.math.BigDecimal;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.producer.repository.jpa.MpPrdM;

@Repository
public interface MpPrdMRepository extends JpaRepository<MpPrdM, BigDecimal> {
    @QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "MpPrdMRepository.findByPrdCd")})
    MpPrdM findByPrdCd(BigDecimal prdCd);

}
