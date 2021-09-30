package no.bouvet.deskbooking.services;

import no.bouvet.deskbooking.models.dtos.DeskDto;
import no.bouvet.deskbooking.models.entities.Desk;
import no.bouvet.deskbooking.models.entities.Office;
import no.bouvet.deskbooking.repository.DeskRepository;
import no.bouvet.deskbooking.repository.OfficeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeskService {

    private final DeskRepository deskRepository;
    private final OfficeService officeService;

    public DeskService(DeskRepository deskRepository, OfficeService officeService) {
        this.deskRepository = deskRepository;
        this.officeService = officeService;
    }

    public List<Desk> getAllDesks() {
        return deskRepository.findAll();
    }

    public Desk getDesk(Long deskId) {
        return deskRepository.findById(deskId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Desk not found"));
    }

    public Desk saveDesk(DeskDto desk) {
        Office office = officeService.getOffice(desk.getOfficeId());

        Desk newDesk = new Desk(office, desk.getDeskLabel());
        return deskRepository.save(newDesk);
    }

    public Desk updateDesk(DeskDto desk) {
        Office office = officeService.getOffice(desk.getOfficeId());

        Desk deskToUpdate = getDesk(desk.getId());
        deskToUpdate.setDeskLabel(desk.getDeskLabel());
        deskToUpdate.setOffice(office);
        return deskRepository.save(deskToUpdate);
    }
}
