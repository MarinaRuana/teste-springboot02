package com.example.spring02.service;

import com.example.spring02.dto.VeiculoDto;
import com.example.spring02.models.Veiculo;

import java.util.List;

public interface VeiculoService {

    VeiculoDto getVeiculo(String placa);

    List<VeiculoDto> getAllVeiculo();

    void saveVeiculo(Veiculo novoVeiculo);
}
