package co.com.nequi.model.commons.message;

public enum BusinessErrorMessage {
    FRANQUICIA_NOT_FOUND("Franquicia no encontrada"),
    UNKNOWN_ERROR("Error desconocido");

    private final String message;

    BusinessErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}