package no.bouvet.deskbooking.controller;

import no.bouvet.deskbooking.models.dtos.PublicHolidayWrapperDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestController
public class PublicHolidayController {
    private final Logger logger = LoggerFactory.getLogger(PublicHolidayController.class);
    private final WebClient client;

    public PublicHolidayController(@Value("${publicHolidaysUrl}") String publicHolidaysUrl) {
        client = WebClient
                .builder()
                .baseUrl(publicHolidaysUrl)
                .build();
    }

    @GetMapping("public_holidays/{year}")
    public ResponseEntity<PublicHolidayWrapperDto> getPublicHolidays(@PathVariable("year") Integer year) {
        PublicHolidayWrapperDto response;
        try {
            response = client
                    .get()
                    .uri(year.toString())
                    .retrieve()
                    .bodyToMono(PublicHolidayWrapperDto.class)
                    .block();

            return ResponseEntity.ok(response);

        } catch (WebClientResponseException webClientResponseException) {
            logger.error("Fikk feil fra underliggende tjeneste: " + webClientResponseException.getStatusCode().toString());
            return ResponseEntity.ok(new PublicHolidayWrapperDto());
        }
    }
}

