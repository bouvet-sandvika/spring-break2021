# 06 - Monitorering

### Oppgave 1

Legg til spring boot actuator. 


```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
```

Du kan nå gjøre kall til http://localhost:8080/actuator for å se hva som automatisk blir eksponert. 

### Oppgave 2

Eksponer flere actuator endepunkter ved å legge til og kall de med postman. 

```properties
management.endpoints.web.exposure.include=health,info,metrics,beans
```

[Liste med endepunkter som kan eksponeres](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints)

### Oppgave 3

For å kunne eksponere prometheus endepunktet trenger vi noen ekstra avhengigheter. Legg til 

```xml
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-core</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
        </dependency>
```

Ved å gå gjøre kall mot http://localhost:8080/actuator kan du nå se at det har dukket opp en link til prometheus endepunktet. 

### Oppgave 4

Klon ned https://github.com/bouvet-sandvika/prometheus-spring-break og følg stegene i Readme filen for å kjøre opp en egen prometheus og grafana instans. 

### Oppgave 5 
Se om du kan lage et nyttig dashboard med grafana. 

