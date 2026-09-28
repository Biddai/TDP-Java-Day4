package tdp.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PersonTest  {
    @Test
    void acceptsANonblankName()  {
        Person person = new Person("Noa");
        person.setName("Ada");
        assertEquals("Ada", person.getName());
    }
}
