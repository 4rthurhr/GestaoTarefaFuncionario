package services;

import java.util.List;
import java.util.Optional;

import Dto.Tarefas.TarefaRespoDto;
import Dto.Tarefas.TarefaUpdateDto;
import Models.FuncionarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.TaferaModel;
import repository.FuncionarioRepository;
import repository.TarefaRepository;

@Service
public class TarefaService {
    @Autowired
	private TarefaRepository tarefaRepository;
    @Autowired
    private FuncionarioRepository fubFuncionarioRepository;

    public TarefaRespoDto criar(TarefaRespoDto dto){
        FuncionarioModel funcionario = fubFuncionarioRepository.findById(dto.funcionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        TaferaModel tafera = new TaferaModel();
        tafera.setDescricao(dto.descricao());
        tafera.setDataEntrega(dto.dataEntrega());
        tafera.setConcluido(false);
        tafera.setFuncionario(funcionario);

        return toResponse(tarefaRepository.save(tafera));
    }

    public TarefaRespoDto atualizar(Long id, TarefaUpdateDto dto){
        TaferaModel tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa Não Encontrada"));

        tarefa.setDescricao(dto.descricao());
        tarefa.setDataEntrega(dto.dataEntrega());

        if (dto.funcionarioId() == null){
            FuncionarioModel funcionario = fubFuncionarioRepository.findById(dto.funcionarioId())
                    .orElseThrow(() -> new RuntimeException("Não Encontrado"));
            tarefa.setFuncionario(funcionario);

        }

        return toResponse(tarefaRepository.save(tarefa));
    }

    public TarefaRespoDto atulizarStatus(Long id, Boolean status){
        TaferaModel tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não Encontrado"));

        tarefa.setConcluido(status);

        return toResponse(tarefaRepository.save(tarefa));
    }

    public List<TarefaRespoDto> listar() {
        return tarefaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }


    private TarefaRespoDto toResponse(TaferaModel tafera) {
        return new TarefaRespoDto(
                tafera.getId(),
                tafera.getDescricao(),
                tafera.getDataEntrega(),
                tafera.isConcluido(),
                tafera.getFuncionario().getId()
        );
    }
}
