package co.com.nequi.r2dbc.adapters.sucursal.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("franquicias_schema.sucursal")
public class SucursalData {
    @Id
    private UUID id;
    private String nombre;
    private UUID franquiciaId;
}