package tdp.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PersonExerciseTest  {
    @Test
    void acceptsANonblankNameExactlyAsGiven()  {
        PersonExercise person = new PersonExercise("Noa");
        person.setName(" Ada ");
        assertEquals(" Ada ", person.getName());
    }
    @Test
    void rejectsWhitespaceOnly()  {
        PersonExercise person = new PersonExercise("Noa");
        assertThrows(IllegalArgumentException.class, () -> person.setName("   "));
        assertEquals("Noa", person.getName());
    }
    @Test
    void rejectsNullWithThePromisedException()  {
        PersonExercise person = new PersonExercise("Noa");
        assertThrows(IllegalArgumentException.class, () -> person.setName(null));
    }
    @Test
    void rejectionPreservesThePreviousName()  {
        PersonExercise person = new PersonExercise("Noa");
        assertThrows(IllegalArgumentException.class, () -> person.setName(""));
        assertEquals("Noa", person.getName());
    }
}
