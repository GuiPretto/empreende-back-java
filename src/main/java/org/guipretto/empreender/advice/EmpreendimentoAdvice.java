package org.guipretto.empreender.advice;

import org.guipretto.empreender.exception.EmpreendimentoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EmpreendimentoAdvice {

    @ExceptionHandler(EmpreendimentoException.class)
    public ResponseEntity<Object> handleEmpreendimentoException(EmpreendimentoException empreendimentoException) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("mensagem", empreendimentoException.getMensagem());
        response.put("status", empreendimentoException.getCodigo().value());
        return new ResponseEntity<Object>(response, empreendimentoException.getCodigo());
    }
}
