package com.example.spring02.controller;

import com.example.spring02.dto.VeiculoDto;
import com.example.spring02.models.Veiculo;
import com.example.spring02.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoDto> getVeiculo(@PathVariable String placa) {
        return ResponseEntity.ok().body(service.getVeiculo(placa));
    }

    @GetMapping("/all")
    public ResponseEntity<List<VeiculoDto>> getAllVeiculo() {
        List<VeiculoDto> lista = service.getAllVeiculo();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/allByValor")
    public ResponseEntity<List<VeiculoDto>> getAllOrderByValor() {
        List<VeiculoDto> lista = service.getAllOrderByValor();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/allByModelo")
    public ResponseEntity<List<VeiculoDto>> getAllOrderByModelo() {
        List<VeiculoDto> lista = service.getAllOrderByModelo();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/allByModelo/{modelo}")
    public ResponseEntity<List<VeiculoDto>> getByModelo(@PathVariable String modelo) {
        List<VeiculoDto> lista = service.getByModelo(modelo);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveVeiculo(@RequestBody Veiculo novoVeiculo){
        service.saveVeiculo(novoVeiculo);
    }

}
