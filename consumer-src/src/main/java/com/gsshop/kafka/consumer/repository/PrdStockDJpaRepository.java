package com.gsshop.kafka.consumer.repository;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdStockD;

@Repository
public interface PrdStockDJpaRepository extends JpaRepository<PrdStockD, String>{
    @QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdStockDRepository.findByAttrPrdRepCd")})
    PrdStockD findByAttrPrdRepCd(String attrPrdRepCd);
}

