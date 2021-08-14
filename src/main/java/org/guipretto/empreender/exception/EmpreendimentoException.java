package org.guipretto.empreender.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class EmpreendimentoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String mensagem;

    private HttpStatus codigo;
}
