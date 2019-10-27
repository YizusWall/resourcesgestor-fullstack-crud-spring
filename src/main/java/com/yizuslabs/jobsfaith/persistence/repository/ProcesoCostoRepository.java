package com.yizuslabs.jobsfaith.persistence.repository;

import com.yizuslabs.jobsfaith.persistence.model.TbProcesoCosto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoCostoRepository extends JpaRepository<TbProcesoCosto, Long> {
}
