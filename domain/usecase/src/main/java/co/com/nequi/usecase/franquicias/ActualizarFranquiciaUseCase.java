package co.com.nequi.usecase.franquicias;

import co.com.nequi.model.franquicia.Franquicia;
import co.com.nequi.model.franquicia.gateways.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarFranquiciaUseCase {

    private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> actualizarFranquicia(Franquicia franquicia) {
        return franquiciaRepository.updateFranquicia(franquicia);
    }
}
