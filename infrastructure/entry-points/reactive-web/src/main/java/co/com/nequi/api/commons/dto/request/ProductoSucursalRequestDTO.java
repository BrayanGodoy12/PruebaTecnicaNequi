package co.com.nequi.api.commons.dto.request;

import java.util.UUID;

public record ProductoSucursalRequestDTO(
        UUID idSucursal,
        String nombre,
        Integer cantidad
) {
}
