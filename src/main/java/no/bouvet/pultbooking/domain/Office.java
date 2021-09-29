package no.bouvet.pultbooking.domain;

public class Office {

    private String location;
    private String name;
    private int id;

    public Office(String location, String name, int id) {
        this.location = location;
        this.name = name;
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
