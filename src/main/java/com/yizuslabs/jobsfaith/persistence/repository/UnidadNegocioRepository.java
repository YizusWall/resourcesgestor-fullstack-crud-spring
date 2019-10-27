package com.yizuslabs.jobsfaith.persistence.repository;

import com.yizuslabs.jobsfaith.persistence.model.TbUnidadNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadNegocioRepository extends JpaRepository<TbUnidadNegocio, Long> {
}
