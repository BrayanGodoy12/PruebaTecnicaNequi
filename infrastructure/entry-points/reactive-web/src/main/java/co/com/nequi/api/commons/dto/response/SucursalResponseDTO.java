package co.com.nequi.api.commons.dto.response;

import java.util.List;

public record SucursalResponseDTO(
        String id,
        String nombre,
        List<ProductoResponseDTO> productos
) {
}
