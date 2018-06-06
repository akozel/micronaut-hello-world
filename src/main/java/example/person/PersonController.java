/*
 * Copyright 2017 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.person;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.validation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Graeme Rocher
 * @since 1.0
 */
@Controller("/person")
@Validated
public class PersonController implements PersonResource {

    @Inject
    PersonRepository personRepository;

    @Override
    public Flux<Person> fluxAll() {
        return personRepository.find();
    }

    @Override
    public Mono<List<Person>> monoAll() {
        return personRepository.find().collectList();
    }

    @Override
    public Mono<Person> save(@Body Person person) {
        System.out.println("Body: " + person.toString());
        return personRepository.save(person);
    }

}
