package com.func.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.func.entities.Funcionario;
import com.func.repository.FunRepository;

@Service
public class FunServico {
	
	private final FunRepository funRepository;
	
	@Autowired
	public FunServico (FunRepository funRepository) {
		this.funRepository = funRepository;
	}
	public List<Funcionario> buscaTodosFuncionarios(){
		return funRepository.findAll();
	}
	public Funcionario buscaFuncionarioId(Long id) {
		Optional <Funcionario> Funcionario = funRepository.findById(id);
		return Funcionario.orElse(null);
	}
	public Funcionario alterarFuncionario(Long id, Funcionario alterarFuncionario) {
		Optional <Funcionario> existeFuncionario = funRepository.findById(id);
		if(existeFuncionario.isPresent()) {
			alterarFuncionario.setId(id);
			return funRepository.save(alterarFuncionario);
		}
		return null;
	}
	public boolean apagarFuncionario(Long id) {
		Optional <Funcionario> existeFuncionario = funRepository.findById(id);
		if(existeFuncionario.isPresent()) {
		funRepository.deleteById(id);
		return true;
	}
	return false;
	}
	public Funcionario salvaFuncionario(Funcionario funcionario) {
		return funRepository.save(funcionario);
	}
}
