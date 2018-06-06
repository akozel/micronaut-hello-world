package example.person;

import io.micronaut.http.client.Client;

@Client(id = "hello-world", path="/person")
interface PersonClient extends PersonResource {

}
