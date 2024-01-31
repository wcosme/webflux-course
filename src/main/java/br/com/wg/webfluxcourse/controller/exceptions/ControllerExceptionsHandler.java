package br.com.wg.webfluxcourse.controller.exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    ResponseEntity<Mono<StandardError>> duplicateKeyException(
            DuplicateKeyException ex, ServerHttpRequest request) {

        return ResponseEntity.status(BAD_REQUEST).body(
                Mono.just(StandardError.builder()
                        .timestamp(now())
                        .status(BAD_REQUEST.value())
                        .error("Duplicate Key")
                        .message(verifyDupKey(ex.getMessage()))
                        .path(request.getURI().getPath().toString())
                        .build())
        );
    }

    private String verifyDupKey(String message){
        if(message.contains("duplicate key")){
            return "E-mail already registered!";
        }
        return "Dup key exception";
    }
}

