package com.jalautopecas.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.jalautopecas.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
Vendedor findByNome(String nome);
Page<Vendedor> findByNomeContainingAllIgnoreCase(@Param("nome") String nome, Pageable pageable);
Vendedor findByNomeAllIgnoringCase(@Param("nome") String nome);
}
