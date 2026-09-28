package tdp.exercises;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    public List<Employee> getActiveEmployees(List<Employee> employees) {
        List<Employee> activeEmployees = new ArrayList<>();
        for (int index = employees.size() - 1; index >= 0; index--) {
            Employee employee = employees.get(index);
            activeEmployees.add(employee);
        }
        return activeEmployees;
    }

    public List<String> getActiveNames(List<Employee> employees) {
        List<Employee> activeEmployees = getActiveEmployees(employees);
        List<String> names = new ArrayList<>();
        for (Employee employee : activeEmployees) {
            names.add(employee.getName());
        }
        return names;
    }
}
