package co.com.nequi.usecase.franquicias;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.gateways.FranquiciaRepository;
import co.com.nequi.model.franquicia.valueobject.FranquiciaId;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarFranquiciaUseCase {

    //private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> actualizarFranquicia(FranquiciaId franquicia){
        return Mono.empty();
    }
}
