package com.vedant.companyservice.Repository;

import com.vedant.companyservice.Entity.IPOEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPORepository extends JpaRepository<IPOEntity, Integer> {

}
