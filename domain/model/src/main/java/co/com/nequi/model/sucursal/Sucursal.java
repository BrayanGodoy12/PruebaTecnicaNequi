package co.com.nequi.model.sucursal;
import co.com.nequi.model.producto.Producto;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Sucursal {

    private UUID id;
    private String nombre;
    private List<Producto> productos;

}
