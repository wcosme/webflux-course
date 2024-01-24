package br.com.wg.webfluxcourse.controller.service;

import br.com.wg.webfluxcourse.entity.User;
import br.com.wg.webfluxcourse.mapper.UserMapper;
import br.com.wg.webfluxcourse.model.request.UserRequest;
import br.com.wg.webfluxcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }
}
