package no.bouvet.deskbooking;

import org.springframework.stereotype.Component;

@Component
public class BookingController {

    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

}
