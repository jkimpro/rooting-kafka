package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdDescdHtmlD;
import com.gsshop.kafka.consumer.repository.prkey.PrdDescdHtmlDPK;

@Repository
public interface PrdDescdHtmlDJpaRepository extends JpaRepository<PrdDescdHtmlD,PrdDescdHtmlDPK>{

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdHtmlDRepository.findByPrdCdAndChanlCdAndRegGbnCd")})
	PrdDescdHtmlD findByPrdCdAndChanlCdAndRegGbnCd(BigDecimal prdCd, String chanlCd, String regGbnCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdHtmlDRepository.findByPrdCd")})
	PrdDescdHtmlD findByPrdCd(BigDecimal prdCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdHtmlDRepository.findByChanlCd")})
	List<PrdDescdHtmlD> findByChanlCd(String chanlCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdHtmlDRepository.findByRegGbnCd")})
	List<PrdDescdHtmlD> findByRegGbnCd(String regGbnCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdHtmlDRepository.findByPrdCdAndChanlCd")})
	List<PrdDescdHtmlD> findByPrdCdAndChanlCd(BigDecimal prdCd, String chanlCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdHtmlDRepository.findByChanlCdAndRegGbnCd")})
	List <PrdDescdHtmlD> findByChanlCdAndRegGbnCd(String chanlCd, String regGbnCd);
	
}

