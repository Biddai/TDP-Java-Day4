package tdp.additionalexercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FilenameValidatorTest  {
    @Test
    void acceptsAnExtension()  {
        assertTrue(new FilenameValidator().validate("autoexec.bat"));
    }
    @Test
    void acceptsNoExtension()  {
        assertTrue(new FilenameValidator().validate("autoexec"));
    }
    @Test
    void rejectsAnIllegalCharacter()  {
        assertFalse(new FilenameValidator().validate("auto!.bat"));
    }
}
