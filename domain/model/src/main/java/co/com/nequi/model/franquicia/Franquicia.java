package co.com.nequi.model.franquicia;

import co.com.nequi.model.sucursal.Sucursal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Franquicia {

    private String id;
    private String nombre;
    private List<Sucursal> sucursales;

}
