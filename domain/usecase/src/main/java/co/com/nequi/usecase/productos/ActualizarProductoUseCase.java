package co.com.nequi.usecase.productos;

import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.sucursal.Sucursal;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarProductoUseCase {
    //private final Producto producto;

    public Mono<Producto> actualizarProducto(Producto producto) {
        return Mono.empty();
    }

    public Mono<Sucursal> actualizarStockProducto(Producto producto) {
        return Mono.empty();
    }
}
