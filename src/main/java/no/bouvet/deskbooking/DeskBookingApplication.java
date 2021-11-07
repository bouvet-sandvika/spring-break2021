package no.bouvet.deskbooking;

import no.bouvet.deskbooking.models.entities.Booking;
import no.bouvet.deskbooking.models.entities.Desk;
import no.bouvet.deskbooking.models.entities.Employee;
import no.bouvet.deskbooking.models.entities.Office;
import no.bouvet.deskbooking.repository.BookingRepository;
import no.bouvet.deskbooking.repository.DeskRepository;
import no.bouvet.deskbooking.repository.EmployeeRepository;
import no.bouvet.deskbooking.repository.OfficeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

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
								  OfficeRepository officeRepository) {
		return (args) -> {
			Employee dai = employeeRepository.save(new Employee("Daniel", "Idris"));
			Employee magnus = employeeRepository.save(new Employee("Magnus", "Korvald"));
			Employee kes = employeeRepository.save(new Employee("Knut Erik", "Skare"));

			Office drammen = officeRepository.save(new Office("Drammen", "Drammen"));
			Office sandvika = officeRepository.save(new Office("Sandvika", "Bærum"));
			Office majorstua = officeRepository.save(new Office("Majorstua", "Oslo"));

			Desk drammen1 = deskRepository.save(new Desk(drammen, "Hjørnepulten"));
			Desk drammen2 = deskRepository.save(new Desk(drammen, "Takterrassen"));
			Desk drammen3 = deskRepository.save(new Desk(drammen, "Sofaen ved kaffemaskinen"));

			Desk sandvika1 = deskRepository.save(new Desk(sandvika, "Møterommet uten lyspærer"));
			Desk sandvika2 = deskRepository.save(new Desk(sandvika, "Parkeringsplassen"));
			Desk sandvika3 = deskRepository.save(new Desk(sandvika, "Taket utenfor kantina"));

			Desk majorstua1 = deskRepository.save(new Desk(majorstua, "Øy 1, pult 1"));
			Desk majorstua2 = deskRepository.save(new Desk(majorstua, "Øy 1, pult 2"));
			Desk majorstua3 = deskRepository.save(new Desk(majorstua, "Øy 1, pult 3"));

			bookingRepository.save(new Booking(dai, drammen1, LocalDateTime.now(), LocalDateTime.now().plusHours(8)));
			bookingRepository.save(new Booking(magnus, sandvika1, LocalDateTime.now(), LocalDateTime.now().plusHours(8)));
			bookingRepository.save(new Booking(kes, drammen3, LocalDateTime.now(), LocalDateTime.now().plusHours(8)));
		};
	}

}