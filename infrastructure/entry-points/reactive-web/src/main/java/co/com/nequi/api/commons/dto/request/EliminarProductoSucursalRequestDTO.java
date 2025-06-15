package co.com.nequi.api.commons.dto.request;

import java.util.UUID;

public record EliminarProductoSucursalRequestDTO(
        UUID idSucursal,
        UUID idProducto
) {
}
