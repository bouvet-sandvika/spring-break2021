package no.bouvet.deskbooking;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingResponseStatus bookRoom(Long roomNumber) {
        List<Long> roomNumbers = bookingRepository.getAllRoomNumbers();

        if (roomNumbers.contains(roomNumber)) {
            return BookingResponseStatus.BOOKING_OK;
        } else {
            throw new RoomDoesNotExistException("Attempted to book room " + roomNumber);
        }
    }

}
