package example.person;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.time.LocalDateTime;
import java.util.List;

public class PersonControllerTest {

    @RegisterExtension
    private static EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

    @RegisterExtension
    private PersonClient personClient = server.getApplicationContext().getBean(PersonClient.class);

    @Test
    void testFlux() throws Exception {
        List<Person> personList = personClient.fluxAll().collectList().block();
        Assertions.assertEquals(4, personList.size());
    }

    @Test
    void testMono() throws Exception {
        List<Person> personList = personClient.monoAll().block();
        Assertions.assertEquals(4, personList.size());
    }

    @Test()
    void saveEntity() throws Exception {
        Person person = new Person();
        person.setName("Peter");
        person.setBirthDate(LocalDateTime.of(1992, 5, 16, 12, 0));
        System.out.println("test: " + person);
        System.out.println("result: " + personClient.save(person).block());
    }

    @AfterAll
    static void after() {
        // server.stop();
    }

}
