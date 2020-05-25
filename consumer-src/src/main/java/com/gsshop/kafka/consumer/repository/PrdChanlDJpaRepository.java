package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdChanlD;
import com.gsshop.kafka.consumer.repository.prkey.PrdChanlDPK;

@Repository
public interface PrdChanlDJpaRepository extends JpaRepository<PrdChanlD, PrdChanlDPK>{

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdChanlDRepository.findByPrdCdAndChanlCd")})
	PrdChanlD findByPrdCdAndChanlCd(BigDecimal prdCd,String chanlCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdChanlDRepository.findByPrdCd")})
	PrdChanlD findByPrdCd(BigDecimal prdCd);
	 
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdChanlDRepository.findByChanlCd")})
	PrdChanlD findByChanlCd(String chanlCd);

}
