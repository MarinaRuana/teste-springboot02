package com.example.spring02.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    private String placa;
    private String modelo;
    private double valor;
    private String renavam;


}
