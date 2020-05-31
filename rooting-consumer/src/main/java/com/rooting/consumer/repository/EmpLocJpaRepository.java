package com.rooting.consumer.repository;

import com.rooting.consumer.repository.vo.EmpLocVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.math.BigDecimal;

public interface EmpLocJpaRepository extends JpaRepository<EmpLocVo, BigDecimal> {

    @QueryHints(value = {@QueryHint(name="org.hibernate.comment", value = "EmpLocJpaRepository.findByEmpCd")})
    public EmpLocVo findByEmpCd(BigDecimal empCd);

}
