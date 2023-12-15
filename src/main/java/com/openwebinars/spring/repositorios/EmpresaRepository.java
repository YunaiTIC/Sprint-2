package com.openwebinars.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openwebinars.spring.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
