package co.com.nequi.model.producto.gateways;

import co.com.nequi.model.producto.Producto;
import reactor.core.publisher.Mono;

public interface ProductoRepository {

    Mono<Producto> createProduct(Producto producto);
    Mono<Producto> updateProduct(Producto producto);
    Mono<Producto> deleteProduct(String idProducto);
    Mono<Producto> getProduct(String idProducto);
    Mono<Producto> listProducts(String idSucursal);
}
