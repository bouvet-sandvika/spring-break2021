package no.bouvet.deskbooking.repository;

import no.bouvet.deskbooking.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
