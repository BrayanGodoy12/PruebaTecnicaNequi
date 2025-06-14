package co.com.nequi.api.commons.dto.request;

public record FranquiciaActualizarRequestDTO(
        String id,
        String nombre
) {

    public FranquiciaActualizarRequestDTO {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
    }
}



