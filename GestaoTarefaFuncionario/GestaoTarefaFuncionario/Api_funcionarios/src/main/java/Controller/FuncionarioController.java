package Controller;

import java.util.List;

import Dto.Funcionarios.FuncinarioRespoDto;
import Dto.Funcionarios.FuncionarioCreateDto;
import Dto.Funcionarios.FuncionarioListDto;
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

    @GetMapping("/nomes")
    public List<FuncionarioListDto> listar(){
        return service.listar();
    }
	

	
	@PostMapping
	public FuncinarioRespoDto criar(@RequestBody FuncionarioCreateDto dto){
        FuncionarioModel funcionario = service.criar(dto);
        return new FuncinarioRespoDto(funcionario);
    }
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> RemoverPorId(@PathVariable("id") Long id){
		service.RemoverPorId(id);
		return ResponseEntity.noContent().build();
		
	}

}
