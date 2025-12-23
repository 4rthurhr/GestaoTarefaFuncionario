package Dto.Tarefas;

import java.time.LocalDate;

public record TarefaRespoDto(
        Long id,
        String descricao,
        LocalDate dataEntrega,
        boolean concluido,
        Long funcionarioId
) {
}
