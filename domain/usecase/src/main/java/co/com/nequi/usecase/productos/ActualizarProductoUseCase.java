package co.com.nequi.usecase.productos;

import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.sucursal.Sucursal;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarProductoUseCase {
    //private final ProductoRepository producto;


    public Mono<Producto> actualizarStockProducto(Producto producto) {
        return Mono.empty();
    }
}
