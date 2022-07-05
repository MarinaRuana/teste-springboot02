package com.example.spring02.dto;

import com.example.spring02.models.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO = Data Transfer Object
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDto {

    private String placa;
    private String modelo;
    private double valor;

    public VeiculoDto(Veiculo veiculo){
        this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.valor = veiculo.getValor();
    }
}
