package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdNmChgH;
import com.gsshop.kafka.consumer.repository.prkey.PrdNmChgHPK;


@Repository
public interface PrdNmChgHJpaRepository extends JpaRepository<PrdNmChgH, PrdNmChgHPK>{
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNmChgHRepository.findByPrdCdAndChanlCdAndValidEndDtmAndValidStrDtm")})
	PrdNmChgH findByPrdCdAndChanlCdAndValidEndDtmAndValidStrDtm(BigDecimal prdCd,String chanlCd,Date validEndDtm,Date validStrDtm);	
	
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNmChgHRepository.findByPrdCd")})
	PrdNmChgH findByPrdCd(BigDecimal prdCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNmChgHRepository.findByChanlCd")})
	PrdNmChgH findByChanlCd(String chanlCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNmChgHRepository.findByValidEndDtm")})
	PrdNmChgH findByValidEndDtm(Date validEndDtm);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNmChgHRepository.findByValidStrDtm")})
	PrdNmChgH findByValidStrDtm(Date validStrDtm);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value ="PrdNmChgHRepository.findByPrdCdAndChanlCd")})
	PrdNmChgH findByPrdCdAndChanlCd(BigDecimal prdCd, String chanlCd);
}
