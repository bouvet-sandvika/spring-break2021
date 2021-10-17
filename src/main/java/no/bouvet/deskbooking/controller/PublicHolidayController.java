package no.bouvet.deskbooking.controller;

import no.bouvet.deskbooking.models.dtos.PublicHolidayWrapperDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class PublicHolidayController {
    private final WebClient client;

    public PublicHolidayController(@Value("${publicHolidaysUrl}") String publicHolidaysUrl) {
        client = WebClient
                .builder()
                .baseUrl(publicHolidaysUrl)
                .build();
    }

    @GetMapping("public_holidays")
    public ResponseEntity<PublicHolidayWrapperDto> getPublicHolidays() {
        PublicHolidayWrapperDto response = client
                .get()
                .uri("2021")
                .retrieve()
                .bodyToMono(PublicHolidayWrapperDto.class)
                .block();

        return ResponseEntity.ok(response);
    }
}

