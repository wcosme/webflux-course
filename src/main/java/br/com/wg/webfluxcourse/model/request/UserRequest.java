package br.com.wg.webfluxcourse.model.request;

public record UserRequest(
        String name,
        String email,
        String password
) { }
