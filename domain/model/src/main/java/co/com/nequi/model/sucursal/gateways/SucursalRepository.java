package co.com.nequi.model.sucursal.gateways;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.sucursal.Sucursal;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SucursalRepository {

    Mono<List<Sucursal>> listSucursales(String idFranquicia);

    Mono<Sucursal> getSucursal(String idSucursal);

    Mono<Sucursal> createSucursal(Franquicia franquicia);

    Mono<Sucursal> updateSucursal(Sucursal sucursal);

    Mono<Sucursal> deleteSucursal(String idSucursal);

}
