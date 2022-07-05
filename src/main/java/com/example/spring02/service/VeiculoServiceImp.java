package com.example.spring02.service;

import com.example.spring02.dto.VeiculoDto;
import com.example.spring02.models.Veiculo;
import com.example.spring02.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImp implements VeiculoService{

    @Autowired
    private VeiculoRepo repo;

    @Override
    public VeiculoDto getVeiculo(String placa) {
        return new VeiculoDto(repo.getVeiculo(placa));
    }

    @Override
    public List<VeiculoDto> getAllVeiculo() {
       List<Veiculo> listaVeiculos = repo.getAllVeiculo();
       return listaVeiculos.stream()
               .map(VeiculoDto::new)
               .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDto> getAllOrderByValor() {
        List<Veiculo> listaVeiculos = repo.getAllVeiculo();
        return listaVeiculos.stream()
                .sorted()
                .map(VeiculoDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDto> getAllOrderByModelo() {
        List<Veiculo> listaVeiculos = repo.getAllVeiculo();
        return listaVeiculos.stream()
                .sorted(Comparator.comparing(Veiculo::getModelo))
                .map(VeiculoDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDto> getByModelo(String modelo) {
        List<Veiculo> listaVeiculos = repo.getAllVeiculo();
        return listaVeiculos.stream()
                .filter(v -> v.getModelo().equalsIgnoreCase(modelo))
                .map(VeiculoDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void saveVeiculo(Veiculo novoVeiculo) {
        repo.saveVeiculo(novoVeiculo);
    }
}
