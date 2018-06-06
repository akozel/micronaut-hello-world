package example.person;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonResource {

    @Get("/flux")
    Flux<Person> fluxAll();


    @Get("/mono")
    Mono<List<Person>> monoAll();

    @Post("/")
    Mono<Person> save(@Body Person person);

}
