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
    @Test
    void rejectsABlankName()  {
        Person person = new Person("Noa");
        assertThrows(IllegalArgumentException.class, () -> person.setName("   "));
    }
    @Test
    void acceptsANonblankNameExactlyAsGiven()  {
        Person person = new Person("Noa");
        person.setName(" Ada ");
        assertEquals(" Ada ", person.getName());
    }
    @Test
    void rejectsWhitespaceOnly()  {
        Person person = new Person("Noa");
        assertThrows(IllegalArgumentException.class, () -> person.setName("   "));
        assertEquals("Noa", person.getName());
    }
    @Test
    void rejectsNullWithThePromisedException()  {
        Person person = new Person("Noa");
        assertThrows(IllegalArgumentException.class, () -> person.setName(null));
    }
    @Test
    void rejectionPreservesThePreviousName()  {
        Person person = new Person("Noa");
        assertThrows(IllegalArgumentException.class, () -> person.setName(""));
        assertEquals("Noa", person.getName());
    }
}
