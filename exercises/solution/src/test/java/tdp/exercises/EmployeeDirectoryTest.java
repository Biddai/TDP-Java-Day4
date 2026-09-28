package tdp.exercises;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;
class EmployeeDirectoryTest {
    @Test void excludesInactiveEmployees() {
        var staff = List.of(new Employee(7, "Avi", true), new Employee(7, "Noa", false));
        assertThat(new EmployeeDirectory().getActiveNames(staff)).containsExactly("Avi");
    }
    @Test void preservesInputOrder() {
        var staff = List.of(new Employee(7, "Noa", true), new Employee(7, "Avi", true));
        assertThat(new EmployeeDirectory().getActiveNames(staff)).containsExactly("Noa", "Avi");
    }
    @Test void handlesNoActiveEmployees() {
        assertThat(new EmployeeDirectory().getActiveNames(List.of(new Employee(7, "Noa", false)))).isEmpty();
    }
    @Test void handlesEmptyInput() {
        assertThat(new EmployeeDirectory().getActiveNames(List.of())).isEmpty();
    }
}
