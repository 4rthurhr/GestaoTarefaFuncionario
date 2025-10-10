package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Models.FuncionarioModel;
import services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	@Autowired
	private FuncionarioService service;

	public FuncionarioController(FuncionarioService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<FuncionarioModel> ListarTodos(){
		return service.ListFuncionario();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioModel> BuscarPorId(Long id){
		return service.BuscaporId(id).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public FuncionarioModel criar(@RequestBody FuncionarioModel funcionario) {
		return service.salvar(funcionario);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> RemoverPorId(@PathVariable("id") Long id){
		service.RemoverPorId(id);
		return ResponseEntity.noContent().build();
		
	}

}
