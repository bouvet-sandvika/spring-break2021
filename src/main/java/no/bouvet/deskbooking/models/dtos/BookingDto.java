package no.bouvet.deskbooking.models.dtos;

import java.time.LocalDateTime;

public class BookingDto {
    private Long id;
    private Long employeeId;
    private Long deskId;
    private LocalDateTime start;
    private LocalDateTime end;

    public BookingDto() {
    }

    public BookingDto(Long id, Long employeeId, Long deskId, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.employeeId = employeeId;
        this.deskId = deskId;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getDeskId() {
        return deskId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
