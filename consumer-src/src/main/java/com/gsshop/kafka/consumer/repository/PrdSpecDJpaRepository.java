package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdSpecD;
import com.gsshop.kafka.consumer.repository.prkey.PrdSpecDPK;

@Repository
public interface PrdSpecDJpaRepository extends JpaRepository<PrdSpecD, PrdSpecDPK>{

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdSpecDRepository.findByPrdCdAndPrdSpecCdAndPrdSpecSeq")})   
	PrdSpecD findByPrdCdAndPrdSpecCdAndPrdSpecSeq(BigDecimal prdCd,String prdSpecCd,BigDecimal prdSpecSeq);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdSpecDRepository.findByPrdCd")})   
	PrdSpecD findByPrdCd(BigDecimal prdCd);

	@QueryHints(value = {@QueryHint(name ="org.hibernate.comment", value ="PrdSpecDRepository.findByPrdSpecCd")})
	PrdSpecD findByPrdSpecCd(String prdSpecCd);
	
	@QueryHints(value = {@QueryHint(name ="org.hibernate.comment", value ="PrdSpecDRepository.findByPrdSpecSeq")})
	PrdSpecD findByPrdSpecSeq(BigDecimal prdSpecSeq);

	@QueryHints(value = {@QueryHint(name ="org.hibernate.comment", value ="PrdSpecDRepository.findByPrdCdAndPrdSpecCd")})
	List<PrdSpecD> findByPrdCdAndPrdSpecCd(BigDecimal prdCd, String prdSpecCd);

}
