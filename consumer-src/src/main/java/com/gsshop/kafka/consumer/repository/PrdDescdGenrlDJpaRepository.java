package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdDescdGenrlD;
import com.gsshop.kafka.consumer.repository.prkey.PrdDescdGenrlDPK;

@Repository
public interface PrdDescdGenrlDJpaRepository extends JpaRepository<PrdDescdGenrlD, PrdDescdGenrlDPK>{
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdGenrlDRepository.findByPrdCdAndChanlCdAndDescdItmSeq")})
	PrdDescdGenrlD findByPrdCdAndChanlCdAndDescdItmSeq(BigDecimal prdCd, String chanlCd,
			BigDecimal descdItmSeq);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdGenrlDRepository.findByPrdCd")})
	PrdDescdGenrlD findByPrdCd(BigDecimal prdCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdGenrlDRepository.findByChanlCh")})
	PrdDescdGenrlD findByChanlCd(String chanlCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdDescdGenrlDRepository.findByDescdItmSeq")})
	PrdDescdGenrlD findByDescdItmSeq(BigDecimal descdItmSeq);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value ="PrdDescdGenrlDRepository.findByPrdCdAndChanlCd")})
	List<PrdDescdGenrlD> findByPrdCdAndChanlCd(BigDecimal prdCd, String chanlCd);
}
