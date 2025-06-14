package co.com.nequi.usecase.franquicias;

import co.com.nequi.model.franquicia.Franquicia;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarSucursalFranquiciaUseCase {
    //private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> agregarSucursalFranquicia(Franquicia franquicia) {
        return Mono.just(franquicia);
    }
}
