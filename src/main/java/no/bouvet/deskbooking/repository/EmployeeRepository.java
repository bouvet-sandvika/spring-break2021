package no.bouvet.deskbooking.repository;

import no.bouvet.deskbooking.models.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
