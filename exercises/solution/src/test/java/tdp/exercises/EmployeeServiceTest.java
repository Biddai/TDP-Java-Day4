package tdp.exercises;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    @Test
    void countsOnlyActiveEmployees() {
        // Arrange
        EmployeeRepository repository = mock(EmployeeRepository.class);
        List<Employee> employees = List.of(
                new Employee(1, "Maya", true),
                new Employee(2, "Dana", false),
                new Employee(3, "Avi", true));
        when(repository.findAll()).thenReturn(employees);
        EmployeeService service = new EmployeeService(repository);

        // Act
        int count = service.countActiveEmployees();

        // Assert
        assertThat(count).isEqualTo(2);
        verify(repository).findAll();
    }
}
