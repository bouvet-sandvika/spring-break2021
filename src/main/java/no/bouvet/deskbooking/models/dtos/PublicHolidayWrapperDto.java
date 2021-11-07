package no.bouvet.deskbooking.models.dtos;

import java.util.List;

public class PublicHolidayWrapperDto {
    List<PublicHolidayDto> data;
    String status;

    public List<PublicHolidayDto> getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
