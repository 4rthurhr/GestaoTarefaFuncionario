package services;

import java.util.*;

import Dto.Funcionarios.FuncinarioRespoDto;
import Dto.Funcionarios.FuncionarioCreateDto;
import Dto.Funcionarios.FuncionarioListDto;
import org.springframework.stereotype.Service;

import Models.*;
import repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private FuncionarioRepository repository;

	public FuncionarioService(FuncionarioRepository Repository) {
		this.repository = Repository;
	}

    public FuncionarioModel criar(FuncionarioCreateDto dto){
        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNome(dto.nome());
        funcionario.setCargo(dto.cargo());

        return repository.save(funcionario);
    }

//    public FuncinarioRespoDto buscarPorNome(String nome){
//        FuncionarioModel funcionario = f;
//    }

	public List<FuncionarioModel> ListFuncionario(){
		return repository.findAll();
	}

    public List<FuncionarioListDto> listar(){
        return repository.findAll().stream().map(FuncionarioListDto::new).toList();
    }
	
	public Optional<FuncionarioModel> BuscaporId(Long id) {
		return repository.findById(id);
	}


	public void RemoverPorId(Long id) {
		repository.deleteById(id);
	}
	
	
	

}
