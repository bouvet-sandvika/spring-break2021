package no.bouvet.deskbooking.controller;

import no.bouvet.deskbooking.models.dtos.OfficeDto;
import no.bouvet.deskbooking.models.entities.Office;
import no.bouvet.deskbooking.services.OfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public List<OfficeDto> getAllOffices() {
        return officeService.getAllOffices().stream()
                .map(office -> new OfficeDto(office.getId(), office.getName(), office.getLocation()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{officeId}")
    public OfficeDto getOffice(@PathVariable Long officeId) {
        Office office = officeService.getOffice(officeId);
        return new OfficeDto(office.getId(), office.getName(), office.getLocation());
    }

    @PostMapping
    public OfficeDto saveOffice(@RequestBody OfficeDto officeDto) {
        Office office = officeService.saveOffice(officeDto);
        return new OfficeDto(office.getId(), office.getName(), office.getLocation());
    }

    @PutMapping("/{officeId}")
    public OfficeDto updateOffice(@PathVariable Long officeId, @RequestBody OfficeDto officeDto) {
        Office office = officeService.updateOffice(officeDto);
        return new OfficeDto(office.getId(), office.getName(), office.getLocation());
    }
}
