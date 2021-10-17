package no.bouvet.deskbooking.models.dtos;

import java.time.LocalDate;

public class PublicHolidayDto {
    LocalDate date;
    String description;

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
