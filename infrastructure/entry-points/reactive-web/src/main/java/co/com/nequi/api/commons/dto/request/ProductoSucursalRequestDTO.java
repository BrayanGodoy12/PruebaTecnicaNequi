package co.com.nequi.api.commons.dto.request;

public record ProductoSucursalRequestDTO(
        String idSucursal,
        String nombre,
        Integer cantidad
) {
}
