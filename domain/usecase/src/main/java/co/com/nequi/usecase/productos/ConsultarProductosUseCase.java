package co.com.nequi.usecase.productos;

import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.producto.gateways.ProductoRepository;
import co.com.nequi.model.producto.valueobject.ProductoId;
import co.com.nequi.model.sucursal.valueobject.SucursalId;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ConsultarProductosUseCase {

    //private final ProductoRepository productoRepository;

    public Mono<Producto> listProduct(SucursalId sucursal) {
        return Mono.empty();
    }

    public Mono<Producto> getProduct(ProductoId producto){
        return Mono.empty();
    }
}
