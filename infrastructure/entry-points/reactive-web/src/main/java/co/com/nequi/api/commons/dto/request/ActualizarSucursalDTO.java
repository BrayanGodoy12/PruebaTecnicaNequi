package co.com.nequi.api.commons.dto.request;

import java.util.UUID;

public record ActualizarSucursalDTO(
        UUID id,
        String nombre,
        UUID idFranquicia
) {
}
