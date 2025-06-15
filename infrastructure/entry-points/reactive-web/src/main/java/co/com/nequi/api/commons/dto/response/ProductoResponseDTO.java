package co.com.nequi.api.commons.dto.response;

import java.util.UUID;

public record ProductoResponseDTO(
        UUID id,
        String nombre,
        Integer cantidad
) {
}
