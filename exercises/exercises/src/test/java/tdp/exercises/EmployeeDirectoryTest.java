package tdp.exercises;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
class EmployeeDirectoryTest {
    @Test void returnsAList() {
        var result = new EmployeeDirectory().getActiveNames(java.util.List.of(new Employee(7, "Avi", true)));
        assertThat(result).isNotNull();
    }
}
