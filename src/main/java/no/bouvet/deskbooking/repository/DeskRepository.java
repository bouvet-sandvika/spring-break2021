package no.bouvet.deskbooking.repository;

import no.bouvet.deskbooking.models.entities.Desk;
import org.springframework.data.repository.CrudRepository;

public interface DeskRepository extends CrudRepository<Desk, Long> {
}
