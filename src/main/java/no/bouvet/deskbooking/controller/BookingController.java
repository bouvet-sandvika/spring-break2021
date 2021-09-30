package no.bouvet.deskbooking.controller;

import no.bouvet.deskbooking.models.dtos.BookingDto;
import no.bouvet.deskbooking.models.entities.Booking;
import no.bouvet.deskbooking.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDto> getAllBookings() {
        return bookingService.getBookings().stream()
                .map(booking -> new BookingDto(booking.getId(),
                        booking.getBooker().getId(),
                        booking.getDesk().getId(),
                        booking.getStart(),
                        booking.getEnd()))
                .collect(Collectors.toList());
    }

    @GetMapping("{bookingId}")
    public Booking getBooking(@PathVariable Long bookingId) {
        return bookingService.getBooking(bookingId);
    }

    @PostMapping
    public Booking saveBooking(@RequestBody BookingDto booking) {
        return bookingService.saveBooking(booking);
    }
}
