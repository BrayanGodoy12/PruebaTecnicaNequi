package co.com.nequi.api.commons.dto.response;

import java.util.List;
import java.util.UUID;

public record SucursalResponseDTO(
        UUID id,
        String nombre,
        List<ProductoResponseDTO> productos
) {
}
