package com.func.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.func.entities.Funcionario;

public interface FunRepository extends JpaRepository<Funcionario, Long> {

	
	

}