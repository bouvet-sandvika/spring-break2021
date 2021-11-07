package no.bouvet.deskbooking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TestConfiguration {

    @Bean
    @Primary
    public BookingRepository bookingRepository() {
        return new BookingRepository() {
            @Override
            public List<Long> getAllRoomNumbers() {
                return Arrays.asList(1L, 2L, 3L);
            }
        };
    }
}
