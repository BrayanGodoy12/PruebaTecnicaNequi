package co.com.nequi.model.producto.gateways;

import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.producto.valueobject.ProductoId;
import co.com.nequi.model.sucursal.Sucursal;
import reactor.core.publisher.Mono;

public interface ProductoRepository {

    Mono<Producto> createProduct(Sucursal sucursal);

    Mono<Producto> updateProduct(Sucursal sucursal);

    Mono<ProductoId> deleteProduct(ProductoId idProducto);
}
