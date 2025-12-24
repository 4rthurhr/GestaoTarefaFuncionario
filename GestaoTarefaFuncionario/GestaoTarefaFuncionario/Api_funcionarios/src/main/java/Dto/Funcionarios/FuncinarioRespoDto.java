package Dto.Funcionarios;

import Models.FuncionarioModel;

public record FuncinarioRespoDto(
        Long id,
        String nome,
        String cargo
) {
    public FuncinarioRespoDto(FuncionarioModel funcionario) {
        this(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCargo()
        );

    }
}
