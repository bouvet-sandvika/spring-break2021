package no.bouvet.deskbooking.services;

import no.bouvet.deskbooking.models.dtos.OfficeDto;
import no.bouvet.deskbooking.models.entities.Office;
import no.bouvet.deskbooking.repository.OfficeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office getOffice(Long officeId) {
        return officeRepository.findById(officeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Office not found"));
    }

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office saveOffice(OfficeDto officeDto) {
        Office office = new Office(officeDto.getName(), officeDto.getLocation());
        return officeRepository.save(office);
    }

    public Office updateOffice(OfficeDto officeDto) {
        Office office = getOffice(officeDto.getId());
        office.setLocation(officeDto.getLocation());
        office.setName(office.getName());
        return officeRepository.save(office);
    }
}