package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> RemoverPorId(@PathVariable("id") Long id){
		tarefaservice.RemoverPorid(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}/status")
	public ResponseEntity<TarefaService> AtualizarStatus(@PathVariable Long id, @RequestBody boolean status){

		if(AtualizarStatus != null){

		}
	}
	

}
