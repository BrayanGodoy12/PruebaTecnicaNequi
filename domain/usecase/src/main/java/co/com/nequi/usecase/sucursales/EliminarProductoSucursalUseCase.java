package co.com.nequi.usecase.sucursales;

import co.com.nequi.model.producto.valueobject.ProductoId;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarProductoSucursalUseCase {
    //private final Producto producto;

    public Mono<ProductoId> eliminarProductSucursal(ProductoId productoId) {
        return Mono.empty();
    }
}
