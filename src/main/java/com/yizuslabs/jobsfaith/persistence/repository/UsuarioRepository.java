package com.yizuslabs.jobsfaith.persistence.repository;

import com.yizuslabs.jobsfaith.persistence.model.TbUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<TbUsuario, Long> {
    List<TbUsuario> findByNomUsuario(String nombreUsuario);
}
