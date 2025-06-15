package co.com.nequi.model.sucursal.gateways;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.valueobject.FranquiciaId;
import co.com.nequi.model.sucursal.Sucursal;
import co.com.nequi.model.sucursal.valueobject.SucursalId;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SucursalRepository {

    Mono<Sucursal> createSucursal(Franquicia franquicia);

    Mono<Sucursal> updateSucursal(Franquicia franquicia);


}
