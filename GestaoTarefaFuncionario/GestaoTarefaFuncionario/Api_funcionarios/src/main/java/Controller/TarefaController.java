package Controller;

import java.util.List;

import Dto.Tarefas.StatusDto;
import Dto.Tarefas.TarefaRespoDto;
import Dto.Tarefas.TarefaUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Models.TaferaModel;
import services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaRespoDto> criar(
            @RequestBody TarefaRespoDto dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaRespoDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }


    @PutMapping("/{id}")
    public TarefaRespoDto atualizar(
            @PathVariable Long id,
            @RequestBody TarefaUpdateDto dto
    ) {
        return service.atualizar(id, dto);
    }

    @PatchMapping("/{id}/status")
    public TarefaRespoDto atualizarStatus(
            @PathVariable Long id,
            @RequestBody StatusDto dto
    ) {
        return service.atulizarStatus(id, dto.concluido());
    }
}
