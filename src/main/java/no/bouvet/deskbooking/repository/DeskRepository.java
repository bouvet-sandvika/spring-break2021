package no.bouvet.deskbooking.repository;

import no.bouvet.deskbooking.models.entities.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<Desk, Long> {
}
