package co.com.nequi.model.sucursal;
import co.com.nequi.model.producto.Producto;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Sucursal {

    private String id;
    private String nombre;
    private List<Producto> productos;

}
