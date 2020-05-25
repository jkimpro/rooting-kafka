package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdChanlChgL;
import com.gsshop.kafka.consumer.repository.prkey.PrdChanlChgLPK;

@Repository
public interface PrdChanlChgLJpaRepository extends JpaRepository<PrdChanlChgL, PrdChanlChgLPK> {

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdChanlChgLRepository.findByPrdCdAndChanlCdAndLogRegDtm")})
	PrdChanlChgL findByPrdCdAndChanlCdAndLogRegDtm(BigDecimal prdCd,String chanlCd, Date logRegDtm);


	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdChanlChgLRepository.findByPrdCd")})
	PrdChanlChgL findByPrdCd(BigDecimal prdCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdChanlChgLRepository.findByChanlCd")})
	PrdChanlChgL findByChanlCd(String chanlCd);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdChanlChgLRepository.findByLogRegDtm")})
	PrdChanlChgL findByLogRegDtm(Date logRegDtm);
	
	@QueryHints(value = {@QueryHint(name ="org.hibernate.comment", value = "PrdChanlChgLRepository.findByPrdCdAndChanlCd")})
	List<PrdChanlChgL> findByPrdCdAndChanlCd(BigDecimal prdCd, String chanlCd);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdChanlChgLRepository.findByChanlCdAndLogRegDtm")})
	List<PrdChanlChgL> findByChanlCdAndLogRegDtm(String chanlCd, Date logRegDtm);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdChanlChgLRepository.findByPrdCdAndLogRegDtm")})
	List<PrdChanlChgL> findByPrdCdAndLogRegDtm(BigDecimal prdCd, Date logRegDtm);
	
}
