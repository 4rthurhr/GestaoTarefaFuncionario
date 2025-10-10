package services;

import java.util.*;

import org.springframework.stereotype.Service;

import Models.*;
import repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private FuncionarioRepository repository;

	public FuncionarioService(FuncionarioRepository Repository) {
		this.repository = Repository;
	}
	
	public List<FuncionarioModel> ListFuncionario(){
		return repository.findAll();
		
	}
	
	public Optional<FuncionarioModel> BuscaporId(Long id) {
		return repository.findById(id);
	}
	
	public FuncionarioModel salvar(FuncionarioModel funcionario) {
		return repository.save(funcionario);
	}
	
	public void RemoverPorId(Long id) {
		repository.deleteById(id);
	}
	
	
	

}
