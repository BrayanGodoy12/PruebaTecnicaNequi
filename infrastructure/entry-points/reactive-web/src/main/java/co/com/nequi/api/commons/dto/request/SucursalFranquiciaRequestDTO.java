package co.com.nequi.api.commons.dto.request;

import java.util.UUID;

public record SucursalFranquiciaRequestDTO(
        UUID idFranquicia,
        String nombre
) {
}
