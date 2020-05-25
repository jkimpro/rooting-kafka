package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdUdaD;
import com.gsshop.kafka.consumer.repository.prkey.PrdUdaDPK;

@Repository
public interface PrdUdaDJpaRepository extends JpaRepository<PrdUdaD, PrdUdaDPK>{

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdUdaDRepository.findByUdaNoAndPrdCdAndValidEndDtmAndValidStrDtm")})
	PrdUdaD findByUdaNoAndPrdCdAndValidEndDtmAndValidStrDtm(BigDecimal udaNo,
			BigDecimal prdCd,Date validEndDtm,Date validStrDtm);
	
	@QueryHints(value = {@QueryHint(name ="org.hibernate.comment", value ="PrdUdaDRepository.findByUdaNo")})
	PrdUdaD findByUdaNo(BigDecimal udaNo);
	
	@QueryHints(value= {@QueryHint(name ="org.hibernate.comment", value ="PrdUdaDRepository.findByPrdCd")})
	PrdUdaD findByPrdCd(BigDecimal prdCd);
	
	@QueryHints(value = {@QueryHint(name ="org.hibernate.comment", value ="PrdUdaDRepository.findByValidEndDtm")})
	PrdUdaD findByValidEndDtm(Date validEndDtm);
	
	@QueryHints(value = {@QueryHint(name ="org.hibernate.comment", value ="PrdUdaDRepository.findByValidStrDtm")})
	PrdUdaD findByValidStrDtm(Date validStrDtm);
	
	@QueryHints(value = {@QueryHint(name ="org.hibernate.comment", value ="PrdUdaDRepository.findByValidStrDtmAndValidEndDtm")})
	List<PrdUdaD> findByValidEndDtmAndValidStrDtm(Date validEndDtm, Date validStrDtm);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value ="PrdUdaDRepository.findByUdaNoAndPrdCd")})
	List<PrdUdaD> findByUdaNoAndPrdCd(BigDecimal udaNo, BigDecimal prdCd);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdUdaDRepository.findByPrdCdAndValidEndDtmAndValidStrDtm")})
	List<PrdUdaD> findByPrdCdAndValidEndDtmAndValidStrDtm(BigDecimal prdCd, Date validEndDtm, Date validStrDtm);

}