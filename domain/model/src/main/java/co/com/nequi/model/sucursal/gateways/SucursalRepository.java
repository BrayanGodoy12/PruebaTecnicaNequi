package co.com.nequi.model.sucursal.gateways;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.sucursal.Sucursal;
import reactor.core.publisher.Mono;

public interface SucursalRepository {

    Mono<Sucursal> createSucursal(Franquicia franquicia);

    Mono<Sucursal> updateSucursal(Franquicia franquicia);


}
