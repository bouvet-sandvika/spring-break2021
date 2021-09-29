package no.bouvet.pultbooking.controller;

import no.bouvet.pultbooking.domain.Booking;
import no.bouvet.pultbooking.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    private BookingRepository repository;

    public BookingController(BookingRepository bookingRepository) {
        this.repository = bookingRepository;
    }

    @GetMapping("/bookings/{id}")
    private Booking getBooking(Long id) {
        return repository.getOne(id);
    }

    @GetMapping("/bookings")
    private List<Booking> getBookings() {
        return repository.findAll();
    }

    @PostMapping ("/bookings")
    private Booking newBooking(@RequestBody Booking newBooking) {
        return repository.save(newBooking);
    }

    @PutMapping("/bookings/{id}")
    private Booking editBooking(
            @RequestBody Booking newBooking,
            @PathVariable Long id) {
        return repository.findById(id)
                .map(booking -> {
                    booking.setStart(newBooking.getStart());
                    booking.setEnd(newBooking.getEnd());
                    return repository.save(booking);
                })
                .orElseThrow(() -> new RuntimeException(id+" finnes ikke"));
    }
}
