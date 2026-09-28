package tdp.additionalexercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class FilenameValidatorTest  {
    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({"autoexec.bat,true", "autoexec,true", "auto!.bat,false", "autoexec.,true", "_-1._-2,true", "lengthIs9.bat,false"})
    void validatesAccordingToTheContract(String name, boolean expected)  {
        assertEquals(expected, new FilenameValidator().validate(name));
    }
    @Test
    void rejectsNull()  {
        assertFalse(new FilenameValidator().validate(null));
    }
}
