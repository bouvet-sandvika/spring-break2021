package no.bouvet.deskbooking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringConfiguration {

    @Bean
    BookingService minBookingService(BookingRepository bookingRepository) {
        return new BookingServiceImpl(bookingRepository);
    }
}
