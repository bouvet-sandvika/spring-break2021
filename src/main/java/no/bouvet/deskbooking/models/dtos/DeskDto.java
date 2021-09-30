package no.bouvet.deskbooking.models.dtos;

public class DeskDto {
    private Long id;
    private Long officeId;
    private String deskLabel;

    public DeskDto(Long id, Long officeId, String deskLabel) {
        this.id = id;
        this.officeId = officeId;
        this.deskLabel = deskLabel;
    }

    public Long getId() {
        return id;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public String getDeskLabel() {
        return deskLabel;
    }
}
