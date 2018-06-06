package example.person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Singleton
class PersonRepository {

    List<Person> people = new ArrayList<>();

    PersonRepository() {
        people.add(new Person("Bobby", LocalDateTime.now().minusYears(15)));
        people.add(new Person("Tom", LocalDateTime.now().minusYears(30)));
        people.add(new Person("Anna", LocalDateTime.now().minusYears(45)));
        people.add(new Person("Darya", LocalDateTime.now().minusYears(70)));
    }

    Flux<Person> find() {
        return Flux.fromIterable(people);
    }

    Mono<Person> save(Person person) {
        people.add(person);
        return Mono.just(person);
    }

}
