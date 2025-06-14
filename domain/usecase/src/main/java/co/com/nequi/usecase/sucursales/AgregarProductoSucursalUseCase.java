package co.com.nequi.usecase.sucursales;

import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.producto.gateways.ProductoRepository;
import co.com.nequi.model.sucursal.Sucursal;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarProductoSucursalUseCase {
    private final ProductoRepository productoRepository;

    public Mono<Producto> agregarProducto(Sucursal sucursal) {
        return productoRepository.createProduct(sucursal);
    }
}
