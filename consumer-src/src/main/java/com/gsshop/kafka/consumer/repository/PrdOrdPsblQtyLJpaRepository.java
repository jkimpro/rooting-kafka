package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdOrdPsblQtyL;

@Repository
public interface PrdOrdPsblQtyLJpaRepository extends JpaRepository<PrdOrdPsblQtyL, BigDecimal>{
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdOrdPsblQtyLRepository.findByLogSeq")})
	PrdOrdPsblQtyL findByLogSeq(BigDecimal logSeq);
	
}

