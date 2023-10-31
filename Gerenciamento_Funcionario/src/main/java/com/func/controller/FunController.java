package com.func.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.func.entities.Funcionario;
import com.func.services.FunServico;


import jakarta.validation.Valid;


@RestController
@RequestMapping("/funcionario")
public class FunController {
	
	private final FunServico funServico;
	
	@Autowired
	public FunController(FunServico funServico) {
		this.funServico = funServico;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscaFuncionarioControlId(@PathVariable Long id){
		Funcionario funcionario = funServico.buscaFuncionarioId(id);
		if(funcionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else{
			return ResponseEntity.notFound().build();
	
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> buscaTodosFuncionariosControl(){
		List<Funcionario> Funcionario = funServico.buscaTodosFuncionarios();
		return ResponseEntity.ok(Funcionario);
	}
	@PostMapping("/")
	public ResponseEntity<Funcionario> salvaFuncionariosControl (@RequestBody @Valid Funcionario funcionario){
		Funcionario salvaFuncionario = funServico.salvaFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> alteraFuncionarioControl (@PathVariable Long id, @RequestBody @Valid Funcionario funcionario){
		Funcionario alteraFuncionario = funServico.alterarFuncionario(id, funcionario);
		if(alteraFuncionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
		public ResponseEntity<Funcionario> apagaFuncionarioControl (@PathVariable Long id){
		boolean apagar = funServico.apagarFuncionario(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
