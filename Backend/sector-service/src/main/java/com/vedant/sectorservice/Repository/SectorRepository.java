package com.vedant.sectorservice.Repository;

import com.vedant.sectorservice.Entity.SectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<SectorEntity, Integer> {
}
