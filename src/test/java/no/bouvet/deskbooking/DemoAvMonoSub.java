package no.bouvet.deskbooking;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class DemoAvMonoSub {

    private void handleMonoResponse(String response){
        System.out.println(response);
    }

    @Test
    public void testAvMonoSub() throws InterruptedException {
        Mono<String> minMono = Mono.just("Dette er en test").delayElement(Duration.ofSeconds(1));

        minMono.subscribe(this::handleMonoResponse);

        Thread.sleep(1500);
    }

}
