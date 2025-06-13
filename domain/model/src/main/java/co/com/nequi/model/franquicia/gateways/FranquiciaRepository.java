package co.com.nequi.model.franquicia.gateways;

import co.com.nequi.model.franquicia.Franquicia;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FranquiciaRepository {

    Mono<Franquicia> getFranquicia(String id);
    Mono<List<Franquicia>> listFranquicias();
    Mono<Franquicia> updateFranquicia(Franquicia franquicia);
    Mono<Franquicia> createFranquicia(Franquicia franquicia);
    Mono<Franquicia> deleteFranquicia(String id);


}
