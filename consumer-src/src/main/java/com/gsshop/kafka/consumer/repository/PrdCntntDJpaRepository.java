package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdCntntD;

@Repository
public interface PrdCntntDJpaRepository extends JpaRepository<PrdCntntD, BigDecimal>{

	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdCntntDRepository.findByCntntNo")})
	PrdCntntD findByCntntNo(BigDecimal cntntNo);

	
}
