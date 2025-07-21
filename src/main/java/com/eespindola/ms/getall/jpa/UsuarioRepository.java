package com.eespindola.ms.getall.jpa;

import com.eespindola.ms.getall.jpa.entities.UsuarioJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJpa, Object> {
}
