package com.example.spring02.repository;

import com.example.spring02.exception.NotFoundException;
import com.example.spring02.models.Veiculo;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class VeiculoRepo {

    private final String linkFile = "src/main/resources/dados.json";

    public Veiculo getVeiculo(String placa) {
        List<Veiculo> lista;
        ObjectMapper mapper = new ObjectMapper();
        try {
            lista = Arrays.asList
                    (mapper.readValue(new File(linkFile), Veiculo[].class));
            for (Veiculo v: lista){
                if(v.getPlaca().equals(placa)){
                    return v;
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro");
        }
        throw new NotFoundException("Veiculo não localizado");
    }

    public List<Veiculo> getAllVeiculo() {
        List<Veiculo> lista = null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            lista = Arrays.asList
                    (mapper.readValue(new File(linkFile), Veiculo[].class));
            return lista;
        } catch (Exception ex) {
            System.out.println("Erro");
        }
        return lista;
    }

    public void saveVeiculo(Veiculo novoVeiculo){
        List<Veiculo> listaAtual = null;
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try{
            listaAtual = Arrays.asList
                    (mapper.readValue(new File(linkFile), Veiculo[].class));
            List<Veiculo> listaCopia = new ArrayList<>(listaAtual);
            listaCopia.add(novoVeiculo);
            writer.writeValue(new File(linkFile), listaCopia);

        } catch (Exception ex) {
            System.out.println("Erro");
        }
    }
}
