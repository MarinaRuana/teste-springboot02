package com.example.spring02.exception;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotFoundExceptionDetails {

    private String titulo;
    private int status;
    private String mensagem;
    private LocalDateTime timeStamp;


}
