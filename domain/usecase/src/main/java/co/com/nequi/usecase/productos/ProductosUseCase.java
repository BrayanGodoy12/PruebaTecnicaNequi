package co.com.nequi.usecase.productos;

import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.producto.gateways.ProductoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ProductosUseCase {

    private ProductoRepository productoRepository;



    public Mono<Producto> listProduct(String idSucursal) {
        return Mono.empty();
    }
    public Mono<Producto> updateProduct(Producto producto){
        return Mono.empty();
    }
    public Mono<Producto> createProduct(Producto producto){
        return Mono.empty();
    }
    public Mono<Producto> deleteProduct(String idProducto){
        return Mono.empty();
    }
    public Mono<Producto> getProduct(String idProducto){
        return Mono.empty();
    }


}
