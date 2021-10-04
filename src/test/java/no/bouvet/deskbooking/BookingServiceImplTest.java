package no.bouvet.deskbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BookingServiceImplTest {

    BookingService bookingService = new BookingServiceImpl();

    @Test
    void bookRoomTest_room_does_not_exist() {
        assertThrows(
                RoomDoesNotExistException.class,
                () -> {
                    bookingService.bookRoom(20L);
                },
                "");
    }

    @Test
    void bookRoomTest_room_available() {
        assertEquals(bookingService.bookRoom(1L), BookingResponseStatus.BOOKING_OK);
    }


}
