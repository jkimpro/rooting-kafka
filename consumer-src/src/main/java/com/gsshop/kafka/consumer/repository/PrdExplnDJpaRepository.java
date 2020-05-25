package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdExplnD;
import com.gsshop.kafka.consumer.repository.prkey.PrdExplnDPK;

@Repository
public interface PrdExplnDJpaRepository extends JpaRepository<PrdExplnD, PrdExplnDPK>{
	
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdExplnDRepository.findByPrdCdAndChanlCdAndGovPublsPrdGrpCdAndPrdExplnItmCd")})
	PrdExplnD findByPrdCdAndChanlCdAndGovPublsPrdGrpCdAndPrdExplnItmCd(BigDecimal prdCd,
			String chanlCd,String govPublsPrdGrpCd,String prdExplnItmCd);
	
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdExplnDRepository.findByPrdCd")})
	PrdExplnD findByPrdCd(BigDecimal prdCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdExplnDRepository.findByChanlCd")})
	PrdExplnD findByChanlCd(String chanlCd);
	
	@QueryHints(value = {@QueryHint(name="org.hibernate.comment", value = "PrdExplnDRepository.findByGovPublsPrdGrpCd")})
	PrdExplnD findByGovPublsPrdGrpCd(String govPublsPrdGrpCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdExplnDRepository.findByPrdExplnItmCd")})
	PrdExplnD findByPrdExplnItmCd(String prdExplnItmCd);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value ="PrdExplnDRepository.findByPrdCdAndChanlCd")})
	List<PrdExplnD> findByPrdCdAndChanlCd(BigDecimal prdCd, String chanlCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdExplnDRepository.findByChanlCdAndGovPublsPrdGrpCd")})
	List <PrdExplnD> findByChanlCdAndGovPublsPrdGrpCd(String chanlCd, String govPublsPrdGrpCd);
}
