package co.com.nequi.api.commons.dto.response;

import java.util.List;

public record FranquiciaConSucursalesResponseDTO(
        String id,
        String nombre,
        List<SucursalResponseDTO> sucursales
) {
}
