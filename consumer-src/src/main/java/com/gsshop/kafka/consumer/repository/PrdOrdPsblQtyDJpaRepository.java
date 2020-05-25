package com.gsshop.kafka.consumer.repository;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.gsshop.kafka.consumer.repository.entity.PrdOrdPsblQtyD;
import com.gsshop.kafka.consumer.repository.prkey.PrdOrdPsblQtyDPK;

@Repository
public interface PrdOrdPsblQtyDJpaRepository extends JpaRepository<PrdOrdPsblQtyD,PrdOrdPsblQtyDPK>{

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdOrdPsblQtyDRepository.findByAttrPrdRepCdAndChanlGrpCd")})
	PrdOrdPsblQtyD findByAttrPrdRepCdAndChanlGrpCd(String attrPrdRepCd,String chanlGrpCd);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdOrdPsblQtyDRepository.findByAttrPrdRepCd")})
	PrdOrdPsblQtyD findByAttrPrdRepCd(String attrPrdRepCd);

	@QueryHints(value = {@QueryHint(name = "org.hibernate.comment", value = "PrdOrdPsblQtyDRepository.findByChanlGrpCd")})
	PrdOrdPsblQtyD findByChanlGrpCd(String chanlGrpCd);
	
	
}
