package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdMontrnExcptD;
import com.gsshop.kafka.consumer.repository.prkey.PrdMontrnExcptDPK;

@Repository
public interface PrdMontrnExcptDJpaRepository extends JpaRepository<PrdMontrnExcptD, PrdMontrnExcptDPK> {
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdMontrnExcptDRepository.findByConctNoAndMontrnExcptTgtGbnCdAndValidStrDtmAndValidEndDtm")})
	PrdMontrnExcptD findByConctNoAndMontrnExcptTgtGbnCdAndValidStrDtmAndValidEndDtm(BigDecimal conctNo,
			String montrnExcptTgtGbnCd,Date validStrDtm,Date validEndDtm);
	
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdMontrnExcptDRepository.findByConctNo")})
	PrdMontrnExcptD findByConctNo(BigDecimal conctNo);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdMontrnExcptDRepository.findByMontrnExcptTgtGbnCd")})
	PrdMontrnExcptD findByMontrnExcptTgtGbnCd(String montrnExcptTgtGbnCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdMontrnExcptDRepository.findByValidStrDtm")})
	PrdMontrnExcptD findByValidStrDtm(Date validStrDtm);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdMontrnExcptDRepository.findByValidEndDtm")})
	PrdMontrnExcptD findByValidEndDtm(Date validEndDtm);
	
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdMontrnExcptDRepository.findByConctNoAndMontrnExcptTgtGbnCd")})
	List<PrdMontrnExcptD> findByConctNoAndMontrnExcptTgtGbnCd(BigDecimal conctNo, String montrnExcptTgtGbnCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdMontrnExcptDRepository.findByValidStrDtmAndValidEndDtm")})
	List<PrdMontrnExcptD> findByValidStrDtmAndValidEndDtm(Date validStrDtm, Date validEndDtm);
	
}
