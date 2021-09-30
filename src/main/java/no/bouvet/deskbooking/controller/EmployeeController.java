package no.bouvet.deskbooking.controller;

import no.bouvet.deskbooking.models.dtos.EmployeeDto;
import no.bouvet.deskbooking.models.entities.Employee;
import no.bouvet.deskbooking.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees().stream()
                .map(employee -> new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{employeeId}")
    public EmployeeDto getEmployee(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName());
    }

    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.saveEmployee(employeeDto);
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName());
    }
}
