package co.com.nequi.api.commons.dto.request;

public record FranquiciaRequestDTO(
   String nombre
) {

    public FranquiciaRequestDTO {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
    }
}



