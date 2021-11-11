package no.bouvet.deskbooking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfiguration.class, TestConfiguration.class})
class BookingServiceImplTest {

    @Autowired
    BookingService bookingService;

    @Test
    void bookRoomTest_room_not_available() {
        assertThrows(
                RoomDoesNotExistException.class,
                () -> {
                    bookingService.bookRoom(5L);
                },
                "");
    }

    @Test
    void bookRoomTest_room_available() {
        assertEquals(bookingService.bookRoom(1L), BookingResponseStatus.BOOKING_OK);
    }

}
