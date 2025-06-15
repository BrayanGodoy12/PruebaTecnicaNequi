package co.com.nequi.api.commons.dto.request;

import java.rmi.server.UID;
import java.util.UUID;

public record ActualizarProductoRequestDTO(
        UUID id,
        String nombre,
        Integer cantidad,
        UUID idSucursal
) {
}
