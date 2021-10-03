package no.bouvet.deskbooking;

import java.util.Arrays;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {

    @Override
    public List<Long> getAllRoomNumbers() {
        return Arrays.asList(1L, 2L, 3L, 4L);
    }

}
