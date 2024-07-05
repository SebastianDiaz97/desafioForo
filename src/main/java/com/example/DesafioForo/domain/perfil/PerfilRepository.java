package com.example.DesafioForo.domain.perfil;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long> {
    Page<Perfil> findByActivoTrue(Pageable paginacion);
}
