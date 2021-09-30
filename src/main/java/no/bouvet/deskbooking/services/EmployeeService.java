package no.bouvet.deskbooking.services;

import no.bouvet.deskbooking.models.dtos.EmployeeDto;
import no.bouvet.deskbooking.models.entities.Employee;
import no.bouvet.deskbooking.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getFirstName(), employeeDto.getLastName());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(EmployeeDto employeeDto) {
        Employee employee = getEmployee(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        return employeeRepository.save(employee);
    }
}
