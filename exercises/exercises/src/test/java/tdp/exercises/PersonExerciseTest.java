package tdp.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PersonExerciseTest  {
    @Test
    void acceptsAnOrdinaryName()  {
        PersonExercise person = new PersonExercise("Noa");
        person.setName("Maya");
        assertEquals("Maya", person.getName());
    }
    // Derive additional tests from the contract in this project's README.md.
    // Keep the real Person and its tests intact while investigating this candidate.
}
