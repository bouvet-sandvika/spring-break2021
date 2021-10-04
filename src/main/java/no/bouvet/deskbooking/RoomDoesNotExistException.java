package no.bouvet.deskbooking;

public class RoomDoesNotExistException extends RuntimeException {
    public RoomDoesNotExistException(String reason) {
        super(reason);
    }
}
