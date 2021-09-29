package no.bouvet.pultbooking.domain;

public class Employee {

    private int employeeId;
    private String name;
    private String lastename;

    public Employee(int employeeId, String name, String lastename) {
        this.employeeId = employeeId;
        this.name = name;
        this.lastename = lastename;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastename() {
        return lastename;
    }

    public void setLastename(String lastename) {
        this.lastename = lastename;
    }
}
