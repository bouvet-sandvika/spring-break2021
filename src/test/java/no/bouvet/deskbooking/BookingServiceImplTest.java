package no.bouvet.deskbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BookingServiceImplTest {

    BookingService bookingService = new BookingServiceImpl();

    @Test
    void bookRoomTest_room_not_available() {
        assertEquals(bookingService.bookRoom(1L), BookingResponseStatus.BOOKING_OK);
    }

    @Test
    void bookRoomTest_room_available_available() {
        assertEquals(bookingService.bookRoom(1L), BookingResponseStatus.ROOM_DOES_NOT_EXIST);
    }

}
