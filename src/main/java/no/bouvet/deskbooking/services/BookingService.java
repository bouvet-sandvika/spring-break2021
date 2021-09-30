package no.bouvet.deskbooking.services;

import no.bouvet.deskbooking.models.dtos.BookingDto;
import no.bouvet.deskbooking.models.entities.Booking;
import no.bouvet.deskbooking.models.entities.Desk;
import no.bouvet.deskbooking.models.entities.Employee;
import no.bouvet.deskbooking.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final EmployeeService employeeService;
    private final DeskService deskService;

    public BookingService(BookingRepository bookingRepository, EmployeeService employeeService, DeskService deskService) {
        this.bookingRepository = bookingRepository;
        this.employeeService = employeeService;
        this.deskService = deskService;
    }

    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
    }

    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    public Booking saveBooking(BookingDto bookingDto) {
        Employee employee = employeeService.getEmployee(bookingDto.getEmployeeId());
        Desk desk = deskService.getDesk(bookingDto.getDeskId());
        Booking booking = new Booking(employee, desk, bookingDto.getStart(), bookingDto.getEnd());
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(BookingDto bookingDto) {
        Booking booking = getBooking(bookingDto.getId());
        Employee employee = employeeService.getEmployee(bookingDto.getEmployeeId());
        Desk desk = deskService.getDesk(bookingDto.getDeskId());

        booking.setBooker(employee);
        booking.setDesk(desk);
        booking.setStart(bookingDto.getStart());
        booking.setEnd(bookingDto.getEnd());
        return bookingRepository.save(booking);
    }
}
