package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import com.gsshop.kafka.consumer.repository.entity.PrdPreOrdngL;
import com.gsshop.kafka.consumer.repository.prkey.PrdPreOrdngLPK;

public interface PrdPreOrdngLJpaRepository extends JpaRepository<PrdPreOrdngL, PrdPreOrdngLPK>{
	 
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdPreOrdngLRepository.findByAttrPrdCdAndEntDtm")})	  
	PrdPreOrdngL findByAttrPrdCdAndEntDtm(BigDecimal attrPrdCd, Date entDtm);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdPreOrdngLRepository.findByAttrPrdCd")})	  
	List<PrdPreOrdngL> findByAttrPrdCd(BigDecimal attrPrdCd);
	
	@QueryHints(value = {@QueryHint(name ="org.hibernate.comment", value ="PrdPreOrdngLRepository.findByEntDtm")})
	List<PrdPreOrdngL> findByEntDtm(Date entDtm);
	
}
