package co.com.nequi.api.commons.dto.response;

import java.util.List;
import java.util.UUID;

public record FranquiciaConSucursalesResponseDTO(
        UUID id,
        String nombre,
        List<SucursalResponseDTO> sucursales
) {
}
