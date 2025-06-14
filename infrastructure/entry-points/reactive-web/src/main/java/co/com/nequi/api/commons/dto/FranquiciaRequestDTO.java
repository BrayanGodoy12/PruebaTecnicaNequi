package co.com.nequi.api.commons.dto;

public record FranquiciaRequestDTO(
   String nombre,
   String id
) {

    public FranquiciaRequestDTO {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
    }
}



