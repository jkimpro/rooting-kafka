package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdNoteD;
import com.gsshop.kafka.consumer.repository.prkey.PrdNoteDPK;

@Repository
public interface PrdNoteDJpaRepository extends JpaRepository<PrdNoteD, PrdNoteDPK> {
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNoteDRepository.findByPrdCdAndNoteTypCdAndNoteSeq")})
	PrdNoteD findByPrdCdAndNoteTypCdAndNoteSeq(BigDecimal prdCd,String noteTypCd,BigDecimal noteSeq);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNoteDRepository.findByPrdCd")})
	List<PrdNoteD> findByPrdCd(BigDecimal prdCd);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNoteDRepository.findByNoteTypCd")})
	List<PrdNoteD> findByNoteTypCd(String noteTypCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNoteDRepository.findByNoteSeq")})
	List<PrdNoteD> findByNoteSeq(BigDecimal noteSeq);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdNotDRepository.findByNoteTypCdAndNoteSeq")})
	List<PrdNoteD> findByNoteTypCdAndNoteSeq(String noteTypCd, BigDecimal noteSeq);
	
}

