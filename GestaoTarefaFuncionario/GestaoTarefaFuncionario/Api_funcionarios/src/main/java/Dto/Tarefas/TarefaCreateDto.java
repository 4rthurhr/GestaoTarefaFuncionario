package Dto.Tarefas;

import java.time.LocalDate;

public record TarefaCreateDto(
        String descricao,
        LocalDate dataEntrga,
        Long funcionarioId
) { }
