package co.com.nequi.usecase.franquicias;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.gateways.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarFranquiciaUseCase {

    //private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> crearFranquicia(Franquicia franquicia) {
        return Mono.just(Franquicia.builder().nombre("Nequi").id("123").build());
    }
}
