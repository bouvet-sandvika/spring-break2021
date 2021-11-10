package no.bouvet.deskbooking.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;

import no.bouvet.deskbooking.models.dtos.DeskDto;
import no.bouvet.deskbooking.models.entities.Desk;
import no.bouvet.deskbooking.services.DeskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/desks")
public class DeskController {

    private final DeskService deskService;

    public DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    @GetMapping
    public List<DeskDto> getAllDesks() {
        return deskService.getAllDesks().stream()
                .map(desk -> new DeskDto(desk.getId(), desk.getOffice().getId(), desk.getDeskLabel()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{deskId}")
    public DeskDto getDesk(@PathVariable Long deskId) {
        Desk desk = deskService.getDesk(deskId);
        return new DeskDto(desk.getId(), desk.getOffice().getId(), desk.getDeskLabel());
    }

    @PostMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public DeskDto saveDesk(@RequestBody DeskDto deskDto) {
        Desk desk = deskService.saveDesk(deskDto);
        return new DeskDto(desk.getId(), desk.getOffice().getId(), desk.getDeskLabel());
    }
}
