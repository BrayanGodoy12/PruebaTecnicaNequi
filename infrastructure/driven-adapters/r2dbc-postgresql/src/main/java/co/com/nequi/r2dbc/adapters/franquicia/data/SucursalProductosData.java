package co.com.nequi.r2dbc.adapters.franquicia.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SucursalProductosData {
    private UUID sucursalId;
    private String sucursalNombre;
    private UUID productoId;
    private String productoNombre;
    private Integer cantidad;
}