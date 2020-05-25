package com.gsshop.kafka.consumer.repository;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdPrcH;
import com.gsshop.kafka.consumer.repository.prkey.PrdPrcHPK;

@Repository
public interface PrdPrcHJpaRepository extends JpaRepository<PrdPrcH, PrdPrcHPK>{
	
    @QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdPrcHRepository.findByPrdCdAndPrdAttrGbnCdAndValidEndDtmAndValidStrDtm")})
    PrdPrcH findByPrdCdAndPrdAttrGbnCdAndValidEndDtmAndValidStrDtm(BigDecimal prdCd,String prdAttrGbnCd, Date validEndDtm,
    		Date validStrDtm);
	
    @QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdPrcHRepository.findByPrdCd")})
    PrdPrcH findByPrdCd(BigDecimal prdCd);

    @QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdPrcHRepository.findByPrdAttrGbnCd")})
    PrdPrcH findByPrdAttrGbnCd(String prdAttrGbnCd);
    
    @QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value ="PrdPrcHRepository.findByValidEndDtm")})
    PrdPrcH findByValidEndDtm(Date validEndDtm);
    
    @QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value ="PrdPrcHRepository.findByValidStrDtm")})
    PrdPrcH findByValidStrDtm(Date validStrDtm);
    
    @QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdPrcHRepository.findByPrdCdAndPrdAttrGbnCd")})
    PrdPrcH findByPrdCdAndPrdAttrGbnCd(BigDecimal prdCd, String prdAttrGbnCd);
    
}

