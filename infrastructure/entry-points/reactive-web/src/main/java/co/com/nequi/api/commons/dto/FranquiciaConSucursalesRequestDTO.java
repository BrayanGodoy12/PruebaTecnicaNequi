package co.com.nequi.api.commons.dto;

import co.com.nequi.model.sucursal.Sucursal;

import java.util.List;

public record FranquiciaConSucursalesRequestDTO(
        String idFranquicia,
        String nombre,
        List<SucursalDTO>  sucursales
) {
}
