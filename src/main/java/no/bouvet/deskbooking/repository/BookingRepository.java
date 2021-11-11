package no.bouvet.deskbooking.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

import no.bouvet.deskbooking.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findBookingByBooker_FirstName(String name);

    @Query("SELECT u FROM Booking u WHERE u.start >= :start")
    Collection<Booking> findByDate(@Param("start") LocalDateTime start);

    @Query(value = "SELECT * from Booking where start >= :start", nativeQuery = true)
    Collection<Booking> findByDateNative(@Param("start") LocalDateTime start);

}
