package no.bouvet.deskbooking;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    BookingServiceImpl() {
        this.bookingRepository = new BookingRepositoryImpl();
    }

    @Override
    public BookingResponseStatus bookRoom(Long roomNumber) {
        List<Long> roomNumbers = bookingRepository.getAllRoomNumbers();

        if (roomNumbers.contains(roomNumber)) {
            return BookingResponseStatus.BOOKING_OK;
        } else {
            return BookingResponseStatus.ROOM_DOES_NOT_EXIST;
        }
    }

}
