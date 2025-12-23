package Dto.Tarefas;

import java.time.LocalDate;

public record TarefaUpdateDto(
        String descricao,
        LocalDate dataEntrega,
        Long funcionarioId
) {
}
