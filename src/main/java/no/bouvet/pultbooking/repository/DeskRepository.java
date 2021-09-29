package no.bouvet.pultbooking.repository;

import no.bouvet.pultbooking.domain.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Long> {
}
