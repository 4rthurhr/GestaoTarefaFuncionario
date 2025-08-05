package services;

import java.util.List;

import org.springframework.stereotype.Service;

import Models.TaferaModel;
import repository.TarefaRepository;

@Service
public class TarefaService {
	private final TarefaRepository tarefaRepository;

	public TarefaService(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	
	
	public TaferaModel salvar(TaferaModel tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	public List<TaferaModel> listTodos(){
		return tarefaRepository.findAll();
	}
}
