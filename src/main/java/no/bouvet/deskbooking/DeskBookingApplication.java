package no.bouvet.deskbooking;

import java.time.LocalDateTime;

import no.bouvet.deskbooking.models.entities.Booking;
import no.bouvet.deskbooking.models.entities.Desk;
import no.bouvet.deskbooking.models.entities.Employee;
import no.bouvet.deskbooking.models.entities.Office;
import no.bouvet.deskbooking.models.entities.User;
import no.bouvet.deskbooking.repository.BookingRepository;
import no.bouvet.deskbooking.repository.DeskRepository;
import no.bouvet.deskbooking.repository.EmployeeRepository;
import no.bouvet.deskbooking.repository.OfficeRepository;
import no.bouvet.deskbooking.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DeskBookingApplication {

    private static final Logger log = LoggerFactory.getLogger(DeskBookingApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(DeskBookingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookingRepository bookingRepository,
                                  DeskRepository deskRepository,
                                  EmployeeRepository employeeRepository,
                                  OfficeRepository officeRepository,
                                  UserRepository userRepository,
                                  PasswordEncoder passwordEncoder) {
        return (args) -> {
            Employee dai = employeeRepository.save(new Employee("Daniel", "Idris"));
            Employee ule = employeeRepository.save(new Employee("Unni", "Le"));
            Employee kes = employeeRepository.save(new Employee("Knut Erik", "Skare"));

            Office drammen = officeRepository.save(new Office("Drammen", "Drammen"));
            Office sandvika = officeRepository.save(new Office("Sandvika", "Bærum"));
            Office majorstua = officeRepository.save(new Office("Majorstua", "Oslo"));

            Desk drammen1 = deskRepository.save(new Desk(drammen, "Hjørnekontoret"));
            Desk drammen2 = deskRepository.save(new Desk(drammen, "Øy 1, pult 1"));
            Desk drammen3 = deskRepository.save(new Desk(drammen, "Øy 1, pult 2"));

            Desk sandvika1 = deskRepository.save(new Desk(sandvika, "Møterommet uten lyspærer"));
            Desk sandvika2 = deskRepository.save(new Desk(sandvika, "Parkeringsplassen"));
            Desk sandvika3 = deskRepository.save(new Desk(sandvika, "Taket utenfor kantina"));

            Desk majorstua1 = deskRepository.save(new Desk(majorstua, "Øy 1, pult 1"));
            Desk majorstua2 = deskRepository.save(new Desk(majorstua, "Øy 1, pult 2"));
            Desk majorstua3 = deskRepository.save(new Desk(majorstua, "Øy 1, pult 3"));

            User user1 = userRepository.save(new User("dai", passwordEncoder.encode("jævlaBraSikkerhet69"), "Daniel", "Idris"));

            bookingRepository.save(new Booking(dai, drammen1, LocalDateTime.now(), LocalDateTime.now().plusHours(8)));
            bookingRepository.save(new Booking(ule, sandvika1, LocalDateTime.now(), LocalDateTime.now().plusHours(8)));
            bookingRepository.save(new Booking(kes, drammen3, LocalDateTime.now(), LocalDateTime.now().plusHours(8)));

            // fetch all employees
            log.info("Employees found with findAll():");
            log.info("-------------------------------");
            for (Employee employee : employeeRepository.findAll()) {
                log.info(employee.toString());
            }
            log.info("");


            // fetch all offices
            log.info("Offices found with findAll():");
            log.info("-------------------------------");
            for (Office office : officeRepository.findAll()) {
                log.info(office.toString());
            }
            log.info("");

            // fetch all desks
            log.info("Desks found with findAll():");
            log.info("-------------------------------");
            for (Desk desk : deskRepository.findAll()) {
                log.info(desk.toString());
            }
            log.info("");

            // fetch all desks
            log.info("Bookings found with findAll():");
            log.info("-------------------------------");
            for (Booking booking : bookingRepository.findAll()) {
                log.info(booking.toString());
            }
            log.info("");
        };
    }

}
