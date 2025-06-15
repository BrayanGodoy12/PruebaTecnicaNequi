package co.com.nequi.model.franquicia;

import co.com.nequi.model.sucursal.Sucursal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Franquicia {

    private UUID id;
    private String nombre;
    private List<Sucursal> sucursales;

}
