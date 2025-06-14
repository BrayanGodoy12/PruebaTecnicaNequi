package co.com.nequi.usecase.sucursales;

import co.com.nequi.model.producto.gateways.ProductoRepository;
import co.com.nequi.model.producto.valueobject.ProductoId;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarProductoSucursalUseCase {
    private final ProductoRepository productoRepository;

    public Mono<ProductoId> eliminarProductSucursal(ProductoId productoId) {
        return productoRepository.deleteProduct(productoId);
    }
}
