package no.bouvet.deskbooking.repository;

import no.bouvet.deskbooking.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
