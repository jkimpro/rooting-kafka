package com.rooting.producer.repository;

import com.rooting.producer.vo.EmpMVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.math.BigDecimal;


@Repository
public interface EmpMJpaRepository extends JpaRepository<EmpMVo, BigDecimal> {

    @QueryHints(value = {@QueryHint( name = "org.hibernate.comment", value = "EmpMJpaRepository.findByEmpCd")})
    public EmpMVo findByEmpCd(BigDecimal empCd);

}
