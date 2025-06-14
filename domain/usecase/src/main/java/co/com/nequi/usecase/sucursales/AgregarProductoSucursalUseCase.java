package co.com.nequi.usecase.sucursales;

import co.com.nequi.model.sucursal.Sucursal;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarProductoSucursalUseCase {
    //private final Producto producto;
    //private final SucursalRepository sucursalRepository;

    public Mono<Sucursal> agregarProducto(Sucursal sucursal) {
        return Mono.empty();
    }
}
