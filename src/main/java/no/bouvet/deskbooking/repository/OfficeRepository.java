package no.bouvet.deskbooking.repository;

import no.bouvet.deskbooking.models.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {

}
