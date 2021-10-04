package no.bouvet.deskbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @InjectMocks
    BookingServiceImpl bookingService;

    @Mock
    BookingRepository bookingRepository;

    @Test
    void bookRoomTest_room_not_available() {
        assertThrows(
                RoomDoesNotExistException.class,
                () -> {
                    bookingService.bookRoom(1L);
                },
                "");
    }

    @Test
    void bookRoomTest_room_available() {
        when(bookingRepository.getAllRoomNumbers()).thenReturn(List.of(1L));
        assertEquals(bookingService.bookRoom(1L), BookingResponseStatus.BOOKING_OK);
    }

}
