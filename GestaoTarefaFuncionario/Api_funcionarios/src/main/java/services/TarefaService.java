package services;

import java.util.List;
import java.util.Optional;

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

	public void RemoverPorid(Long id ){
		tarefaRepository.deleteById(id);
	}

	public TaferaModel concluido (Long id, boolean status){
		Optional<TaferaModel> tarefaExistente = tarefaRepository.findById(id);

		if (tarefaExistente.isPresent()){
			TaferaModel tarefa = tarefaExistente.get();
			tarefa.setConcluido(status);
			return tarefaRepository.save(tarefa);
		} else {
			return null;
		}
	}
}
