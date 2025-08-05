package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Models.TaferaModel;
import services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	@Autowired
	private final TarefaService tarefaservice;

	public TarefaController(TarefaService tarefaservice) {
		this.tarefaservice = tarefaservice;
	}
	
	@PostMapping
	public TaferaModel criaTarefa(@RequestBody TaferaModel tarefa) {
		return tarefaservice.salvar(tarefa);
	}
	
	@GetMapping
	public List<TaferaModel> listarTarefa(){
		return tarefaservice.listTodos();
	}
	

}
