package co.com.nequi.usecase.productos;

import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.producto.gateways.ProductoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarProductoUseCase {
    private final ProductoRepository productoRepository;


    public Mono<Producto> actualizarStockProducto(Producto producto) {
        return productoRepository.updateProduct(producto);
    }
}
