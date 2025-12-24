package Dto.Funcionarios;

import Models.FuncionarioModel;

public record FuncionarioListDto(
        String nome,
        String cargo
){
    public FuncionarioListDto(FuncionarioModel f){
        this(
                f.getNome(),
                f.getCargo()
        );
    }
}
