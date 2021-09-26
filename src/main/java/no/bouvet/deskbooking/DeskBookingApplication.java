package no.bouvet.deskbooking;

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
			employeeRepository.save(new Employee("Daniel", "Idris"));
			employeeRepository.save(new Employee("Unni", "Le"));
			employeeRepository.save(new Employee("Knut Erik", "Skare"));

			officeRepository.save(new Office("Drammen", "Drammen"));
			officeRepository.save(new Office("Sandvika", "Bærum"));
			officeRepository.save(new Office("Majorstua", "Oslo"));

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


		};
	}

}
