package co.com.nequi.model.franquicia.gateways;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.valueobject.FranquiciaId;
import reactor.core.publisher.Mono;

public interface FranquiciaRepository {

//Mono<Franquicia> getFranquicia(FranquiciaId id);

    // Mono<List<Franquicia>> listFranquicias();

    Mono<Franquicia> updateFranquicia(Franquicia franquicia);

    Mono<Franquicia> createFranquicia(Franquicia franquicia);

    //Mono<Franquicia> deleteFranquicia(FranquiciaId id);

    Mono<Franquicia> consultarMayorProductoSucursal(FranquiciaId idFranquicia);


}
