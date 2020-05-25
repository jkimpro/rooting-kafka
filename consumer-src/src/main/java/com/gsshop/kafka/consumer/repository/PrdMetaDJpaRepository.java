package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdMetaD;
import com.gsshop.kafka.consumer.repository.prkey.PrdMetaDPK;

@Repository
public interface PrdMetaDJpaRepository extends JpaRepository<PrdMetaD, PrdMetaDPK>{

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdMetaDRepository.findByPrdCdAndPrdMetaTypCd")})
	PrdMetaD findByPrdCdAndPrdMetaTypCd(BigDecimal prdCd, String prdMetaTypCd);

	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdMetaDRepository.findByPrdCd")})
	PrdMetaD findByPrdCd(BigDecimal prdCd);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PRdMetaDRepository.findByPrdMetaTypCd")})
	PrdMetaD findByPrdMetaTypCd(String prdMetaTypCd);

}
