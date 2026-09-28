package tdp.exercises;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
class AssertionsTest {
    @Test void checksEmployeeNamesInOrder() {
        var maya = new Employee(7, "Maya", true);
        maya.setName("Maya Levi");
        assertThat(maya.getName()).startsWith("Maya").endsWith("Levi");
        var team = List.of(maya, new Employee(9, "Avi", true));
        assertThat(team).extracting(Employee::getName).containsExactly("Maya Levi", "Avi");
    }
}
