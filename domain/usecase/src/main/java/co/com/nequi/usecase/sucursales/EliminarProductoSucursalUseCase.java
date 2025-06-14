package co.com.nequi.usecase.sucursales;

import co.com.nequi.model.producto.Producto;
import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.model.sucursal.valueobject.SucursalId;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarProductoSucursalUseCase {
    //private final Producto producto;

    public Mono<Producto> deleteProductSucursal(SucursalId sucursal){
        return Mono.empty();
    }
}
