package co.com.nequi.model.franquicia.gateways;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.valueobject.FranquiciaId;
import reactor.core.publisher.Mono;

public interface FranquiciaRepository {

    Mono<Franquicia> updateFranquicia(Franquicia franquicia);

    Mono<Franquicia> createFranquicia(Franquicia franquicia);

    Mono<Franquicia> consultarMayorProductoSucursal(FranquiciaId idFranquicia);


}
