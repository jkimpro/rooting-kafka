package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdColorImgD;
import com.gsshop.kafka.consumer.repository.prkey.PrdColorImgDPK;

@Repository
public interface PrdColorImgDJpaRepository extends JpaRepository<PrdColorImgD, PrdColorImgDPK> {
	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdColorImgDRepsoitory.findByPrdCdAndColorNm")})
	PrdColorImgD findByPrdCdAndColorNm(BigDecimal prdCd, String colorNm);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdColorImgDRepository.findByPrdCd")})
	PrdColorImgD findByPrdCd(BigDecimal prdCd);
	
	@QueryHints(value = {@QueryHint(name = "org.hivbernate.comment", value = "PrdColorImgDRepository.findByColorNm")})
	PrdColorImgD findByColorNm(String colorNm);
}
